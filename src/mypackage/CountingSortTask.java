package mypackage;

public class CountingSortTask 
{

	public static int[] cSort(int[] arr)
	{
//		arr for possible digits to count
		int[] counts = new int[3];
		
		int digit = 0;
		
		for(int i=0; i<arr.length; i++)
			counts[arr[i]]++;
		
		for(int i=0; ; i++)
		{
			arr[i] = digit;
			counts[digit]--;
			if(counts[digit]<=0)
				digit++;
			if(digit >= counts.length)
				break;
		}
		
		return arr;
	}
	
	public static void main(String[] args) 
	{
		
		int[] arr = new int[] {2, 1, 2, 2, 2, 1, 0, 0, 0, 1, 0, 2, 0, 1};

		cSort(arr);
		
		System.out.println();
	}

}
