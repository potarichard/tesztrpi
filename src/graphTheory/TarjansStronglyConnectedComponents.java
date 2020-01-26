package graphTheory;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

import graphProblems.GraphDirected;

// on a directed graph tells each node if its a part of a strongly connected compnent, 
// gives each nodes the same id in a strongly connected component
public class TarjansStronglyConnectedComponents {

		int n;
	  private boolean solved;
	  private int sccCount, id;
	  private boolean[] onStack;
	  private int[] ids, low;
	  private Deque<Integer> stack;
	  List<Integer>[] graph;
	  
	  private static final int UNVISITED = -1;
	  
	  
	  
	public TarjansStronglyConnectedComponents(GraphDirected graph) 
	{
		super();
		this.graph = graph.nodes;
		this.n = graph.nodes.length;
	}

	// Returns the number of strongly connected components in the graph.
	  public int sccCount() 
	  {
	    if (!solved) 
	    	solve();
	    return sccCount;
	  }
	  
	  // Get the connected components of this graph. If two indexes have the same value then they're in the same SCC.
	  public int[] getSccs() 
	  {
	    if (!solved) 
	    	solve();
	    return low;
	  }
	
	  
	  public void solve() 
	  {
		    if (solved) 
		    	return;

		    ids = new int[n];
		    low = new int[n];
		    onStack = new boolean[n];
		    stack = new ArrayDeque<>();
		    Arrays.fill(ids, UNVISITED);

		    for (int i = 0; i < n; i++) 
		    	if (ids[i] == UNVISITED) 
		    		dfs(i);

		    solved = true;
	  }
	  
	  private void dfs(int at) 
	  {

		    stack.push(at);
		    onStack[at] = true;
		    ids[at] = low[at] = id++;

		    for (int to : graph[at]) 
		    {
		      if (ids[to] == UNVISITED) 
		    	  dfs(to);
		      if (onStack[to]) 
		    	  low[at] = Math.min(low[at], low[to]);
		    }

		    // On recursive callback, if we're at the root node (start of SCC) empty the seen stack until back to root.
		    if (ids[at] == low[at]) 
		    {
		    	while(!stack.isEmpty())
		    	{
		    		int node = stack.pop();
		    		
		    		onStack[node] = false;
			        low[node] = ids[at];
			        if (node == at)
			        	break;
		    	}
		      
		      sccCount++;
		    }
		}
	  
	  static void initThisGraph(GraphDirected graph)
	  {
		  graph.addEdge(0, 1);
			
			graph.addEdge(1, 2);	
			
			graph.addEdge(2, 0);
			
			graph.addEdge(3, 4);
			graph.addEdge(3, 7);
			
			graph.addEdge(4, 5);
			
			graph.addEdge(5, 6);
			graph.addEdge(5, 0);
			
			graph.addEdge(6, 0);
			graph.addEdge(6, 2);
			graph.addEdge(6, 4);
			
			graph.addEdge(7, 5);		
			graph.addEdge(7, 3);
	  }
	  
	public static void main(String[] args) 
	{
		GraphDirected graph = new GraphDirected(8);		

		initThisGraph(graph);
		
		TarjansStronglyConnectedComponents tssc = new TarjansStronglyConnectedComponents(graph);
		
		tssc.solve();
		
		System.out.println();
				
	}

}






















