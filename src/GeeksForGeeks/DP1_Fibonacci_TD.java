package GeeksForGeeks;

//Memoization (Top Down): The memoized program for a problem is similar to the recursive version with a small modification that 
//it looks into a lookup table before computing solutions. We initialize a lookup array with all initial values as NIL. 
//Whenever we need the solution to a subproblem, we first look into the lookup table. If the precomputed value is there then we 
//return that value, otherwise, we calculate the value and put the result in the lookup table so that it can be reused later.

public class DP1_Fibonacci_TD 
{
	  final int NIL = -1; 
	  
	  int lookup[] = new int[0]; 
	  
	  /* Function to initialize NIL values in lookup table */
	  void _initialize(int len) 
	  { 
		len++;
		lookup = new int[len];
	    for (int i = 0; i < len; i++) 
	        lookup[i] = NIL; 
	  } 
	  
	  /* function for nth Fibonacci number */
	  int fib(int n) 
	  { 
	    if (lookup[n] == NIL) 
	    { 
	      if (n <= 1) 
	          lookup[n] = n; 
	      else
	          lookup[n] = fib(n-1) + fib(n-2); 
	    } 
	    return lookup[n]; 
	  } 
	  
	  public static void main(String[] args) 
	  { 
		DP1_Fibonacci_TD f = new DP1_Fibonacci_TD(); 
	    int n = 3; 
	    f._initialize(n); 
	    System.out.println("Fibonacci number is" + " " + f.fib(n)); 
	  } 
	
}
