package arrays;

public class LeftRotation {

	
	
	public static int[] leftR(int[] arr, int d)	{
		
		int size = arr.length;
		int[] new_arr = new int [size];
		
		int i = 0, rotate_index = d;
		
		while(rotate_index < size)
		{
			new_arr[i] = arr[rotate_index];
			i++;
			rotate_index++;
		}
		
		rotate_index = 0;
		
		while(rotate_index < d)
		{
			new_arr[i] = arr[rotate_index];
			i++;
			rotate_index++;
		}
		
		return new_arr;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int[] arr = {1,2,3,4,5};	// 3,4,5,1,2
		
		leftR(arr, 2);
	}

}
