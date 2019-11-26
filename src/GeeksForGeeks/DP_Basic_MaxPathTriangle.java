package GeeksForGeeks;

public class DP_Basic_MaxPathTriangle 
{

	public static int maxPath(int[][] grid)
	{
		int max1 = 0, max2 = 0;
		int rows = grid.length;
		int cols = grid[0].length;
		
		for(int row=rows-2; row>=0; row--)
		{
			for(int col=0; col<row+1; col++)
			{		
				max1 = max2 = 0;
				
				if(col<cols-1)
					max1 = Math.max(grid[row+1][col], grid[row+1][col+1]);
				if(col>0)
					max2 = Math.max(grid[row+1][col], grid[row+1][col-1]);
				
				grid[row][col] += Math.max(max1, max2);
			}
		}
		
		return grid[0][0];
	}
	
	public static int minPath(int[][] grid)
	{
		int min1 = 0, min2 = 0;
		int rows = grid.length;
		int cols = grid[0].length;
		
		for(int row=rows-2; row>=0; row--)
		{
			for(int col=0; col<row+1; col++)
			{		
				min1 = min2 = Integer.MAX_VALUE;
				
				if(col<cols-1)
					min1 = Math.min(grid[row+1][col], grid[row+1][col+1]);
				if(col>0)
					min2 = Math.min(grid[row+1][col], grid[row+1][col-1]);
				
				grid[row][col] += Math.min(min1, min2);
			}
		}
		
		return grid[0][0];
	}
	
	public static void main(String[] args) 
	{
		
		int[][] triangle = 
			{
					{3, 0, 0, 0},
					{7, 4, 0, 0},
					{2, 4, 6, 0},
					{8, 5, 9, 3}
			};
		
		int max = maxPath(triangle);		
		System.out.println(max);

		int[][] triangle2 = 
			{
					{3, 0, 0, 0},
					{7, 4, 0, 0},
					{2, 4, 6, 0},
					{8, 5, 9, 3}
			};
		
		int min = minPath(triangle2);		
		System.out.println(min);
	}

}
