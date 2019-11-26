package graphProblems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// visit all edges only once

// conditions!
// undirected graph: every node has even degree
// directed: max 1 node: out-in = 1, max 1 node: out-in = 1, every other node has equal in and out degree

public class EulerianPath 
{

	private int[] in, out;
	private int n = 0, edges = 0;
	private LinkedList<Integer> path;
	private List<Integer>[] graph;
	
	public EulerianPath(GraphDirected graph)
	{
		this.graph = graph.nodes;
	}
	
	public int[] getEulerianPath()
	{
		setUp();
		countNodeDegrees();
		
		if(!hasEulerianPath())
			return null;
		
		int start_node = findStartNode();
		
		dfs(start_node);
		
	    if (path.size() != edges + 1)
	    	return null;

	    // Instead of returning the 'path' as a linked list return
	    // the solution as a primitive array for convenience.
	    int[] soln = new int[edges + 1];
	    
	    for (int i = 0; !path.isEmpty(); i++) 
	    	soln[i] = path.removeFirst();

	    return soln;
	}
	
	private void setUp()
	{		
		this.edges = 0;
		this.n = this.graph.length;
		this.path = new LinkedList<Integer>();
		this.in = new int[n];
		this.out = new int[n];
	}
	
	private void countNodeDegrees()
	{
		for(int o=0; o<graph.length; o++)
		{
			out[o] = graph[o].size();
			
			for(Integer i : graph[o])
			{
				in[i]++;
				edges++;
			}
				
		}
	}
	
	public boolean hasEulerianPath()
	{		
		int 	start_nodes = 0,
				end_nodes = 0;
		
		for(int i=0; i<n; i++)
		{
			if((out[i] - in[i] > 1) || (in[i] -out[i] > 1))
				return false;
			else if(out[i] - in[i] == 1)
				start_nodes++;
			else if(in[i] - out[i] == 1)
				end_nodes++;
		}
		
		return 
				(start_nodes == 0 && end_nodes == 0) ||
				(start_nodes == 1 && end_nodes == 1); 
	}
	
	private int findStartNode() 
	{
	    int start = 0;
	    
	    for (int i = 0; i < n; i++) 
	    {
	      // Unique starting node.
	      if (out[i] - in[i] == 1) 
	    	  return i;
	      
	      // Start at a node with an outgoing edge.
	      if (out[i] > 0) start = i;
	    }
	    
	    return start;
	}

	// Perform DFS to find Eulerian path.
	private void dfs(int at) 
	{
	    while (out[at] != 0) 		// every out edge from the node must be covered before move on
	    {
	      int next = graph[at].get(--out[at]);
	      dfs(next);
	    }
	    
	    path.addFirst(at);
	}
	
	public static void main(String[] args) 
	{
		
		GraphDirected graph = new GraphDirected(7);
		
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		
		graph.addEdge(2, 2);
		graph.addEdge(2, 4);
		graph.addEdge(2, 4);
		
		graph.addEdge(3, 1);
		graph.addEdge(3, 2);
		graph.addEdge(3, 5);
		
		graph.addEdge(4, 3);
		graph.addEdge(4, 6);
		
		graph.addEdge(5, 6);
		
		graph.addEdge(6, 3);

		
		EulerianPath ep = new EulerianPath(graph);
		
		int[] path = ep.getEulerianPath();
		
		System.out.println(Arrays.toString(path));
	}

}
