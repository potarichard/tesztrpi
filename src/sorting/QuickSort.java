package sorting;

import java.util.Random;

// time: O(n*logn)
// space: better than merge sort 

public class QuickSort 
{
	/* This function takes last element as pivot, 
    places the pivot element at its correct 
    position in sorted array, and places all 
    smaller (smaller than pivot) to left of 
    pivot and all greater elements to right 
    of pivot */
	
	
	// problema lehet, hpgy unbalanced lesz a particio, ha mindig az utolso elemet valasztom pivotnak
	// pl.  1 2 3 4 5 6 7 8			8 at valasztod pivotnak, nem lesz balanced a particio
 int partition(int arr[], int low, int high) 
 { 
     int pivot = arr[high];  
     
     int i = (low-1); 						// index of smaller element 
     
     for (int j=low; j<high; j++) 			// swap elements so that every element which is lesser than pivot goes to the left
     {          
         if (arr[j] < pivot) 
         { 
             i++;              
             int temp = arr[i];              
             arr[i] = arr[j]; 
             arr[j] = temp; 
         } 
     } 

     
     int temp = arr[i+1]; 					// there was a index (i)  from where the items were no longer lesser than the pivot
     arr[i+1] = arr[high]; 					// put to pivot element to to partition (i) index (swapping)
     arr[high] = temp; 

     return i+1; 
 } 


 /* The main function that implements QuickSort() 
   arr[] --> Array to be sorted, 
   low  --> Starting index, 
   high  --> Ending index */
 void sort(int arr[], int low, int high) 
 { 
     if (low < high) 
     { 
    	 int pi = randomPartition(arr, low, high);
         
         sort(arr, low, pi-1); 
         sort(arr, pi+1, high); 
     } 
 } 
 
 int randomPartition(int arr[], int low, int high)
 {
	 Random rand= new Random(); 
     int pivot = rand.nextInt(high-low) + low; 
       
     int temp	= arr[pivot]; 
     arr[pivot]	= arr[high]; 
     arr[high]	= temp; 
	 
	 return partition(arr, low, high);
 }
}






















