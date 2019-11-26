package stacks;

import java.util.Stack;

public class ReveseAStack 
{
    static Stack<Integer> stack = new Stack<>(); 
      
    static void insertAtBottom(int x) 
    {   
        if(stack.isEmpty()) 
            stack.push(x);   
        else
        { 
            int a = stack.pop(); 
            insertAtBottom(x); 
            
            stack.push(a); 
        } 
    } 
      
    static void reverse() 
    { 
        if(stack.size() > 0) 
        {     
            int x = stack.pop(); 
            reverse(); 
            
            insertAtBottom(x); 
        } 
    } 
      
    
    // Driver Code 
    public static void main(String[] args)  
    { 
        stack.push(1); 
        stack.push(2); 
        stack.push(3); 
        stack.push(4); 
          
        System.out.println("Original Stack");           
        System.out.println(stack); 
        
        reverse(); 
                  
        System.out.println("Reversed Stack");           
        System.out.println(stack); 
    } 
	
}








