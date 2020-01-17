package HackerRank.Greedy;

import java.util.Arrays;

public class Maxmin {

	// create subarrays with lengths k. find min of: max(subarray) - min(subarray)
	// 1,4,7,2  és k = 2 -> 
    static int maxMin(int len, int[] arr) 
    {    	
    	
    	
    	int max_subarrays = (int) Math.pow(2, arr.length);
    	int min = Integer.MAX_VALUE;
    	
    	for(int i=0; i<max_subarrays; i++)
    	{
    		if(Integer.bitCount(i) == len)
    		{
    			int index = 0, diff;
        		int[] sub_arr = new int[len];
        		
    			for(int k=0; k<arr.length; k++)
        		{
        			if((1<<k & i) > 0)
        				sub_arr[index++] = arr[k];
        		}
    			
    			Arrays.sort(sub_arr);
    			
    			diff = sub_arr[len-1] - sub_arr[0];
    			
    			if(diff >= 0)    			
    				min = Math.min(min, diff);
    		}    			
    	}
    	
    	return min;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {4504,1520,5857, 4094,4157,3902,	822,6643,2422,7288,	8245,9948,2822,	1784,7802,3142,	9739,5629,5413,	7232};
		
		maxMin(5, arr);
	}

}













