package BackToBackSWE;

public class PrintShapes 
{

	static void printNormal(int rows)
	{
		for(int i=0; i<rows; i++)
		{
			for(int k=0; k<i+1; k++)
				System.out.print("* ");
			
			System.out.println();
		}
	}
	
	static void printNormalMirror(int rows)
	{
		for(int i=0, j=rows; i<rows; i++,j--)
		{
			int margin = j*2 - 2;
			
			for(int k=0; k<margin; k++)
				System.out.print(" ");
			
			for(int k=0; k<i+1; k++)
				System.out.print("* ");
			
			System.out.println();
		}
	}
	
	static void printTree(int rows)
	{
		for(int i=0, j=rows; i<rows; i++,j--)
		{
			int margin = j-1;
			
			for(int k=0; k<margin; k++)
				System.out.print(" ");
			
			for(int k=0; k<i+1; k++)
				System.out.print("* ");
			
			System.out.println();
		}
	}
	
	static void printDenseTree(int rows)
	{
		rows *= 2;
		
		for(int i=0, j=rows; i<rows; i++,j--)
		{
			if(i != 0 && i%2 == 1)
				continue;
			
			int margin = j-2;
			
			for(int k=0; k<margin; k++)
				System.out.print(" ");
			
			for(int k=0; k<i+1; k++)
				System.out.print("* ");
			
			System.out.println();
		}
	}
	
	static void printDiamond(int rows)
	{
		rows *= 2;
		
		for(int i=0, j=rows; i<rows; i++,j--)
		{
			if(i != 0 && i%2 == 1)
				continue;
			
			int margin = j-2;
			
			for(int k=0; k<margin; k++)
				System.out.print(" ");
			
			for(int k=0; k<i+1; k++)
				System.out.print("* ");
			
			System.out.println();
		}
		
		for(int i=rows-1, j=0; i>=0; i--,j++)
		{
			if(i%2 == 1)
				continue;
			
			int margin = j;
			
			for(int k=0; k<margin; k++)
				System.out.print(" ");
			
			for(int k=0; k<i-1; k++)
				System.out.print(" *");
			
			System.out.println();
		}
	}
	
	public static void main(String[] args) 
	{
	
		int rows = 6;
		
		printNormal(rows);
		System.out.println();
		printNormalMirror(rows);
		System.out.println();
		printTree(rows);
		System.out.println();
		printDenseTree(rows);
		System.out.println();
		printDiamond(rows);
	}

}
