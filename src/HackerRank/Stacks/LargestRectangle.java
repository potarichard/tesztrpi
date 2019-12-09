package HackerRank.Stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//              1
//              1
//           1  1
//        1  1  1
//  1     1  1  1
//  1  1  1  1  1  1

//  0  1  2  3  4  5

// -> 9


public class LargestRectangle {

	
	static long largestRectangleOwn(int[] heights) 
	{
		class Bar
		{
			int index;
			int height;
			
			public Bar(int index, int height) 
			{
				super();
				this.index = index;
				this.height = height;
			}			
		}
		
		Stack<Bar> stack = new Stack<Bar>(); 
		List<Bar> bars = new ArrayList<Bar>();
		
		for(int i=0; i<heights.length; i++)
			bars.add(new Bar(i+1, heights[i]));
		
		int max = heights[0];
		int height = heights[0];		
		
		for(Bar bar : bars)
		{
			if(stack.isEmpty())
				stack.push(bar);
			
			// 1. vagy ez magaban, 
			// 2. vagy eddigi legnagyobb height * bar index - elozo bar index
			// 
		}
		
		return max;
	}
	
	
	// kell egy stack amibe 0, 1 van alapbol, ha a kovetkezo magassag nagyobb
	static long largestRectangle(int[] hist) 
    {
		// Create an empty stack. The stack holds indexes of hist[] array 
        // The bars stored in stack are always in increasing order of their heights. 
        Stack<Integer> stack = new Stack<>(); 
          
        int max_area = 0; 			// Initialize max area 
        int max_height_index;  		// To store top of stack  
        int area_with_top; 			// To store area with top bar as the smallest bar 
       
        int i = 0; 
        
        while (i < hist.length) 
        { 
            // If this bar is higher than the bar on top stack, push it to stack 
            if (stack.empty() || hist[stack.peek()] <= hist[i]) 
                stack.push(i++); 
       
            // If this bar is lower than top of stack, then calculate area of rectangle  
            // with stack top as the smallest (or minimum height) bar. 'i' is  
            // 'right index' for the top and element before top in stack is 'left index' 
            else
            { 
                max_height_index = stack.pop();  
       
                // Calculate the area with hist[max_height] stack as smallest bar 
                area_with_top = hist[max_height_index] * (stack.empty() ? i : i - stack.peek() - 1); 
       
                max_area = Math.max(max_area, area_with_top);
            } 
        } 
       
        // Now pop the remaining bars from stack and calculate area with every popped bar as the smallest bar 
        while (!stack.empty()) 
        { 
            max_height_index = stack.pop(); 
            
            area_with_top = hist[max_height_index] * (stack.empty() ? i : i - stack.peek() - 1); 
       
            max_area = Math.max(max_area, area_with_top);
        } 
       
        return max_area; 
    }
	
	
	
	public static void main(String[] args) {
		
		int[] h = {2, 1, 3, 4, 6, 1};
		
		largestRectangle(h);

	}

}
