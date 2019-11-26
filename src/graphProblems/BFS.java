package graphProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS 
{
	
	public void bfs(GraphUndirected graph, int src)
	{
		Integer node;
		List<Integer> connections;
		boolean[] visited = new boolean[graph.node_count];
		Queue<Integer> que = new LinkedList<Integer>();
		
		visited[src] = true; 
		que.add(src); 
		
		while(que.size() > 0)
		{
			node = que.poll();
			
			System.out.print(node + " ");
			
			connections = graph.nodes[node];
			
			for(Integer connected_node : connections)
			{
				if(!visited[connected_node])
				{
					visited[connected_node] = true;
					que.add(connected_node);
				}
			}
		}
	}
	
	public Integer[] bfsWithPath(GraphUndirected graph, int start)
	{
		Integer node;
		List<Integer> connections;
		boolean[] visited = new boolean[graph.node_count];
		Integer[] path = new Integer[graph.node_count];			// the nodes values are the indexes, the values are the indexes from that node can be reached
		Queue<Integer> que = new LinkedList<Integer>();
		
		visited[start] = true; 
		que.add(start); 
		
		while(que.size() > 0)
		{
			node = que.poll();
			
			System.out.print(node + " ");
			
			connections = graph.nodes[node];
			
			for(Integer connected_node : connections)
			{
				if(!visited[connected_node])
				{
					visited[connected_node] = true;
					que.add(connected_node);
					path[connected_node] = node;
				}
			}
		}
		
		return path;
	}
	
	public void printShortestPath(int start, int end, GraphUndirected graph)
	{
		Integer[] paths = bfsWithPath(graph, start);
		
		List<Integer> path = new ArrayList<Integer>();
		
		Integer i = end;
		
		while(i != null)			// start pont a null.
		{
			path.add(i);
			i=paths[i];				// ertek = indexen levo ertek !
		}					
		
		Collections.reverse(path);
		
		if(path.get(0) == start)
		{
			System.out.println("\n\npath: ");
			
			for(Integer node : path)
				System.out.print(node + " ");
		}
		
		else
			System.out.println("no path");
	}

	public static void main(String[] args) 
	{
		BFS bfsOperations = new BFS();
		GraphUndirected graph = new GraphUndirected(10);
		graph.initEdges();	
		
		
		bfsOperations.bfs(graph, 5);
		
		System.out.println();
		
		bfsOperations.bfsWithPath(graph, 0);
		
		System.out.println();
		
		bfsOperations.printShortestPath(0, 9, graph);
		
		System.out.println("\n\ntry with node values are letters not numbers !!!");
		
	}

}
