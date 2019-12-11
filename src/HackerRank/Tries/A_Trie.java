package HackerRank.Tries;

import java.util.HashMap;
import java.util.Map;

// https://www.youtube.com/watch?v=-urNrIAQnNo

public class A_Trie {

	static class Node
	{
		Map<Character, Node> child = new HashMap<Character, Node>();
		boolean is_word;
		
		public Node() {}
	}
	
	public static void main(String[] args) {
		
		Node root = new Node();
		
		root.child.put('H', new Node());		// gonna be Hacker
		root.child.put('D', new Node());		// gonna be Duck
		
		root.child.get('H').child.put('A', new Node());

		System.out.println();
	}

}
