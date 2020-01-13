package HackerRank.Searching;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RadioTransmitters {

	// x house at given distance, k transmitter range, minumum transmitter to cover radio signals ?
    static int hackerlandRadioTransmitters2(int[] x, int k) {

    	Arrays.sort(x);
    	int numOfTransmitters = 0;
    	int i = 0, n = x.length;

    	while (i < n) 
    	{
    	    numOfTransmitters++;
    	    
    	    int loc = x[i] + k;
    	    
    	    while (i < n && x[i] <= loc) 
    	    	i++;
    	    
    	    loc = x[--i] + k;
    	    
    	    while (i < n && x[i] <= loc) 
    	    	i++;
    	}
    	
    	return numOfTransmitters;
    }
	
    // elso oda ahol meg a legelso hazat is lefedi
    static int hackerlandRadioTransmitters(int[] house, int range) 
    {    	
    	int numOfTransmitters = 0;
    	int i = 0, len = house.length;    	
    	Set<Integer> houses = new HashSet<Integer>();
    	
    	Arrays.sort(house);
    	
    	for(int h : house)
    		houses.add(h);
    	
    	int location = house[0] + range;
    	int min = house[0];
    	int max = location + range;
    	
    	int maxrange = house[len-1];
    	
    	
    	while (i < len) 
    	{	
    		if(houses.contains(location))
    		{
    			numOfTransmitters++;
    			
    			// kovi haz:
    			i = max + 1;
    			while(!houses.contains(i) && i<len)
    				i++;
    		}
    		
    		else
    		{
    			location--;
    		}
    			
    		location = i + range;
    		min = i;
        	max = location + range;
        }
    	
    	
    	return numOfTransmitters;
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//	k=1		    w     w
		int[] arr = {1, 2, 3, 4, 5};		// 2 es 4 pontba kell ado
		
		
		//	k=2    		 |     w     |  |     w     |   w
		//			  _, 2, _, 4, 5, 6, 7, _, 9, _, 11, 12
		int[] arr2 = {2, 4, 5, 6, 7, 9, 11, 12};		// 4, 9 es 12 pontba kell ado
		
		hackerlandRadioTransmitters(arr, 1);
		
	}

}
















