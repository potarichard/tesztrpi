package HackerRank.ConstructiveAlgorithms;

public class MatrixFlipMaxSum {

//	ex:
//	112  42   83   119
//	56   125  56   49
//	15   78   101  43
//	62   98   114  108
	
//	sol
//	119   114   42   112
//	56 	  125 	101  49
//	15    78    56   43
//	62    98    83   118
	
//	 can reverse a row and columns
//	 maximum sum in matrix.len/2 matrix
	
	
    
    static int flippingMatrix(int[][] matrix) 
    {
        int 	length = matrix.length,
        		new_length = matrix.length / 2,
        		last_element = length-1,
        		sum = 0;
        
        for(int row=0; row<new_length; row++)
        {
            for(int col=0; col<new_length; col++)
            {
            	int top_left_corner 	= matrix[row][col];
            	int top_right_corner 	= matrix[row][last_element-col]; 
            	int bot_left_corner  	= matrix[last_element-row][col];
            	int bot_right_corner 	= matrix[last_element-row][last_element-col];       
            	            	
            	int bot_max  		= Math.max(bot_left_corner, bot_right_corner);
            	int top_max  		= Math.max(top_left_corner, top_right_corner);
            	
            	sum 	+= Math.max(bot_max, top_max);
            }                
        }

        return sum;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] matrix =	{{112,  42,   83,   119},
							{56,   125,  56,   49},
							{15,   78,   101,  43},
							{62,   98,   114,  108}};
		
		flippingMatrix(matrix);
	}

}




















