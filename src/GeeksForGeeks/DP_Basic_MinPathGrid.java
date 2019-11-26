package GeeksForGeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import graphTheory.Dijkstra.Graph.Node;

public class DP_Basic_MinPathGrid 
{

	// a vegpontbol vissza indulva minden iranyba szetnezunk es a legkissebhez hozzadjuk magunkat, majd oszlop vagy sor no, es o magat integer maxra allitom
	private static int minCost(int cost[][], int x, int y) 
    { 
		
		
		return cost[0][0];
    }
	
	static int rows, cols;
	
	private static int surroundingMin(int cost[][], int x, int y)
	{
		return 0;
	}
	
	private static int min(int x, int y, int z) 
    { 
        if (x < y) 
            return (x < z)? x : z; 
        else
            return (y < z)? y : z; 
    } 
	
    private static int minCostStandard(int cost[][], int m, int n) 
    { 
        int i, j; 
        int tc[][]=new int[m+1][n+1]; 
  
        tc[0][0] = cost[0][0]; 
  
        /* Initialize first column of total cost(tc) array */
        for (i = 1; i <= m; i++) 
            tc[i][0] = tc[i-1][0] + cost[i][0]; 
  
        /* Initialize first row of tc array */
        for (j = 1; j <= n; j++) 
            tc[0][j] = tc[0][j-1] + cost[0][j]; 
  
        /* Construct rest of the tc array */
        for (i = 1; i <= m; i++) 
            for (j = 1; j <= n; j++) 
                tc[i][j] = min(tc[i-1][j-1],  
                               tc[i-1][j], 
                               tc[i][j-1]) + cost[i][j]; 
  
        return tc[m][n]; 
    }
    
    
    
    /////////////// turn to graph problem eplore neighbours and bfs
    
    PriorityQueue<Node> que;
	boolean[][] visited;
	int[][] graph;
	int[][] prev;
	int[][] min_distance;
	
	private static class Node implements Comparable<Node>
	{
		int row, col, w;
		
		public Node(int row, int col, int weight)
		{
			this.row = row;
			this.col = col;
			this.w = weight;
		}

		@Override
		public int compareTo(Node compareto) 
		{
			
			if(this.w < compareto.w)
				return -1;
			else if(this.w > compareto.w)
				return 1;
			
			return 0;
		}
	}
	
	// 8 iranyba mehet    F, JF,  J, JL,  L, BL,  B, BF
    int[] row_move = {-1, -1,  0,  1,  1,  1,  0, -1}; 
    int[] col_move = { 0,  1,  1,  1,  0, -1, -1, -1};
    
	private void exploreNeighBours(Node node) 
	{
		
		System.out.println();
		
		int row, col;
		
		for(int i=0; i<8; i++)
		{
			row = node.row + row_move[i];
			col = node.col + col_move[i];
			
			if(row < 0 || row >= this.graph.length)
				continue;
			if(col < 0 || col >= this.graph[0].length)
				continue;
			if(visited[row][col])
				continue;
			
			visited[row][col] = true;
			int new_dist = min_distance[node.row][node.col] + graph[row][col];
			
			if (new_dist < min_distance[row][col]) 
	        {
	          prev[row][col] = graph[node.row][node.col];
	          min_distance[row][col] = new_dist;
	          que.add(new Node(row, col, min_distance[row][col]));
	        }
		}
	}
	
    public void bfs(int[][] grid, int row, int col)
    {
    	graph = grid;
    	que = new PriorityQueue<Node>();    	
    	visited = new boolean[grid.length][grid[0].length];
    	
    	min_distance = new int[3][3];	
    	for(int i=0; i<min_distance.length; i++)
    		Arrays.fill(min_distance[i], Integer.MAX_VALUE);	  
    	
	    min_distance[0][0] = 0;
    	
    	que.add(new Node(0, 0, grid[0][0]));
    	visited[0][0] = true;
    	Node node = new Node(0, 0, 0);
    	
    	prev = new int[3][3];
    	
    	while(!que.isEmpty())
    	{
    		node = que.poll();    
    		
    		if(min_distance[node.row][node.col] < node.w)	// found a better way to here
    			continue;
    		
    		exploreNeighBours(node);
    		
    		if(node.row == row && node.col == col)
    		{
    			break;
    		}  
    	}   
    	
    	System.out.println("min dist is: " + min_distance[row][col]);
    }

    public void getPath(int start, int end)
    {
    	List<Integer> path = new ArrayList<>();
    	
    	int[] pprreevv = new int[this.prev.length*this.prev[0].length];
    	int t=0;
    	
    	for(int i=0; i<prev.length; i++)
    	{
    		for(int k=0; k<prev[i].length; k++)
        	{
    			pprreevv[t++] = prev[i][k];
        	}
    	}
    	
    	pprreevv[start] = Integer.MIN_VALUE;
    	
    	for (Integer at = end; at != Integer.MIN_VALUE; at = pprreevv[at]) 
    	{
    		path.add(at);
    		t = 0;
    	}
	    	
    	
    	Collections.reverse(path);
    	
    	System.out.println("kicsit zavaros a dolog az atalakits miatt matrixbol array lett a prev...");
    }
    
	public static void main(String[] args) 
	{
		DP_Basic_MinPathGrid min_p_g = new DP_Basic_MinPathGrid();
		
		int cost[][]= 
			{
				{0,  1,  2}, 
                {3,  4,  5}, 
                {6,  7,  8}
            };		

		min_p_g.bfs(cost,2,2);
		
		min_p_g.getPath(0, 8);
	}

}













