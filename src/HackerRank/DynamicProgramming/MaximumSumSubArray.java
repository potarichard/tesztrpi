package HackerRank.DynamicProgramming;

import java.util.Arrays;

public class MaximumSumSubArray {

	
	// maxsum but also the array
	// {-1, 2, 3, -4, 5, 10}
    static int[] maxSubarray(int[] arr) 
    {
    	//1) For max continuous sub array
        int max_ending_here = 0;
        int max_so_far = Integer.MIN_VALUE;

        for(int x : arr){
            max_ending_here = Math.max(x, max_ending_here + x);
            max_so_far = Math.max(max_so_far, max_ending_here);
        }

        //2) For max non-continuous sub array, order doesn't matter
        Arrays.sort(arr);
        
        int sum = 0;

        //if there is none positive value in entire array
        if(arr[arr.length-1] <= 0)
            sum = arr[arr.length - 1];
        
        //accumulate all positive values in entire array
        else
        {
            for(int x : arr)
                if(x > 0)
                    sum += x;
        }
        
        int[] ret = {max_so_far, sum};
        
        
        return ret;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {-1, 2, 3, -4, 5, 10};
		
//		int[] arr = {-1, -2, -3, -4, -5, -10};
		
		maxSubarray(arr);
	}

}
