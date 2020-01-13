package HackerRank.Strings;

import java.util.HashSet;
import java.util.Set;

public class Panagrams {

    static String pangrams(String s) {

    	String abc = "abcdefghijklmnopqrstuvwxyz";
    	
    	Set<Character> set = new HashSet<Character>();
    	
    	for(int i=0; i<s.length(); i++)
    		set.add(Character.toLowerCase(s.charAt(i)));
    	
    	for(int i=0; i<abc.length(); i++)
    		if(!set.contains(abc.charAt(i)))
    			return "not pangram";
    	
    	return "pangram";
    }
    
	public static void main(String[] args) {
		
		

	}

}
