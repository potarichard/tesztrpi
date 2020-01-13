package HackerRank.Searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MissingNumbers {
	
	// ket lista a hosszak kulonbsege a missing numbers
	// ket map kell, value es annak freqvenciaja
	// ahol eltero frekik vannak az a hianyzo szam
	
	// 203 204 205 206 207 208 203 204 205 206
	// 203 204 204 205 206 207 205 208 203 206 205 206 204
	
	// 204 205 206   are missing from arr
	static int[] missingNumbers(int[] arr, int[] brr) 
	{				
		Map<Integer, Integer> amm = new HashMap<Integer, Integer>();
		Map<Integer, Integer> bmm = new HashMap<Integer, Integer>();
		List<Integer> missing_numbers = new ArrayList<Integer>(); 
		
		
		for(int a : arr)
		{
			Integer val = amm.get(a);
			
			if(val == null)
				amm.put(a, 1);
			else
				amm.put(a, val+1);
		}
		
		for(int b : brr)
		{
			Integer val = bmm.get(b);
			
			if(val == null)
				bmm.put(b, 1);
			else
				bmm.put(b, val+1);
		}
		
		for(Entry<Integer, Integer> entry : amm.entrySet())
		{
			Integer val_1 = entry.getValue();
			Integer val_2 = bmm.get(entry.getKey());
			
			if(val_1.intValue() != val_2.intValue())
				missing_numbers.add(entry.getKey());
		}
		
		for(Entry<Integer, Integer> entry : bmm.entrySet())
		{
			Integer val = amm.get(entry.getKey());
			
			if(val == null)
				missing_numbers.add(entry.getKey());
		}
		
		int[] ret = missing_numbers.stream().mapToInt(x -> x).toArray();
		
		Arrays.sort(ret);
		
		return ret;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr	= {203, 204, 205, 206, 207, 208, 203, 204, 205, 206};
		int[] brr	= {203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204};
		
		missingNumbers(arr, brr);
	}

}










