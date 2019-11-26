package sorting;

// time: O(n*logn)
// space: A(n)

public class MergeSortMine 
{

//	1. part Merge
	private void merge(int[] A, int[] L, int[] R)
	{		
		
		int left_index = 0,
			right_index = 0,
			main_index = 0;

		while(left_index < L.length && right_index < R.length)		// override the A with the smaller from L or R
		{
			if(L[left_index] < R[right_index]) 
				A[main_index++] = L[left_index++];
			else 
				A[main_index++] = R[right_index++];
		}
		
		while(left_index < L.length) 								// put the remaining to A fromL and R
			A[main_index++] = L[left_index++];
		while(right_index < R.length) 
			A[main_index++] = R[right_index++];
		
	}
	
	
//	2. part recursive breakdown of the array
	public void sort(int[] arr, int length)
	{
		// base case, the breakdown got to a single element in the array
		if(length < 2)				
			return;
				
		// creating the 2 half arrays
		int 	mid = length/2,
				i;		
		int[] 	L = new int[mid],
				R = new int[length-mid];		
		for(i = 0;i<mid;i++) 
			L[i] = arr[i];
		for(i = mid;i<length;i++) 
			R[i-mid] = arr[i];		
		
		// keep breaking down 1st and 2nd half
		sort(L, mid);
		sort(R, length-mid);
		
		// merge
		merge(arr, L, R);
	}	
	
}
