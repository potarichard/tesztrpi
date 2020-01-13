package HackerRank.Sortings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LilysHomework {

	// get minimum number of swaps to get the list sorted!
    static int lilysHomework(int[] arr) {

    	int[] arr_cpy = arr.clone();
    	int swaps = 0;
    	Arrays.sort(arr_cpy);
    	
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();	// key-arr values, values array indexes
    	
//    	prep
    	for(int i=0; i<arr.length; i++)    		
    		if(!map.containsKey(arr[i]))
    			map.put(arr[i], i);    
    	
//    	algo, valami ilyesmi...
    	for(int i=0; i<arr.length; i++)  
    	{
    		if(arr[i] != arr_cpy[i])
    		{
    			int indexofcpy = map.get(arr_cpy[i]);
    			int temp = arr[i];
    			
    			arr[i] = arr_cpy[i];    			
    			arr[indexofcpy] = temp;
    			
    			map.put( map.get(arr[i]),  map.get(arr_cpy[i])); 
    		}
    	}
    	
    	return swaps;
    }
	
	public static void main(String[] args) 
	{

		int[] arr = {2, 5, 3, 1};	// ret 2
		
		lilysHomework(arr);
	}

}
