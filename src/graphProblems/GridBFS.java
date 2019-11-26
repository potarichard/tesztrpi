package graphProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GridBFS 
{

	private char[][] grid = null;
	private Integer[][] path;
	private Integer[] path_linear;
	private int 	rows = 0, cols = 0,
					sr = 0, sc = 0,					// Start index
					move_count = 0, 
					nodes_current_layer = 1,		// 1 node biztos van kezdeskor, maga a kezdo node
					nodes_next_layer = 0;			// feltetelek teljeseulnek a "felfedezeskor" novelni kell nodok szamat (connected, unvisited nodes number in the next iteration)
	private boolean[][] visited = null;
	private int[]	dr = {-1,  1,  0,  0},			// rows possible movement up, down
					dc = { 0,  0, -1,  1}; 			// cols possible movement left, right
	
	private Queue<Integer> rq = new LinkedList<Integer>();		
	private Queue<Integer> cq = new LinkedList<Integer>();
	
	public GridBFS(Grid gdobj)
	{
		this.grid = gdobj.grid;
		
		if(grid != null)
		{
			this.rows = grid.length;
			this.cols = grid[0].length;
			this.visited = new boolean[rows][cols];
			this.path = new Integer[rows][cols];
			this.path_linear = new Integer[rows*cols];
		}		
	}
	
	public int reachEndWithBFS()
	{
		int row, col;
		
		rq.add(sr);
		cq.add(sc);
		visited[sr][sc] = true;
		
		printGrid();
		
		while(rq.size() > 0)			// sima bfs, csak ket queut kell kezelni egyszerre, meg ellenorizni kell a cel elereset, es szamolni kell a lepeseket
		{
			row = rq.poll();
			col = cq.poll();
			
			if(this.grid[row][col] == 'E')
				return move_count;
			
			exploreNeighbours(row, col);
			
			nodes_current_layer--;				// bfs soran az osszes childnode, ami a parentbol jott
			
			if(nodes_current_layer == 0)		// olyan mintha egy lepesben az osszes lehetseges lepest megtettem volna a nodeokbol a layerben
			{
				nodes_current_layer = nodes_next_layer;
				nodes_next_layer = 0;
				move_count++;
				
				printGrid();
			}
		}
		
		return -1;
	}
	
	
	
	private void exploreNeighbours(int row, int col) 
	{
		int new_row, new_col;			// the neighbour col, and row coordinate,  like in a grap 2 nodes connected, in a grid if 2 cels are neighbours they are connected
		
		for(int i=0; i<4; i++)
		{
			new_row = row + dr[i];
			new_col = col + dc[i];
			
			if(new_row < 0 || new_row >= grid.length)
				continue;
			if(new_col < 0 || new_col >= grid[i].length)
				continue;
			if(visited[new_row][new_col])
				continue;
			if(grid[new_row][new_col] == '#')
				continue;
			
			rq.add(new_row);
			cq.add(new_col);
			visited[new_row][new_col] = true;
			nodes_next_layer++;
			
			// prev_row = row
			// prev_col = col   just save it
			
			addPath(row, col, new_row, new_col);
		}		
	}
	
	private void addPath(int row, int col, int new_row, int new_col)
	{
		// 0 1 2 3 4 5 
		// 6 7 8 9 10 11
		
		// index = col + row*row.length
		
		Integer new_index = new_col + new_row*grid[0].length;
		Integer old_value = col + row*grid[0].length;
		
		path_linear[new_index] = old_value;
	}

	private void printPath()
	{
		for(int i=0; i<path_linear.length; i++)
		{
			if(i%grid[0].length == 0)
				System.out.println();
			if(path_linear[i] == null)
				System.out.print(" . ");
			else
			{
				if(path_linear[i]/10 < 1)
					System.out.print(" " + path_linear[i] + " ");
				else
					System.out.print(path_linear[i] + " ");
			}
				
		}
	}
	
	private void printGrid()
	{
		System.out.println(move_count + ". move");
		
		for(int i=0; i<visited.length; i++)
		{
			for(int k=0; k<visited[i].length; k++)
			{
				if(grid[i][k] == 'E')
					System.out.print(" E ");
				else if(visited[i][k])
					System.out.print(" v ");
				else if(grid[i][k] == '#')
					System.out.print(" # ");
				else
					System.out.print(" . ");
			}
			System.out.println();
		}
	}
	
	public void printShortestPath(int start, int end)
	{
		Integer[] paths = this.path_linear;
		
		List<Integer> path = new ArrayList<Integer>();
		
		Integer i = end;
		
		while(i != null)
		{
			path.add(i);
			i=paths[i];				// ertek = indexen levo ertek !
		}					
		
		Collections.reverse(path);
		
		if(path.get(0) == start)
		{
			System.out.println("\n\npath: ");
			
			for(Integer node : path)
				System.out.print(node + " ");
		}
		
		else
			System.out.println("no path");
	}
	
	public static void main(String[] args) 
	{
		
		GridBFS gbfs = new GridBFS(new Grid());

		int moves = gbfs.reachEndWithBFS();
		
		System.out.println("\nEnd reached in: " + moves);
		System.out.println("and the shortest path is: ");
		
		gbfs.printPath();
		
		System.out.println("\n\n");
		
		gbfs.printShortestPath(0, 32);
	}

}
