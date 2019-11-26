package graphProblems;

import java.util.ArrayList;
import java.util.List;

public abstract class GraphFlow 
{

	static class Edge
	{
		public final long capacity;
		public long flow;
		public int from, to;
		public Edge residual;
		
		public Edge(int from, int to, long capacity)
		{
			this.from = from;
			this.to = to;
			this.capacity = capacity;
		}
		
		public boolean isResidual()
		{
			return this.capacity == 0;
		}
		
		public long remainingCapacity()
		{
			return capacity - flow;
		}
		
		public void augment(long bottleneck)
		{
			this.flow 			+= bottleneck;
			this.residual.flow 	-= bottleneck;
		}		
	}
	
	
	static final long INF = Long.MAX_VALUE / 2;
	
	final int n, s, t;
	
	protected int visitedToken = 1;
	protected int[] visited;
	
	protected boolean solved;
	
	protected long maxFlow;
	
	protected List<Edge>[] graph;
	
	public GraphFlow(int n, int s, int t)
	{
		this.n = n;
		this.s = s;
		this.t = t;
		
		this.visited = new int[n];
		this.graph = new List[n];
		
		for(int i=0; i<n; i++)
			this.graph[i] = new ArrayList<GraphFlow.Edge>();
	}
	
	public void addEdge(int from, int to, int capacity)
	{
		if(capacity <= 0)
			throw new IllegalArgumentException();
		
		Edge e1 = new Edge(from, to, capacity);
		Edge e2 = new Edge(to, from, 0);
		
		e1.residual = e2;
		e2.residual = e1;
		
		this.graph[from].add(e1);
		this.graph[to].add(e2);
	}
	
	public List<Edge>[] getGraph()
	{
		this.execute();
		return this.graph;
	}
	
	public long getMaxFlow()
	{
		this.execute();
		return this.maxFlow;
	}
	
	public void visit(int node)
	{
		if(node < 0 || node >= visited.length)
			throw new IllegalArgumentException();
		
		visited[node] = visitedToken;
	}
	
	public boolean visited(int node)
	{
		return visited[node] == visitedToken;
	}
	
	public void markNodesAsUnvisited()
	{
		visitedToken++;
	}
	
	
	
	

	protected void execute()
	{
		if(this.solved)
			return;
		
		solved = true;
		solve();
	} 

	protected abstract void solve();
	
}











