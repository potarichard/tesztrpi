package HackerRank.Implementation;

import java.util.List;

public class NonDivisibleSubset {

	static void heapPermutation(int[] a, int size, int n) 
    { 
        if (size == 1) 
        {
        	System.out.println(a[0] + " " + a[1] + " " + a[2] + " " + a[3]);
        }
  
        for (int i=0; i<size; i++) 
        { 
            heapPermutation(a, size-1, n); 
   
            if (size % 2 == 1) 
            { 
                int temp = a[0]; 
                a[0] = a[size-1]; 
                a[size-1] = temp; 
            } 
  
            else
            { 
                int temp = a[i]; 
                a[i] = a[size-1]; 
                a[size-1] = temp; 
            } 
        } 
    } 
	
	static void permutOfXElements(int[] a, int elements, int size, int n) 
	{
		
	}
	
	public static void main(String[] args) {
		
		int[] arr = {1, 7, 2, 4};

		heapPermutation(arr, 4, 4);
	}

}












