package HackerRank.Queues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DownToZero {

	static int downToZero(int n) 
	{
		int count = 0;
		int largest_div;
		
        while(n > 0)
        {
        	largest_div = largestDivisor(n);
        	
        	if(largest_div != 1 && largest_div != n)
        		n = largest_div;
        	else
        		n--;
        	
        	count++;
        }
		
		return count;
    }
	
	// a szam felétõl elkezd lépegetni amig meglesz az osztó
	static int largestDivisor(int n) 
	{
	    for (int i = n/2; i >= 2; i--) 
	        if (n % i == 0) 
	            return i;
	    
	    return 1;
	}
	
	
	static int downToZeroDynamic(int n) 
	{				
		class Item
		{
			int value;
			int step;
			
			public Item(int value, int step)
			{
				this.value 	= value;
				this.step	= step;
			}
		}
		
		Item first, second;		
		Queue<Item> que = new LinkedList<Item>();
		
		que.add(new Item(n, 0));	
				
		while(!que.isEmpty())
		{
			Item from_que = que.poll();
			
			System.out.print(from_que.value + ", ");
			
			first = new Item(from_que.value-1, from_que.step+1);
			
			int largest_div = largestDivisor(from_que.value);
			
			if(largest_div != 1 && largest_div != from_que.value)
				second = new Item(largest_div, from_que.step+1);
			else
				second = new Item(from_que.value-1, from_que.step+1);		
			
			if(first.value == 0 || second.value == 0)
			{
				if(first.value == 0)
					return first.step;
				else if(second.value == 0)
					return second.step;
			}		
			
			else
			{
				if(first.value == second.value)
					que.add(first);
				else
				{
					que.add(first);
					que.add(second);
				}
				
			}
		}
		
		return -1;	
	}
	
//	continue sequenc till 0.  Can decrement OR number = a x b (a != 1 & b != 1)  number -> max(a,b) 
//	1. case  3-> 2-> 1-> 0.  = 3  moves
//	2. case  4-> 3-> 2-> 1-> 0  or  4-> 2-> 1-> 0	 min(4, 3) = 3 moves minimum
	
	public static void main(String[] args) 
	{
	
		System.out.println("\n" + downToZeroDynamic(94));	// 17 x 18 es matrix 
		
	}

}
















