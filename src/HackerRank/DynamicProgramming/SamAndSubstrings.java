package HackerRank.DynamicProgramming;

public class SamAndSubstrings {

    static int substrings(String n) 
    {
    	char[] arr = n.toCharArray();    	
    	int max = (int) Math.pow(2, arr.length);
    	int sum = 0;
    	
    	for(int i=0; i<max; i++)
    	{
    		String num ="";
    		
    		for(int k=0; k<arr.length; k++)
    		{    			
    			if((1<<k & i) > 0)
    				num += arr[k];
    		}
    		
    		if(num.length() > 0)
    			sum += Integer.valueOf(num);
    	}

    	return sum;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		substrings("123");
		
	}

}
