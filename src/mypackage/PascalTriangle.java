package mypackage;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle 
{

	public List<List<Integer>> generate (int num)
	{
		List<List<Integer>> rows = new ArrayList<List<Integer>>();
		
		ArrayList<Integer> row = new ArrayList<Integer>();
		
		
		
		for(int i=0; i<num; i++)
		{
			row.add(0, 1);		// add 1 to 0. index
			
			for(int j=1; j<row.size()-1; j++)
				row.set(j,  row.get(j) + row.get(j+1));
				
			rows.add(new ArrayList<Integer>(row));
		}
		
		return rows;
	}
	
	public static void main(String[] args) 
	{
		
		PascalTriangle pt = new PascalTriangle();
		
		pt.generate(5);

	}

}
