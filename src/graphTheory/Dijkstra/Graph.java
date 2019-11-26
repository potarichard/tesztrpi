package graphTheory.Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Graph 
{
	  public static class Edge 
	  {
	    double cost;
	    int from, to;

	    public Edge(int from, int to, double cost) 
	    {
	      this.from = from;
	      this.to = to;
	      this.cost = cost;
	    }
	  }

	  public static class Node 
	  {
	    int id;
	    double value;

	    public Node(int id, double value) 
	    {
	      this.id = id;
	      this.value = value;
	    }
	  }

	  private Comparator<Node> comparator = new Comparator<Node>() 
	  {
	        @Override
	        public int compare(Node node1, Node node2) 
	        {
	          if (Math.abs(node1.value - node2.value) < EPS) 
	        	  return 0;
	          
	          return (node1.value - node2.value) > 0 ? 1 : -1;
	        }
	  };
	  
	  private static final double EPS = 1e-6;
	  private int V;
	  private double[] min_distance;
	  private Integer[] prev;
	  private List<List<Edge>> nodes;
	  
	  public Graph(int v) 
	  {
		    this.V = v;
		    
		    nodes = new ArrayList<>(v);
		    
		    for (int i = 0; i < v; i++) 
		    	nodes.add(new ArrayList<>());
	  }
	  
	  // egyiranyu csak az osszekotes
	  public void addEdge(int from, int to, int cost) 
	  {
		  nodes.get(from).add(new Edge(from, to, cost));
	  }
	  
	  
	  
	  public List<Integer> reconstructPath(int start, int end) 
	  {
	    if (end < 0 || end >= V) 
	    	throw new IllegalArgumentException("Invalid node index");
	    if (start < 0 || start >= V) 
	    	throw new IllegalArgumentException("Invalid node index");
	    
	    double dist = dijkstra(start, end);
	    
	    List<Integer> path = new ArrayList<>();
	    
	    if (dist == Double.POSITIVE_INFINITY) 
	    	return path;
	    
	    for (Integer at = end; at != null; at = prev[at]) 
	    	path.add(at);
	    
	    Collections.reverse(path);
	    
	    return path;
	  }
	  
	  public double dijkstra(int start, int end) 
	  {
		    min_distance = new double[V];
		    
		    Arrays.fill(min_distance, Double.POSITIVE_INFINITY);
		    
		    min_distance[start] = 0;

		    // Keep a priority queue of the next most promising node to visit.
		    PriorityQueue<Node> pq = new PriorityQueue<>(2 * V, comparator);
		    
		    pq.offer(new Node(start, 0));
		    // Array used to track which nodes have already been visited.
		    boolean[] visited = new boolean[V];
		    
		    prev = new Integer[V];
		    
		    List<Edge> edges;
		    Edge edge;
		    Node node;
		    double new_dist;
		    
		    while (!pq.isEmpty()) 
		    {
		      node = pq.poll();
		      
		      visited[node.id] = true;

		      // We already found a better path before we got to
		      // processing this node so we can ignore it.
		      if (min_distance[node.id] < node.value) 
		    	  continue;

		      edges = nodes.get(node.id);
		      
		      for (int i = 0; i < edges.size(); i++) 
		      {
		        edge = edges.get(i);

		        // You cannot get a shorter path by revisiting
		        // a node you have already visited before.
		        if (visited[edge.to]) 
		        	continue;

		        // Relax edge by updating minimum cost if applicable.
		        new_dist = min_distance[edge.from] + edge.cost;
		        
		        if (new_dist < min_distance[edge.to]) 
		        {
		          prev[edge.to] = edge.from;
		          min_distance[edge.to] = new_dist;
		          pq.offer(new Node(edge.to, min_distance[edge.to]));
		        }
		      }
		      
		      // Once we've visited all the nodes spanning from the end
		      // node we know we can return the minimum distance value to
		      // the end node because it cannot get any better after this point.
		      if (node.id == end) 
		    	  return min_distance[end];
		    }
		    
		    // End node is unreachable
		    return Double.POSITIVE_INFINITY;
		  }	  
	  
	  
	  
	  
}




















