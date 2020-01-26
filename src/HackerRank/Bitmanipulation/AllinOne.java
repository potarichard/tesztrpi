package HackerRank.Bitmanipulation;

import java.util.Arrays;

public class AllinOne {

    static int lonelyinteger(int[] a) {


    	if(a.length == 1)
    		return a[0];
    	
    	Arrays.sort(a);
    	
    	for(int i=0; i<a.length; i+=2)
    	{
    		if(i+1 < a.length)
    		{
    			if((a[i+1]^a[i]) != 0)
	    			return a[i];
    		}
	    		
    		else
    			return a[i];
    	}
    		
    	
    	return -1;
    }
	
    static String counterGame(long n) 
    {
    	boolean turn_one = true;
    	
    	long k = highestPowerof2(n);
    	
    	if(k != n)
    	{
    		turn_one = !turn_one;
    		n = k;
    	}
    		
    	
    	while(n>1)
    	{
    		n /= 2;	    		
    		turn_one = !turn_one;
    	}    	

    	if(turn_one)
    		return "Louise";
    	
    	return "Richard";
    }
    
    static long highestPowerof2(long n) 
    { 
      long res = 0; 
      
      for (long i = n; i >= 1; i--) 
      { 
    	  res = i; 
    	  
    	  if ((i & (i - 1)) == 0)           
             break; 
      } 
      
      return res; 
    } 
    
    static String counterGame2(long n) 
    {
    	if((setBits(n-1) & 1) == 1) 
    		return "Louise";
    	
    	return "Richard";
    }
    
    static int setBits(long  n) 
    {
        int count = 0;
        
        while(n>0) 
        {
        	n &= (n-1);
            count++;
        }
        return count ;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {0, 0, 1, 2, 1};
		
		lonelyinteger(arr);
		
		
		counterGame2(2147483648l);
		
	}

}




