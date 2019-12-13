package HackerRank.DisJointSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ComponentsInGraph {

	
	private static HashMap<Integer, ArrayList<Integer>> graph;  // class-scoped graph variable
	private static int curCount;                                // class scoped vertex counter for current DFS traversal

	static int[] componentsInGraph(int[][] gb) 
	{
	    graph = buildGraph(gb);
	    Set<Integer> visited = new HashSet<Integer>();

	    int shortest = Integer.MAX_VALUE;
	    int longest = 0;

	    // Note that our graph may be a disconnected graph
	    // Consider vertices [1, 4], [1, 5], [3, 6], [3, 7], [3, 8]
	    
	    for(Integer node : graph.keySet())
	    {        
	        if(!visited.contains(node))
	        {         
	            curCount = 0;                   // Reset traversal counter to 0
	            DFSSearch(node, visited);       // Traverse it
	                                            // After traversal, curCount contains the number of vertices in that graph

	            longest  = Math.max(curCount, longest);  
	            shortest = Math.min(curCount, shortest);
	        }
	    }

	        int[] ans = {shortest, longest};
	        return ans;
	 }

    // Standard DFS traversal, except on each recursive call, curCount is incremented
    private static void DFSSearch(int current_node, Set<Integer> visited)
    {
        visited.add(current_node);
        curCount++;             			

        for(Integer node : graph.get(current_node))
            if(!visited.contains(node))     
                    DFSSearch(node, visited);     
    }


    // Converts given 2D array into a graph
    // Instead of typical adecency list (aka a list of lists), I have a mapping of Vertex to all of its connected Vertices
    // Since we aren't guarenteed that all edge values will be continious
    // (ie. we can't guarentee we'll get [1, 4], [2, 5], [3, 6] -- instead we may get [2, 4], [2, 5], [2, 6], notice that 1 and 3 are not present)
    
    private static HashMap<Integer, ArrayList<Integer>> buildGraph(int[][] gb)
    {
	    HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();

	    for(int[] node : gb)
	    {
	        int n0 = node[0];
	        int n1 = node[1];

	        if(graph.get(n0) == null)
	            graph.put(n0, new ArrayList<Integer>());
	        
	        if(graph.get(n1) == null)
	            graph.put(n1, new ArrayList<Integer>());
	        

	        graph.get(n0).add(n1);
	        graph.get(n1).add(n0);
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


























