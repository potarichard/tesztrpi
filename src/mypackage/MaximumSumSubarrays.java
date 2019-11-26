package mypackage;

public class MaximumSumSubarrays 
{
	// time O(n^2), space O(1)  
	public int maxContigousSubarrayBF(int[] arr)
	{
		int max = 0, max_start = 0, max_end = 0;
		int sum;
		
		for(int i=0; i<arr.length; i++)
		{
			sum = arr[i];
			
			if(sum > max)
			{
				max = sum;
				max_start = i;
				max_end = i;
			}
				
			
			for(int k=i+1; k<arr.length; k++)
			{
				sum += arr[k];
				
				if(sum > max)
				{
					max = sum;
					max_start = i;
					max_end = k;
				}
					
			}
		}
		
		return max;
	}
	
	// time O(n), space O(n)  
	public int maxContigousSubarray(int[] arr)
	{
		
		int[] dp = new int[arr.length];
		dp[0] = arr[0];
		int max = dp[0] ;
		
		for(int i=1; i<arr.length; i++)
		{
			dp[i] = arr[i] + (dp[i-1] > 0 ? dp[i-1] : 0);
			
			max = Math.max(max, dp[i]);
		}
		
		
		return max;
	}

	public static void main(String[] args) 
	{
	
		int[] arr = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};			// largest sum of countinous array is 6, {4, -1, 2, 1}

		MaximumSumSubarrays ms = new MaximumSumSubarrays();
		
		System.out.println( ms.maxContigousSubarrayBF(arr) );
		
		System.out.println( ms.maxContigousSubarray(arr) );
		
	}

}
















