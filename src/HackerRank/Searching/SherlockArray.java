package HackerRank.Searching;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class SherlockArray {

	// middle point where both halves are equal
	static String balancedSums(List<Integer> list) 
	{
		int[] arr = list.stream().mapToInt(Integer::new).toArray();

		int i = 0, e = arr.length-1;
		
		int sum_l = 0, sum_r = 0; 
		
		if(arr[i] < arr[e])
		{
			sum_l = 0;
			sum_r = arr[e--];
		}
		
		else if(arr[i] > arr[e])
		{
			sum_l = arr[i++];
			sum_r = 0;
		}
		
		while(e >= (i+1))
		{
			if(sum_l > sum_r)
			{
				sum_r += arr[e];
				e--;
			}
			else if(sum_l < sum_r)
			{
				sum_l += arr[i];
				i++;
			}
			else
			{
				i++; e--;
			}
		}
		
		if(sum_l == sum_r)
			return "YES";
		
		return "NO";
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> arr = Arrays.asList(1, 1, 4, 1, 1);
		
		balancedSums(arr);
	}

}
