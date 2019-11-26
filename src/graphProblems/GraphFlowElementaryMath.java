package graphProblems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import graphProblems.GraphFlow.Edge;

// have some number pairs in an array
// use +,- or mul, as operator on the pair
// collect result in array, each must be unique

// example

// 	 1   5  = -4
// 	 3   3  =  0
// 	 4   5  =  9
//	-1  -6  =  6

//   -, -, +, mul

//  1 pair 3 operators = 3 possible unique solution

//    set up grap
// 1  source to pairs
// 2  pairs to answers
// 3  answers to sink
// all have 1 capacity, as pairs are unique (in advanced they not) ....

public class GraphFlowElementaryMath 
{

	public List<Integer> answers = new ArrayList<Integer>();	
	List<Pair> pairs = new ArrayList<GraphFlowElementaryMath.Pair>();
	
	private static class Pair
	{
		public int a, b;
		public Set<Integer> ans;
		
		public Pair(int a, int b)
		{
			this.a = a;
			this.b = b;
			
			ans = new HashSet<Integer>();
			
			ans.add(a+b);
			ans.add(a-b);
			ans.add(a*b);			
		}

		@Override
		public String toString() {
			return "Pair [" + a + " " + b +"]";
		}		
		
		
	}
	
	
	public static void main(String[] args) 
	{
		
		GraphFlowElementaryMath elementary = new GraphFlowElementaryMath();

		elementary.pairs.add(new Pair(1, 5));
		elementary.pairs.add(new Pair(3, 3));
		elementary.pairs.add(new Pair(6, 5));
		elementary.pairs.add(new Pair(-1, -6));
		
		
		for(Pair pair : elementary.pairs)
		{
			for(Integer an : pair.ans)
			{
				if(!elementary.answers.contains(an))
					elementary.answers.add(an);
			}
				
		}
				
		System.out.println();
		
		int p   = elementary.pairs.size();
		int a   = elementary.answers.size();
		int n 	= p + a + 2;
		int s 	= n-2;
		int t 	= n-1;
		
		
		GraphFlowFordFulkerson graphFordFulk = new GraphFlowFordFulkerson(n, s, t);
		
//		source   0-3
		for(int i=0; i<a; i++)
			graphFordFulk.addEdge(s, i, 1);
		
//		4-10 ig
//		answers is 0-7 ig megy, de a node index 4-11 kell menni, 
		for(int i=0; i<p; i++)
		{
			for(Integer an : elementary.pairs.get(i).ans)
			{
				int k = p;
				for(Integer ansi : elementary.answers)
				{
					if(ansi.equals(an))
					{
						graphFordFulk.addEdge(i, k, 1);
						break;
					}
					
					k++;
				}
			}
		}
		
		
		
//		11 source, 12 sink   de ugye 0 as indextol vagyunk
		int k = p;
		for(Integer ansi : elementary.answers)
		{
			graphFordFulk.addEdge(k, t, 1);			
			k++;
		}
		
		List<Edge>[] graph = graphFordFulk.getGraph();		
		
		for(int i=0; i<p; i++)
		{
			System.out.print("\n" + elementary.pairs.get(i) + " : ");
			
			for(Edge edge : graph[i])
			{
				if(edge.flow == 1)
				{
					int index = edge.to-p;
					System.out.print(elementary.answers.get(index));
					break;
				}
					
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("\n\nEdmond karp");
		
		GraphFlowEdmondsKarp graphEK = new GraphFlowEdmondsKarp(n, s, t);
		
//		source   0-3
		for(int i=0; i<a; i++)
			graphEK.addEdge(s, i, 1);
		
//		4-10 ig
//		answers is 0-7 ig megy, de a node index 4-11 kell menni, 
		for(int i=0; i<p; i++)
		{
			for(Integer an : elementary.pairs.get(i).ans)
			{
				k = p;
				for(Integer ansi : elementary.answers)
				{
					if(ansi.equals(an))
					{
						graphEK.addEdge(i, k, 1);
						break;
					}
					
					k++;
				}
			}
		}
		
		
		
//		11 source, 12 sink   de ugye 0 as indextol vagyunk
		k = p;
		for(Integer ansi : elementary.answers)
		{
			graphEK.addEdge(k, t, 1);			
			k++;
		}
		
		List<Edge>[] graph2 = graphFordFulk.getGraph();		
		
		for(int i=0; i<p; i++)
		{
			System.out.print("\n" + elementary.pairs.get(i) + " : ");
			
			for(Edge edge : graph2[i])
			{
				if(edge.flow == 1)
				{
					int index = edge.to-p;
					System.out.print(elementary.answers.get(index));
					break;
				}
					
			}
		}
	}

}


















