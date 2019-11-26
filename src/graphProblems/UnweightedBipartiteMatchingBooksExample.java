package graphProblems;

import java.util.List;

import graphProblems.GraphFlow.Edge;

// network flow 2 main algorithm
//	1, ford-fulkerson use dfs to find augmenting paths
//  2, edmonds-krap use bfs   time complexity becomes better!

// finding the max flow on a flow graphs is equal to find bibarte graph problems (matching things to other things)

// the algoritmh is ok, the hard part is to realize the problem can be turned to a flow problem, and then create the flowgraph

//ember konyv kapcsolat   network flowval, start sink, edge capacities 
// edge cpaaciti olyan mintha ket nodot tobbszor osszekotnenk (pl egy konyvet tobbszor el lehet vinni)
// ez igy mar eleg erdekes megoldasokra vezet, kell a sima network flow stuff hozzá

//also do the owl - mouse problem

// elementary math equations problem

// nagyon sok jo feladat es magoldas van network flowra erre erdemes ramenni







// THIS EXAMPLE IS
// 5 people 5 books, (1. try to get each person a book) some people wat 1 book, other more  => turn it to a flow problem get max flow!
public class UnweightedBipartiteMatchingBooksExample 
{
	public void onePersonOneBook()
	{
		System.out.println("\none Person One Book");
		
		int n 	= 12;						// 5 people, 5 books, 1 source, 1 sink
		int s 	= n-2;
		int t 	= n-1;
				
		GraphFlowFordFulkerson graphFordFulk = new GraphFlowFordFulkerson(n, s, t);

//		source
		graphFordFulk.addEdge(s, 0, 1);		// 1. person
		graphFordFulk.addEdge(s, 1, 1);		// 2. person	
		graphFordFulk.addEdge(s, 2, 1);		// 3. person
		graphFordFulk.addEdge(s, 3, 1);		// 4. person
		graphFordFulk.addEdge(s, 4, 1); 	// 5. person
		
//		middle
		graphFordFulk.addEdge(0, 6, 1);
		graphFordFulk.addEdge(0, 7, 1);
		
		graphFordFulk.addEdge(1, 6, 1);
		graphFordFulk.addEdge(1, 7, 1);
		graphFordFulk.addEdge(1, 8, 1);
		
		graphFordFulk.addEdge(2, 5, 1);
		graphFordFulk.addEdge(2, 6, 1);
		graphFordFulk.addEdge(2, 7, 1);
		graphFordFulk.addEdge(2, 9, 1);
		
		graphFordFulk.addEdge(3, 7, 1);
		
		graphFordFulk.addEdge(4, 7, 1);
		graphFordFulk.addEdge(4, 8, 1);
		graphFordFulk.addEdge(4, 9, 1);		
		
//		sink
		graphFordFulk.addEdge(5, t, 1);		// 1. book
		graphFordFulk.addEdge(6, t, 1);		// 2. book
		graphFordFulk.addEdge(7, t, 1);		// 3. book
		graphFordFulk.addEdge(8, t, 1);		// 4. book
		graphFordFulk.addEdge(9, t, 1);		// 5. book
		
		System.out.println("\nMax Sink: " + graphFordFulk.getMaxFlow());
		
		whoWhich(graphFordFulk);
	}
	
	
	public void onePersonMultipleBook()
	{		
		System.out.println("\none Person Multiple Book");
		
		int n 	= 12;						// 5 people, 5 books, 1 source, 1 sink
		int s 	= n-2;
		int t 	= n-1;
				
		GraphFlowFordFulkerson graphFordFulk = new GraphFlowFordFulkerson(n, s, t);

//		source
		graphFordFulk.addEdge(s, 0, 1);		// 1. person
		graphFordFulk.addEdge(s, 1, 2);		// 2. person	2 book
		graphFordFulk.addEdge(s, 2, 3);		// 3. person	3 book
		graphFordFulk.addEdge(s, 3, 1);		// 4. person
		graphFordFulk.addEdge(s, 4, 2); 	// 5. person	2 book
		
//		middle
		graphFordFulk.addEdge(0, 6, 1);
		graphFordFulk.addEdge(0, 7, 1);
		
		graphFordFulk.addEdge(1, 6, 1);
		graphFordFulk.addEdge(1, 7, 1);
		graphFordFulk.addEdge(1, 8, 1);
		
		graphFordFulk.addEdge(2, 5, 1);
		graphFordFulk.addEdge(2, 6, 1);
		graphFordFulk.addEdge(2, 7, 1);
		graphFordFulk.addEdge(2, 9, 1);
		
		graphFordFulk.addEdge(3, 7, 1);
		
		graphFordFulk.addEdge(4, 7, 1);
		graphFordFulk.addEdge(4, 8, 1);
		graphFordFulk.addEdge(4, 9, 1);		
		
//		sink
		graphFordFulk.addEdge(5, t, 1);		// 1. book
		graphFordFulk.addEdge(6, t, 1);		// 2. book
		graphFordFulk.addEdge(7, t, 1);		// 3. book
		graphFordFulk.addEdge(8, t, 1);		// 4. book
		graphFordFulk.addEdge(9, t, 1);		// 5. book
		
		System.out.println("\nMax Sink: " + graphFordFulk.getMaxFlow());
		
		whoWhich(graphFordFulk);
	}
	
