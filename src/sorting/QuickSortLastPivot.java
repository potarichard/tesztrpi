package sorting;

public class QuickSortLastPivot {

	
    int partition(int arr[], int low, int high) 
    { 
        int pivot = arr[high];  
        int i = (low-1); 				// index of smaller element 
        
        for (int j=low; j<high; j++) 
        { 
            if (arr[j] < pivot) 
            { 
                i++; 
  
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        
        i++;						// last item was i before pivot, now i+1 is the place for pivot so swap it there
        
        int temp = arr[i]; 
        arr[i] = arr[high]; 
        arr[high] = temp; 
  
        return i; 
    } 
  
  
    void sort(int arr[], int low, int high) 
    { 
        if (low < high) 
        { 
            // pi is partitioning index, arr[pi] is now at right place
            int pi = partition(arr, low, high); 
  
            // Recursively sort elements before partition       
            sort(arr, low, pi-1); 
            // And after partition 
            sort(arr, pi+1, high); 
        } 
    } 
  
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        
        System.out.println(); 
    } 


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int arr[] = {10, 7, 8, 9, 1, 5}; 
		
//		int arr[] = {1, 5, 7, 8, 9, 10}; 
		
		int arr[] = {10, 9, 8, 7, 5, 1}; 
		
        int n = arr.length; 
  
        QuickSortLastPivot ob = new QuickSortLastPivot(); 
        ob.sort(arr, 0, n-1); 
  
        System.out.println("sorted array"); 
        printArray(arr); 
	}

}
