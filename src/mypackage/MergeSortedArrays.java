package mypackage;

public class MergeSortedArrays 
{

	public int[] merge(int[] L, int[] R)
	{
		int[] 	A = new int[L.length + R.length];
		int		left=0, right=0, main=0;
		
		while(left < L.length && right < R.length)					// override the A with the smaller from L or R
		{
			if(L[left] < R[right]) 
				A[main++] = L[left++];
			else 
				A[main++] = R[right++];
		}
		
		while(left < L.length) 										// put the remaining to A fromL and R
			A[main++] = L[left++];
		while(right < R.length) 
			A[main++] = R[right++];
		
		return A;
		
	}
	
	public static void main(String[] args) 
	{
		
		int[] arr_1 = new int[] {1, 2, 4, 9,  15, 44,  100};
		int[] arr_2 = new int[] {0, 3, 5, 55, 99, 132, 453};

		// 0, 1, 2, 3, 5, 9, 15, 44, 67, 99, 132, 453
		MergeSortedArrays mg = new MergeSortedArrays();
		int[] merged = mg.merge(arr_1, arr_2);
		
		System.out.println();
	}

}
