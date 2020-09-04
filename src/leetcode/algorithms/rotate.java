package leetcode.algorithms;

public class rotate {

	static int[] rot(int[] arr, int k) {
		
		int n = arr.length;
		int[] rotated = new int[n*2];
		k = k%n;
		
		int left = n-k;
		int l = 0;
		
		for(int i=0; i<n*2; i++)
		{
			if(l == n)
				l=0;
			rotated[i] = arr[l++];
		}
		
		l=0;
		
		for(int i=k; i<k+n; i++)
		{
			arr[l++] = rotated[i];
		}
		
		return arr;
	}
	
//	masik verzio hogy reverse arr, aztan reverse from 0 to k azutan reverse from k to n
//	es pontosan megkapjuk a cuccot
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int[] arr = {1,2,3,4,5,6,7};
//		
//		rot(arr, 3);
	}

}
