package HackerRank.Implementation;

public class StringEncryption {

	static String encryption(String s) 
	{
		s = s.replaceAll(" ", "");
		String ret = "";
		double root = Math.sqrt(s.length());
		
		int row, col;
		
		if(Math.floor(root) < Math.ceil(root))
		{
			row = (int) Math.ceil(root);
			col = row;
		}
		else
		{
			row = (int) Math.floor(root);
			col = row+1;
		}
		
		int c = 0;
		char[][] table = new char[row][col];		
		
		
		for(int i=0; i<table.length; i++)
		{
			for(int k=0; k<table[i].length; k++)
			{
				if(c<s.length())
					table[i][k] = s.charAt(c++);
			}
		}
		
		
		for(int i=0; i<col; i++)
		{
			for(int k=0; k<table.length; k++)
			{
				if(table[k][i] != 0)
					ret += table[k][i];
			}
			if(i<col-1)
				ret += " ";
		}
		
		return ret;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		encryption("feedthedog");
		
	}

}
