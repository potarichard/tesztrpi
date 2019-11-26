package popular;

public class BinarySearch 
{

	public int binarySearchRecursive(int[] arr, int number, int start, int end)
	{
		if(end < start)
			return -1;
		
		int mid = start + (end-start)/2;
		
		if(arr[mid] == number)
			return mid;
		
		if(number < arr[mid])
			return binarySearchRecursive(arr, number, start, mid-1);
		else
			return binarySearchRecursive(arr, number, mid+1, end);		
		
	}
	
	public int binarySearchIterative(int[] arr, int number)
	{
		int 	start = 0, 
				end = arr.length-1,
				mid;	
		
		while(start <= end)
		{
			mid = (start + end) / 2;
			
			if(arr[mid] == number)
				return mid;
			
			if(number < arr[mid])
				end = mid-1;
			else 
				start = mid + 1;
		}
		
		
		return -1;
	}
	
	public int firstOccurrence(int[] arr, int number)
	{
		int 	start = 0, 
				end = arr.length-1,
				mid,
				result = -1;	
		
		while(start <= end)
		{
			mid = (start + end) / 2;
			
			if(arr[mid] == number)
			{
				result = mid;
				end = mid - 1;
				continue;
			}
			
			if(number < arr[mid])
				end = mid-1;
			else 
				start = mid + 1;
		}
		
		
		return result;
	}
	
	public int lastOccurrence(int[] arr, int number)
	{
		int 	start = 0, 
				end = arr.length-1,
				mid,
				result = -1;	
		
		while(start <= end)
		{
			mid = (start + end) / 2;
			
			if(arr[mid] == number)
			{
				result = mid;
				start = mid + 1;
				continue;
			}
			
			if(number < arr[mid])
				end = mid-1;
			else 
				start = mid + 1;
		}
		
		
		return result;
	}
	
	public int countOccurrence(int[] arr, int number)
	{		
		int first_index 	= firstOccurrence(arr, number);
		
		if(first_index == -1)
			return -1;
		
		int last_index	= lastOccurrence(arr, number);
		
		return last_index - first_index + 1;
		
	}
	
	public int countRotations(int[] arr)
	{		
		int 	start = 0, 
				end = arr.length-1,
				n = arr.length,
				mid, next, prev;
		
//		1. case, no rotations
		if(arr[0] < arr[end])
			return 0;
		
		while(start <= end)
		{			
//			2. case, elemnt found where the number to the left is greater, and the right is grater thats the point
			mid = (start + end) / 2;
			next = (mid+1) % n;			// circular overflow handled
			prev = (mid+n-1) % n;		// circular overflow handled
			
			if (arr[mid] < arr[next] && arr[mid] < arr[prev])
				return mid;
			
//			3. continue search in left half
			if(arr[mid] < arr[end])
				end = mid-1;
//			4. continue search in right half
			else 
				start = mid + 1;
		}
		
		return -1;
	}
	
	public int searchInRotated(int[] arr, int num)
	{
		int 	start = 0, 
				end = arr.length-1,
				mid;	
		
		while(start <= end)
		{
			mid = (start + end) / 2;
			
//			1. case
			if (arr[mid] == num)
				return mid;
			
//			2. right half is sorted
			if (arr[mid] <= arr[end])
			{
//				continue search in right half
				if (num > arr[mid] && num <= arr[end])
					start = mid + 1;
//				continue search in left half (which can be unsorted)
				else
					end = mid - 1;
			}
			
//			3. left half must be sorted
			else
			{
//				continue search in left half
				if (arr[start] <= num && num <= arr[mid])
					end = mid - 1;
				else
					start = mid + 1;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) 
	{
		int[] arr_basic = new int[] {1, 2, 3, 5, 8, 10, 24, 44, 76, 98};
		int[] arr_multiple = new int[] {1, 4, 10, 10, 10, 10, 10, 17, 76, 98};
		int[] arr_rotated = new int[] {5, 6, 7, 8, 9, 2, 3, 4};
		
		BinarySearch bs = new BinarySearch();
		
		System.out.println(bs.binarySearchRecursive(arr_basic, 1, 0, 9));
		System.out.println(bs.binarySearchIterative(arr_multiple, 10));
		System.out.println("first occour: " + bs.firstOccurrence(arr_multiple, 10));
		System.out.println("last occour: " + bs.lastOccurrence(arr_multiple, 10));
		System.out.println("count occour: " + bs.countOccurrence(arr_multiple, 10));
		
		System.out.println("count rotations: " + bs.countRotations(arr_rotated));
		System.out.println("search in rotated array: " + bs.searchInRotated(arr_rotated, 7));
	}

}



