	public void onePersonMultipleBookMultipleCopies()
	{		
		System.out.println("\none Person Multiple Book");
		
		int n 	= 12;						// 5 people, 5 books, 1 source, 1 sink
		int s 	= n-2;
		int t 	= n-1;
				
		GraphFlowFordFulkerson graphFordFulk = new GraphFlowFordFulkerson(n, s, t);

//		source
		graphFordFulk.addEdge(s, 0, 1);		// 1. person	1 book
		graphFordFulk.addEdge(s, 1, 2);		// 2. person	2 book
		graphFordFulk.addEdge(s, 2, 3);		// 3. person	3 book
		graphFordFulk.addEdge(s, 3, 1);		// 4. person	1 book
		graphFordFulk.addEdge(s, 4, 2); 	// 5. person	2 book
		
//		middle
		graphFordFulk.addEdge(0, 6, 1);
		graphFordFulk.addEdge(0, 7, 1);
		
		graphFordFulk.addEdge(1, 6, 1);
		graphFordFulk.addEdge(1, 7, 1);
		graphFordFulk.addEdge(1, 8, 1);
		
		graphFordFulk.addEdge(2, 5, 1);
		graphFordFulk.addEdge(2, 6, 1);
		graphFordFulk.addEdge(2, 7, 1);
		graphFordFulk.addEdge(2, 9, 1);
		
		graphFordFulk.addEdge(3, 7, 1);
		
		graphFordFulk.addEdge(4, 7, 1);
		graphFordFulk.addEdge(4, 8, 1);
		graphFordFulk.addEdge(4, 9, 1);		
		
//		sink
		graphFordFulk.addEdge(5, t, 5);		// 1. book		5 copies
		graphFordFulk.addEdge(6, t, 1);		// 2. book		1 copies
		graphFordFulk.addEdge(7, t, 2);		// 3. book		2 copies
		graphFordFulk.addEdge(8, t, 1);		// 4. book		1 copies
		graphFordFulk.addEdge(9, t, 3);		// 5. book		3 copies
		
		System.out.println("\nMax Sink: " + graphFordFulk.getMaxFlow());
		
		whoWhich(graphFordFulk);
	}
	
	private void whoWhich(GraphFlowFordFulkerson graphFordFulk)
	{
		List<Edge>[] graph = graphFordFulk.graph;
		
		for(int i= 0; i<5; i++)
		{
			System.out.print("\n" + (i+1) + ". person: ");
			for(Edge edge : graph[i])
			{
				if(edge.flow == 1)
					System.out.print(edge.to-4 + ". ");
			}
			System.out.print("book.");
		}
	}

	public static void main(String[] args) 
	{
		
		UnweightedBipartiteMatchingBooksExample personToBook = new UnweightedBipartiteMatchingBooksExample();
		
		personToBook.onePersonOneBook();
		personToBook.onePersonMultipleBook();
		personToBook.onePersonMultipleBookMultipleCopies();
		
		System.out.println("\n\n\nif one person wants to have the same book multiple times change the edge capacity between the persen and the book");
	}
 
}


















