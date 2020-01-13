package HackerRank.Searching;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

//  https://www.quora.com/What-is-the-logic-used-in-the-HackerRank-Maximise-Sum-problem
// IMPORTANT:	1, (a+b) % mod = (a % mod + b % mod) % mod
//				2, (a-b) % mod = (a % mod - b % mod) % mod

//				pl (2+7) % 4   = (2%4 + 7%4) % 4
//					9%4 = 1	   =  (2 + 3) % 4 = 1	

public class MaxSubArrayMod {

	// +/- arrays...
	static long maximumSumBasic(long[] arr, long mod) 
    {
		int size = arr.length; 
		long max_so_far = Integer.MIN_VALUE, max_ending_here = 0; 
  
        for (int i = 0; i < size; i++) 
        { 
            max_ending_here = max_ending_here + arr[i]; 
            
            if (max_so_far < max_ending_here) 
                max_so_far = max_ending_here; 
            if (max_ending_here < 0) 
                max_ending_here = 0; 
        } 
        return max_so_far; 
    }
	
	// the modular problem
	static long maximumSum(long[] arr, long mod) 
	{
		long maxSum = 0;	
		long currentSum = 0;		
		TreeSet<Long> prefix = new TreeSet<Long>();		
		
		for(int i=0; i<arr.length; i++)
		{
			currentSum			= (currentSum + arr[i] % mod) % mod;
			SortedSet<Long> set = prefix.tailSet(currentSum+1);
			Iterator<Long> itr 	= set.iterator();
			
			if(itr.hasNext())
				maxSum = Math.max(maxSum, (currentSum - itr.next() + mod) % mod);
			
			maxSum = Math.max(maxSum, currentSum);
			prefix.add(currentSum);
		}		
		
		return maxSum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long[] arr = {1, 5, 9};
		
		maximumSum(arr, 5);
	}

}
