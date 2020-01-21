package graphTheory;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import graphProblems.GraphWeighted;
import graphProblems.GraphWeighted.Edge;

public class SingleSourceShortestPath {

//		A	B	C	D	E	F	G	H
//		0	1	2	3	4	5	6	7	
	static int[] sssp(GraphWeighted graph, int[] top_order)
	{
		int[] shortest_path = new int[top_order.length];
		
		for(int i=1; i<shortest_path.length; i++)
			shortest_path[i] = Integer.MAX_VALUE;
		
		int start_node = top_order[0];
		
		for(int i=start_node; i<top_order.length; i++)
		{
			List<Edge> edges = graph.nodes[i];
			
			for(Edge edge : edges)
			{
				int cost = shortest_path[i] + edge.cost;
				
				if(cost < shortest_path[edge.to])
					shortest_path[edge.to] = cost;
			}
		}
		
		return shortest_path;
	}
	
	static int[] sslp(GraphWeighted graph, int[] top_order)
	{
		for(int i=0; i<graph.nodes.length; i++)
		{
			for(Edge edge : graph.nodes[i])
				edge.cost *= -1;
		}
		
		int[] longest_path = sssp(graph, top_order);
		
		for(int i=0; i<longest_path.length; i++)
			longest_path[i] *= -1;
		
		return longest_path;
	}
	
	public static int[] topologicalSort(GraphWeighted graph)
    {
    	int[] top_order = new int[graph.nodes.length];    	
    	boolean[] visited = new boolean[graph.nodes.length];    	
    	Queue<Integer> visited_nodes = new LinkedList<Integer>();
    	
    	int index = top_order.length - 1; 
    	
    	for(int i=0; i<graph.nodes.length; i++)
    	{
    		if(!visited[i])
    		{
    			dfs(i, visited, visited_nodes, graph.nodes);
    			
    			while(!visited_nodes.isEmpty())
    				top_order[index--] = visited_nodes.poll();
    		}
    	}
    	
    	return top_order;
    }
    
    private static void dfs(int node, boolean[] visited, Queue<Integer> visited_nodes, List<Edge>[] edges)
    {
    	visited[node] = true;    	
    	
    	for(Edge edge : edges[node])
    	{
    		if(!visited[edge.to])
    			dfs(edge.to, visited, visited_nodes, edges);
    	}
    	
    	visited_nodes.add(node);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GraphWeighted graph = new GraphWeighted(8);
				
		//	A	B	C	D	E	F	G	H
		//	0	1	2	3	4	5	6	7		
		graph.addEdgeD(0, 1, 3);
		graph.addEdgeD(0, 2, 6);
		
		graph.addEdgeD(1, 2, 4);
		graph.addEdgeD(1, 3, 4);
		graph.addEdgeD(1, 4, 11);
		
		graph.addEdgeD(2, 3, 8);
		graph.addEdgeD(2, 6, 11);
		
		graph.addEdgeD(3, 4, -4);
		graph.addEdgeD(3, 5, 5);
		graph.addEdgeD(3, 6, 2);
		
		graph.addEdgeD(4, 7, 9);
		
		graph.addEdgeD(5, 7, 1);
		
		graph.addEdgeD(6, 7, 2);
		
		// the first index is the starting node !, its value is 0 in the shortest path, we already there
		int[] top_sort = topologicalSort(graph);
		
		int[] shortestpath = sssp(graph, top_sort);
		
		int[] longestpath = sslp(graph, top_sort);
		
		System.out.println();
		
	}

}






