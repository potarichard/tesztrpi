package HackerRank.algoPractice;

public class ArrayRotation {

	static void rotate(int[] arr, int n)
	{
		// 1. rootate, do it in loop ...		
		// 2. O(n)		1 2 3 4 5   4x  ->  5 1 2 3 4
		
		int len = arr.length;			// 5
		int start = n % len;			// 4
		
		int i = 0;
		int[] arr_out = new int[len];		
		
		// 3,4,5,6,7,0,0
		for(int k=start; k<len; k++)
			arr_out[i++] = arr[k];
		
		for(int k=0; k<start; k++)
			arr_out[i++] = arr[k];
		
		
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5};
		
		rotate(arr, 1);
	}

}
