package graphTheory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import hashing.HashMain;

// lenyege egy olyan ordering lesz ahol egy node elott mindig ott lesznek az abba a nodeba vezeto nodok
// megy a dfs, stackbe beletesszuk a nodot aminek mar nincs tobb neighbour
// lesz egy listám , abból a listából bármelyik nodot kiválaszrtva, megnézem mik vannak elõtte
// amig a loopban megyek az elemeket folyamatosan teszem egy stackbe
// pop stack es ugye pont a keresett node elotti node van ott, megnezem hogy a vizsgalt nodbol el lehet e jutni a keresettbe
// ha igen akkor az kell a nodhoz (pl egy program build esetén), ha nem akkor az a keresettt node egy kezdo node nincs dependencije
// folytatom tovább az algoritmust

// olyan elotte levo szart kell nezni ami ramutat
public class TopologicalSort {

	static class Node
	{
		char data;		
		List<Character> in_edges = new ArrayList<Character>();
		List<Character> out_edges = new ArrayList<Character>();
		
		public Node(char data) 
		{
			this.data = data;
		}
		
		@Override
		public boolean equals(Object o) 
		{			
			if (o == this) 
	            return true;
			if (!(o instanceof Node))
	            return false; 
			
			Node node = (Node) o;
			
			return this.data == node.data;
		}		
	}
	
	static class Graph
	{
		int node_count;
		Map<Character, Node> nodes = new HashMap<Character, Node>();
		
		@SuppressWarnings("unchecked")
		public Graph(char[] vertecies)
		{
			for(char c : vertecies)
				nodes.put(c, new Node(c));
		}
		
	    
	    public void addEdge(char from, char to) 
	    {
	    	Node n_from = nodes.get(from);
	    	Node n_to = nodes.get(to);
	    	
	    	if(n_from == null || n_to == null)
	    		return;
	    	
	    	n_from.out_edges.add(to); 
	    	n_to.in_edges.add(from);
	    }
	    
	    public char[] topologicalSort()
	    {
	    	char[] top_order = new char[nodes.entrySet().size()];
	    	
	    	Set<Character> visited = new HashSet<Character>();
	    	List<Character> visited_nodes = new ArrayList<Character>();
	    	
	    	int i = top_order.length - 1; 
	    	
	    	for(Entry<Character, Node> entry : nodes.entrySet())
	    	{
	    		if(!visited.contains(entry.getKey()))
	    		{
	    			visited_nodes = new ArrayList<Character>();
	    			dfs(entry.getKey(), visited, visited_nodes, nodes);
	    			
	    			
	    			for(Character c : visited_nodes)
	    				top_order[i--] = c;
	    			
	    		}
	    	}
	    	
	    	return top_order;
	    }
	    
	    private void dfs(char node, Set<Character> visited, List<Character> visited_nodes, Map<Character, Node> nodes)
	    {
	    	visited.add(node);
	    	
	    	List<Character> out_edges = nodes.get(node).out_edges;
	    	
	    	for(Character out : out_edges)
	    	{
	    		if(!visited.contains(out))
	    			dfs(out, visited, visited_nodes, nodes);
	    	}
	    	
	    	visited_nodes.add(node);
	    }
	    
	    
	    public char[] topologicalSort2()
	    {
	    	char[] top_order = new char[nodes.entrySet().size()];
	    	
	    	Set<Character> visited = new HashSet<Character>();
	    	Stack<Character> visited_nodes = new Stack<Character>();
	    	
	    	int i = 0; 
	    	
	    	for(Entry<Character, Node> entry : nodes.entrySet())
	    	{
	    		if(!visited.contains(entry.getKey()))
	    		{
	    			dfs2(entry.getKey(), visited, visited_nodes, nodes);
	    			
	    			while(!visited_nodes.isEmpty())
	    				top_order[i++] = visited_nodes.pop();
	    		}
	    	}
	    	
	    	return top_order;
	    }
	    
	    private void dfs2(char node, Set<Character> visited, Stack<Character> visited_nodes, Map<Character, Node> nodes)
	    {
	    	visited.add(node);
	    	
	    	List<Character> out_edges = nodes.get(node).out_edges;
	    	
	    	for(Character out : out_edges)
	    	{
	    		if(!visited.contains(out))
	    			dfs2(out, visited, visited_nodes, nodes);
	    	}
	    	
	    	visited_nodes.add(node);
	    }
	    
	    public char[] buildPath(char to, char[] order)
	    {
	    	Queue<Character> path = new LinkedList<Character>();
	    	Queue<Character> build_path = new LinkedList<Character>();
	    	
	    	// add only lesser nodes to to que, igazábol ami elotte van mindent lebuildelek ugy is jo, de lesz olyan ami kozvetlenul nem kell
	    	for(char c : order)
	    	{
	    		if(to == c)
	    			break;
	    		path.add(c);
	    	}
	    	
	    	// may not all prev nodes are nessearry to reach the destination node (build)
	    	// the build path will be an ordered array	    	
	    	while(!path.isEmpty())
	    	{
	    		char prev = path.poll();	   
	    		
	    		// check if from prev node, destination node is reachable, if yes add it to build path
	    		Queue<Character> que = new LinkedList<Character>();	    		
	    		que.add(prev);
	    		
	    		while(!que.isEmpty())
	    		{
	    			char next_node = que.poll();
	    			
	    			if(next_node == to)
	    			{
	    				build_path.add(prev);
	    				break;
	    			}
	    			
	    			for(char c : nodes.get(next_node).out_edges)
	    				que.add(c);
	    		}
	    		
	    	}
	    	
	    	char[] ret = new char[build_path.size()];
	    	int i = 0;
	    	
	    	while(!build_path.isEmpty())
	    		ret[i++] = build_path.poll();
	    	
	    	return ret;
	    }
	}
	
	public static void main(String[] args) {
		
		char[] vertecies = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M'};
		Graph graph = new Graph(vertecies);
		
//		A
		graph.addEdge('A', 'D');
		
//		B
		graph.addEdge('B', 'D');
		
//		C
		graph.addEdge('C', 'A');
		graph.addEdge('C', 'B');
		
//		D
		graph.addEdge('D', 'G');
		graph.addEdge('D', 'H');
		
//		E
		graph.addEdge('E', 'A');
		graph.addEdge('E', 'D');
		graph.addEdge('E', 'F');
		
//		F
		graph.addEdge('F', 'K');
		graph.addEdge('F', 'J');
		
//		G
		graph.addEdge('G', 'I');
		
//		H
		graph.addEdge('H', 'I');
		graph.addEdge('H', 'J');
		
//		I
		graph.addEdge('I', 'L');
		
//		J
		graph.addEdge('J', 'L');
		graph.addEdge('J', 'M');
		
//		K
		graph.addEdge('K', 'J');
		
//		L
		
//		M
		
		char[] top_1 = graph.topologicalSort();
//		char[] top_2 = graph.topologicalSort2();
		
		graph.buildPath('H', top_1);
		
		System.out.println();

	}

}












