package selfSolved;

public class GenerateArrayPermutations {

	
//	1,2,3
	
	static void printAllPermutation(int[] arr, int index)
	{
		if(index >= arr.length)
			printArray(arr);
		
		else
		{
			for(int i=index; i<arr.length; i++)
			{
				printAllPermutation(arr, i+1);
				
				int temp = arr[0];
				arr[0] = arr[arr.length-1];
				arr[arr.length-1] = temp;
			}
		}
	}
	
   static void heapPermutation(int a[], int size, int n) 
   { 
        if (size == 1) 
        	printArray(a); 
  
        for (int i=0; i<size; i++) 
        { 
            heapPermutation(a, size-1, n); 
  
            // if size is odd, swap first and last element 
            if (size % 2 == 1) 
            { 
                int temp = a[0]; 
                a[0] = a[size-1]; 
                a[size-1] = temp; 
            } 
  
            // If size is even, swap ith and last element 
            else
            { 
                int temp = a[i]; 
                a[i] = a[size-1]; 
                a[size-1] = temp; 
            } 
        } 
    } 
	
	static void printArray(int[] arr)
	{
		for(int i : arr)
			System.out.print(i + ",");
		
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {1, 2, 3};
		
		heapPermutation(arr, arr.length, arr.length);
	}

}
