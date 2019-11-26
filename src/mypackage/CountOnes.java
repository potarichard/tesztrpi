package mypackage;

public class CountOnes 
{

	public int getIslands(int[][] map)
	{
		int count = 0;
		
		for(int row=0; row<map.length; row++)
		{
			for(int col=0; col<map[0].length; col++)
			{
				if(map[row][col] == 1)
				{
					count++;
					dfs(map, row, col);
				}
					
			}
		}
		
		return count;
	}
	
	
//	the idea is if its an island we already counted, so mark it as visited bs setting that position to 0, do it from there to up, left, right, down
//	so the island is now all water (minden a kezdestol szamitott egybefuggo 1 esel jelolt terulet most mar 0 lesz)  ATLOBAN NEM SZAMIT EGYBEFUGGO SZIGETNEK
	private void dfs(int[][] map, int row, int col)
	{
		if(row < 0 || row >= map.length || col < 0 || col >= map[0].length || map[row][col] == 0)
			return;
		
		map[row][col] = 0;
	
		dfs(map, row, col-1);				//	left
		dfs(map, row-1, col);				//	up
		dfs(map, row, col+1);				//	right
		dfs(map, row+1, col);				//	down
	}
	
	
//	a legnagyob egybefuggo 1 esekbol allo teglalap kell
//	nem 0-azhatom ki mert mashol lehet h resze lesz
//	ezt tok mashogy kell megoldani mint a islandosat
//	soronkent kell a legnagyobb
//	aztan elmenteni a kezdo es vegindext
//	sor no aztan nezni a leghosszababat vagy a 1esek vannak e egybefuggonene a veg eskezdoindex alatt
	public int getMaximumRectangle(int[][] map)
	{
		
//		eloszor soronkent a leghosszabbat beupdatelem maxnak
//		ha a felette levok is 1 sek vagy nagyobbak mint 1 akkor az alatta levoket is atirom 1++ ra
//		aztan megkeresem minden sorban a legnagyobb szamot
		
// 1	T, B, L, R   corners index of maxrect
		
// 2	vagy ahol 1 van, onnan rekurziv dfs es amig 1 es jo helyen van addig megy
		
		return 0;
	}
	
	static void printMaxSubSquare(int M[][]) 
    { 
        int i,j; 
        int R = M.length;         
        int C = M[0].length;     
        int S[][] = new int[R][C];      
          
        int max_of_s, max_i, max_j;  
      
        for(i = 0; i < R; i++) 
            S[i][0] = M[i][0]; 
      
        for(j = 0; j < C; j++) 
            S[0][j] = M[0][j]; 
          
        for(i = 1; i < R; i++) 
        { 
            for(j = 1; j < C; j++) 
            { 
                if(M[i][j] == 1)  
                {
                	int valami_1 = Math.min(S[i-1][j], S[i-1][j-1]);
                	int result = Math.min(S[i][j-1], valami_1);
                	S[i][j] = result + 1; 
                }
                    
                else
                    S[i][j] = 0; 
            }  
        }      
        
          
        max_of_s = S[0][0]; max_i = 0; max_j = 0; 
        for(i = 0; i < R; i++) 
        { 
            for(j = 0; j < C; j++) 
            { 
                if(max_of_s < S[i][j]) 
                { 
                    max_of_s = S[i][j]; 
                    max_i = i;  
                    max_j = j; 
                }      
            }                  
        }      
        
        System.out.println();
    }
	
	
	static void MaxSubSquare(int S[][]) 
    { 
        
        int rows = S.length;         
        int cols = S[0].length;  
          
        for(int i = 1; i < rows; i++) 
        { 
            for(int j = 1; j < cols; j++) 
            { 
                if(S[i][j] == 1)  
                {
                	int valami_1 = Math.min(S[i-1][j], S[i-1][j-1]);
                	int result = Math.min(S[i][j-1], valami_1);
                	S[i][j] = result + 1; 
                }
                    
                else
                    S[i][j] = 0; 
            }  
        }      
        
          
           
        
        System.out.println();
    }
	
	public static void main(String[] args) 
	{
		
		int[][] map = new int[][] { {1, 1, 0, 0, 0},
									{1, 1, 0, 0, 0},
									{0, 0, 1, 0, 0},
									{0, 0, 0, 1, 1} };
									
		
		CountOnes ci = new CountOnes();
		
//		System.out.println(ci.getIslands(map));
		
		printMaxSubSquare(map);

	}

}














