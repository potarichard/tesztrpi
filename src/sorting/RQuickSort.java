package sorting;

import java.util.Random;

public class RQuickSort 
{

	int randomPartition(int[] arr, int low,int high) 
    { 
      
        Random rand = new Random(); 
        int pivot = rand.nextInt(high-low) + low; 
          
        int temp1  = arr[pivot]; 
        arr[pivot] = arr[high]; 
        arr[high]  = temp1; 
        
        return partition(arr, low, high);
    } 
	
      
    /* This function takes last element as pivot,  
    places the pivot element at its correct  
    position in sorted array, and places all  
    smaller (smaller than pivot) to left of  
    pivot and all greater elements to right  
    of pivot */
      
    int partition(int arr[], int low, int high)  
    {  
        // pivot is choosen randomly 
        int pivot = arr[high];        
  
        int i = (low-1); // index of smaller element  
        
        for (int j = low; j < high; j++)  
        {  
            if (arr[j] <= pivot)  
            {  
                i++;  
  
                int temp = arr[i];  
                arr[i] = arr[j];  
                arr[j] = temp;  
            }  
        }  
  
        // swap arr[i+1] and arr[high] (or pivot)  
        int temp = arr[i+1];  
        arr[i+1] = arr[high];  
        arr[high] = temp;  
  
        return i+1;  
    }  
  
  
    void sort(int arr[], int low, int high)  
    {  
        if (low < high)  
        {  
            /* pi is partitioning index, arr[pi] is  
            now at right place */
            int pi = randomPartition(arr, low, high);  
  
            // Recursively sort elements before  
            // partition and after partition  
            sort(arr, low, pi-1);  
            sort(arr, pi+1, high);  
        }  
    }  
	
}














