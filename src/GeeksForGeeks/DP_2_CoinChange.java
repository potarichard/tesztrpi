package GeeksForGeeks;

public class DP_2_CoinChange 
{

	// we have coins [1,3,5], want to get to n (amount)
	static int solve(int n) 
	{  
	   // base case 
	   if (n < 0)  
	      return 0; 
	   if (n == 0)   
	      return 1;   
	  
	   return solve(n-1) + solve(n-3) + solve(n-5); 
	}
	
	static int dp[]; 
	
	static void initDPTable(int n)
	{		
		dp = new int[++n];
		
		for(int i=0; i<n; i++)
			dp[i] = -1;
	}
	
	
	// we have coins [1,3,5], want to get to n (amount), store counted values
	static int solveMemo(int n) 
	{  
	  // base case 
	  if (n < 0)   
	      return 0; 
	  if (n == 0)   
	      return 1; 
	  
	  // checking if already calculated 
	  if (dp[n]!=-1)  
	      return dp[n]; 
	  
	  // storing the result and returning 
	  return dp[n] = solveMemo(n-1) + solveMemo(n-3) + solveMemo(n-5); 
	} 
	
	public static void main(String[] args) 
	{
		initDPTable(6);
		
		System.out.println(solve(6));
		System.out.println(solveMemo(6));
	}

}













