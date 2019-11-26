package GeeksForGeeks;

import java.util.Stack;

// i did brute force with 2 for loops try all stuff
// https://www.geeksforgeeks.org/largest-rectangle-under-histogram/
public class MaxHistogramArea 
{

	static int getMaxArea(int hist[])  
    { 
        Stack<Integer> stack = new Stack<Integer>(); 
          
        int length = hist.length;
        int max_area = 0;
        int top;
        int area_with_top;    
        int i = 0; 
        
        while (i < length) 
        {             
            if (stack.empty() || hist[stack.peek()] <= hist[i]) 
                stack.push(i++); 
       
            else
            { 
                top = stack.pop();
       
                area_with_top = hist[top] * (stack.empty() ? i : i - stack.peek() - 1); 
       
                max_area = Math.max(max_area, area_with_top);
            } 
        } 
       
        // Now pop the remaining bars from stack and calculate area with every popped bar as the smallest bar 
        while (stack.empty() == false) 
        { 
            top = stack.pop(); 
            
            area_with_top = hist[top] * (stack.empty() ? i : i - stack.peek() - 1); 
       
            max_area = Math.max(max_area, area_with_top);
        } 
       
        return max_area;   
    }
	
	public static void main(String[] args) 
	{
		
		int hist[] = { 6, 2, 5, 4, 5, 1, 6 }; 
        System.out.println("Maximum area is " + getMaxArea(hist));

	}

}
