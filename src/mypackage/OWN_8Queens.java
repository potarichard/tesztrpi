package mypackage;

import java.util.ArrayList;
import java.util.List;

public class OWN_8Queens {

	static void possiblePlacements(int rows, List<Integer[]> result)
	{
		placements(0, rows, new Integer[rows], result);
	}
	
	static void placements(int row, int rows, Integer[] cols, List<Integer[]> result)
	{
		if(row == rows)
			result.add(cols.clone());
		
		else
		{
			for(int col=0; col<rows; col++)
			{
				if(check(row, col, cols))
				{
					cols[row] = col;
					placements(row+1, rows, cols, result);
				}
			}
		}
	}
	
	static boolean check(int row, int col, Integer[] columns)
	{
		
		for(int row_check=0; row_check<row; row_check++)
		{
			int col_check = columns[row_check];
			
			if(col == col_check)
				return false;
			
			int columnDistance = Math.abs(col_check-col);
			int rowDistance = row-row_check;
			
			if(columnDistance == rowDistance)
				return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer[]> result = new ArrayList<Integer[]>();		// megadja hogy melyik oszlopba hanyas sorba kell rakni a queent hogy jó legyen
		
		possiblePlacements(4, result);
		
		System.out.println();
	}

}
