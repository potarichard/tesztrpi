package graphTheory;

import java.util.LinkedList;

public class Graph 
{
	
	int V; 
    LinkedList<Integer> vertices[]; 	// nodes = vertices
    
    @SuppressWarnings("unchecked")
	Graph(int V) 
    { 
        this.V = V; 
          
        vertices = new LinkedList[V]; 
          
        for(int i = 0; i < V ; i++)
        	vertices[i] = new LinkedList<>(); 
    } 
	
    public void addUEdge(int src, int dest) 
    {  
    	if(src >= this.V || dest >= this.V)
    		return;
    	
        this.vertices[src].add(dest); 
          
        this.vertices[dest].add(src); 
    } 
    
    public void addDEdge(int src, int dest) 
    {  
    	if(src >= this.V || dest >= this.V)
    		return;
    	
        this.vertices[src].add(dest); 
    } 
    
    public void printGraph() 
    {        
        for(int v = 0; v < this.V; v++) 
        { 
            System.out.print("Connected to " + v +".node ->"); 
            
            for(Integer pCrawl: this.vertices[v])
                System.out.print(pCrawl + " , "); 
            
            System.out.println("\n"); 
        } 
    } 
}














