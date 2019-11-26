package mypackage;

public class MaximumRectangle 
{
	
	public int maxRect(int[][] A)
	{
//		1. calc max area row by row
//		2. update maxarea
//		3. if(value is not 0) add current values to next row, else next row/col value is 0
		
		int area = maxArea(A[0]);
		int rows = A.length;
		int cols = A[0].length;
		
		for(int i=1; i<rows; i++)
		{
			for(int k=0; k<cols; k++)
			{
				if(A[i][k] != 0 && A[i-1][k] >= 1)
					A[i][k] = A[i-1][k] + 1;
			}
			
			area = Math.max(area, maxArea(A[i]));
		}
		
		return area;
	}
	
	public int maxArea(int[] heights)
	{		
		int max_area = 0;
		int height;
		int length;
		
		for(int i=0; i<heights.length; i++)
		{
			height = heights[i];
			length = 0;
			
			for(int k=i; k<heights.length; k++)
			{
				if(heights[k] < height)
					break;
				else
					length++;
			} 
			
			max_area = Math.max(max_area, height*length);
		}
		
		return max_area;
	}

	public static void main(String[] args) 
	{
		MaximumRectangle mr = new MaximumRectangle();
		
		int[][] A = { 	{0, 1, 1, 0}, 
		                {1, 1, 1, 1}, 
		                {1, 1, 1, 1}, 
		                {1, 1, 0, 0}, 
		                {0, 1, 1, 0}
		             }; 
		
		System.out.println(mr.maxRect(A)); 				// should return 8

	}

}
