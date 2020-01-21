package graphTheory.Dijkstra;

import java.util.List;

public class Main {

	public static void main(String[] args) 
	{
		
		Graph graph = new Graph(9);
		
		graph.addEdge(0, 3, 1);
		graph.addEdge(0, 6, 1);
		graph.addEdge(6, 7, 1);
		graph.addEdge(6, 8, 1);
		graph.addEdge(8, 5, 1);
		graph.addEdge(8, 2, 1);
		
		List<Integer> shorthest_path = graph.shortestPath(0, 2);
		
		System.out.println(shorthest_path);		
		
		
				
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
/*		
		
		String asd = 
		"XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\r\n" + 
		"...................................................................................................X\r\n" + 
		"XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX.X\r\n" + 
		"X................................................................................................X.X\r\n" + 
		"X.XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX.X.X\r\n" + 
		"X.X............................................................................................X.X.X\r\n" + 
		"X.X.XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX.X.X.X\r\n" + 
		"X.X.X........................................................................................X.X.X.X\r\n" + 
		"X.X.X.XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX.X.X.X.X\r\n" + 
		"X.X.X.X....................................................................................X.X.X.X.X\r\n" + 
		"X.X.X.X.XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX.X.X.X.X.X\r\n" + 
		"X.X.X.X.X................................................................................X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X............................................................................X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X........................................................................X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X....................................................................X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X................................................................X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X............................................................X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X........................................................X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X....................................................X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX.X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.X................................................X.X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.X.XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX.X.X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.X.X............................................X.X.X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.X.X.XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.X.X.X........................................X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X....................................X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X................................X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X............................X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.XXXXXXXXXXXXXXXXXXXXXXXXXX.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X........................X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.XXXXXXXXXXXXXXXXXXXXXX.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X......................X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X......................X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X......................X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X......................X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X......................X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X......................X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X......................X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X......................X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X......................X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X......................X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X......................X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X......................X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X......................X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X......................X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X......................X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X......................X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X......................X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X......................X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X......................X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X......................X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.XXXXXXXXXXXXXXXXXXXXXXXX.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X..........................X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.XXXXXXXXXXXXXXXXXXXXXXXXXXXX.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X..............................X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X..................................X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X......................................X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.X.X.X..........................................X.X.X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.X.X.XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX.X.X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.X.X..............................................X.X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.X.XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX.X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.X..................................................X.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X.XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX.X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.X......................................................X.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X.XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX.X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.X..........................................................X.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X.XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX.X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.X..............................................................X.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X.XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX.X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.X..................................................................X.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X.XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX.X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.X......................................................................X.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X.XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX.X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.X..........................................................................X.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X.XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX.X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.X..............................................................................X.X.X.X.X.X\r\n" + 
		"X.X.X.X.X.XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX.X.X.X.X.X\r\n" + 
		"X.X.X.X.X..................................................................................X.X.X.X.X\r\n" + 
		"X.X.X.X.XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX.X.X.X.X\r\n" + 
		"X.X.X.X......................................................................................X.X.X.X\r\n" + 
		"X.X.X.XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX.X.X.X\r\n" + 
		"X.X.X..........................................................................................X.X.X\r\n" + 
		"X.X.XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX.X.X\r\n" + 
		"X.X..............................................................................................X.X\r\n" + 
		"X.XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX.X\r\n" + 
		"X..................................................................................................X\r\n" + 
		"XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\\r\\n";
		
//		1 0 50 50  paramteres
//		expected output 79

		*/
	}

}
