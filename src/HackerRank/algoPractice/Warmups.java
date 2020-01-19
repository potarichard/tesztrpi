package HackerRank.algoPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Warmups {

//	1. apples oranges
	// if s + apples(i) > s && <=t   orange 
    static void countApplesAndOranges(int house_left, int house_right, int apple_tree, int orange_tree, int[] apples, int[] oranges) 
    {
    	int fall = 0, apple_fall = 0, orange_fall = 0;
    	
    	for(int apple : apples)
    	{
    		fall = apple_tree + apple;
    		
    		if(fall >= house_left && fall <= house_right)
    			apple_fall++;
    	}

    	for(int orange : oranges)
    	{
    		fall = orange_tree + orange;
    		
    		if(fall >= house_left && fall <= house_right)
    			orange_fall++;
    	}
    	
    	System.out.println(apple_fall);
    	System.out.println(orange_fall);
    }
	
//  2. 2 sets bullshit
    public static int getTotalX(List<Integer> a, List<Integer> b) 
    {

    	int f = lcm(a);
        int l = gcd(b);
        int count = 0;
        
        for(int i = f, j =2; i<=l; i=f*j,j++)
            if(l%i==0)
            	count++;
        
        System.out.println(count);
        
        return count;
    }
    
    private static int gcd(int a, int b) {
        while (b > 0) 
        {
            int temp = b;
            b = a % b; 
            a = temp;
        }
        return a;
    }

    private static int gcd(List<Integer> input) 
    {
        int result = input.get(0);
        
        for (int i = 1; i < input.size(); i++) 
            result = gcd(result, input.get(i));
        
        return result;
    }

    private static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }

    private static int lcm(List<Integer> input) 
    {
        int result = input.get(0);
        
        for (int i = 1; i < input.size(); i++) 
            result = lcm(result, input.get(i));
        
        return result;
    }
    
//  3. baseball scores
    static int[] breakingRecords(int[] scores) 
    {
    	int max = 0, min = 0;
    	int max_breaks = 0, min_breaks = 0;
    	
    	if(scores != null && scores.length >0)
    	{
    		max = scores[0];
    		min = scores[0];
    	}
    		
    	for(int i=1; i<scores.length; i++)
    	{
    		if(scores[i] > max)
    		{
    			max_breaks++;
    			max = scores[i];
    		}
    			
    		else if(scores[i] < min)
    		{
    			min_breaks++;
    			min = scores[i];
    		}    			
    	}    	
    	
    	int[] ret = {max_breaks, min_breaks};
    	
    	return ret;
    }
    
//  4. magic square 3x3 matrix -> every row,col diag ' s sum must be the same 15!
    static int formingMagicSquare(int[][] square) 
    {    	
    	int mods = 0;
    	int[][] original = new int[3][3];
    	
    	for(int i=0; i<3; i++)
    		original[i] = square[i].clone();

    	
    	
    	return mods;
    }
    
    
    // O(1)     
    static boolean check(Integer[][] square)
    {
    	int r1, r2, r3,
    		c1, c2, c3,
    		d1, d2;
    	
    	Set<Integer> set = new HashSet<Integer>();
    	
    	for(int i=0; i<3; i++)
    	{
    		for(int k=0; k<3; k++)
        	{
        		if(set.contains(square[i][k]))
        			return false;
        		else
        			set.add(square[i][k]);
        	}
    	}
    	
    	r1 = square[0][0] + square[0][1] + square[0][2];
    	r2 = square[1][0] + square[1][1] + square[1][2];
    	r3 = square[2][0] + square[2][1] + square[2][2];
    	
    	c1 = square[0][0] + square[1][0] + square[2][0];
    	c2 = square[0][1] + square[1][1] + square[2][1];
    	c3 = square[0][2] + square[1][2] + square[2][2];
    	
    	d1 = square[0][0] + square[1][1] + square[2][2];
    	d2 = square[0][2] + square[1][1] + square[2][0];
    	
    	
    	
    	
    	if(		r1 == 15 && r2 == 15 && r3 == 15 &&
    			c1 == 15 && c2 == 15 && c3 == 15 &&
    			d1 == 15 && d2 == 15)
    	{
    		System.out.println( 
    		    	square[0][0] + " " + square[0][1] + " " + square[0][2] + "\n" +
    		    	square[1][0] + " " + square[1][1] + " " + square[1][2] + "\n" +
    		    	square[2][0] + " " + square[2][1] + " "+ square[2][2] );
    		
    		return true;
    	}
    		
    	
    	return false;
    }
    
