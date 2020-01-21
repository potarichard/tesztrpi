package graphProblems;

import java.util.ArrayList;
import java.util.List;

// Bridge - if u cut the edge u get 2 graphs
// Articulation point - if u remove this node u get 2 graphs
public class BridgesOfGraph 
{

	private int n, id = 0;
	private int[] low, ids;
	private boolean[] visited;
	private List<Integer>[] graph;
	List<Integer> bridges;
	
	public List<Integer> findBridges(GraphUndirected graph) 
	{
		this.graph = graph.nodes;
		this.n = this.graph.length;
		
		low = new int[n];
		ids = new int[n];
		visited = new boolean[n];	
		bridges = new ArrayList<Integer>();	
		
		
		for (int i = 0; i < n; i++) 
			if (!visited[i]) 
				dfs(i, -1, bridges);
	
		return bridges;
	}

//	minden node kap egy id-t (tobbe nem irodik felul)
//	kap egy low valuet is, ami eloszor az id, majd felulirodik azzal a LEGKISEBB id/low valueval 
//	amibe abbol a nodebol el lehet jutni
//	megj. ugy csinalunk mintha directed lenne a graf
//	a loopban atugorja azt amikor to == parent (visszairányt átugorjuk)
	private void dfs(int at, int parent, List<Integer> bridges) 
	{	
	    visited[at] = true;
	    low[at] = ids[at] = id++;
	
	    for (Integer to : graph[at]) 
	    {
	      if (to == parent) 
	    	  continue;
	      if (!visited[to]) 
	      {
	        dfs(to, at, bridges);
	        
	        low[at] = Math.min(low[at], low[to]);
	        
	        if (ids[at] < low[to]) 
	        {
	          bridges.add(at);
	          bridges.add(to);
	        }
	      } 
	      
	      else 
	        low[at] = Math.min(low[at], ids[to]);
	    }
	}
	
	public void printBridges()
	{
		if(this.bridges != null)
		{
			for(int i=0; i<bridges.size(); i+=2)
				System.out.println("bridge: " + bridges.get(i) + "---" + bridges.get(i+1));
		}
	}
	
	public static void main(String[] args) 
	{		
		BridgesOfGraph bog = new BridgesOfGraph();		
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
		
		bog.findBridges(graph);
		bog.printBridges();
		
		System.out.println();

	}

}















