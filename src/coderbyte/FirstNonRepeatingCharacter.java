package coderbyte;

import java.util.HashMap;
import java.util.Map;

// loop once to fill the map
// 2. loop stop when map -> 1 value
public class FirstNonRepeatingCharacter {

	static char firstNonrepeating(String word)
	{
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(int i=0; i<word.length(); i++)
		{
			Integer val = map.get(word.charAt(i));
			
			if(val != null)
				map.put(word.charAt(i), val+1);
			else
				map.put(word.charAt(i), 1);
		}
		
		for(int i=0; i<word.length(); i++)
			if(map.get(word.charAt(i)) == 1)
					return word.charAt(i);
		
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(firstNonrepeating("abcdeabcde"));
		
	}

}
