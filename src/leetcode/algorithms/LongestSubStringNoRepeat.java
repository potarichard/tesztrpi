package leetcode.algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

public class LongestSubStringNoRepeat {
	
	public static int lengthOfLongestSubstring(String s) {
    
		Map<Character, Integer> map = new HashMap<Character, Integer>();		
		
		int max = 0;
		char[] arr = s.toCharArray();		
		
		for(int i=0; i<arr.length; i++)
		{
			char c = arr[i];
			
			if(!map.containsKey(c))
				map.put(c, i);	
			else
			{
				int index = map.get(c);
				map = map.entrySet()
						.stream().filter( (entry)-> entry.getValue()>=index)
						.collect(Collectors.toMap(e->e.getKey(),e->e.getValue()));
				map.put(c, i);
			}
			
			max = Math.max(max, map.size());
		}
		
		return max;
    }
	
	public static int lengthOfLongestSubstring2(String s) {

		int i=0, j=0, max=0;
		
		HashSet<Character> set = new HashSet<Character>();
		
		while(j < s.length())
		{
			if(!set.contains(s.charAt(j)))
			{
				set.add(s.charAt(j));
				j++;
				max = Math.max(max, set.size());
			}
			else
			{
				set.remove(s.charAt(i));
				i++;
			}
		}
		
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		mindig epitek egy uj mapot, linearisan nezem hogy van e ilyen betu mar a mapban
//		vagy egy 26 os tomb...

		lengthOfLongestSubstring2("dvdf");
		
	}

}
