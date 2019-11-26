package HackerRank;

//- n: an integer, the number of rows and columns in the board
//- k: an integer, the number of obstacles on the board
//- r_q: integer, the row number of the queen's position
//- c_q: integer, the column number of the queen's position
//- obstacles: a two dimensional array of integers where each element is an array of  integers, the row and column of an obstacle

public class QueenAttack 
{
//	from queen postion, mark cells, 1 and count the same time
	
//	8 iranyba mehet    F, JF,  J, JL,  L, BL,  B, BF
    int[] row_move = {-1, -1,  0,  1,  1,  1,  0, -1}; 
    int[] col_move = { 0,  1,  1,  1,  0, -1, -1, -1};
    
	int queensAttack(int n, int k, int rq, int cq, int[][] grid) 
    {
		int count = 0;
		
		for(int i=0; i<8; i++)		// minden iranyba megyek amig tart a bor
		{
			int new_row = rq + row_move[i];
			int new_col = cq + col_move[i];
			
			while(isValid(grid, new_row, new_col))
			{
				grid[new_row][new_col] = 1;
				count++;
				new_row += row_move[i];
				new_col += col_move[i];
			}		
		}
		
		return count;
    }
	

    
	boolean isValid(int[][] grid, int row, int col)
	{		
		if(row<0 || row >= grid.length)
			return false;
		if(col<0 || col >= grid[0].length)
			return false;
		if(grid[row][col] == -1)
			return false;
		
		return true;
	}

	public static void main(String[] args) 
	{
		int n=5;
		int[][] obstacles = 
			{
					{ 0, 0, 0, 0,-1},
					{ 0,-1, 3, 0, 0},
					{ 0, 0, 0, 0, 0},
					{ 0, 0,-1, 0, 0},
					{ 0, 0, 0, 0, 0}
			};
		
		QueenAttack qa = new QueenAttack();

		qa.queensAttack(5, 3, 1, 2, obstacles);
	}

}
