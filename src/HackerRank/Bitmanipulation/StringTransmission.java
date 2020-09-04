package HackerRank.Bitmanipulation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// READ: https://www.geeksforgeeks.org/print-all-possible-combinations-of-r-elements-in-a-given-array-of-size-n/

public class StringTransmission {

	
	/* arr[]  ---> Input Array 
    data[] ---> Temporary array to store current combination 
    start & end ---> Staring and Ending indexes in arr[] 
    index  ---> Current index in data[] 
    r ---> Size of a combination to be printed */
    static void combinationUtil(int arr[], int data[], int start, int end, int index, int r) 
    { 
        // Current combination is ready to be printed, print it 
        if (index == r) 
        { 
            for (int j=0; j<r; j++) 
                System.out.print(data[j]+" "); 		// print indexes instead and wergood
            System.out.println(""); 
            return; 
        } 
  
        // replace index with all possible elements. The condition 
        // "end-i+1 >= r-index" makes sure that including one element 
        // at index will make a combination with remaining elements 
        // at remaining positions 
        for (int i=start; i<=end && end-i+1 >= r-index; i++) 
        { 
            data[index] = arr[i]; 
            combinationUtil(arr, data, i+1, end, index+1, r); 
        } 
    } 
  
    // The main function that prints all combinations of size r 
    // in arr[] of size n. This function mainly uses combinationUtil() 
    static void printCombination(int arr[], int n, int r) 
    { 
        // A temporary array to store all combination one by one 
        int data[]=new int[r]; 
  
        // Print all combination using temprary array 'data[]' 
        combinationUtil(arr, data, 0, n-1, 0, r); 
    } 
	
    
    static void combinationIndexUtil(int arr[], int data[], int start, int end, int index, int r, Set<String> list) 
    { 
        // Current combination is ready to be printed, print it 
    	// System.out.print(data[j] + "-" + arr[data[j]] + ", ");
    	
        if (index == r) 
        { 
        	String str = "";
        	
            for (int j=0; j<r; j++) 
            {
            	if(arr[data[j]] == 1)
            		arr[data[j]] = 0;
            	else
            		arr[data[j]] = 1;            	
            }
            	
            for (int j=0; j<arr.length; j++) 
            	str += arr[j];
            	
            
            list.add(str);
            	
            return; 
        } 
  
        for (int i=start; i<=end && end-i+1 >= r-index; i++) 
        { 
            data[index] = i; 
            combinationIndexUtil(arr, data, i+1, end, index+1, r, list); 
        } 
    } 
  
    // The main function that prints all combinations of size r 
    // in arr[] of size n. This function mainly uses combinationUtil() 
    static void indexesCombination(int arr[], int n, int r, Set<String> list) 
    { 
        // A temporary array to store all combination one by one 
        int data[]=new int[r]; 
  
        // Print all combination using temprary array 'data[]' 
        combinationIndexUtil(arr, data, 0, n-1, 0, r, list); 
    } 
    

    
    static boolean isRepeat(String str) 
    { 
    	
//    	String str = new String(arr);
    	
        // Find length of string and create  
        // an array to store lps values used in KMP 
        int n = str.length(); 
        int lps[] = new int[n]; 
      
        // Preprocess the pattern (calculate lps[] array) 
        computeLPSArray(str, n, lps); 
      
        // Find length of longest suffix  
        // which is also prefix of str. 
        int len = lps[n-1]; 
      
        // If there exist a suffix which is also  
        // prefix AND Length of the remaining substring 
        // divides total length, then str[0..n-len-1]  
        // is the substring that repeats n/(n-len)   
        // times (Readers can print substring and  
        // value of n/(n-len) for more clarity. 
        return len > 0 && n%(n-len) == 0; 
    } 
    
    static void computeLPSArray(String str, int M, int lps[]) 
	{    
		// lenght of the previous  
		// longest prefix suffix 
		int len = 0;  
		
		int i; 
		
		lps[0] = 0; // lps[0] is always 0 
		i = 1; 
		
		// the loop calculates lps[i]  
		// for i = 1 to M-1 
		while (i < M) 
		{ 
			if (str.charAt(i) == str.charAt(len)) 
			{ 
				len++; 
				lps[i] = len; 
				i++; 
			} 
			else // (pat[i] != pat[len]) 
			{ 
				if (len != 0) 
				{ 
					// This is tricky. Consider the  
					// example AAACAAAA and i = 7. 
					len = lps[len-1]; 
					
					// Also, note that we do  
					// not increment i here 
				} 
				else // if (len == 0) 
				{ 
					lps[i] = 0; 
					i++; 
				} 
			} 
		} 
	} 
    
    // 		101
	// 3 	010
	// 2	011, 000, 110
	// 1	001, 111, 100
	
	// 	could be: 	010, 
//					011, 110, 001, 100, + original 101    
    
    static int stringTransmission(int k, String s) 
    {
    	if(k==0)
    		return 0;
    	
    	int count = 1;    	
    	int[] arr = new int[s.length()];
    	
    	for(int i=0; i<arr.length; i++)
    		arr[i] = s.charAt(i)-48;
    	
    	Set<String> list = new HashSet<String>();
    	
    	while(k>0)
    	{   		    		
    		indexesCombination(arr, arr.length, k, list);    		
    		k--;
    	}
    	
    	for(String str : list)
			if(!isRepeat(str))
				count++;
    	
    	return count;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int arr[] = {1, 2, 3, 4, 5}; 
//		int arr[] = {10, 21, 32}; 
//        int r = 1; 
//        int n = arr.length; 
//        indexesCombination(arr, n, r);
//        System.out.println();
//        printCombination(arr, n, r);
		
		
		
		stringTransmission(0, "00000");
		
	}

}

















