package byteBybyte;

public class MaxSquareSubmatrix {

//	bal fentrol nezem atloba hogy melyik a min a folotte atloba vagy mellette levobol es arra irom at a dp table erteket, kozbe update max
	static int maxSquareSubmatrix(int[][] mat)
	{
		int x = mat.length;
		if(x == 0)
			return 0;
		
		int y = mat[0].length;
		if(y == 0)
			return 0;
		
		int sizes[][] = new int[mat.length][mat[0].length];
		int max = 0;
		
		for (int row=0; row<x; row++)
		{
			for (int col=0; col<y; col++)
			{
				if(row==0  && col==0)
					sizes[row][col] = mat[row][col];
				else if(row==0 && col > 0)
					sizes[row][col] = mat[row][col-1];
				else if(col==0 && row > 0)
					sizes[row][col] = mat[row-1][col];
				else if(mat[row][col] == 1)
					sizes[row][col] = Math.min(Math.min(sizes[row-1][col], sizes[row][col-1]), sizes[row-1][col-1]) + 1;

				max = Math.max(sizes[row][col], max); 
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
//		3 a max
		int[][] mat_1 =
			{
					{1, 1, 1, 0},
					{1, 1, 1, 0},
					{1, 1, 1, 0},
					{0, 0, 0, 0}
			};
		
		
//		2 a maxx de tobbfelekeppen is ki lehet rakni 2x2 negyzetet
		int[][] mat_2 =
			{
					{1, 1, 1, 0},
					{1, 1, 1, 1},
					{1, 1, 0, 0}
			};
		
		System.out.println(maxSquareSubmatrix(mat_1));
	}

}
