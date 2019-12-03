package HackerRank.algoPractice;

import java.util.HashMap;
import java.util.Map;

public class QueryStrings {

	static int[] matchingStrings(String[] strings, String[] queries) 
	{
		Map<String, Integer> inputs = new HashMap<String, Integer>();
		int[] ret = new int[queries.length];
		Integer val;
		
		for(String st : strings)
		{
			val = inputs.get(st);
			
			if(val != null)
				inputs.put(st, ++val);
			else
				inputs.put(st, 1);				
		}
		
		for(int i=0; i<queries.length; i++)
		{
			val = inputs.get(queries[i]);
			
			if(val == null)
				ret[i] = 0;
			else
				ret[i] = val;
		}
			
		
		return ret;
    }
	
	public static void main(String[] args) {
		
		String[] strings = {"ab", "ab", "abc"};
		String[] queries = {"ab", "abc", "bc"};

		matchingStrings(strings, queries);
		
		System.out.println();
	}

}
