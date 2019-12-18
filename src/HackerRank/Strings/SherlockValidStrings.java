package HackerRank.Strings;

import java.util.HashMap;
import java.util.Map;

public class SherlockValidStrings {

	
    static String isValid(String s) 
    {
    	if(s.isEmpty())
    		return "YES";
    	
    	int freq = -1;
    	boolean first = false;
    	Map<Character, Integer> map = new HashMap<Character, Integer>();
    	
    	for(int i=0; i<s.length(); i++)
    	{
    		Integer num = map.get(s.charAt(i));
    		
    		if(num == null)
    			map.put(s.charAt(i), 1);
    		else
    			map.put(s.charAt(i), num+1);
    	}
    	
    	freq = map.get(s.charAt(0));
    	
    	for(Integer val : map.values())
    	{
    		if(!first)
    		{
    			if(Math.abs(freq-val) > 1)
    				return "NO";
    			else if(Math.abs(freq-val) == 1)
    				first = true;
    		}
    		
    		else if(Math.abs(freq-val) > 0)
    			return "NO";
    	}

    	return "YES";
    }
    
	public static void main(String[] args) 
	{	
		
	}

}









