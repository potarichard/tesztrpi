package HackerRank.Bitmanipulation;

import java.math.BigInteger;
import java.util.Stack;

public class AorB {

	
//	k = ka + kb
//	change at most ka bits in a, and kb in b  SO that  a|b = c
//	a should be minimum, if still possibilities then b should minimum
//	print the new a,b,c values
	
//	0 < a,b,c < pow(16, 50000)
	
//	ex: k=8, a=2B, b=9F, c=58
//	ka = 3 -> a = 9
//	kb = 5 -> b = 58
//	9|58 = 58
		
	static String hexToBin(String s) {
		  return new BigInteger(s, 16).toString(2);
	}
	
	static String binToHex(String s) {
		  return new BigInteger(s, 2).toString(16);
	}
	
	static char[] leadingZeros(String str, long num)
	{
		String zeros = "";
		
		for(long i=0; i<Math.abs(str.length()-num); i++)
			zeros += "0";
		
		return (zeros + str).toCharArray();
	}
	
    static void aOrB(int k, String a, String b, String c) 
    {
        
    	a = hexToBin(a);
    	b = hexToBin(b);
    	c = hexToBin(c);

    	long max_len = Math.max(a.length(), Math.max(b.length(), c.length()));
    	
    	char[] a_arr = leadingZeros(a, max_len);
    	char[] b_arr = leadingZeros(b, max_len);
    	char[] c_arr = leadingZeros(c, max_len);
    	
    	int k_temp=0;
    	    	
// 1   	change what must be 0
    	for(int i=0; i<c_arr.length; i++)
    	{
    		if(c_arr[i] == '0')
    		{
    			if(a_arr[i] == '1')
    			{
    				k_temp++;
    				a_arr[i] = '0';
    			}
    			if(b_arr[i] == '1')
    			{
    				k_temp++;
    				b_arr[i] = '0';
    			}
    		}
    	}
    	
    	
    	if(k_temp > k)
    	{
    		System.out.println(-1);
    		return;
    	}
    		
    		
// 2	change in a what must be 1
    	for(int i=0; i<c_arr.length; i++)
    	{
    		if(c_arr[i] == '1')
    		{
    			if(a_arr[i] == '0' && b_arr[i] == '0')
    			{
    				b_arr[i] = '1';
    				k_temp++;
    			}
    		}
    	}
    	

    	if(k_temp < k)
    	{
// 3	optional make a to 0 where b is 1
    		for(int i=0; i<c_arr.length; i++)
        	{
        		if(c_arr[i] == '1' && b_arr[i] == '1' && a_arr[i] == '1')
        		{
        			a_arr[i] = '0';
    				k_temp++;
    				
    				if(k_temp == k)
    					break;
        		}
        	}
    		
//  4		optional make b to 0 where a is 1
    		for(int i=0; i<c_arr.length; i++)
        	{
    			if(c_arr[i] == '1' && b_arr[i] == '1' && a_arr[i] == '1')
        		{
        			b_arr[i] = '0';
    				k_temp++;
    				
    				if(k_temp == k)
    					break;
        		}
        	}
    	}
    	
    	if(k_temp > k)
    	{
    		System.out.println(-1);
    		return;
    	}
    	
    	
    	a = new String(a_arr); 
    	b = new String(b_arr); 
    	c = new String(c_arr); 
    	
    	a = binToHex(a);
    	b = binToHex(b);
    	c = binToHex(c);
    	
    	System.out.println(a);
    	System.out.println(b);
//    	System.out.println(c);
    	
    	return;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		aOrB(80, "2BB", "9FE3C", "5864");
		
	}

}










