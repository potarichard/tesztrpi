package graphProblems;

import java.util.List;

import graphProblems.GraphWeighted.Edge;

public class BellmanFord 
{

	public double[] bellmanFordAlgorithm(GraphWeighted graph, int start) 
	{		
		int V = graph.node_count;
		double[] dist = new double[V];
		List<Edge> edges = graph.getEdges();		
	    
	    java.util.Arrays.fill(dist, Double.POSITIVE_INFINITY);
	    dist[start] = 0;

	    // Only in the worst case does it take V-1 iterations for the Bellman-Ford algorithm to complete. Another stopping condition is when we're unable to
	    // relax an edge, this means we have reached the optimal solution early.
	    boolean relaxedAnEdge = true;
	    for (int v = 0; v < V - 1 && relaxedAnEdge; v++) 
	    {
	      relaxedAnEdge = false;
	      for (Edge edge : edges) 
	      {
	        if (dist[edge.from] + edge.cost < dist[edge.to]) 
	        {
	          dist[edge.to] = dist[edge.from] + edge.cost;
	          relaxedAnEdge = true;
	        }
	      }
	    }

	    // Run algorithm a second time to detect which nodes are part of a negative cycle. A negative cycle has occurred if we
	    // can find a better path beyond the optimal solution.
	    relaxedAnEdge = true;
	    for (int v = 0; v < V - 1 && relaxedAnEdge; v++) 
	    {
	      relaxedAnEdge = false;
	      for (Edge edge : edges) 
	      {
	        if (dist[edge.from] + edge.cost < dist[edge.to]) 
	        {
	          dist[edge.to] = Double.NEGATIVE_INFINITY;
	          relaxedAnEdge = true;
	        }
	      }
	    }

	    return dist;
	}
	
	
	  public double[] bellmanFordAlgorithmOptimazed(GraphWeighted graphA, int start) 
	  {
		    // Initialize the distance to all nodes to be infinity except for the start node which is zero.
		  	int V = graphA.node_count;
		    double[] dist = new double[V];
		    List<Edge>[] graph = graphA.nodes;
		    
		    java.util.Arrays.fill(dist, Double.POSITIVE_INFINITY);
		    dist[start] = 0;
	
		    // For each vertex, apply relaxation for all the edges
		    for (int i = 0; i < V - 1; i++)
		      for (List<Edge> edges : graph)
		        for (Edge edge : edges)
		          if (dist[edge.from] + edge.cost < dist[edge.to])
		            dist[edge.to] = dist[edge.from] + edge.cost;
	
		    // Run algorithm a second time to detect which nodes are part of a negative cycle. A negative cycle has occurred if we
		    // can find a better path beyond the optimal solution.
		    for (int i = 0; i < V - 1; i++)
		      for (List<Edge> edges : graph)
		        for (Edge edge : edges)
		          if (dist[edge.from] + edge.cost < dist[edge.to]) 
		        	  dist[edge.to] = Double.NEGATIVE_INFINITY;
	
		    
		    return dist;
	 }
	
	
	public static void main(String[] args) 
	{
	
		BellmanFord bf = new BellmanFord();
		GraphWeighted graph = new GraphWeighted(10);
		
		graph.addEdgeD(0, 1, 5);
		
		graph.addEdgeD(1, 2, 20);
		graph.addEdgeD(1, 5, 30);
		graph.addEdgeD(1, 6, 60);
		
		graph.addEdgeD(2, 3, 10);
		graph.addEdgeD(2, 4, 75);
		
		graph.addEdgeD(3, 2, -15);
		
		graph.addEdgeD(4, 9, 100);
		
		graph.addEdgeD(5, 8, 50);
		graph.addEdgeD(5, 4, 25);
		graph.addEdgeD(5, 6, 5);
		
		graph.addEdgeD(6, 7, -50);
		
		graph.addEdgeD(7, 8, -10);
		
		bf.bellmanFordAlgorithm(graph, 0);
		
		bf.bellmanFordAlgorithmOptimazed(graph, 0);
		
		graph.printGraph();
		
		System.out.println();
		
	}

}
