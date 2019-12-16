package HackerRank.algoPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PossibleArrayGeneration {

        
    static List<Integer[][]> magicSquareGeneratorBruteForce(int size, int start, int end)
    {   
    	Integer[][] square = new Integer[size][size];  
    	List<Integer[][]> magic_squares = new ArrayList<Integer[][]>();       
    	
    	List<Integer[]> possibles = generateArrays(size, start, end);
    	
    	magicSquareGeneratorBruteForceHelper(possibles, magic_squares, square, 0, 0);

    	return magic_squares;
    }
    
    static void magicSquareGeneratorBruteForceHelper(List<Integer[]> poss, List<Integer[][]> magic_squares, Integer[][] square, int start, int index)
    {
    	if(index == 729)
    		System.out.println();
    	if(index < square.length)
		{
			if(start<poss.size()-1)
			{
//				generateArrays(poss, arr, start+1, end, index);
				magicSquareGeneratorBruteForceHelper(poss, magic_squares, square, start+1, index);
				if(check(square))
					magic_squares.add(square.clone());
			}
			
			square[index] = poss.get(start);
			
//			generateArrays(poss, arr, 1, end, index+1);
			
			magicSquareGeneratorBruteForceHelper(poss, magic_squares, square, 0, index+1);
		}
    }
	
    static List<Integer[]> generateArrays(int size, int start, int end)
    {     	
    	Integer[] arr = new Integer[size];
    	List<Integer[]> arrays = new ArrayList<Integer[]>();
    	
    	Arrays.fill(arr, start);
    	
    	generateArrays(arrays, arr, start, end, 0);
    	
    	arrays.add(arr);
    	
    	return arrays;
    }
    
    static void generateArrays(List<Integer[]> poss, Integer[] arr, int start, int end, int index)
    {   
    	if(index < arr.length)
		{
			if(start<end)
			{
				generateArrays(poss, arr, start+1, end, index);
				poss.add(arr.clone());
			}
			
			arr[index] = start;
			
			generateArrays(poss, arr, 1, end, index+1);
		}
    }
    
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
    
    static void printArr(Integer[] arr)
    {
    	System.out.println();
    	for(Integer a : arr)
    		System.out.print(a + " ");
    }
    
    
    
    public static void main(String[] args) {
    	
    	List<Integer[]> poss = new ArrayList<Integer[]>();
    	
//    	poss = generateArrays(3, 1, 9);
    	
    	List<Integer[][]> magicSquares = magicSquareGeneratorBruteForce(3, 1, 9);
    	
    	
    	
    	System.out.println();
    }
	
    // verzio 2 -> egy sima array pl [1, 2, 3, 4, 5, 6, 7, 8, 9]  
    // ezt 3massaval betesszuk a squarebe es check
    // majd ezt az arrayt permutaljuk es ujra
    
}










