package sorting;


// The above function always runs O(n^2) time even if the array is sorted. It can be optimized by stopping the algorithm if inner loop didn’t cause any swap.

public class BubbleSort 
{
	// simple version
	void bubbleSort(int arr[]) 
    { 
        int n = arr.length; 
        
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (arr[j] > arr[j+1]) 
                { 
                    int temp = arr[j]; 
                    arr[j] = arr[j+1]; 
                    arr[j+1] = temp; 
                } 
    } 
	
	
	
	// Recursive version. A function to implement bubble sort 
    static void bubbleSort(int arr[], int n) 
    { 
        if (n == 1) 
            return; 
       
        // One pass of bubble sort. After this pass, the largest element  is moved (or bubbled) to end. 
        for (int i=0; i<n-1; i++) 
            if (arr[i] > arr[i+1]) 
            { 
                int temp = arr[i]; 
                arr[i] = arr[i+1]; 
                arr[i+1] = temp; 
            } 
       
        // Largest element is fixed, recur for remaining array 
        bubbleSort(arr, n-1); 
    } 
}








