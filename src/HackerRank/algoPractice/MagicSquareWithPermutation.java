package HackerRank.algoPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MagicSquareWithPermutation {

	
	List<Integer[][]> magicSquares = new ArrayList<Integer[][]>();
	
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
        {
//        	printArr(a,n); 
        	allPermut.add(a.clone());
        }
            
  
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
    
    static void getMagicSquares(List<Integer[]> allPermut)
    {
    	for(Integer[] permut : allPermut)
    	{
    		
    	}
    }
    
    static Integer[][] makeSquare(Integer[] permut)
    {
    	return null;
    }
    
	public static void main(String[] args) {
		
		List<Integer[]> allPermut = new ArrayList<Integer[]>();
		
		Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		heapPermutation(allPermut, arr, 9, 9);

		System.out.println();
	}

}


















