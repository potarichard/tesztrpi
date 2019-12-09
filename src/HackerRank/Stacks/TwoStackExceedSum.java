package HackerRank.Stacks;

import java.util.ArrayList;
import java.util.List;

public class TwoStackExceedSum {

	// recursive backtrack
	// remove the maximum number of elements from the stack without exceeding the max sum
	
	// ha leveszek valamit es tulmegy return
    static int twoStacks(int max, int[] a, int[] b) 
    {
    	int ai = 0, bi = 0;
    	int sum = 0, count = 0;
    	
    	while(ai < a.length && sum < max)
    		sum += a[ai++];
    	
    	count = ai;
    	
    	return 0;
    }
    
//    static int helper(int max, int[] a, int[] b, int ai, int bi)
//    {
//    	if(maxScore.get(0) > max)
//    		return -1;
//    	
//    	
//    	// 1. choose ai and not bi
//    	
//    	// 2. choose bi and not ai
//    	
//    	helper(max, a, b, maxScore, ai+1, bi);
//    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
