package HackerRank.DynamicProgramming;

import java.util.Arrays;
import java.util.List;

public class CoinChangeDP {

	// ex: [1,2,3], 4    -> 1,1,1,1		1,1,2		2,2		1,3
    public static long getWays(int amount, List<Long> c) 
    {
    	long[] coins = c.stream().mapToLong(x->x).toArray();    	
    	long[][] dp_table = new long[coins.length+1][amount+1];
    	
    	for(int row=1; row<dp_table.length; row++)
    	{
    		dp_table[row][0] = 1;		// 0 amount can only be solved one way.
    		
    		for(int current_amount=1; current_amount<dp_table[0].length; current_amount++)
        	{
    			long currentCoinValue = coins[row-1];
    			
    			long withoutThisCoin = dp_table[row-1][current_amount];		// egy sorral folotte
    			
    			// currentCoinValue <= current_amount  means is it possible to even use the coin (the coin could be bigger then the current amount so cant use the coin
    			// if can use the coin then in this row, but in the column: current_amount - currentCoinValue   , thats it with this coin
    			long withThisCoin = currentCoinValue <= current_amount ? dp_table[row][current_amount - (int)currentCoinValue] : 0;
    			
    			dp_table[row][current_amount] = withoutThisCoin + withThisCoin;
        	}
    	}
    	
    	return dp_table[coins.length][amount];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Long> c = Arrays.asList(1l,2l,3l);
		
		getWays(4, c);
		
	}

}
