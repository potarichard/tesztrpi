package HackerRank;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapTwoStrings {

	
	static String twoStrings(String s1, String s2)
	{
		Set<Character> chars = new HashSet<Character>();
		
		for(int i=0; i<s1.length(); i++)
			chars.add(s1.charAt(i));
		
		for(int i=0; i<s2.length(); i++)
			if(chars.contains(s2.charAt(i)))
				return "YES";
		
		return "NO";
	}
	
	public static void main(String[] args) 
	{
		
		

	}

}
