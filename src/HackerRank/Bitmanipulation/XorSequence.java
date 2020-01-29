package HackerRank.Bitmanipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class XorSequence {

	
	// find the xor sum from 0 to l, then 0 to r,  then xor sum from l to r
    static long xorSequence(long l, long r) {

//    	long ret = 0;
//    	
//    	while(l <= r)
//    		ret ^= computeXOR(l++);
    	
    	return computeXORLong(r)^computeXORLong(l-1);
    }
    
    // Method to calculate xor 
    static int computeXORInt(int n) 
    { 
    	int a = n % 4;
    	
        // If n is a multiple of 4 
        if (a == 0) 
            return n; 
       
        // If n%4 gives remainder 1 
        if (a == 1) 
            return 1; 
       
        // If n%4 gives remainder 2 
        if (a == 2) 
            return n + 1; 
       
        // If n%4 gives remainder 3 
        return 0; 
    } 
    
    // another Method to calculate xor 
    static long computeXORLong(long x)
    {    	
        long a = x % 8;
        
        if(a == 0 || a == 1) return x;
        if(a == 2 || a == 3) return 2;
        if(a == 4 || a == 5) return x+2;
        if(a == 6 || a == 7) return 0;
        
        return 0;
    }
	
    
//  2  another task 
    static long sumXor(long n) 
    {
    	long count = 0;
    	
    	for(long i=0; i<=n; i++)
    		if((n+i) == (n^i))
    			count++;
    	
    	return count;    	
    }
    
    
    //	1.	 5 = 101
    //			&001  = 1
    
    //  2.	 2 = 010			// shifted 1 to right
    //  		&001  = 0		
    
    //  3.	 1 = 001
    //			&001  = 1
    static long theGreatXor(long x)
    {
        // Complete this function
        long result = 0;
        int bitPos = 0;
        
        while(x > 0) 
        {
            if((x&1) == 0) 
                result += (1<<bitPos);
            
            bitPos++;
            x >>= 1;
        }
        return result;
    }
    
    
    // 101   & 001 = 1  res add bit  , bit <<= 1;
    // 010	 & 001 = 0  res add bit
    // 001
    // 000   exit
    static long flippingBits(long n) 
    {
    	long res = 0, bit = 1;
    	Long max =  (long) (Math.pow(2,32)-1);

    	
    	res = max ^ n;
    	
//    	while(n>0)
//    	{
//    		if((n&1) == 0)
//    			res += bit;
//    		bit <<= 1;
//    		n >>= 1;
//    	}
    	
    	return res;
    }
    
    
    // for contigous suvbarray
//    generate a value
//    ex: 3,4,5
//							111|110|100	
    // ahany 1 addig megy a loop !
    
    static int sansaXor(int[] arr) 
    {    	    	
    	int ret = 0;
    	
    	for(int i=0;i<arr.length;i++) 
    	{
            for(int j=i;j<arr.length;j++) 
            {
            	int num = 0;
            	
                for(int k=i;k<=j;k++) 
                    num ^= arr[k];
                
                ret ^= num;
            }
    	}
    	
    	return ret;		// 6
    }
    
    // strings, or put in array
    // check all possible
    
    static int sansaXor2(int[] arr) 
    {
    	long max = (long) Math.pow(2, arr.length);
    	
    	List<Integer> possible_pos = new ArrayList<Integer>();
    	
    	for(int i=1; i<max; i++)				// check if in the binary value is there a 0 that breaks a 1 sequence  ex  1101, or 10001 skip these    		    		
    		checkBinary(Integer.toBinaryString(i), arr, possible_pos);
    	
    	int value = 0;
    	
    	for(Integer i : possible_pos)
    		value ^= i;
    	
    	return value;
    }
    
    private static boolean checkBinary(String str, int[] arr, List<Integer> possible_pos)
    {
    	boolean found_1 = false, found_1_after_0 = false;    	
    	
    	int value = 0;
    	
    	if(str.length() < arr.length)	//add leading 0's
    	{
    		String lead = "";
    		
    		for(int i=0; i<arr.length-str.length(); i++)
    			lead += "0";
    		
    		str = lead + str;
    	}
    	
    	for(int i=0; i<str.length(); i++)
    	{
    		if(str.charAt(i) == '1' && !found_1)
    			found_1 = true;
    		
    		if(str.charAt(i) == '1')
    			value ^= arr[i];
    			
    		if(str.charAt(i) == '0' && found_1)
    			found_1_after_0 = true;
    			
    		if(str.charAt(i) == '1' && found_1 && found_1_after_0)
    			return false;
    	}
    	
    	possible_pos.add(value);
    	
    	return true;
    }
    
//    AND product
    static long andProduct(long a, long b) {

    	long val = a++;
    	
    	for(long i=a; i<=b; i++)
    		val &= i;
    	
    	return val;    	
    }
    
    // foreach tickett find another so every digit 0..9 are present in the two
    static long winningLotteryTicket(String[] tickets) 
    {
    	boolean[] digit_1 = new boolean[10];
    	boolean[] digit_2 = new boolean[10];
    	
    	long pairs = 0;
    	
    	for(int i=0; i<tickets.length; i++)
    	{
    		digit_1 = setDigits(tickets[i]);
    		
    		for(int k=i+1; k<tickets.length; k++)
    		{
    			digit_2 = setDigits(tickets[k]);
        		
        		if(checkDigits(digit_1, digit_2))
        			pairs++;
    		}    			
    	}

    	return pairs;
    }
    
    private static boolean[] setDigits(String str)
    {
    	boolean[] digit = new boolean[10];
    	
    	for(int i=0; i<10; i++)
    	{    		
    		if(str.indexOf(i+48) > -1)
    			digit[i] = true;
    	}
    	
    	return digit;
    }
    
    private static boolean[] setDigits2(String str)
    {
    	boolean[] digit = new boolean[10];
    	
    	for(int i=0; i<str.length(); i++)
    	{
    		int dig = Character.getNumericValue(str.charAt(i));
    		digit[dig] = true;
    	}
    	
    	return digit;
    }
    
    private static boolean checkDigits(boolean[] digit_1, boolean[] digit_2)
    {
    	for(int i=0; i<digit_1.length; i++)
    	{
    		if(!digit_1[i] && !digit_2[i])
    			return false;
    	}
    	
    	return true;
    }
    
    
    static int xoringNinja(int[] arr) 
    {
        long max = 1<<arr.length;
        int  sum = 0;

        for(int i=1; i<max; i++)
		{			
        	int val = 0;
        	
			for(int j=0; j<arr.length; j++)
			{
				if((1<<j & i) > 0)
					val ^= arr[j];
			}			
			
			sum += val;
		}
		return sum%1000000007;        
    }
    
    
//    1001010
//    01001010
//    001001010
//    0001001010
//    ----------
//    1110100110
    static String cipher(int k, String str)
    {
    	char[] s = str.toCharArray();
    	char[] result = new char[s.length-k+1];
    	
    	  result[0] = s[0];
    	  int i;
    	  
    	  for(i=1; i<k; i++)
    	    result[i]= s[i]==s[i-1] ? '0':'1';
    	  
    	  for(; i<s.length-k+1; i++)
    	    result[i]= s[i]==s[i-1] ? result[i-k] : (result[i-k]=='1' ? '0':'1');
    	  
    	  
    	  return new String(result);
    }
    
    
    // k = 3 | s = 101   101 stringbol mind a 3 bit lehet rossz
    // nem lehet az eredeti string periodikus
    // hany lehetseges string johetett eredetielg
    
    // peldaanal maradva 6db:	 001, 010, 100, 011, 101, 110 		//csak a csupa 0, vagy 1 lehetne periodikus
    
    // permutaciok kozul a periodikusak szurese
    static int stringTransmission(int k, String s) 
    {
        // 		101
    	// 3 	010
    	// 2	011, 000, 110
    	// 1	001, 111, 100
    	
    	// 	could be: 010, 011, 110, 001, 100, + original 101    	
    	
    	while(k>0)		// mindig valtoztatok ennyit
    	{
    		char[] arr = s.toCharArray();
    		
    		for(int i=0; i<arr.length; i++)		// kezdo
    		{
    			
    		}
    	}
    	
    	return 0;
    }
    
    
    static boolean isRepeat(String str) 
    { 
    	System.out.println(str);
    	
        // Find length of string and create  
        // an array to store lps values used in KMP 
        int n = str.length(); 
        int lps[] = new int[n]; 
      
        // Preprocess the pattern (calculate lps[] array) 
        computeLPSArray(str, n, lps); 
      
        // Find length of longest suffix  
        // which is also prefix of str. 
        int len = lps[n-1]; 
      
        // If there exist a suffix which is also  
        // prefix AND Length of the remaining substring 
        // divides total length, then str[0..n-len-1]  
        // is the substring that repeats n/(n-len)   
        // times (Readers can print substring and  
        // value of n/(n-len) for more clarity. 
        return len > 0 && n%(n-len) == 0; 
    } 
    
    static void computeLPSArray(String str, int M, int lps[]) 
	{    
		// lenght of the previous  
		// longest prefix suffix 
		int len = 0;  
		
		int i; 
		
		lps[0] = 0; // lps[0] is always 0 
		i = 1; 
		
		// the loop calculates lps[i]  
		// for i = 1 to M-1 
		while (i < M) 
		{ 
			if (str.charAt(i) == str.charAt(len)) 
			{ 
				len++; 
				lps[i] = len; 
				i++; 
			} 
			else // (pat[i] != pat[len]) 
			{ 
				if (len != 0) 
				{ 
					// This is tricky. Consider the  
					// example AAACAAAA and i = 7. 
					len = lps[len-1]; 
					
					// Also, note that we do  
					// not increment i here 
				} 
				else // if (len == 0) 
				{ 
					lps[i] = 0; 
					i++; 
				} 
			} 
		} 
	} 
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//        System.out.println(computeXORLong(3));
//        
//        System.out.println(computeXORLong(5));
        
        xorSequence(3,5);
        
        theGreatXor(5);
        
        flippingBits(1);
        
        int[] help = {3,4,5};
        
        sansaXor2(help);
        
        andProduct(12,15);
        
        String[] arr = {"129300455" ,
		        		"5559948277",
		        		"012334556" ,
		        		"56789",
		        		"123456879"};
        
        winningLotteryTicket(arr);
        
        int[] arr2 = {1, 2, 3};
        
        xoringNinja(arr2);
        
        cipher(4, "1110100110");
        
        stringTransmission(4, "1001");
	}

}





















