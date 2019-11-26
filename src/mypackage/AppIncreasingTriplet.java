package mypackage;

public class AppIncreasingTriplet 
{

	static boolean incTrip(int[] arr)
	{
		int min=0, max=0;	// ket vegpont, i lesz a kozepso elem
		
		for(int i=1; i<arr.length-1; i++)
		{
			min = arr[i-1];
			max = arr[i+1];
			
			if(arr[i] <= max && arr[i] >= min)
				return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) 
	{
		
		int[] arr = {23, 43, 11, 2, 43, 232, -5, 100, 5};		// ret true if array contains an increasing triplet

		incTrip(arr);
	}

}
