package mypackage;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SearchPairs 
{

	// count pairs that difference is = target
	// 
	public static int pairs(int[] arr, int target)
	{
		//   k-ertek, v-index
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		int 	count = 0,
				pair_1,
				pair_2;
		
		for(int i=0; i<arr.length; i++)
		{
			pair_1 = Math.abs(target - arr[i]);
			pair_2 = target+arr[i];
			
			if(map.get(pair_1) != null || map.get(pair_2) != null)
				count++;
			if(map.get(pair_1) == null)
				map.put(arr[i], i);
			if(map.get(pair_2) == null)
				map.put(pair_2, i);
				
		}
		
		return count;
	}
	
	public static int pairsSorted(int[] arr, int target)
	{
		
		// if it was shorted
		arr = new int[] {1, 2, 3, 4, 5, 6, 8};
		
		   int 	i=0,
				j=1,
				count=0;
		    
		    while(j < arr.length) 
		    {
		        int diff = arr[j] - arr[i];
		        
		        if (diff == target) 
		        {
		            count++;
		            j++;
		        } 
		        else if (diff > target)
		            i++;
		        else if (diff < target) 
		            j++;
		    }
		    
		    return count;
	}
	
	public static int pairsWithSet(int[] arr, int target)
	{
		Set<Integer> set = new HashSet<Integer>();
		int count = 0;
		
		for(int i=0; i<arr.length; i++)
			set.add(Math.abs(target-arr[i]));			// {1, 3, 5, 8, 6, 4, 2} -> (1, 3, 6, 4, 2, 0) lesz a set
		
		
		for(int i=0; i<arr.length; i++)
			if(set.contains(arr[i]))					// ez O(1), data structure HashTable
				count++;
		
		return count;
	}
	
	public static void main(String[] args) 
	{
		
		int[] arr = {1, 5, 3, 4, 2};			// if target is 2, pairs are (5,3), (1,3), (4,2)
		
		int[] arr2 = {1, 3, 5, 8, 6, 4, 2};		// if target is 2, pairs are (1,3), (3,5), (8,6), (6,4), (4,2)

//		System.out.println(pairs(arr2, 2));
//		
//		System.out.println(pairsSorted(arr2, 2));
		
		System.out.println(pairsWithSet(arr2, 2));
	}

}








