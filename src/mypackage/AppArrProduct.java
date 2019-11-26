package mypackage;

public class AppArrProduct {

	static void prod(int[] arr)				// ez O(n^2)
	{
		int i=0, k=0;
		int[] prod_arr = {1, 1, 1, 1}; 
		
		while(i<arr.length)
		{
			k=0;
			while(k<arr.length)
			{
				if(k!=i)
					prod_arr[i] *= arr[k];
				
				k++;
			}
			i++;
		}
		
		System.out.println();
	}
	
	public static void main(String[] args) 
	{
		
		int[] arr = {1, 2, 3, 4};		// can be O(n)

		prod(arr);
	}

}
