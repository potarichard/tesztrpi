package GeeksForGeeks;

//Tabulation (Bottom Up): The tabulated program for a given problem builds a table in bottom up fashion and returns the last entry from table. 
//For example, for the same Fibonacci number, 
//we first calculate fib(0) then fib(1) then fib(2) then fib(3) and so on. So literally, we are building the solutions of subproblems bottom-up.

public class DP1_Fibonacci_BU 
{
	  int fib(int n) 
	  { 
	    int f[] = new int[n+1]; 
	    f[0] = 0; 
	    f[1] = 1; 
	    for (int i = 2; i <= n; i++) 
	          f[i] = f[i-1] + f[i-2]; 
	    return f[n]; 
	  } 
	  
	  public static void main(String[] args) 
	  { 
		DP1_Fibonacci_BU f = new DP1_Fibonacci_BU(); 
	    int n = 6; 
	    System.out.println("Fibonacci number is" + " " + f.fib(n)); 
	  } 
}
