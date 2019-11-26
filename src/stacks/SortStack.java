package stacks;

import java.util.Stack;

public class SortStack 
{	
	
	static Stack<Integer> stack = new Stack<>(); 
	
    static void sortedInsert(Stack<Integer> s, int x) 
    { 
        if (s.isEmpty() || x > s.peek()) 
        { 
            s.push(x); 
            return; 
        } 
        int temp = s.pop(); 
        sortedInsert(s, x); 
       
        s.push(temp); 
    } 
       
    static void sortStackRec(Stack<Integer> s) 
    { 
        if (!s.isEmpty()) 
        { 
            int x = s.pop(); 
       
            sortStackRec(s); 
       
            sortedInsert(s, x); 
        } 
    }       
    
    
    static int[] sortStackIterative(Stack<Integer> s)
    {
    	int[] arr = new int[s.size()];
    	int j = 0;
    	
    	while(!s.isEmpty())
    	{
    		int x = s.pop();    		
    		arr[j++] = x;
    	}
    	
//    	sort array somehow
    	
    	return arr;
    }

    
    // Driver method  
    public static void main(String[] args)  
    {         
        stack.push(30); 
        stack.push(-5); 
        stack.push(18); 
        stack.push(14); 
        stack.push(-3); 
       
        System.out.println("Stack elements before sorting: "); 
        System.out.println(stack);
       
//        sortStackRec(stack); 
        
//        System.out.println(" \n\nStack elements after sorting:"); 
//        System.out.println(stack);
        
        System.out.println(" \n\nStack elements after sorting:"); 
        System.out.println(sortStackIterative(stack));
       
    } 

}















