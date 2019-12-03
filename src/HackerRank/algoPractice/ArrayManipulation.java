package HackerRank.algoPractice;

public class ArrayManipulation {

	
	// n length of the array
	// query - start , end , value
	static long arrayManipulation(int n, int[][] queries) 
	{

		int[] arr = new int[n+1];
		
		int start, end, val,
			p_start, p_end, p_val;
		int max = 0;
		
		p_start = queries[0][0];
		p_end 	= queries[0][1];
		p_val 	= queries[0][2];
		
		for(int[] query : queries)
		{
			start 	= query[0];
			end		= query[1];
			val		= query[2];
			
			for(int i=start; i<=end; i++)
				arr[i] += val;
		}
		
		for(int i=0; i<=n; i++)
			max = Math.max(max, arr[i]);
		
		return max;
    }
	
	
	
	public static void main(String[] args) {

	}

}
