package mypackage;

import java.util.ArrayList;
import java.util.List;

public class SearchMaximumSubarraySum 
{

	// subarray != subset
	// subarray csak egymast koveto elemek
	// subset barmely elemek
	
	// https://www.geeksforgeeks.org/maximum-subarray-sum-using-divide-and-conquer-algorithm/

	// https://www.geeksforgeeks.org/generating-subarrays-using-recursion/	
	
	static List<ArrayList<Long>> getAllSubarrays(long[] arr)
	{
		int group_size = 1;
		int n = arr.length;
		int start, end, i;
		
		List<ArrayList<Long>> subs = new ArrayList<ArrayList<Long>>();
		ArrayList<Long> sub = new ArrayList<Long>();
		
		while(group_size <= n)
		{
			start = 0;
			end = 0;
			i=0;
			
			while(end < n)
			{
				sub = new ArrayList<Long>();				
				end = start + group_size;
				
				while(sub.size() < group_size)			// itt lehetne groupcount valtozo is   (groupcount < group_size)
				{
					sub.add(arr[i]);	
					i++;
				}
				
				start++;
				i=start;				
				
				subs.add(sub);
			}
			
			group_size++;
		}
		
		
		return subs;
	}
	
	static long maxSubarraySum(long[] arr, int mod)
	{
		int group_size = 1;
		int n = arr.length;
		int start, end, i;
		long sum = 0, maxmod = 0, count = 0;
		
		
		while(group_size <= n)
		{
			start = 0;
			end = 0;
			i=0;
			
			while(end < n)
			{		
				end = start + group_size;
				sum = 0;
				count = 0;
				
				while(count < group_size)
				{					
					sum += arr[i];					
					i++;
					count++;
				}
				
				maxmod = Math.max(maxmod, sum%mod);
				
				
				
				start++;
				i=start;				
				
			}
			
			group_size++;
		}
		
		
		return maxmod;
	}

	public static void main(String[] args) 
	{
		
		long[] arr = {1, 2, 3, 4};
		
		getAllSubarrays(arr);

		System.out.println("maxmod: " + maxSubarraySum(arr, 2));
	}

}









