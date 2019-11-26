package mypackage;

public class WordSearchMatrix 
{

	static boolean anyad(char[][] mat, String word)
	{		
		for(int w=0; w<=word.length(); w++)
		{
			int wl = word.length();			
			
			for(int i=0; i<mat.length; i++)
			{
				for(int k=0; k<mat[i].length; k++)
				{
					if(word.length() == 0)
						return true;
					if(word.charAt(0) == mat[i][k])
					{
						word = word.substring(1);
						mat[i][k] = '-';
					}
				}
			}
			
			if(wl == word.length())
				return false;
		}
		
		if(word.length() == 0)
			return true;
		
		
		return false;
	}
	
	public static void main(String[] args) 
	{
		
//		only one use each
//		ABCCED		true
//		SEE			true
//		ABCB		false
		
		char[][] mat = 	{ 
							{'A', 'B', 'C', 'E'},
							{'S', 'F', 'C', 'S'},
							{'A', 'D', 'E', 'E'}
						};

		
		System.out.println(anyad(mat, "SEE"));
		
		System.out.println();
	}

}
