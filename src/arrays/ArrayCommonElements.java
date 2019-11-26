package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayCommonElements {

//	1. arr_1 loop each -> inner loop arr_2 put commons to a set  -> n2
	
//	2. sort both nxlogn, aztan loop once with 2 pointers -> (nxlogn) + (n+m)  jobb mint az 1.
	
	static Integer[] findCommons(int[] arr_1, int[] arr_2)
	{
		
		if(arr_1 == null || arr_2 == null)
			return null;
		if(arr_1.length == 0 || arr_2.length == 0)
			return new Integer[0];
		
		Arrays.sort(arr_1);
		Arrays.sort(arr_2);
		
		int i= 0, k = 0;
		
		Set<Integer> uniques = new HashSet<Integer>(); 
		
		while(i < arr_1.length && k < arr_2.length)
		{
			if(arr_1[i] == arr_2[k])
			{
				uniques.add(arr_1[i]);
				i++;
				k++;
			}
			else if(arr_1[i] > arr_2[k])
				k++;
			else if(arr_1[i] < arr_2[k])
				i++;
		}
		
		Integer[] ret = new Integer[uniques.size()];
		
		return uniques.toArray(ret);
	}
	
	public static void main(String[] args) {
		
		
		int[] arr_1 = {1,2,3,2,1,4};
		int[] arr_2 = {3,3,3,2};

		// return unique common elements -> [2, 3]
		findCommons(arr_1, arr_2);
		
	}

}






