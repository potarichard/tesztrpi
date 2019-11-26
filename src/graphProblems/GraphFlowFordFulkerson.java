package graphProblems;

import java.util.List;

// dfs feltaras kozben az edge flowjat noveli a bottleneckel
// ebbel a pldaban 
// 1. korben 2 lesz a bottleneck (3->1) igy minden edge flowja 2 lesz 1. korben
// 2. korben mar 2 a flow az erintett edgeken, ratol meg annyit amennyit bir 8 at kozben uj utakat is talalt
// 3. korben olyan ut ahol megint 2 a bottleneck
// 4. kor 3 bottle
// 5. korben 5
// 6. korben 3
// 7. korben mar minden edge telitet, nem talal olyan utat ahol lehetne me menni a sink fele 

public class GraphFlowFordFulkerson extends GraphFlow
{

	public GraphFlowFordFulkerson(int n, int s, int t)
	{
		super(n, s, t);
	}
	

	@Override
	protected void solve() 
	{
		System.out.println(visitedToken + ". kor");
		
		long flow = dfs(s, INF);
		
		System.out.println("\nBottleneck: " + flow);
		
		while(flow != 0)
		{
			visitedToken++;				//  resets visited array...
			maxFlow += flow;
			
			System.out.println("\n" + visitedToken + ". kor");
			
			flow = dfs(s, INF);
			
			System.out.println("\nBottleneck: " + flow);
		}
	}

	
	
	private long dfs(int node, long flow) 
	{		
		if(node == t)			//  sink reached
			return flow;
		
		visited[node] = visitedToken;
		
		List<GraphFlow.Edge> edges = graph[node];
		
		for(GraphFlow.Edge edge : edges)
		{
			if(visited[edge.to] != visitedToken && edge.remainingCapacity() > 0)				// solvban noveljuk a visited tokent, igy a visited arrayben nem T\F lesz, hanem mindig az aktualis kor ertekei elso korvben 1 sekkel vizsgalja, 2. korben 2sekkel
			{
				long min_flow = Math.min(flow, edge.remainingCapacity());
				
				long bottle_neck = dfs(edge.to, min_flow);
				
				if(bottle_neck > 0)
				{
					System.out.print(node + " ");
					
					edge.augment(bottle_neck);
					return bottle_neck;
				}
			}
		}
			
		return 0;
	}


	public static void main(String[] args) 
	{
		
		int n 	= 12;
		int s 	= n-2;
		int t 	= n-1;
		
		
		GraphFlowFordFulkerson graphFordFulk = new GraphFlowFordFulkerson(n, s, t);
		
//		source
		graphFordFulk.addEdge(s, 0, 10);
		graphFordFulk.addEdge(s, 1, 5);
		graphFordFulk.addEdge(s, 2, 10);
		
//		middle
		graphFordFulk.addEdge(0, 3, 10);
		graphFordFulk.addEdge(1, 2, 10);
		graphFordFulk.addEdge(2, 5, 15);
		graphFordFulk.addEdge(3, 1, 2);
		graphFordFulk.addEdge(3, 6, 15);
		graphFordFulk.addEdge(4, 1, 15);
		graphFordFulk.addEdge(4, 3, 3);
		graphFordFulk.addEdge(5, 4, 4);
		graphFordFulk.addEdge(5, 8, 10);
		graphFordFulk.addEdge(6, 7, 10);
		graphFordFulk.addEdge(7, 4, 10);
		graphFordFulk.addEdge(7, 5, 7);
		
//		sink
		graphFordFulk.addEdge(6, t, 15);
		graphFordFulk.addEdge(8, t, 10);		
		
		System.out.println();
		System.out.println(graphFordFulk.getMaxFlow());
	}
	
}





























