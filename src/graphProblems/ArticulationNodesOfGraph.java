package graphProblems;

import java.util.List;

public class ArticulationNodesOfGraph 
{

	private int n, id, rootNodeOutcomingEdgeCount;
	private int[] low, ids;
	private boolean[] visited, isArticulationPoint;
	private List<Integer>[] graph;
	
	
	public boolean[] findArticulationPoints(GraphUndirected graph) 
	{		
		this.graph = graph.nodes;
	    this.n = this.graph.length;
	    
	    low = new int[n];
	    ids = new int[n];
	    visited = new boolean[n];
	    isArticulationPoint = new boolean[n];

	    id = 0;
	    
	    for (int i = 0; i < n; i++) 
	    {
	      if (!visited[i]) 
	      {
	        rootNodeOutcomingEdgeCount = 0;
	        dfs(i, i, -1);
	        isArticulationPoint[i] = (rootNodeOutcomingEdgeCount > 1);		// csak akkor valoban az, ha kimeno élek száma > 1 (egy kivetel van ez igy van lekezelve)
	      }
	    }

	    return isArticulationPoint;
	 }

	// hasonloan mint a bridgnel, idk beallitasa, majd low valuek
	// cycle keresés a gráfban, akkor van kör ha a low valuek visszaérnek a kezdõ node idjahoz
	// pl 0 id nodebol indult, mire vegez a dfs, a 1-es id node nak is 0 lesz a low value
	// tehát kör van a gráfban, a kör ahonnan indult és ha ide visszaér az a node articulation point
	private void dfs(int root, int at, int parent) 
	{
	    if (parent == root) 
	    	rootNodeOutcomingEdgeCount++;

	    visited[at] = true;
	    low[at] = ids[at] = id++;

	    List<Integer> edges = graph[at];
	    for (Integer to : edges) 
	    {
	      if (to == parent) 
	    	  continue;
	      
	      if (!visited[to]) 
	      {
	        dfs(root, to, at);
	        low[at] = Math.min(low[at], low[to]);
	        
	        if (ids[at] <= low[to]) 
	          isArticulationPoint[at] = true;
	      } 
	      
	      else 
	        low[at] = Math.min(low[at], ids[to]);		      
	    }
	}

	
	public static void main(String[] args) 
	{
		ArticulationNodesOfGraph anog = new ArticulationNodesOfGraph();
		GraphUndirected graph = new GraphUndirected(9);
		
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		
		graph.addEdge(1, 2);
		
		graph.addEdge(2, 3);
		graph.addEdge(2, 5);
		
		graph.addEdge(3, 4);
		
		graph.addEdge(5, 6);
		
		graph.addEdge(6, 7);
		
		graph.addEdge(7, 8);
		
		graph.addEdge(8, 5);
		
		anog.findArticulationPoints(graph);
		
		System.out.println();

	}

}
