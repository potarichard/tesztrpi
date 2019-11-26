package mypackage;


public class MatrixSpiral 
{

	private static enum DIR
	{
		RIGHT,
		DOWN,
		LEFT,
		UP
	}
	
	public static void printAsSpiral(int[][] matrix)
	{
//		init bounderies (right, bottom, left, top)
		int 	R = matrix[0].length - 1,
				B = matrix.length - 1,
				L = 0,
				T = 0;
		
		DIR direction = DIR.RIGHT;
		
		System.out.println();
		
		while(R >= L && B >= T)
		{
			switch(direction)
			{
				case RIGHT:
					for(int i=L; i<=R; i++)
						System.out.print(matrix[T][i] + " ");	
					T++;
					direction = DIR.DOWN;
					break;
					
				case DOWN:
					for(int i=T; i<=B; i++)
						System.out.print(matrix[i][R] + " ");
					R--;
					direction = DIR.LEFT;
					break;
					
				case LEFT:
					for(int i=R; i>=L; i--)
						System.out.print(matrix[B][i] + " ");
					B--;
					direction = DIR.UP;
					break;
					
				case UP:
					for(int i=B; i>=T; i--)
						System.out.print(matrix[i][L] + " ");
					L++;
					direction = DIR.RIGHT;
					break;						
			}			
		}		
	}
	
	public static void main(String[] args) 
	{
		
		int[][] matrix = new int[][] { 
										{1,  2,  3,  4},
										{5,  6,  7,  8},
										{9,  10, 11, 12},
										{13, 14, 15, 16},
										{17, 18, 19, 20}
									 };
									 
		// print as spiral:  1 2 3 4 , 8 12 16 20 , 19 18 17 , 13 9 5 , 6 7 , 11 15 , 14 , 10 
									 
		MatrixSpiral.printAsSpiral(matrix);							 
								
									 
	}

}
