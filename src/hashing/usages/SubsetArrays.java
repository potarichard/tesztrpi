package hashing.usages;

public class SubsetArrays 
{
    static boolean isSubset(int arr1[], int arr2[]) 
    { 
        int i = 0; 
        int j = 0; 
        
        for (i = 0; i < arr2.length; i++) 
        { 
            for (j = 0; j < arr1.length; j++) 
            {
            	if(arr2[i] == arr1[j]) 
                    break;
            }
                 
              
//          If the above inner loop was not broken at all then 
//          arr2[i] is not present in arr1[]
            if (j == arr1.length) 
                return false; 
        } 
          
        return true; 
    } 
      
    // Driver code 
    public static void main(String args[]) 
    { 
        int arr1[] = {11, 1, 13, 21, 3, 7}; 
        int arr2[] = {11, 3, 7, 1, 0}; 
          
      
        if(isSubset(arr1, arr2)) 
            System.out.print("arr2[] is subset of arr1[] "); 
        else
            System.out.print("arr2[] is not a subset of arr1[]");  
    } 
	
}
