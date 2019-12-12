package HackerRank.Tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://www.youtube.com/watch?v=-urNrIAQnNo

public class A_Trie {

	Node root = new Node();
	
	static class Node
	{
		Map<Character, Node> child = new HashMap<Character, Node>();
		boolean is_word;
		
		public Node() {}
	}
	
	public void add(String word)
	{		
		Node node = root;
		
		while(!word.isEmpty())
		{
			Character letter = word.charAt(0);
			
			Node n = node.child.get(letter);
			
			if(n != null)
				node = n;
			else
			{
				Node new_child = new Node();
				node.child.put(letter, new_child);					
				node = new_child;
			}				
			
			word = word.substring(1);
		}
		
		node.is_word = true;
	}
	
	// keressen olyan szavakat aminek ez a prefixe
	public String find(String word)
	{
		if(word.isEmpty())
			return word;
		String ret = "";
		Node node = root;
		String original = word;
		
		// amig van betu addig megyek, aztan onnan meg egy loop, es addig megyek amig talalok egy szot
		while(!word.isEmpty() && !node.child.isEmpty())
		{
			Character letter = word.charAt(0);
			word = word.substring(1);
			ret += letter;
			
			Node n = node.child.get(letter);
			
			if(n != null)
			{
				node = n;
				if(node.is_word && original.length() <= ret.length())
					return ret;
			}
			
			else
				return original;
			
		}
		
		while(!node.child.isEmpty())
		{
			Map.Entry<Character,Node> entry = node.child.entrySet().iterator().next();
			node =  entry.getValue();
			
			if(node != null)
				ret += entry.getKey();
			
			if(node.is_word && original.length() <= ret.length())
				return ret;
		}
		
		return ret;
	}
	
	
	public List<String> findAllWithPrefix(String word)
	{
		List<String> ret = new ArrayList<String>();
		String original = word;
		Node node = root;
		
		if(word.isEmpty())
			return ret;
		
		while(!word.isEmpty() && !node.child.isEmpty())
		{
			Character letter = word.charAt(0);
			
			word = word.substring(1);
			
			Node n = node.child.get(letter);
			
			if(n == null)
				return ret;
			
			if(n != null)
				node = n;	
		}
		
		if(original.length() > 1)
			findHelper(node, original.substring(0, original.length()-1), ret);
		else
			findHelper(node, original, ret);
		
		return ret;  
	}
	
	
	private void findHelper(Node node, String current, List<String> list)
	{
		if(node.is_word)
			list.add(current);
		
		for(Map.Entry<Character,Node> entry : node.child.entrySet())
			findHelper(entry.getValue(), current+entry.getKey(), list);
	}
	

	
	public static void main(String[] args) {
				
		
		A_Trie trie = new A_Trie();
		
		trie.add("Hello");
		trie.add("HackerRank");
		trie.add("Hacker");
		trie.add("Hackos");
		trie.add("Duck");
		
		System.out.println(trie.find(""));
		System.out.println(trie.find("H"));
		System.out.println(trie.find("He"));		
		System.out.println(trie.find("Hackerr"));
		System.out.println(trie.find("HackerR"));
		System.out.println(trie.find("d"));
		System.out.println(trie.find("D"));
		
		trie.findAllWithPrefix("Hac");
		trie.findAllWithPrefix("D");
		trie.findAllWithPrefix("");

		System.out.println();
		
		// more teszt
		// add s, add ss, add sss, add ssss, add sssss, add ssssss, add sssssss
		// find ....
		// lassu is
		
		/////////////////////////////////////////////////////////////////////////////////////////////
		
	}

}


















