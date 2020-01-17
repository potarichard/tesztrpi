package HackerRank.Searching;

public class MaximumConnectedCells {

	// aka largest island
	static int connectedCell(int[][] matrix) 
	{
		int cells = 0;
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		
		for(int i=0; i<matrix.length; i++)
		{
			for(int k=0; k<matrix[i].length; k++)
			{
				if(matrix[i][k] == 1 && !visited[i][k])
					cells = Math.max(cells, 1 + dfs(matrix, visited, i, k));					
			}
		}
		
		return cells;
    }
	
	static boolean isSafe(int[][] matrix, boolean[][] visited, int new_row, int new_col)
	{
		if(new_row < 0 || new_col < 0)
			return false;
		if(new_row >= matrix.length || new_col >= matrix[0].length)
			return false;
		if(matrix[new_row][new_col] == 0 || visited[new_row][new_col])
			return false;
		
		return true;
	}
	
	static int[] rm = { 1, -1,  0,  0};
	static int[] cm = { 0,  0,  1, -1};
	
	static int dfs(int[][] matrix, boolean[][] visited, int row, int col)
	{
		int sum = 0;
		
		visited[row][col] = true;
		
		for(int i=0; i<4; i++)
		{
			int new_row = row + rm[i];
			int new_col = col + cm[i];
			
			if(isSafe(matrix, visited, new_row, new_col))	
				sum += 1 + dfs(matrix, visited, new_row, new_col);	
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] matrix = {	{1, 1, 0, 0},
							{0, 1, 1, 0},
							{1, 0, 1, 1},
							{1, 0, 1, 0}};
		
		System.out.println(connectedCell(matrix));
		
	}

}










