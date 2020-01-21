package HackerRank.DynamicProgramming;

public class SherlockAndCost {

//	Suppose B = [2, 4, 3]. Then 1<=A1<=2, 1<=A2<=4 and 1<=A3<=3. Hence, there are 24 possible options for A
//	Out of all the possible options, A = [1, 4, 1] maximizes S.
//	Thus, the answer is : |4-1| + |1-4| = 3 + 3 = 6.
    static int cost(int[] B) 
    {
		int hi = 0,low = 0;
		
		for(int i=1; i<B.length; i++)
		{
			int high_to_low_diff 	= Math.abs(B[i-1] - 1);
			int low_to_high_diff 	= Math.abs(B[i] - 1);
			int high_to_high_diff 	= Math.abs(B[i] - B[i-1]);
					
			int low_next 	= Math.max(low, hi+high_to_low_diff);
			int hi_next 	= Math.max(hi+high_to_high_diff, low+low_to_high_diff);
					
			low = low_next;
			hi = hi_next;
		}
		
		return Math.max(hi,low);
    }

	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] B = {2, 4, 3};
		
		cost(B);
	}

}
