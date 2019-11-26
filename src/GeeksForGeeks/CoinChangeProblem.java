package GeeksForGeeks;

public class CoinChangeProblem 
{

	static int countRecursive2( int arr[], int length, int amount ) 
    { 
        // If n is 0 then there is 1 solution (do not include any coin) 
        if (amount == 0) 
            return 1; 
          
        // If amount is less than 0 then no solution exists 
        if (amount < 0) 
            return 0; 
      
        // If there are no coins and amount is greater than 0, then no solution exist 
        if (length <=0 && amount >= 1) 
            return 0; 
      
        // count cases where we dont chose the coin, and where we choose the coin
        return countRecursive2( arr, length - 1, amount ) + 
               countRecursive2( arr, length, amount-arr[length-1] ); 
    } 
	
	static int countRecursive( int arr[], int length, int amount ) 
    { 
        // If n is 0 then there is 1 solution (do not include any coin) 
        if (amount == 0) 
            return 1; 
          
        // If amount is less than 0 then no solution exists 
        if (amount < 0) 
            return 0; 
      
        // If there are no coins and amount is greater than 0, then no solution exist 
        if (length <=0 && amount >= 1) 
            return 0; 
      
        // count cases where we dont chose the coin
        int skipped = countRecursive( arr, length - 1, amount );
        
        // and where we choose the coin
        int choosed = countRecursive( arr, length, amount-arr[length-1] ); 
        
        return skipped + choosed; 
    } 
	
	static long countWaysSimpleArrayDP(int arr[], int length, int amount) 
    { 
        //Time complexity of this function: O(mn) 
        //Space Complexity of this function: O(n) 
  
        // table[i] will be storing the number of solutions 
        // for value i. We need n+1 rows as the table is 
        // constructed in bottom up manner using the base 
        // case (n = 0) 
        long[] table = new long[amount+1]; 
        long new_value = 0;
        int temp = 0;
        
        // Base case (If given value is 0), 0 amount can be chooed 1 way exactly!
        table[0] = 1; 
  
        // Pick all coins one by one and update the table[] 
        // values after the index greater than or equal to 
        // the value of the picked coin 
        for (int i=0; i<length; i++) 
	    	for (int value=arr[i]; value<=amount; value++) 
	    	{
	    		temp = value-arr[i];
	    		new_value = table[temp];
	    		table[value] += new_value;
	    	}
            
  
        return table[amount]; 
    } 
	
	static long countWaysMatriyDP_b2bswe(int coins[], int amount) 
    {
		
//	  Each row represents using the denominations up to that point in the denominations array (see the video explanation)	 
	  int[][] dp = new int[coins.length+1][amount+1];

	 
//	  Max ways to make change for 0 will be 1, doing nothing.	  
	  dp[0][0] = 1;
	  
	  for (int i = 1; i <= coins.length; i++) 
	  {
//	    Set the subproblem for the amount of 0 to 1 when solving this row
	    dp[i][0] = 1;

	    for (int val = 1; val <= amount; val++) 
	    {
	      int currentCoinValue = coins[i-1];

	      /*
	        dp[i][j] will be the sum of the ways to make change not considering
	        this coin (dp[i-1][j]) and the ways to make change considering this
	        coin (dp[i][j] - currentCoinValue] ONLY if currentCoinValue <= j, otherwise
	        this coin can not contribute to the total # of ways to make change at this
	        sub problem target amount) 
	      */
	      int withoutThisCoin = dp[i-1][val];
	      int withThisCoin = currentCoinValue <= val ? dp[i][val - currentCoinValue] : 0;

	      dp[i][val] = withoutThisCoin + withThisCoin;
	    }
	  }

	  
//	  The answer considering ALL coins for the FULL amount is what we want to return as the answer	 
	  return dp[coins.length][amount];	
    }
	
	
	public static void main(String[] args) 
	{
		
		int arr[] = {5, 2, 1}; 
        int m = arr.length; 
        
        System.out.println( countRecursive(arr, m, 5));
        System.out.println( countWaysSimpleArrayDP(arr, m, 5));
        System.out.println( countWaysMatriyDP_b2bswe(arr, 5));
	}

}











