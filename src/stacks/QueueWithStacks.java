package stacks;

import java.util.Stack;

//The problem is opposite of this post. We are given a stack data structure with push and pop operations, 
//the task is to implement a queue using instances of stack data structure and operations on them.

// s1 a fostack, de kell az s2 seged stack, hogy s1 hez valo hozzaadaskor fejetetejere forditsuk a stacket+

public class QueueWithStacks 
{

	Stack<Integer> s1 = new Stack<Integer>();  
    Stack<Integer> s2 = new Stack<Integer>();  
  
    void enQueue(int x)  
    {  
        // Move all elements from s1 to s2  
        while (!s1.isEmpty()) 
            s2.push(s1.pop());  
  
        // Push item into s1  
        s1.push(x);  
  
        // Push everything back to s1  
        while (!s2.isEmpty())  
            s1.push(s2.pop());  
    }  
  
    // Dequeue an item from the queue  
    int deQueue()  
    {  
        // if first stack is empty  
        if (s1.isEmpty())  
        {  
            System.out.println("Q is Empty");  
            System.exit(0);  
        }  
  
        // Return top of s1  
        int x = s1.peek();  
        s1.pop();  
        
        return x;  
    }  

  
	// Driver code  
	public static void main(String[] args)  
	{  
		QueueWithStacks q = new QueueWithStacks();  
	    q.enQueue(34);  
	    q.enQueue(55);  
	    q.enQueue(0);  
	  
	    System.out.println(q.deQueue());  
	    System.out.println(q.deQueue()); 
	    System.out.println(q.deQueue()); 
	}  
	
}









