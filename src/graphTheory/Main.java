package graphTheory;

public class Main {

	public static void main(String[] args) 
	{
		
//		1. simple graph representation
//        int V = 5; 
//        Graph graph = new Graph(V); 
//        graph.addEdge(0, 1); 
//        graph.addEdge(0, 4); 
//        graph.addEdge(1, 2); 
//        graph.addEdge(1, 3); 
//        graph.addEdge(1, 4); 
//        graph.addEdge(2, 3); 
//        graph.addEdge(3, 4);         
//        graph.addEdge(5, 2); 
//       
//        graph.printGraph(); 

		
//		2. BFS of a graph
		BreathFirstSearch g = new BreathFirstSearch(4); 
		  
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
  
        System.out.println("Breadth First Traversal "); 
  
        g.BFS(2); 
		
		
//		3. DFS of a graph		
//		DepthFirstSearch g = new DepthFirstSearch(4); 
//		  
//        g.addEdge(0, 1); 
//        g.addEdge(0, 2); 
//        g.addEdge(1, 2); 
//        g.addEdge(2, 0); 
//        g.addEdge(2, 3); 
//        g.addEdge(3, 3); 
//  
//        System.out.println("Depth First Traversal "); 
//  
//        g.DFS(2); 
		
		
//		4. count possible paths between 2 nodes
//		CountPaths g = new CountPaths(4); 
//        g.addEdge(0, 1); 
//        g.addEdge(0, 2); 
//        g.addEdge(0, 3); 
//        g.addEdge(2, 0); 
//        g.addEdge(2, 1); 
//        g.addEdge(1, 3); 
//  
//        System.out.println(g.countPaths(2, 3)); 
		
		
//		5. cycle in graph
//		CycleInDirectedGraph graph = new CycleInDirectedGraph(4); 
//        graph.addEdge(0, 1); 
//        graph.addEdge(0, 2); 
//        graph.addEdge(1, 2); 
//        graph.addEdge(2, 0); 
//        graph.addEdge(2, 3); 
//        graph.addEdge(3, 3); 
//          
//        if(graph.isCyclic()) 
//            System.out.println("Graph contains cycle"); 
//        else
//            System.out.println("Graph doesn't "
//                                    + "contain cycle"); 
		

		
//		6. cycle in undirected graph
		
//		// Create a graph given in the above diagram 
//		CycleInUndirectedGraph g1 = new CycleInUndirectedGraph(5); 
//        g1.addEdge(1, 0); 
//        g1.addEdge(0, 2); 
//        g1.addEdge(2, 1); 
//        g1.addEdge(0, 3); 
//        g1.addEdge(3, 4); 
//        if (g1.isCyclic()) 
//            System.out.println("Graph contains cycle"); 
//        else
//            System.out.println("Graph doesn't contains cycle"); 
//  
//        CycleInUndirectedGraph g2 = new CycleInUndirectedGraph(4); 
//        g2.addEdge(0, 1); 
//        g2.addEdge(1, 2);
//        g2.addEdge(2, 3);
//        if (g2.isCyclic()) 
//            System.out.println("Graph contains cycle"); 
//        else
//            System.out.println("Graph doesn't contains cycle"); 
		
	}

}














