package sorting;


// eloszor sorbarakja legkissebb digit szerint (counting sort)
// majd 2. digit szerint, ...
// MINDEN DIGITNEL COUNTING SORT MEGY VEGBE, AZ EGY ELEG EGYEDI ALGORITMUS, (megszamolja a kulonbozo ertekeket ezeket leirja egy tombe es elshifteli)

public class RadixSort 
{

    static int getMax(int arr[], int n) 
    { 
        int mx = arr[0]; 
        for (int i = 1; i < n; i++) 
            if (arr[i] > mx) 
                mx = arr[i]; 
        return mx; 
    } 
    
   
    static void countSort(int arr[], int n, int exp) 
    { 
        int 	output[] 	= new int[n],
        		count[] 	= new int[10]; 		// 10 fele elem fordulhat elo egy decimalis szamban egy helyierteken
        int i; 
  
        // Store count of occurrences of the current digit in the right place
        // store 0's count on the 0. index, 1's count on 1. index ... 9's count on the 9. index
        for (i = 0; i < n; i++) 
            count[ (arr[i]/exp)%10 ]++; 			// a helyierteken levo digit %10 = a digit, ami az adott index a countban, es azt noveljuk minden elofordulasnal
  
        // Change count[i] so that count[i] now contains actual position of this digit in output[] 
        for (i = 1; i < 10; i++) 
            count[i] += count[i - 1]; 		// 1 tol indulva hozzaadjuk az elozo elem erteket az aktualishoz, igy ezek a szamok mar a startindexei lesznek a szamoknak a count meg hogy hanyszor kell leirni
  
        // Build the output array, az elozoleg kapott count arraybe benne van hogy melyik digit hanyas indextol indul
        // (meg egy jobbra shiftelés kéne, de mivel out count-1 az megoldja
        for (i = n - 1; i >= 0; i--) 
        { 
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i]; 
            count[ (arr[i]/exp)%10 ]--; 
        } 
  
        // Copy the output array to arr[], so that arr[] now contains sorted numbers according to curent digit 
        for (i = 0; i < n; i++) 
            arr[i] = output[i]; 
    } 
  
    void radixsort(int arr[], int n) 
    { 
        int max = getMax(arr, n); 
  
        // Do counting sort for every digit. Note that instead of passing digit number, exp is passed. exp is 10^i 
        // where i is current digit number 
        for (int exp = 1; max/exp > 0; exp *= 10) 
            countSort(arr, n, exp); 
    } 
  
    
	
}



















