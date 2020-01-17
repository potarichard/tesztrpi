package HackerRank.Greedy;

import java.util.Arrays;

public class MinAbsDiff {

//	sort, diff (0-1), dif  
//	ha sorba rendezem mindig csak ket egymast koveto elemnek lehet minimum diffje
	static int minimumAbsoluteDifference(int[] arr) 
    {
		int min = Integer.MAX_VALUE;
		
		Arrays.sort(arr);
		
		min = Math.abs(arr[0] - arr[1]);
		
		for(int i=0; i<arr.length-1; i++)
			min = Math.min(min, Math.abs(arr[i] - arr[i+1]));
		
		return min;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {1, -3, 71, 68, 17};
		
		minimumAbsoluteDifference(arr);
	}

}