//  4_0. magic square generator
    static List<Integer[][]> magicSquareGeneratorBruteForce()
    {
    	List<Integer[][]> magic_squares = new ArrayList<Integer[][]>();    	
    	Integer[][] square = new Integer[3][3];    	    	
    	List<Integer[]> possibles = generateArrays(1,9);
    	
    	
    	for(int in=0; in<possibles.size(); in++)
		{    		
    		square[0] = possibles.get(in);
			
			for(int kn=0; kn<possibles.size(); kn++)
    		{
				square[1] = possibles.get(kn);								
    			
    			for(int hn=0; hn<possibles.size(); hn++)
        		{
    				square[2] = possibles.get(hn); 
    				
    				if(check(square))
    					magic_squares.add(square.clone());
        		}
    		}
		}
    	
    	return magic_squares;
    }
    
    static List<Integer[]> generateArrays(int start, int end)
    {     	
    	Integer[] arr = new Integer[3];
    	List<Integer[]> vectors = new ArrayList<Integer[]>();
    	
    	for(int in=start; in<=end; in++)
		{
			arr[0] = in;
			
			for(int kn=start; kn<=end; kn++)
    		{
    			arr[1] = kn;
    			
    			for(int hn=start; hn<=end; hn++)
        		{
        			arr[2] = hn;        			
        			vectors.add(arr.clone());
        		}
    		}
		}
    	
    	return vectors;
    }
    
    
//  6 array permutations, recursive
    static void printArr(int a[], int n) 
    { 
        for (int i=0; i<n; i++) 
            System.out.print(a[i] + " "); 
        System.out.println(); 
    } 
  
    static void heapPermutation(int a[], int size, int n) 
    { 
        if (size == 1) 
            printArr(a,n); 
  
        for (int i=0; i<size; i++) 
        { 
            heapPermutation(a, size-1, n); 
   
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
//    static void mSqGen(List<Integer[][]> magic_squares, int[][] square, int row, int col, int num)
//    {
//    	if(row == 2 && col == 2)
//    	{
//    		if(check(square))
//    			System.out.println("ok");
//    	}
//    	
//    	else
//		{
//			for(int r=row; r<3; r++)
//        	{
//        		for(int c=col; c<3; c++)
//        		{
//        			if(num<=9)
//        			{
//        				square[r][c] = num;            			 
//            			mSqGen(magic_squares, square, r, c, num+1);
//        			}
//        			else
//        			{
//        				num = 1;         			 
//        			}
//        		}
//        	}    	
//		}
//    	
//    }
    
    static void mSqGen(List<Integer[][]> magic_squares, Integer[][] square, int row, int col, int num)
    { 
		for(int i=1; i<=9; i++)
		{
			for(int r=0; r<3; r++)
			{
				if(col<3)
				{
					square[r][col] = i; 
					
					if(check(square))
					{
						System.out.println("heeeej");
						mSqGen(magic_squares, square, r, col+1, i);						
					}
					else
					{
						square[r][col] = i; 
						mSqGen(magic_squares, square, r, col+1, i);
					}
					
					
				}						
			}
		}
    }
    
    

	public static void main(String[] args) {
		
		lcm(6, 8);		// 24
		gcd(18, 48);	// 6
		
		int[][] sq = {	{4, 8, 2},
						{4, 5, 7},
						{6, 1, 6}};
		
		
		long time = System.currentTimeMillis();
		
		List<Integer[][]> magic_squares = magicSquareGeneratorBruteForce();
		
		time = System.currentTimeMillis() - time;
		
		System.out.println(time + " ms runtime");
		
		for(Integer[][] square : magic_squares)
		{
			System.out.println();
			
			for(int i=0; i<square.length; i++)
			{
				for(int k=0; k<square[i].length; k++)
					System.out.print(square[i][k] + " ");
				System.out.println();
			}
		}
		
		System.out.println();
	}

}
















