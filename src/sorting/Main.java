package sorting;

import java.util.Random;

//   https://www.geeksforgeeks.org/sorting-algorithms/

public class Main 
{

	public static void main(String[] args) 
	{
//		1. fill array
		int[] arr = new int[] {689,2,30,1,9,105,151,13};
		
		// array for counting sort test (part of radix sort)
//		arr = new int[] {1, 0, 3, 1, 3, 1};
		
		// randomize array
//		arr = new int[10000000];
//		fillArrayRandomly(arr);
		
		try 
		{
			Thread.sleep(1000);
		} catch (InterruptedException e) {e.printStackTrace();}
		
//		2. get timestamp
		long start = System.currentTimeMillis();
		
		
		
		
//		////////////////////////////////    choose a sorting algorithm /////////////////////////////////
		
		
//		MergeSortMine msm = new MergeSortMine();		
//		msm.sort(arr, arr.length);					// 1,000 -> 2 ms | 10,000 -> 5 ms | 100,000 -> 28 ms | 1,000,000 -> 172 ms  | 100,000,000 -> 44 s
		
//		SelectionSort sels = new SelectionSort();
//		sels.sort(arr);								// 1,000 -> 4 ms | 10,000 -> 27 ms | 100,000 -> 3100 ms | 1,000,000 -> terminated timeout
		
		QuickSort qs = new QuickSort();
		qs.sort(arr, 0, arr.length-1);				// 1,000 -> 1 ms | 10,000 -> 3 ms | 100,000 -> 16 ms | 1,000,000 -> 170 ms | 10,000,000 -> 2100 ms
		
//		HeapSort heaps = new HeapSort();
//		heaps.sort(arr);							// 1,000 -> 1 ms | 10,000 -> 3 ms | 100,000 -> 16 ms | 1,000,000 -> 155 ms | 10,000,000 -> 2253 ms
		
//		RadixSort rads = new RadixSort();
//		rads.radixsort(arr, arr.length);			// 100,000 -> 13 ms | 1,000,000 -> 74 ms  | 10,000,000 -> 	500 ms  | 	100,000,000 ->  5 s

		
		
//		3. result time print		
		long runtime = System.currentTimeMillis() - start;
		System.out.println("\n\n" + runtime + " ms");
	}

	
	static void fillArrayRandomly(int[] arr)
	{
		Random random = new Random();
		
		for(int i=0; i<arr.length; i++)
			arr[i] = random.nextInt(50000);
		
	}
	
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
    } 
}











