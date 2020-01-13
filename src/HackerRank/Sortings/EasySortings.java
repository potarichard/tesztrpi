package HackerRank.Sortings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class EasySortings {

//	sort much, and very long strings as numbers
//	nums may not able to allocate to int (so big)
	
//	8
//	1
//	2
//	100
//	12303479849857341718340192371
//	3084193741082937
//	3084193741082938
//	111
//	200
    static String[] bigSorting(String[] unsorted) {

    	int i=0;
    	String[] sorted = new String[unsorted.length];
    	
    	PriorityQueue<String> strings = new PriorityQueue<String>((a,b) -> 
    	{    		
    		double da = Double.valueOf(a) / 1000000000000000.0;
    		double db = Double.valueOf(b) / 1000000000000000.0;
    		
    		if(da > db)
    			return 1;
    		else if(da < db)
				return -1;
			else
				return 0;
    	});
    	
    	
    	for(String str : unsorted)
    		strings.add(str);
    	
    	while(!strings.isEmpty())
    		sorted[i++] = strings.poll();
    	
    	return sorted;    	
    }

//  easy binary search
    static int introTutorial(int V, int[] arr) 
    {
    	return binarySearch(V, arr, 0, arr.length-1);
    }
    
    static int binarySearch(int num, int[] arr, int start, int end)
    {    	 
    	int mid = (end+start)/2;
    	
    	if(end>=start)
    	{
    		if(arr[mid] == num)
    			return mid;
    		else if(num < arr[mid])
    			mid = binarySearch(num, arr, start, mid);
    		else
    			mid = binarySearch(num, arr, mid+1, end);
    	}
    	else
    		return -1;
    	
    	return mid;
    }
    
    
    
    // mindig a kovi elem a kulcs, ha vizsgalt nagyobb mint a kulcs akkor csere
    static void insertionSort2(int n, int[] arr)
    {
    	int count = 0;
    	
		 for(int k=0; k<arr.length-1; k++)
		 {
		     for(int i=0; i<arr.length-1; i++)
		     {
		    	 int key = arr[k+1];
		      
		         if(i == k+1)
		             break;           
		         if(arr[i] > key)
		         {
		             arr[k+1]	= arr[i];
		             arr[i]		= key;
		             count++;
		         }
		     }
		     
		     for(int i=0; i<arr.length; i++)
		    	 System.out.print(arr[i] + " ");
		     
		     System.out.println();
		 }
    }
    
    static int[] closestNumbers(int[] arr) {

    	List<Integer> list = new ArrayList<Integer>();
    	
    	Arrays.sort(arr);
    	
    	int min = Integer.MAX_VALUE;
    	
    	for(int i=1; i<arr.length; i++)
			min = Math.min(min, arr[i]-arr[i-1]);
    	
    	for(int i=1; i<arr.length; i++)
    	{
    		if(arr[i]-arr[i-1] == min)
    		{
    			list.add(arr[i-1]);
    			list.add(arr[i]);
    		}
    	}
    		
    	int[] ret = list.stream().mapToInt(x -> x).toArray();
    	
    	return ret;
    }
    
    
	
	public static void main(String[] args) {
		
		String[] unsorted = {	"8",
								"1",
								"2",
								"100",
								"12303479849857341718340192371",
								"3084193741082937",
								"3084193741082938",
								"111",
								"200"};
		
		bigSorting(unsorted);

		
		int[] arr = {1, 4, 5, 7, 9, 12};
		
		int[] arr_s = {2, 1, 3, 1, 2};
		
		insertionSort2(10312, arr_s);
		
		introTutorial(18, arr);

		int[] arr_s3 = {5, 4, 3, 2};
		
		closestNumbers(arr_s3);
	}

}























