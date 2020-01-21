package graphProblems;

import java.util.ArrayList;
import java.util.List;

public class GraphWeighted 
{
	public static class Edge implements Comparable<Edge>
	{
	    public int cost;
	    public int from, to;

	    public Edge(int from, int to, int cost) 
	    {
	      this.to = to;
	      this.from = from;
	      this.cost = cost;
	    }

		@Override
		public int compareTo(Edge edge) 
		{
			if(this.cost > edge.cost)
				return 1;
			else if(this.cost < edge.cost)
				return -1; 
			return 0;
		}
	 }
	
	int node_count;
	public List<Edge>[] nodes;

	@SuppressWarnings("unchecked")
	public GraphWeighted(int vertecies)
	{
		this.node_count = vertecies;
		this.nodes = new List[node_count];
		
		for(int i = 0; i<node_count ; i++)
			nodes[i] = new ArrayList<Edge>(); 
		
	}
	
    public void addEdgeD(int from, int to, int cost) 
    {  
    	if(from >= this.node_count || to >= this.node_count)
    		return;
    	
        this.nodes[from].add(new Edge(from, to, cost));       
    } 
    
    public void addEdgeUD(int from, int to, int cost) 
    {  
    	if(from >= this.node_count || to >= this.node_count)
    		return;
    	
        this.nodes[from].add(new Edge(from, to, cost));       
        this.nodes[to].add(new Edge(to, from, cost)); 
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









