package stacks;

import java.util.LinkedList;
import java.util.Queue;

public class StackWith1Queue 
{

	Queue<Integer> q = new LinkedList<Integer>(); 
    
    void push(int val)  
    { 
        int size = q.size();           
        q.add(val); 
          
        // Pop (or Dequeue) all previous elements and put them after current element 
        for (int i = 0; i < size; i++)  
        { 
            int x = q.remove(); 
            q.add(x); 
        } 
    } 
      
    int pop()  
    { 
        if (q.isEmpty())  
        { 
            System.out.println("No elements"); 
            return -1; 
        } 
        
        int x = q.remove(); 
        return x; 
    } 
      
    int top()  
    { 
        if (q.isEmpty()) 
            return -1; 
        return q.peek(); 
    } 
      
    boolean isEmpty()  
    { 
        return q.isEmpty(); 
    } 
  
    public static void main(String[] args)  
    { 
    	StackWith1Queue s = new StackWith1Queue(); 
        s.push(10); 
        System.out.println("Top element :" + s.top()); 
        s.push(20); 
        System.out.println("Top element :" + s.top()); 
        s.push(30); 
        System.out.println("Top element :" + s.top()); 
        s.pop(); 
        System.out.println("Top element :" + s.top()); 
    } 
	
}












