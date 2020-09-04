package HackerRank.Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CrosswordPuzzle {

	// INPUT 
	
//	+-++++++++
//	+-++++++++
//	+-------++
//	+-++++++++
//	+-++++++++
//	+------+++
//	+-+++-++++
//	+++++-++++
//	+++++-++++
//	++++++++++
//	
//	AGRA;NORWAY;ENGLAND;GWALIOR
	
	// OUTPUT
	
//	+E++++++++
//	+N++++++++
//	+GWALIOR++
//	+L++++++++
//	+A++++++++
//	+NORWAY+++
//	+D+++G++++
//	+++++R++++
//	+++++A++++
//	++++++++++
	
    static String[] crosswordPuzzle(String[] crossword, String words) 
    {
    	List<String> strings = new ArrayList<String>();
    	String word = "";
    	
    	for(int i=0; i<words.length(); i++)
    	{
    		if(words.charAt(i)==';')
    		{
    			strings.add(word);
    			word = "";
    		}    			
    		else
    			word += words.charAt(i);
    	}    
    	strings.add(word);
    	
    	String[] words_arr = strings.stream().map(x->x).toArray(String[]::new);
    	
    	char[][] cws = new char[10][10];
    	
    	int i=0;
    	for(String arr : crossword)
    		cws[i++] = arr.toCharArray();
    	
    	crosswordPuzzleUtil(cws, word, 0, 0, false, false);
    	
    	return crossword;
    }
    
    // ha ez es amellette levo is - akkor mehet oda jelezni kell hogy odarol jottunk
    // ha ez es az alatta levo is - akkor le jelezni kell h fentrol jott
    static void crosswordPuzzleUtil(char[][] crossword, String word, int r, int c, boolean vertical, boolean horizontal)
    {    	
    	if(r>9 || c>9)
    		return;    	
    	
//    	if(crossword[r][c] == '+' && !vertical && !horizontal)
//    		crosswordPuzzleUtil(crossword, word, r, c+1, false, false);
//    	if(crossword[r][c] == '+' && vertical && !horizontal)
//    		crosswordPuzzleUtil(crossword, word, r+1, c, true, false);
//    	if(crossword[r][c] == '+' && !vertical && horizontal)
//    		crosswordPuzzleUtil(crossword, word, r, c+1, false, true);
    		
    	
    	if(crossword[r][c] == '-' && !vertical)
		{
    		crossword[r][c] = 'V';
			crosswordPuzzleUtil(crossword, word, r, c+1, false, true);
		}
		if(crossword[r][c] == '-' && !horizontal)
		{
			crossword[r][c] = 'V';
			crosswordPuzzleUtil(crossword, word, r+1, c, true, false);
		}
    	
    }
	
    
    
    
    
    
//    as if graph problem
    
    static String[] graphPuzzle(String[] crossword, String words) 
    {
    	List<String> strings = new ArrayList<String>();
    	String word = "";
    	
    	for(int i=0; i<words.length(); i++)
    	{
    		if(words.charAt(i)==';')
    		{
    			strings.add(word);
    			word = "";
    		}    			
    		else
    			word += words.charAt(i);
    	}    
    	strings.add(word);
    	
    	String[] words_arr = strings.stream().map(x->x).toArray(String[]::new);
    	
    	char[][] cws = new char[10][10];
    	
    	int i=0;
    	for(String arr : crossword)
    		cws[i++] = arr.toCharArray();
    	
    	
    	graphPuzzleSolver(cws, words_arr);
    	
    	return crossword;
    }
    
    
    static void graphPuzzleSolver(char[][] graph, String[] words) 
    {    	
    	class Crossword
    	{
    		String word;
    		Map<Integer, Character> children = new HashMap<Integer, Character>();		// melyik pozicioban milyen betuvel kell kezdodnie
    		
			public Crossword(String word) {
				super();
				this.word = word;
			}		
    	}
    	
    	class VerticalWord
    	{
    		int col, start, end;    		
    		
    		Map<Integer, Integer> children = new HashMap<Integer, Integer>();		// melyik pozicioban milyen hosszu kell
    	}
    	
    	class HorizontalWord
    	{
    		int row, start, end;
    		
    		Map<Integer, Integer> children = new HashMap<Integer, Integer>();    		
    	}
    	
    	List<VerticalWord> verticalWords = new ArrayList<VerticalWord>(); 
    	boolean[][] visited = new boolean[10][10];
    	
    	// only vertical words
    	for(int c=0; c<10; c++)
    	{
    		for(int r=0; r<10; r++)
    		{
    			if(graph[r][c] == '-')
    			{
    				VerticalWord vw = new VerticalWord();
    				
    				vw.col = c;
    				vw.start = r;
    				
    				while(r<10 && graph[r][c] == '-')			// go to end of vertivcal word
    				{
    					visited[r][c] = true;
    					
    					if(c<10 && !visited[r][c+1] && graph[r][c+1] == '-')		// find childrens
    					{
    						visited[r][c] = false;
    						
    						int col = c+1;
    						int len = 1;
    						
    						while(col<10 && graph[r][col] == '-')
    						{				
    							visited[r][col] = true;
    							len++;
    							col++;
    						}
    						
    						vw.children.put(r, len);
    					}
    					
    					r++;
    				}
    				
    				vw.end = r;
    				
    				if(vw.end-vw.start > 1)    				
    					verticalWords.add(vw);
    			}
    		}
    	}
    	
    	// only horizontal words
    	// ahol - es !visited ott elkezdhet megnezni egy horizontal szot
    	for(int r=0; r<10; r++)
		{
    		for(int c=0; c<10; c++)
        	{
        		if(!visited[r][c] && graph[r][c] == '-')
        		{
        			HorizontalWord hw = new HorizontalWord();
        			
        			
        		}
        	}
		}    	
    	
    	System.out.println();
    }
    
    
    // make it a graph problem ?
    // 1.node -> 2. node
    // 1.node -> 3. node
    // 3.node -> 4. node
    
    // mintha meglennenek a nodok
    static void solve()
    {
    	class Node
    	{
    		String word;
    		int length;    		
    		Map<Integer, Node> children = new HashMap<Integer, Node>();
    		
//			public Node(String word) {
//				super();
//				this.word = word;
//			}    	
			public Node(int length) {
				super();
				this.length = length;
			} 
    	}
    	
    	// mintha meglenne a tree
    	List<Node> nodes = new ArrayList<Node>();
    	
    	Node node = new Node(7);
    	node.children.put(2, new Node(7));
    	
    	Node ch = new Node(6);
    	ch.children.put(5, new Node(4));
    	
    	node.children.put(5, ch);
    	
    	return;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String[] crossword =   {"+-++++++++",
								"+-++++++++",
								"+-------++",
								"+-++++++++",
								"+-++++++++",
								"+------+++",
								"+-+++-++++",
								"+++++-++++",
								"+++++-++++",
								"++++++++++"};
		
		String words = "AGRA;NORWAY;ENGLAND;GWALIOR";

//		graphPuzzle(crossword, words);
		
		solve();
	}

}


//for(int r=row; r<10-1; r++)
//{
//	for(int c=col; c<10-1; c++)
//	{
//		
//	}
//}





















