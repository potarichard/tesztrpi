package HackerRank.Implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EmaSupercomputer {

	// minden pontbol bfs fel le bal jobb, ha minden iranyba sikerult akkor a temporary visiting = visited es mehet tovabb
//	int[][] visited = new int[rows][cols];		// 1 el az 1 kiterjedésûeket, 2 2 es kiterjedesu ...
//	// aztan loop megtalálni a 2 legnagyobb számot abbol rogton tu nemjo mert product kell es abbol nehez
	
	
    static int twoPluses(String[] grid) 
    {
    	int product = 0;
    	int rows = grid.length;
    	int cols = grid[0].length();    
    	Character[][] ch_grid = new Character[rows][cols];
    	List<Character[][]> pluses = new ArrayList<Character[][]>();
    	
    	for(int i=0; i<rows; i++)
    		for(int k=0; k<cols; k++)
        		ch_grid[i][k] = grid[i].charAt(k); 
    	
    	
    	for(int row=1; row<rows-1; row++)
    	{
    		for(int col=1; col<cols-1; col++)
    		{
    			if(ch_grid[row][col] != 'B')
    				explore(pluses, ch_grid, row, col);
    		}
    	}
    	
    	if(pluses.size() == 0)
    		return 0;
    	if(pluses.size() == 1)
    		return getArea(pluses.get(0));
    		
    	for(int i=0; i<pluses.size(); i++)
    		for(int k=i+1; k<pluses.size(); k++)
    			product = Math.max(product, product(pluses.get(i), pluses.get(k)));
    	
    	return product;
    }
	
    
    
    // visiteden 2 lesz, chgriden B
	private static void explore(List<Character[][]> pluses, Character[][] ch_grid, int row, int col) 
	{
		int[] mh = {1, -1,  0,  0};
	    int[] mv = {0,  0,  1, -1};
	    
		int rows = ch_grid.length;
		int cols = ch_grid[0].length;
		int nrow, ncol;
		int layer = 1;
		boolean loop = true;
		boolean anything_to_add = false;
		
		Character[][] grid = new Character[rows][cols];
		for(Character[] gr : grid)
			Arrays.fill(gr, '0');
		
		while(loop)
		{
			int move_counter = 0;
			
			for(int i=0; i<4; i++)		// move 4 dir
			{
				nrow = row + mv[i];
				ncol = col + mh[i];
				
				if(nrow<0 || nrow >= ch_grid.length ||
						(ncol<0 || ncol >= ch_grid[i].length) ||
							(ch_grid[nrow][ncol] == 'B'))
					{
						loop = false;
						break;
					}
				
				move_counter++;
			}
			
			if(move_counter == 4)
			{
				grid[row][col] = 'X';
				anything_to_add = true;	
				
				for(int i=0; i<4; i++)
				{
					nrow = row + mv[i];
					ncol = col + mh[i];
					
					grid[nrow][ncol] = 'X';									
				}
				
				layer++;
				
				for(int i=0; i<4; i++)
				{
					mv[i] *= layer;
					mh[i] *= layer;;
				}
			}
		}
		
		if(anything_to_add)
			pluses.add(grid);
		
	}
	
	static int product(Character[][] grid1, Character[][] grid2)
	{
		if(!overlap(grid1, grid2))
			return getArea(grid1)*getArea(grid2);
		
		return 0;
	}
	
	static boolean overlap(Character[][] grid1, Character[][] grid2)
	{
		int rows = grid1.length;
		int cols = grid1[0].length;
		
		for(int row=0; row<rows; row++)
    	{
    		for(int col=0; col<cols; col++)
    		{
    			if(grid1[row][col] == 'X' && grid2[row][col] == 'X')
    				return true;
    		}
    	}		
		
		return false;
	}
	
	static int getArea(Character[][] grid)
	{
		int sum = 0;
		int rows = grid.length;
		int cols = grid[0].length;
		
		for(int row=0; row<rows; row++)
    		for(int col=0; col<cols; col++)
    			if(grid[row][col] == 'X')
    				sum ++;
		
		return sum;
	}
	

	public static void main(String[] args) {
		
		String[] grid1 = { 	"GGGGGG",
							"GBBBGB",
							"GGGGGG",
							"GGBBGB",
							"GGGGGG"};
		
		String[] grid2 = { 	"BGBBGB",
							"GGGGGG",
							"BGBBGB",
							"GGGGGG",
							"BGBBGB",
							"BGBBGB"};
		
		String[] grid3 = { 	"BBBGBBB",
							"BBBGBBB",
							"BGGGGGB",
							"BBBGBBB",
							"BBBGBBB",
							"BBBBBBB"};

		twoPluses(grid3);
	}

}











