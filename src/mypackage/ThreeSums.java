package mypackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

// https://www.geeksforgeeks.org/find-triplets-array-whose-sum-equal-zero/

public class ThreeSums 
{

	List<Integer[]> triplets = new ArrayList<Integer[]>();
	
	public List<Integer[]> getZeroTriplets(int[] arr)
	{
		this.triplets.clear();
		
		
		
		return this.triplets;
	}
	
	private boolean zeroTriplet(int[] arr)
	{		
		int sum = 0;
		
		for(int i=1; i<arr.length; i++)
			arr[0] += arr[i];
		
		if(sum == 0)
			return true;
		
		return false;
	}
	
	private int[] sortTriplet(int[] arr)
	{
		int temp;
		
		for(int i=0; i<arr.length; i++)
		{
			for(int j=i+1; j<arr.length; j++)
			{
				if(arr[j] < arr[i])
				{
					temp   = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		return arr;
	}
	
	public int isZeroTrip(int[] arr, int sum, int index)
	{
		if(sum == 0)
			return 1;
		if(sum < 0)
			return 0;
		
		int count = 0;
		
		for(int i=index; i<arr.length; i++)
		{
			if(arr[i] < 0)
				count += isZeroTrip(arr, sum+arr[i], i);
			else
				count += isZeroTrip(arr, sum-arr[i], i);			
		}
		
		return count;
	}
	
	
	public void bruteForce(int[] arr)
	{
		int n = arr.length;
		
	    for (int i=0; i<n-2; i++) 
	    { 
	        for (int j=i+1; j<n-1; j++) 
	        { 
	            for (int k=j+1; k<n; k++) 
	            { 
	                if (arr[i]+arr[j]+arr[k] == 0) 
	                { 
	                    System.out.print(arr[i]); 
	                    System.out.print(" "); 
	                    System.out.print(arr[j]); 
	                    System.out.print(" "); 
	                    System.out.print(arr[k]); 
	                    System.out.print("\n"); 
	                } 
	            } 
	        } 
	    } 
	}
	
	public void bruteForce2(int[] arr)
	{
		boolean found = false; 
		int n = arr.length;  
		
        for (int i = 0; i < n - 1; i++)  
        { 
            // Find all pairs with sum equals to 
            // "-arr[i]" 
            HashSet<Integer> s = new HashSet<Integer>(); 
            for (int j = i + 1; j < n; j++)  
            { 
                int x = -(arr[i] + arr[j]); 
                if (s.contains(x))  
                { 
                    System.out.printf("%d %d %d\n", x, arr[i], arr[j]); 
                    found = true; 
                }  
                else 
                { 
                    s.add(arr[j]); 
                } 
            } 
        } 
	}
	
	public void bF3(int[] arr)
	{
		boolean found = false; 
		int n = arr.length;  
		
	    // sort array elements 
	    Arrays.sort(arr); 
	  
	    for (int i=0; i<n-1; i++) 
	    { 
	        // initialize left and right 
	        int l = i + 1; 
	        int r = n - 1; 
	        int x = arr[i]; 
	        while (l < r) 
	        { 
	            if (x + arr[l] + arr[r] == 0) 
	            { 
	                // print elements if it's sum is zero 
	                    System.out.print(x + " "); 
	                    System.out.print(arr[l]+ " "); 
	                    System.out.println(arr[r]+ " "); 
	      
	                l++; 
	                r--; 
	                found = true; 
	            } 
	  
	            // If sum of three elements is less 
	            // than zero then increment in left 
	            else if (x + arr[l] + arr[r] < 0) 
	                l++; 
	  
	            // if sum is greater than zero than 
	            // decrement in right side 
	            else
	                r--; 
	        } 
	    } 
	  
	    if (found == false) 
	            System.out.println(" No Triplet Found"); 
	}
		
	public static void main(String[] args) 
	{
		
		int[] arr = new int[] {-1, 0, 1, 2, -1};		// [-1, 0, 1] , [-1, -1, 2]
		
		ThreeSums ts = new ThreeSums();
		
		List<Integer[]> triplets = ts.getZeroTriplets(arr);
		
//		ts.bruteForce(arr);
		
//		ts.bruteForce2(arr);
		
		ts.bF3(arr);
		
//		System.out.println(ts.isZeroTrip(arr, 1, 0));
		

	}

}
