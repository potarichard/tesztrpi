package graphProblems;

import java.util.List;
import java.util.PriorityQueue;

import graphProblems.GraphWeighted.Edge;

//lazy version
// on undirected weighted grafs
// addig kell menni amig a MST edges = lesz nodes -1  EZ ERTHETO
// nodebol kiindulva minden edget beteszunk a PQ-ba, majd a legkedvezobbet kiveve haladunk tovabb, amig elerjuk a que veget vagy az edgek szama jo lesz
// kozben visited nodes tracked



public class PrimMST 
{

	int 	edges,
			expected_edges,
			mst_cost;
	
	boolean[] visited;
	List<Edge>[] nodes;
	PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
	
	public PrimMST(GraphWeighted graph)
	{
		this.expected_edges = graph.node_count - 1;
		this.nodes = graph.nodes;
		this.visited = new boolean[graph.node_count];
		
		edges = 0;
		mst_cost = 0;
	}
	
	private void addEdge(int node)
	{
		this.visited[node] = true;
		
		List<Edge> edges = nodes[node];
		
		for(Edge edge : edges)
		{
			if(!visited[edge.to])
				this.pq.add(edge);
		}
	}
	
	
	public Edge[] solveMST()
	{
		Edge[] mstEdge = new Edge[expected_edges];
		Edge current_edge;
		int node_index;
		
		addEdge(0);
		
		while(!pq.isEmpty() && edges != expected_edges)
		{
			current_edge = pq.poll();
			node_index = current_edge.to;
			
			if(visited[node_index])
				continue;
			
			mstEdge[edges++] = current_edge;
			mst_cost += current_edge.cost;
			
			addEdge(node_index);
		}
		
		if(edges != expected_edges)
			return null;
		
		return mstEdge;
	}
	
	
	public static void main(String[] args) 
	{
		
		GraphWeighted graph = new GraphWeighted(8);
		
		graph.addEdgeUD(0, 1, 10);
		graph.addEdgeUD(0, 2, 1);
		graph.addEdgeUD(0, 3, 4);
		
		graph.addEdgeUD(1, 4, 0);
		graph.addEdgeUD(1, 2, 3);
		
		graph.addEdgeUD(2, 3, 2);
		graph.addEdgeUD(2, 5, 8);
		
		graph.addEdgeUD(3, 5, 2);
		graph.addEdgeUD(3, 6, 7);
		
		graph.addEdgeUD(4, 5, 1);
		graph.addEdgeUD(4, 7, 8);
		
		graph.addEdgeUD(5, 6, 6);
		graph.addEdgeUD(5, 7, 9);
		
		graph.addEdgeUD(6, 7, 12);
		
		PrimMST primMST = new PrimMST(graph);
		
//		expected result  0->2->3->5->4->1
//						 5->6
//						 4->7
		primMST.solveMST();
		
		System.out.println("gote");
	}

}













