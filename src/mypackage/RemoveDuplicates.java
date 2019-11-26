package mypackage;

public class RemoveDuplicates 
{

	public static int[] removeD(int[] arr)			// time O(n), space O(n) cuz new array
	{
		int 	n = arr.length,
				j = 0;
		int[] 	reduced = new int[arr[n-1]];
		
		reduced[0] = arr[0];
		
		for(int i=1; i<n; i++)
		{
			if(arr[i] != reduced[j])
				reduced[++j] = arr[i];
		}
		
		return reduced;
	}
	
	public static int countExceptParam(int[] arr, int value)
	{
		if(arr.length == 0)
			return 0;
		
		int 	size = 0;
		
		for(int i=0; i<arr.length; i++)
			if(arr[i] != value)
				size++;
		
		return size;
	}
	
	// only the new size is important
	public static int standardSolution(int[] arr)		// space must be O(1), time O(n)
	{
		if(arr.length == 0)
			return 0;
		
		int		count = 1;
		
		for(int i=1; i<arr.length; i++)
		{
			if(arr[i] != arr[i-1])
				count++;
		}
		
		return count;
	}
	
	public static void main(String[] args) 
	{
		int[] sorted = new int[] {1, 2, 2, 2, 3, 3, 4, 5, 5, 6, 6, 6};			

		int[] new_reduced = RemoveDuplicates.removeD(sorted);					// O(n) -> (1, 2, 3, 4, 5, 6)
		
		int size_of_reduced = RemoveDuplicates.standardSolution(sorted);		// 6
		
		int count_expect = countExceptParam(sorted, 6);							// 9
		
		System.out.println();
	}

}
