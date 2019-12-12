package HackerRank.DisJointSet;

import java.util.ArrayList;
import java.util.HashMap;

public class ComponentsInGraph {

	
	private static HashMap<Integer, ArrayList<Integer>> graph;  // class-scoped graph variable
	private static int curCount;                                // class scoped vertex counter for current DFS traversal

	static int[] componentsInGraph(int[][] gb) 
	{
	    graph = buildGraph(gb);
	    HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>();

	    int shortest = Integer.MAX_VALUE;
	    int longest = 0;

	    // Note that our graph may be a disconnected graph
	    // Consider vertices [1, 4], [1, 5], [3, 6], [3, 7], [3, 8]
	    
	    for(Integer i : graph.keySet())			// Go through every vertex in the graph
	    {        
	        if(visited.get(i) == null)
	        {         
	            curCount = 0;                   // Reset traversal counter to 0
	            DFSSearch(i, visited);          // Traverse it
	                                            // After traversal, curCount contains the number of vertices in that graph. 
	            								// This may or may not be the only graph

	            longest = Math.max(curCount, longest);  
	            shortest = Math.min(curCount, shortest);
	        }
	    }

	        int[] ans = {shortest, longest};
	        return ans;
	 }

    // Standard DFS traversal, except on each recursive call, curCount is incremented
    private static void DFSSearch(int curVal, HashMap<Integer, Boolean> visited)
    {
        visited.put(curVal, true);
        curCount++;             			

        for(Integer i : graph.get(curVal))
            if(visited.get(i) == null)     
                    DFSSearch(i, visited);     
    }


    // Converts given 2D array into a graph
    // Instead of typical adecency list (aka a list of lists), I have a mapping of Vertex to all of its connected Vertices
    // Since we aren't guarenteed that all edge values will be continious
    // (ie. we can't guarentee we'll get [1, 4], [2, 5], [3, 6] -- instead we may get [2, 4], [2, 5], [2, 6], notice that 1 and 3 are not present)
    
    private static HashMap<Integer, ArrayList<Integer>> buildGraph(int[][] gb)
    {
	    HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();

	    for(int[] edge : gb)
	    {
	        int e0 = edge[0];
	        int e1 = edge[1];

	        if(graph.get(e0) == null)
	            graph.put(e0, new ArrayList<Integer>());
	        
	        if(graph.get(e1) == null)
	            graph.put(e1, new ArrayList<Integer>());
	        

	        graph.get(e0).add(e1);
	        graph.get(e1).add(e0);
	    }

	    return graph;
    }
	
	public static void main(String[] args) {
		
		// egy node par van osszekotve, undirected
		// so 1-6, 2-[7,6]..
		int[][] gb_something = {	{1, 6}, 
									{2, 7},
									{3, 8},
									{4, 9},
									{2, 6}};

		componentsInGraph(gb_something);
	}

}


























