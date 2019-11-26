package hashing;

public class HashBasic 
{

//	lenyeg: Hash function which is used to map a given value with a particular key for faster access of elements.
	
//	egy array elemeit elmentjuk egy hashtablebe ahol a keyeket az array elemeivel vamalilyen hashfunction alapjan szampljuk
//	pl.   arr = [15, 10, 22, 43, 59];
//	hashfunction  key[i] = arr[i] % 10;
	
	
	
	final static int MAX = 1000; 
	  
	// Since array is global, it  
	// is initialized as 0.  
	static boolean[][] has = new boolean[MAX + 1][2]; 
	  
	// searching if X is Present in  
	// the given array or not.  
	static boolean search(int X)  
	{ 
	    if (X >= 0)  
	    { 
	        if (has[X][0] == true)  
	        { 
	            return true; 
	        }  
	        else 
	        { 
	            return false; 
	        } 
	    } 
	  
	    // if X is negative take the  
	    // absolute value of X.  
	    X = Math.abs(X); 
	    if (has[X][1] == true)  
	    { 
	        return true; 
	    } 
	  
	    return false; 
	} 
	  
	static void insert(int a[], int n)  
	{ 
	    for (int i = 0; i < n; i++)  
	    { 
	        if (a[i] >= 0)  
	        { 
	            has[a[i]][0] = true; 
	        }  
	        else 
	        { 
	            has[Math.abs(a[i])][1] = true; 
	        } 
	    } 
	} 
	  
	// Driver code  
	public void callBasic(int a[],  int X)  
	{ 	    
	    int n = a.length; 
	    insert(a, n); 
	    
	    if (search(X) == true) 
	    { 
	        System.out.println("Present"); 
	    }  
	    else 
	    { 
	        System.out.println("Not Present"); 
	    } 
	} 
}







