package mypackage;

public class AppMoveZeros 
{

	static void moveZ(int[] arr)			// t: O(n^2), s: O(1)
	{
		int temp = 0;
		
		for(int i=0; i<arr.length; i++)
		{
			for(int k=i+1; k<arr.length; k++)
			{
				if(arr[i] == 0)
				{
					temp = arr[k];
					arr[k] = 0;
					arr[i] = temp;
				}
			}
		}		
	}
	
	static void moveZ2(int[] arr)			// t: O(2n), s: O(1)
	{
		int cz = 0, i = 0, j = 0;
		
		for(i=0; i<arr.length; i++)
			if(arr[i] == 0)
				cz++;
		
		i= 0;
		
		while(i<arr.length)
		{
			if(arr[i] != 0)
				arr[j++] = arr[i];
			
			i++;
		}
		
		for(i=arr.length-cz; i<arr.length; i++)
			arr[i] = 0;		
	}
	
	static void moveZ3(int[] arr)				// t: O(n), s: O(n)
	{
		int 	i = 0, j = 0;
		int[] 	ret = new int[arr.length];
		
		while(i<arr.length)
		{
			if(arr[i] != 0)
				ret[j++] = arr[i];
			
			i++;
		}
		
		
		System.out.println();
	}
	
	public static void main(String[] args) 
	{
		
		int[] arr = {0, 1, 0, 3, 12};

		moveZ3(arr);
	}

}









