package GeeksForGeeks;

public class DP_Basic_SubsetSum 
{

	static boolean isSubsetSumSimple(int set[], int length, int sum) 
	{ 
		// Base Cases 
		if (sum == 0) 
			return true; 
		if (length == 0 && sum != 0) 
			return false; 
		
		// If last element is greater than sum, then ignore it 
		if (set[length-1] > sum) 
			return isSubsetSumSimple(set, length-1, sum); 
		
		// skip or include
		return isSubsetSumSimple(set, length-1, sum) || isSubsetSumSimple(set, length-1, sum-set[length-1]); 
	} 
	
	static boolean isSubsetSumDynamic(int set[], int length, int sum) 
	{ 
		// The value of subset[i][j] will be 
		// true if there is a subset of  
		// set[0..j-1] with sum equal to i 
		boolean subset[][] = new boolean[sum+1][length+1]; 
		
		// If sum is 0, then answer is true 
		for (int i = 0; i <= length; i++) 
			subset[0][i] = true; 
		
		// If sum is not 0 and set is empty, 
		// then answer is false 
		for (int i = 1; i <= sum; i++) 
			subset[i][0] = false; 
		
		// Fill the subset table in botton 
		// up manner 
		for (int i = 1; i <= sum; i++) 
		{ 
			for (int j = 1; j <= length; j++) 
			{ 
				subset[i][j] = subset[i][j-1]; 
				if (i >= set[j-1]) 
					subset[i][j] = subset[i][j] || subset[i - set[j-1]][j-1]; 
			} 
		} 
		
		/* // uncomment this code to print table 
		for (int i = 0; i <= sum; i++) 
		{ 
		for (int j = 0; j <= n; j++) 
		System.out.println (subset[i][j]); 
		} */
		
		return subset[sum][length]; 
	} 
	
	/* Driver program to test above function */
	public static void main (String args[]) 
	{ 
		int set[] = {3, 34, 4, 12, 5, 2}; 
		int sum = 9; 
		int n = set.length; 
		
		if (isSubsetSumSimple(set, n, sum) == true) 
			System.out.println("Found a subset" + " with given sum"); 
		else
			System.out.println("No subset with" + " given sum"); 
		
		System.out.println();
		
		if (isSubsetSumDynamic(set, n, sum) == true) 
			System.out.println("Found a subset" + " with given sum"); 
		else
			System.out.println("No subset with" + " given sum"); 
	} 
	
}
