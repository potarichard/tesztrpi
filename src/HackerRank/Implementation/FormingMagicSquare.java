package HackerRank.Implementation;

import java.util.ArrayList;
import java.util.List;

public class FormingMagicSquare {

	static int formingMagicSquare(int[][] s) 
	{
		List<Integer[][]> magic_squares = allMagicSquares();
		
		int matching_square_min = Integer.MAX_VALUE;
		
		for(Integer[][] magic : magic_squares)
			matching_square_min = Math.min(matching_square_min, compareSquares(magic, s));
		
		return matching_square_min;
    }
	
	static int compareSquares(Integer[][] magic, int[][] sq)
	{
		int sum = 0;
		
		for(int i=0; i<magic.length; i++)
			for(int k=0; k<magic.length; k++)
				sum += Math.abs(magic[i][k] - sq[i][k]);
		
		return sum;
	}
	
	static List<Integer[][]> allMagicSquares()
	{
		List<Integer[][]> magic_squares = new ArrayList<Integer[][]>();
		
		Integer[][] square1 = {{2,9,4}, {7,5,3}, {6,1,8}};
		Integer[][] square2 = {{2,7,6}, {9,5,1}, {4,3,8}};
		Integer[][] square3 = {{4,3,8}, {9,5,1}, {2,7,6}};
		Integer[][] square4 = {{4,9,2}, {3,5,7}, {8,1,6}};
		Integer[][] square5 = {{6,7,2}, {1,5,9}, {8,3,4}};
		Integer[][] square6 = {{6,1,8}, {7,5,3}, {2,9,4}};
		Integer[][] square7 = {{8,3,4}, {1,5,9}, {6,7,2}};
		Integer[][] square8 = {{8,1,6}, {3,5,7}, {4,9,2}};
		
		magic_squares.add(square1);
		magic_squares.add(square2);
		magic_squares.add(square3);		
		magic_squares.add(square4);
		magic_squares.add(square5);
		magic_squares.add(square6);
		magic_squares.add(square7);
		magic_squares.add(square8);
		
		
		return magic_squares;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
