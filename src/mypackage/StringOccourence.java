package mypackage;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class StringOccourence 
{

	private static class Word
	{
		int index;
		int freq;
		
		@SuppressWarnings("unused")
		public Word() {}
		
		public Word(int index, int frequency)
		{
			this.index = index;
			this.freq  = frequency;
		}
	}
	
	public int firstMultipleOccouringCharIndex(String word)
	{
		Map<String, Integer> map = new HashMap<String, Integer>();
		String key;
		
		for(int i=0; i<word.length(); i++)
		{
			key = word.substring(i, i+1);
			
			if(map.containsKey(key))
				return map.get(key);
			
			else
				map.put(key, i);
		}
		
		return -1;
	}
	
	public int firstNonOccouringCharIndex(String word)
	{
		Map<String, Word> map = new HashMap<String, Word>();
		String key;
		
		for(int i=0; i<word.length(); i++)
		{
			key = word.substring(i, i+1);
			
			if(map.containsKey(key))
			{
				Word value = map.get(key);
				value.freq++;
				map.put(key, value);
			}
			else
				map.put(key, new Word(i, 1));
		}
		
		for(Word value : map.values())
		{
			if(value.freq == 1)
				return value.index;
		}
		
		return -1;
	}
	
	public String longestContinuouslyOccouringChar(String word)
	{
		Map<String, Integer> map = new HashMap<String, Integer>();
		String key, temp = "";
		int max = 0;
		
		for(int i=0; i<word.length(); i++)
		{
			key = word.substring(i, i+1);
			
			if(map.containsKey(key) && i>0)
			{
				temp = word.substring(i-1, i);
				if(temp.matches(key))
				{
					Integer value = map.get(key);				
					value++;
					map.put(key, value);
				}				
			}
			else
				map.put(key, 1);
		}
		
		for(Entry<String, Integer> entry : map.entrySet())
		{
			if( entry.getValue() > max)
			{
				max = entry.getValue();
				temp = entry.getKey();
			}
				
		}
		
		return temp;
	}
	
	public static void main(String[] args) 
	{
		StringOccourence so = new StringOccourence();
		String word = "ABCBAAEBBBBADD";		
		
		System.out.println( so.firstMultipleOccouringCharIndex(word) );			// should be O(n), return 1, cuz B is the first and its index is 1 when first appeared

		System.out.println( so.firstNonOccouringCharIndex(word) ); 				// should be O(n), return 2, C
		
		System.out.println( so.longestContinuouslyOccouringChar(word) );		// should be O(n), return B (freq 4)
	}

}














