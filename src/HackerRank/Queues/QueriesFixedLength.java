package HackerRank.Queues;

import java.util.PriorityQueue;

public class QueriesFixedLength {

	
	static int[] solve(int[] arr, int[] queries) 
	{
		int[] ret = new int[queries.length];
		int c = 0;
		PriorityQueue<Integer> maxQue;		
		
		for(int query : queries)
		{
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			
			for(int i=0, k=0; i<arr.length; i++)
			{
				if((i+query) > arr.length)
					break;
					
				maxQue = new PriorityQueue<Integer>((a,b) -> b-a);
				
				while(k<query)
				{
					maxQue.add(arr[i+k]);
					k++;
				}
				
				k=0;
				
				if(!maxQue.isEmpty())
				{
					max = maxQue.poll();		
					min = Math.min(min, max);
				}
			}			
			
			ret[c++] = min;
		}

		return ret;
    }
	
	static int[] solveNoQ(int[] arr, int[] queries) 
	{
		int[] ret = new int[queries.length];
		
		int c = 0;			
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int query : queries)
		{
			min = Integer.MAX_VALUE;
			
			for(int i=0, k=0; i<arr.length; i++)
			{
				if((i+query) > arr.length)
					break;
				
				max = Integer.MIN_VALUE;
				k = 0;
				
				while(k<query)
				{
					max = Math.max(max, arr[i+k]);
					k++;
				}				
						
				min = Math.min(min, max);
			}			
			
			ret[c++] = min;
		}

		return ret;
    }
	
	// 1. min( max(33), max(11)...
	// 2. min( max(33,11), max(11, 44)
	// 3. min( max(33,11,44), max(11, 44, 11)
	// 4. min( max(33,11,44, 11), max(11, 44, 11, 55)
	// 5. min( max(33,11,44, 11, 55)
	
	// ret 11, 33, 44, 44, 55
	public static void main(String[] args) {
		
		int[] arr = {33, 11, 44, 11, 55};
//		int[] arr = {1, 2, 3, 4, 5};
		int[] queries = {1, 2, 3, 4, 5};
		
		solveNoQ(arr, queries);
	}

}























