package sorting;

public class HeapSort 
{

	public void sort(int arr[]) 
    { 
        int n = arr.length; 
  
        // Build heap (rearrange array) 
        for (int i = n / 2 - 1; i >= 0; i--) 
            heapify(arr, n, i); 
  
        // One by one extract an element from heap 
        for (int i=n-1; i>=0; i--) 
        { 
            // Move current root to end 
            int temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
  
            // call max heapify on the reduced heap 
            heapify(arr, i, 0); 
        } 
    } 
  
    // To heapify a subtree rooted with node i which is 
    // an index in arr[]. n is size of heap 
    void heapify(int arr[], int arr_length, int i) 
    { 
        int root 	= i; 			// Initialize largest as root 
        int left 	= 2*i + 1; 		// left = 2*i + 1 
        int right 	= 2*i + 2; 		// right = 2*i + 2 
  
        if (left < arr_length && arr[left] > arr[root]) 
            root = left; 
  
        if (right < arr_length && arr[right] > arr[root]) 
            root = right; 
  
        // If largest is not root 
        if (root != i) 
        { 
            int swap = arr[i]; 
            arr[i] = arr[root]; 
            arr[root] = swap; 
  
            // Recursively heapify the affected sub-tree 
            heapify(arr, arr_length, root); 
        } 
    } 
  
    /* A utility function to print array of size n */
    public void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
    } 
	
}

















