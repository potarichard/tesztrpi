package HackerRank.algoPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MagicSquareWithPermutation {

	

	
    // all row, col sums and 2 atlo
    static boolean check(Integer[][] square)
    {
    	Set<Integer> set = new HashSet<Integer>();
    	Integer[] rows = new Integer[square.length];
    	Integer[] cols = new Integer[square.length];  
    	Integer d1 = 0, d2 = 0;
    	
    	Arrays.fill(rows, 0);
    	Arrays.fill(cols, 0);
    	
    	int col=0, row=0;
    	
//    	check duplicates
    	for(int i=0; i<square.length; i++)
    	{
    		for(int k=0; k<square.length; k++)
        	{
        		if(set.contains(square[i][k]))
        			return false;
        		else
        			set.add(square[i][k]);
        	}
    	}
    	
//    	check sums
    	while(row<square.length)
    	{
    		rows[row] += square[row][col++];
    		
    		if(col >= square.length)
    		{
    			col = 0;
    			row++;
    		}
    	}
    		
    	col=0; row=0;
    	
    	while(col<square.length)
    	{
    		cols[col] += square[row++][col];
    		
    		if(row >= square.length)
    		{
    			row = 0;
    			col++;
    		}
    	}
    	
    	Integer sum = rows[0];
    	
    	for(int i=0; i<rows.length-1; i++)
    	{
    		if(sum == rows[i] && rows[i] == rows[i+1] && cols[i] == cols[i+1])
    			sum = rows[i];
    		else
    			return false;
    	}
    	
    	
    	col=0; row=0;
    	
    	while(col<square.length)
    	{
    		d1 += square[col][col];
    		col++;
    	}
    		
    	
    	col = 0; row = square.length-1;
    	
    	while(col<square.length && row >=0)
    		d2 += square[row--][col++];
    	
    	if(sum == d1 && d1 == d2)
    		return true;
    	
    	
    	return false;
    }
	
    static void printArr(Integer a[], int n) 
    { 
        for (int i=0; i<n; i++) 
            System.out.print(a[i] + " "); 
        System.out.println(); 
    } 
  
    static void heapPermutation(List<Integer[]> allPermut, Integer a[], int size, int n) 
    { 
        if (size == 1) 
        	allPermut.add(a.clone());            
  
        for (int i=0; i<size; i++) 
        { 
            heapPermutation(allPermut, a, size-1, n); 
   
            if (size % 2 == 1) 
            { 
                int temp = a[0]; 
                a[0] = a[size-1]; 
                a[size-1] = temp; 
            } 
  
            else
            { 
                int temp = a[i]; 
                a[i] = a[size-1]; 
                a[size-1] = temp; 
            } 
        } 
    } 
    
    static List<Integer[][]> getSquares(List<Integer[]> allPermut)
    {
    	List<Integer[][]> msq = new ArrayList<Integer[][]>();
    	
    	for(Integer[] permut : allPermut)
    		msq.add(makeSquare(permut));
    		
		return msq;
    }
    
    static Integer[][] makeSquare(Integer[] permut)
    {
    	int size = (int) Math.sqrt(permut.length);
    	
    	Integer[][] square = new Integer[size][size];
    	
    	for(int i=0; i<square.length; i++)
    	{
    		for(int k=0; k<square.length; k++)
        		square[i][k] = permut[k+i*size];
    	}
    	
    	return square;
    }
    
    static Integer[] createArr(int size, int start, int end)
    {
    	Integer[] arr = new Integer[size*size];
    	
    	int k=0;
    	
    	while(k<arr.length && start <= end)
    		arr[k++] = start++;
    	
    	return arr;
    }
    
	static List<Integer[][]> magicSquares(int size, int start, int end)
	{
		Integer[] arr;
		List<Integer[]> allPermut = new ArrayList<Integer[]>();
		List<Integer[][]> magicsquares = new ArrayList<Integer[][]>();
		List<Integer[][]> allsquares;
		
		arr = createArr(size, start, end);		
		heapPermutation(allPermut, arr, arr.length, arr.length);
		allsquares = getSquares(allPermut);		
		
		for(Integer[][] sq : allsquares)
			if(check(sq))
				magicsquares.add(sq);
		
		return magicsquares;
	}
    
	public static void main(String[] args) {
		
		
		List<Integer[][]> magicsquares = magicSquares(3, 1, 9);
		
		
		

		System.out.println();
	}

}


















