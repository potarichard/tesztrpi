package byteBybyte;

public class MatrixProductLongestPath {
	
	static int longestPathOnlyPositives(int[][] mat)
	{
		int[][] dp = new int[mat.length][mat[0].length];
		dp[0][0] = mat[0][0];
		
//		a maximum kell vagy a mellette levobol balra vagy felette levobol
		for (int row=0; row<mat.length; row++)
		{
			for (int col=0; col<mat[0].length; col++)
			{
				if(row == 0 && col == 0)
					continue;
				if(row == 0 && col > 0)
					dp[0][col] = mat[0][col] * mat[0][col-1];
				else if(col == 0 && row > 0)
					dp[row][0] = mat[row][0] * mat[row-1][0];				
				else
					dp[row][col] = mat[row][col] * Math.max(dp[row][col-1], dp[row-1][col]);
			}
		}
		
		return dp[dp.length-1][dp[0].length-1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] mat = 
			{
					{1, 2, 3},
					{4, 5, 6},
					{7, 8, 9}
			};
		
//		1 -> 4 -> 7 -> 8 -> 9  = 2016

		System.out.println(longestPathOnlyPositives(mat));
		
	}

}
