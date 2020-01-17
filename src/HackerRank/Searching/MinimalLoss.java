package HackerRank.Searching;

import java.util.Arrays;
import java.util.Collections;

public class MinimalLoss {

//	pl: 20 7 8 2 5   buy for 7, sell for 5, loss is 2  (must lose some)
    static int minimumLoss(long[] price) 
    {

    	// class value, index
    	// sort
    	// select 1st
    	// select next if it has lesser index ok
    	
    	class House implements Comparable<House>
    	{
    		long value, index;

			public House(long value, long index) {
				super();
				this.value = value;
				this.index = index;
			}

			@Override
			public int compareTo(House o) 
			{
				if(this.value > o.value)
					return 1;
				else if(this.value < o.value)
					return -1;
				return 0;
			}    		
    	}
    	
    	House[] house = new House[price.length];
    	
    	for(int i=0; i<price.length; i++)
    		house[i] = new House(price[i], i);
    	
    	Arrays.sort(house, Collections.reverseOrder());
    	
    	int min = Integer.MAX_VALUE;
    	
    	for(int i=0; i<house.length; i++)
    	{
    		for(int k=i+1; k<house.length; k++)
        	{
        		if(house[k].index > house[i].index)
        			min = Math.min(min,  (int) (house[i].value - house[k].value) );
        	}
    	}
    	
    	return min;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long[] price = {20, 7, 8, 2, 5};
		
		minimumLoss(price);
	}

}














