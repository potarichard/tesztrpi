package graphProblems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class GraphFlowEdmondsKarp extends GraphFlow
{

	public GraphFlowEdmondsKarp(int n, int s, int t) 
	{
		super(n, s, t);
	}

	
	@Override
	protected void solve() 
	{
		long maxFlow = 0;

		System.out.println("solving edmonds karp\n");
		
		while (true) 
		{
			// Parent array used for storing path
			// (parent[i] stores edge used to get to node i)
			Edge[] parent = new Edge[n];			
			Queue<Integer> q = new LinkedList<Integer>();
			
			markNodesAsUnvisited();
			
			visit(s);
			q.add(s);
			
			
// 			BFS finding shortest augmenting path   ez es a masik teljesen ugyan az
			
//			while (!q.isEmpty()) 
//			{
//				int curr = q.poll();
//				
//				// Checks that edge has not yet been visited, and it doesn't
//				// point to the source, and it is possible to send flow through it. 
//				for (Edge e : graph[curr])
//				{
//					if (parent[e.to] == null && e.to != s && e.capacity > e.flow) 
//					{
//						parent[e.to] = e;
//						q.add(e.to);
//					}
//				}
//					
//			}
			
			while (!q.isEmpty()) 
		    {
		      int node = q.poll();
		      
		      if (node == t) 
		    	  break;

		      for (Edge edge : graph[node]) 
		      {
		        long cap = edge.remainingCapacity();
		        
		        if (cap > 0 && !visited(edge.to)) 
		        {
		          visit(edge.to);
		          parent[edge.to] = edge;
		          q.add(edge.to);
		        }
		      }
		    }
				
			// If sink was NOT reached, no augmenting path was found.
			// Algorithm terminates and prints out max flow.
			if (parent[t] == null)
				break;
			
			// If sink WAS reached, we will push more flow through the path
			long pushFlow = Integer.MAX_VALUE;
			
			// Finds maximum flow that can be pushed through given path
			// by finding the minimum residual flow of every edge in the path
			for (Edge e = parent[t]; e != null; e = parent[e.from])
				pushFlow = Math.min(pushFlow , e.capacity - e.flow);
			
			// Adds to flow values and subtracts from reverse flow values in path
			for (Edge e = parent[t]; e != null; e = parent[e.from]) 
			{
				e.flow += pushFlow;
				e.residual.flow -= pushFlow;
			}
			
			maxFlow += pushFlow;
			
			printpath(parent);
		}

		this.maxFlow = maxFlow;
	}
	
	private void printpath(Edge[] parent)
	{
		System.out.println("path flow - " + parent[t].flow);
		for (Edge e = parent[t]; e != null; e = parent[e.from]) 
		{
			if(e != null)
				System.out.print(e.to + " ");
		}
		System.out.println("\n");
	}
	
//	@Override
//	protected void solve() 
//	{
//		long flow;
//	    do 
//	    {
//	      markNodesAsUnvisited();
//	      flow = bfs();
//	      maxFlow += flow;
//	    } 
//	    while (flow != 0);
//	}
	
	private long bfs()
	{
		Edge[] prev = new Edge[n];

	    Queue<Integer> queue = new ArrayDeque<Integer>();
	    
	    visit(s);
	    queue.offer(s);
	    
	    while (!queue.isEmpty()) 
	    {
	      int node = queue.poll();
	      
	      if (node == t) 
	    	  break;

	      for (Edge edge : graph[node]) 
	      {
	        long cap = edge.remainingCapacity();
	        
	        if (cap > 0 && !visited(edge.to)) 
	        {
	          visit(edge.to);
	          prev[edge.to] = edge;
	          queue.offer(edge.to);
	        }
	      }
	    }
	   
	    if (prev[t] == null) 			 									// Sink not reachable!
	    	return 0;

	    long bottleNeck = Long.MAX_VALUE;
	    
	    for (Edge edge = prev[t]; edge != null; edge = prev[edge.from])		// Find augmented path and bottle neck
	    	bottleNeck = Math.min(bottleNeck, edge.remainingCapacity());
	    
	    if(bottleNeck == 0)
	    	return 0;
	    
	    for (Edge edge = prev[t]; edge != null; edge = prev[edge.from]) 	// Retrace augmented path and update flow values.
	    	edge.augment(bottleNeck);
	    
	    return bottleNeck;
	}
	
	public static void main(String[] args) 
	{
		int n = 11;
		int s = n-2;
		int t = n-1;
		
		GraphFlowEdmondsKarp graphEK = new GraphFlowEdmondsKarp(n, s, t);
		GraphFlowFordFulkerson graphFF = new GraphFlowFordFulkerson(n, s, t);
		
		
//												SET  Edmond Karp
//		source
		graphEK.addEdge(s, 0, 5);
		graphEK.addEdge(s, 1, 10);
		graphEK.addEdge(s, 2, 5);
		
//		middle
		graphEK.addEdge(0, 3, 10);
		graphEK.addEdge(1, 0, 15);
		graphEK.addEdge(1, 4, 20);
		graphEK.addEdge(2, 5, 10);
		graphEK.addEdge(3, 4, 25);
		graphEK.addEdge(3, 6, 10);
		graphEK.addEdge(4, 2, 5);
		graphEK.addEdge(4, 7, 30);
		
		// switched order
		graphEK.addEdge(5, 8, 10);
		graphEK.addEdge(5, 7, 5);
		
		graphEK.addEdge(7, 3, 15);
		graphEK.addEdge(7, 8, 5);		
		
//		sink
		graphEK.addEdge(6, t, 5);
		graphEK.addEdge(7, t, 15);
		graphEK.addEdge(8, t, 10);
		
		

//												SET  Ford Fulkerson
//		source
		graphFF.addEdge(s, 0, 5);
		graphFF.addEdge(s, 1, 10);
		graphFF.addEdge(s, 2, 5);
		
//middle
		graphFF.addEdge(0, 3, 10);
		graphFF.addEdge(1, 0, 15);
		graphFF.addEdge(1, 4, 20);
		graphFF.addEdge(2, 5, 10);
		graphFF.addEdge(3, 4, 25);
		graphFF.addEdge(3, 6, 10);
		graphFF.addEdge(4, 2, 5);
		graphFF.addEdge(4, 7, 30);
		graphFF.addEdge(5, 7, 5);
		graphFF.addEdge(5, 8, 10);
		graphFF.addEdge(7, 3, 15);
		graphFF.addEdge(7, 8, 5);		
		
//sink
		graphFF.addEdge(6, t, 5);
		graphFF.addEdge(7, t, 15);
		graphFF.addEdge(8, t, 10);
		
		
		graphEK.getGraph();
		graphFF.getGraph();
		
		System.out.println();
	}



}























