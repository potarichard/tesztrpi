package graphProblems;

import java.util.ArrayList;
import java.util.List;

public class GraphDirected 
{

	int node_count;
	public List<Integer>[] nodes;
	
	@SuppressWarnings("unchecked")
	public GraphDirected(int vertecies)
	{
		this.node_count = vertecies;
		this.nodes = new List[node_count];
		
		for(int i = 0; i<node_count ; i++)
			nodes[i] = new ArrayList<Integer>(); 
		
	}
	
    public void addEdge(int from, int to) 
    {  
    	if(from >= this.node_count || to >= this.node_count)
    		return;
    	
        this.nodes[from].add(to);    
    } 
    
    public void initEdges()
    {
    	this.addEdge(0, 1);
    	this.addEdge(0, 2);
    	this.addEdge(0, 3);
    	this.addEdge(1, 5);
    	this.addEdge(1, 8);
    	this.addEdge(2, 5);
    	this.addEdge(2, 9);
    	this.addEdge(3, 4);
    	this.addEdge(5, 9);
    }
	
} 
