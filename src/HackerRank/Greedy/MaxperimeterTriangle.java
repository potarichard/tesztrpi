package HackerRank.Greedy;

import java.util.Arrays;

public class MaxperimeterTriangle {

	
	// desc order, loop once, check 3 eighbour
    static int[] maximumPerimeterTriangle(int[] sticks) {

    	int[] ret = new int[3];
    	boolean ok = false;
    	
    	for(int i=0; i<sticks.length; i++)
    		sticks[i] *= -1;
    	
    	Arrays.sort(sticks);
    	
    	for(int i=0; i<sticks.length; i++)
    		sticks[i] *= -1;
    	
    	
    	for(int i=0; i<sticks.length-3; i++)
    	{
    		if(sticks[i] < (sticks[i+1] + sticks[i+2]) && sticks[i+1] < (sticks[i] + sticks[i+2]) && sticks[i+2] < (sticks[i] + sticks[i+1]))
    		{
    			ret[0] = sticks[i];
    			ret[1] = sticks[i+1];
    			ret[2] = sticks[i+2];
    			
    			ok = true;
    			break;
    		}
    	}
    	
    	if(!ok)
    	{
    		System.out.println(-1);
    		return null;
    	}
    	
    	Arrays.sort(ret);
    	
    	return ret;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] sticks = {1, 1, 1, 3, 3};
		
		maximumPerimeterTriangle(sticks);
	}

}















