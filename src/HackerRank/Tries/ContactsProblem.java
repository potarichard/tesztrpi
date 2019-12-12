package HackerRank.Tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ContactsProblem {


	static Node root = new Node();
	
	static class Node
	{
		Map<Character, Node> child = new HashMap<Character, Node>();
		boolean is_word;
		
		public Node() {}
	}
	
	public static void add(String word)
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
	
	public static List<String> findAllWithPrefix(String word)
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
	
	
	static void findHelper(Node node, String current, List<String> list)
	{
		if(node.is_word)
			list.add(current);
		
		for(Map.Entry<Character,Node> entry : node.child.entrySet())
			findHelper(entry.getValue(), current+entry.getKey(), list);
	}
	
	// HackerRank part
	static int[] contacts(String[][] queries) 
	{
        int[] ret;
        List<Integer> finds = new ArrayList<Integer>();
        int i = 0;
        
		for(String[] query : queries)
		{
			String type = query[0];
			String word = query[1];
			
			switch(type)
			{
			case "add":		
				add(word);
				break;
			case "find":
				finds.add( findAllWithPrefix(word).size() );
				break;
			}
		}

		ret = new int[finds.size()];
		
		for(Integer num : finds)
			ret[i++] = num;
		
		return ret;
    }
	
	public static void main(String[] args) {
		
		String[][] queries = {	{"add", "hack"},
								{"add", "hackerrank"},
								{"find", "hac"},
								{"find", "hak"}};

		
		contacts(queries);
	}

}






