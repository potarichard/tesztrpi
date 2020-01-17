package HackerRank.Greedy;

public class DecentNumber {

	// given a length ret 
	// 1. the largest number of that length
	// 2. only 3 and 5 digits allowed
	// 3. number of 3's divisible by 5
	// 3. number of 5's divisible by 3
	// can be like 555, 33333, 55555533333
    static void decentNumber(int number) 
    {

    	// 3-masok 0,5,10,15.. lehetnek
    	// 5-sok 0,3,6,9... lehetnek
    	
    	if(number<3)
    	{
    		System.out.println(-1);
    		return;
    	}
    		
    	String num = "";
    	
    	if(number%3 == 0)
    	{
    		for(int i=0; i<number; i++)
    			num += "5";
    		System.out.println(num);
    		return;
    	}

    	else if(number%3 != 0)
    	{
    		int remainder = 0, original = number;
    		
    		while(original > 0)
    		{    			
    			if(original%3 == 0 && remainder%5 == 0)
    				break;
    			else
    			{
    				original -= 5;
    				remainder += 5;
    			}
    		}
    		
    		if(original > 0)
    		{
        		for(int k=0; k<original; k++)
        			num += "5";
    			for(int k=0; k<remainder; k++)
        			num += "3";
    			
    			System.out.println(num);
        		return;
    		}
    		
    	}
    	
    	if(number%5 == 0)
    	{
    		for(int i=0; i<number; i++)
    			num += "3";
    		System.out.println(num);
    		return;
    	}
    	
    	System.out.println(-1);
		return;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		decentNumber(15);
		
	}

	
}













