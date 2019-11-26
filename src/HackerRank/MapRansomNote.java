package HackerRank;

import java.util.HashMap;
import java.util.Map;

public class MapRansomNote 
{

	public static void rn(String[] magazine, String[] note)
	{
		// load map with magazin int number of words, key word itself
		Map<String, Integer> mag = new HashMap<String, Integer>();
		
		int val;
		
		for(String str : magazine)
		{
			if(mag.containsKey(str))
			{
				val = mag.get(str);
				mag.put(str, val+1);
			}
			else
				mag.put(str, 1);
		}
		
		for(String str : note)
		{
			if(mag.containsKey(str))
			{
				val = mag.get(str);
				mag.put(str, val-1);
				
				if(val <= 0)
				{
					System.out.println("NO");
					return;
				}
					
			}
			
			else
			{
				System.out.println("NO");
				return;
			}
		}
		
		System.out.println("YES");
	}
	
	public static void main(String[] args) 
	{
		
		

	}

}
