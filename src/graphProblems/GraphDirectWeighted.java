package graphProblems;

import java.util.ArrayList;
import java.util.List;

public class GraphDirectWeighted 
{
	public static class Edge 
	{
	    double cost;
	    int from, to;

	    public Edge(int from, int to, double cost) 
	    {
	      this.to = to;
	      this.from = from;
	      this.cost = cost;
	    }
	 }
	
	int node_count;
	List<Edge>[] nodes;

	@SuppressWarnings("unchecked")
	public GraphDirectWeighted(int vertecies)
	{
		this.node_count = vertecies;
		this.nodes = new List[node_count];
		
		for(int i = 0; i<node_count ; i++)
			nodes[i] = new ArrayList<Edge>(); 
		
	}
	
    public void addEdge(int from, int to, int cost) 
    {  
    	if(from >= this.node_count || to >= this.node_count)
    		return;
    	
        this.nodes[from].add(new Edge(from, to, cost));       
    } 
    
    public void printGraph()
    {
    	for(List<Edge> edges : nodes)
    	{
    		for(Edge edge : edges)
    			System.out.println(edge.from + " -> " + edge.to + " (" + edge.cost + ")");
    		
    		System.out.println();
    	}
    }

	public List<Edge> getEdges() 
	{
		List<Edge> all_edges = new ArrayList<Edge>();
		
		for(List<Edge> edges : nodes)
    	{
    		for(Edge edge : edges)
    			all_edges.add(edge);
    	}
		
		return all_edges;
	}
    
}









