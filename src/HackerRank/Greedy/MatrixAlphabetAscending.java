package HackerRank.Greedy;

import java.util.Arrays;

// https://brilliant.org/wiki/greedy-algorithm/

public class MatrixAlphabetAscending {

	// possible to rearange rows -> colums will asc too ?
    static String gridChallenge(String[] grid) 
    {
    	char[] word;
    	int c = 0;
    	
    	for(int i=0; i<grid.length; i++)
    	{
    		word = grid[i].toCharArray();
    		
    		Arrays.sort(word);
    		
    		grid[i] = String.valueOf(word);
    	}	
    	
    	
    	for(int i=0; i<grid[0].length(); i++)
    	{
    		String asd = "";    		
    		
    		for(int k=0; k<grid.length; k++)
    			asd += grid[k].charAt(c);
    		
    		word = asd.toCharArray();
    		
    		Arrays.sort(word);
    		
    		if(!String.valueOf(word).equals(asd))
    			return "NO";
    		
    		c++;
    	}

    	return "YES";
    }
    
    
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String[] grid = {"ebacd",
						"fghij",
						"olmkn",
						"trpqs",
						"xywuv"};
		
		
		gridChallenge(grid);
		
	}

}








