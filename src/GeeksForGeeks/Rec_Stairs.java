package GeeksForGeeks;

import java.util.Arrays;

import GeeksForGeeks.LongestCommonSubsequence.BottomUp;

public class Rec_Stairs 
{

	static int jumps(int stairs)
	{
		if(stairs == 0)
			return 1;
		if(stairs < 0)
			return 0;
		
		return jumps(stairs-3) + jumps(stairs-2) + jumps(stairs-1); 
	}
	
	static int jumpsMemo(int stairs)
	{
		int[] memo = new int[stairs+1];
		Arrays.fill(memo, -1);
		return jumpsMemo(stairs, memo);
	}
	
	static int jumpsMemo(int n, int[] memo)
	{
		if(n == 0)
			return 1;
		if(n < 0)
			return 0;
		if(memo[n] != -1)
			return memo[n];
		
		memo[n] = jumpsMemo(n-3, memo) + jumpsMemo(n-2, memo) + jumpsMemo(n-1, memo);
		
		return memo[n];  
	}
	
	static int bottomUp(int n)
	{
		int[][] table = new int[6][4];
		
		for(int stair=1; stair<table.length; stair++)
		{
			for(int step=1; step<table[0].length; step++)
			{
				if(stair-step-table[stair-1][step] == 0 || stair-step == 0)
					table[stair][step] = Math.max(table[stair-1][step], table[stair][step-1]) + 1;
				else
					table[stair][step] = Math.max(table[stair-1][step], table[stair][step-1]);
			}
		}
		
		return table[table.length-1][table[0].length-1];
	}
	
	public static void main(String[] args) 
	{
//		3 lepcso  2 lepestipus
//		1,1,1
//		1,2
//		2,1
		
//		3 lepcso  3 lepestipus
//		1,1,1
//		1,2
//		2,1
//		3
		
		System.out.println(jumps(5));
		System.out.println(jumpsMemo(5));
		System.out.println(bottomUp(5));

	}

}
