package coderbyte;

import java.util.HashMap;
import java.util.Map;

// loop once to fill the map
// 2. loop stop when map -> 1 value
public class FirstNonRepeatingCharacter {

	static String firstNonrepeating(String str)
	{
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(int i=0; i<str.length(); i++)
		{
			Integer val = map.get(str.charAt(i));
			
			if(val != null)
				map.put(str.charAt(i), val+1);
			else
				map.put(str.charAt(i), 1);
		}
		
		for(int i=0; i<str.length(); i++)
			if(map.get(str.charAt(i)) == 1)
					return str.charAt(i) + "";
		
		return "";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(firstNonrepeating("abcdeabcde"));
		
	}

}
