package GeeksForGeeks;

//Ugly numbers are numbers whose only prime factors are 2, 3 or 5. 
//The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … shows the first 11 ugly numbers.

public class DP_Basic_UglyNums 
{

	/*This function divides a by greatest 
    divisible power of b*/
    static int maxDivide(int a, int b) 
    { 
        while(a % b == 0) 
            a = a/b; 
        return a; 
    } 
      
    /* Function to check if a number  
    is ugly or not */
    static int isUgly(int no) 
    { 
        no = maxDivide(no, 2); 
        no = maxDivide(no, 3); 
        no = maxDivide(no, 5); 
          
        return (no == 1)? 1 : 0; 
    } 
      
    /* Function to get the nth ugly  
    number*/
    static int getNthUglyNoSimple(int n) 
    { 
        int i = 1; 
          
        // ugly number count  
        int count = 1;  
          
        // check for all integers  
        // until count becomes n  
        while(n > count) 
        { 
            i++; 
            if(isUgly(i) == 1) 
                count++; 
        } 
        return i; 
    } 
    
    static int getNthUglyNoDynamic(int n) 
    { 
        int ugly[] = new int[n];  // To store ugly numbers 
        int i2 = 0, i3 = 0, i5 = 0; 
        int next_multiple_of_2 = 2; 
        int next_multiple_of_3 = 3; 
        int next_multiple_of_5 = 5; 
        int next_ugly_no = 1; 
          
        ugly[0] = 1; 
          
        for(int i = 1; i < n; i++) 
        { 
            next_ugly_no = Math.min(next_multiple_of_2, 
                                  Math.min(next_multiple_of_3, 
                                        next_multiple_of_5)); 
              
            ugly[i] = next_ugly_no; 
            if (next_ugly_no == next_multiple_of_2) 
            { 
               i2 = i2+1; 
               next_multiple_of_2 = ugly[i2]*2; 
            } 
            if (next_ugly_no == next_multiple_of_3) 
            { 
               i3 = i3+1; 
               next_multiple_of_3 = ugly[i3]*3; 
            } 
            if (next_ugly_no == next_multiple_of_5) 
            { 
               i5 = i5+1; 
               next_multiple_of_5 = ugly[i5]*5; 
            } 
        } /*End of for loop (i=1; i<n; i++) */
        return next_ugly_no; 
    } 
      
    /* Driver program to test above 
    functions */
    public static void main(String args[]) 
    { 
    	int nth_num = 11;
        int num = getNthUglyNoSimple(nth_num); 
        System.out.println("Simple " + nth_num+ ". ugly num is "+ num); 
        
        num = getNthUglyNoDynamic(nth_num);
        System.out.println("Dynamic " + nth_num+ ". ugly num is "+ num); 
    } 
	
}











