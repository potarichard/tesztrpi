package sorting;


// Time Complexity: O(n*2)

public class InsertionSort 
{

//	simple version
	void sort(int arr[]) 
    { 
        int n = arr.length; 
        
        for (int i = 1; i < n; ++i) 
        { 
            int key = arr[i]; 
            int j = i - 1; 
  
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j >= 0 && arr[j] > key) 
            { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            
            arr[j + 1] = key; 
        } 
    } 
	
	
	
//	recursive version
	
	// Recursive function to sort an array using 
    // insertion sort 
    static void insertionSortRecursive(int arr[], int n) 
    { 
        // Base case 
        if (n <= 1) 
            return; 
       
        // Sort first n-1 elements 
        insertionSortRecursive( arr, n-1 ); 
       
        // Insert last element at its correct position 
        // in sorted array. 
        int last = arr[n-1]; 
        int j = n-2; 
       
        /* Move elements of arr[0..i-1], that are 
          greater than key, to one position ahead 
          of their current position */
        while (j >= 0 && arr[j] > last) 
        { 
            arr[j+1] = arr[j]; 
            j--; 
        } 
        arr[j+1] = last; 
    } 
	
}












