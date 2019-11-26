package HackerRank;

import java.math.BigInteger;

public class LongFactorials 
{
	
	// This function finds factorial of large numbers and prints them 
    static void factorial(int n) 
    { 
        int res[] = new int[500]; 
  
        // Initialize result 
        res[0] = 1; 
        int res_size = 1; 
  
        // Apply simple factorial formula n! = 1 * 2 * 3 * 4...*n 
        for (int x = 2; x <= n; x++) 
            res_size = multiply(x, res, res_size); 
  
        System.out.print("\nby calculations \n");
        for (int i = res_size - 1; i >= 0; i--) 
            System.out.print(res[i]); 
    } 
      
    // This function multiplies x with the number 
    // represented by res[]. res_size is size of res[] or  
    // number of digits in the number represented by res[]. 
    // This function uses simple school mathematics for  
    // multiplication. This function may value of res_size 
    // and returns the new value of res_size 
    static int multiply(int x, int res[], int res_size) 
    { 
        int carry = 0;
  
        // One by one multiply n with individual digits of res[] 
        for (int i = 0; i < res_size; i++) 
        { 
            int prod = res[i] * x + carry; 
            res[i] = prod % 10; 				// Store last digit of 'prod' in res[] 
            carry = prod/10; 					// Put rest in carry 
        } 
  
        // Put carry in res and increase result size 
        while (carry!=0) 
        { 
            res[res_size] = carry % 10; 
            carry = carry / 10; 
            res_size++; 
        } 
        return res_size; 
    } 

	public static void main(String[] args) 
	{		
		BigInteger sd = new BigInteger("1");
		
		for(int i=1; i<=30; i++)
			sd = sd.multiply(sd.valueOf(i));
		
		System.out.println("bigint \n" + sd);

		
		LongFactorials lgf = new LongFactorials();
		lgf.factorial(6);
	}

}




