package coderbyte;



// �tlet: gr�f probl�mak�nt kezelem a helyzetet. L�trehozok egy bool matrix-t, ami az ul�seket jelk�pezi.
// A bemeneti array alapj�n megjel�l�m a m�r foglalt helyeket. 2db seg�d array-el fogom a lehets�ges szomsz�dokat felder�teni.
// A matrixban v�gigmegyek minden �l�sen, �s ami �res, onnan felderitem minden ir�nyba a lehets�ges �res szomsz�dokat. Ahol �res
// az egy lehets�ges �ltet�snek min�s�l, n�velem a kombin�ci�k sz�m�t.
// Miut�n egy �l�sb�l az �sszes ir�nyt felder�tettem, megjel�l�m a jelenlegi pozici�t foglaltk�nt (true) �s 
// folytatja az algoritmus a BFS felder�t�st.

// Idea is to turn this problem into a graph problem, and with breath first search from each seat count the combinations.
// For the seats I made a bool matrix. From the input array, I mark all reserved seat in the matrix as true.
// Make 2 helper arrays for possible horizontal and vertical moves. Loop on empty seats in the matrix, and start a BFS from, 
// each of them, explore all neighbours with the help of the 2 direction helper arrays. If a neighbour seat is also empty,
// increment the combination counter. After each direction has been exhausted, mar the current
// seat as true. Then let the BFS continue.

public class Seatings2 {
	
	static int combinations(int[] arr)
	{
		int combinations = 0;
		int desks_num = arr[0];
		int rows = 2,
			cols = desks_num/2;		
		
		boolean[][] visited = new boolean[rows][cols];
		
		int[] horizontal_move 	= {-1,  1,  0,  0};			// left , right
		int[] vertical_move 	= { 0,  0, -1,  1};			// up, down

		
		// mark already reserved seats, as true
		for(int i=1; i<arr.length; i++)
		{
			
//			if(arr[i]/2  >= cols || arr[i]/2  >= cols)
//				break;
			
			// odd row
			if(arr[i]%2 == 1)
				visited[0][arr[i]/2] = true;		
			
			// even row
			else
				visited[1][arr[i]/2 -1] = true;
		}		
		
		// start a new breath-first-search from every position
		for(int row=0; row<rows; row++)
		{			
			for(int col=0; col<cols; col++)
			{
				if(visited[row][col])
					continue;								
				
				int new_row, new_col;
				
				for(int i=0; i<4; i++)		// check all direction
				{
					new_row = row + horizontal_move[i];
					
					new_col = col + vertical_move[i];
					
					if(new_row < 0 || new_row >= visited.length)
						continue;
					
					if(new_col < 0 || new_col >= visited[row].length)
						continue;
					
					if(visited[new_row][new_col])
						continue;
					
					combinations++;
				}
				
				visited[row][col] = true;	// mark current index as visited, after every direction was exhausted				
			}		
		}		
		
		return combinations;
	}
	
	// 0, 0, 0, 1, 0, 1
	// 1, 0, 1, 0, 0, 0
	
	// 1, 0, 0, 1, 1, 0
	// 1, 1, 1, 1, 1, 0
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = {8, 1, 8};
		
		combinations(array);
		
		System.out.println(combinations(array));
		
	}

}


















//int[][] seats = new int[rows][cols];		
//// make the matrix
//for(int i=0; i<rows; i++)
//{
//	int c=0;
//	
//	for(int k=1; k<=desks_num; k++)
//	{
//		if(c > cols)
//			break;
//		if(i==0 && k%2==1)
//			seats[i][c++] = k; 
//		else if(i==1 && k%2==0)
//			seats[i][c++] = k; 
//	}
//}
