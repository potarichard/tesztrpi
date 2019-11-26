package mypackage;

public class TowerJump 
{

	public boolean canJumpStandard(int[] arr)
	{
		int		n = arr.length,
				last = arr.length-1;
		
		for(int i=n-2; i>=0; i--)
		{
			if(i + arr[i] >= last)
				last = i;
		}		
		
		return last <=0;
	}
	
	public static void main(String[] args) 
	{
		TowerJump tj = new TowerJump();
		
		int[] arr1 = new int[] {2, 3, 1, 1, 4};			// should return true
		int[] arr2 = new int[] {3, 2, 1, 0, 4};			// should return false
		int[] arr3 = new int[] {4, 2, 0, 0, 2};			// should return ?
		
		System.out.println( tj.canJumpStandard(arr1) );
		System.out.println( tj.canJumpStandard(arr2) );
		System.out.println( tj.canJumpStandard(arr3) );
	}

}
