package HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapCountTriplets 
{

	// tegyuk bele egy mapba az elemek x szereset
	static long countTriplets(List<Long> arr, long r) 
    {
		long count = 0, i = 0;	
		Set<String> map = new HashSet<String>();
		
		for(Long value : arr)
			map.add(value + ":" + i++);
		
		
		for(Long value : arr)
		{
			
		}
			
		
		return count;
    }
	
//	 ertek es index, majd kivesz a mapbol gyujtjuk aztan visszapakoljuk
	
	private static long countTriplets2(List<Long> arr, long r) 
	{
		Map<Long, Long> t2 = new HashMap<>();
		Map<Long, Long> t3 = new HashMap<>();
		long result = 0L;
	        
		
		
		return result;
	}
	
	public static void main(String[] args) 
	{
		
		List<Long> arr = new ArrayList<Long>(Arrays.asList(1L, 3L, 9L, 9L, 27L, 81L));				// 1 3 9 9 27 81
		
		countTriplets2(arr, arr.size());
		
	}

}
