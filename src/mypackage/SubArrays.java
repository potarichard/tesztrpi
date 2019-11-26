package mypackage;

import java.util.ArrayList;
import java.util.List;

public class SubArrays 
{
	
	public static void asd(int[] arr)
	{
		int n = arr.length;
		int len = 0;
		
		List<ArrayList<Integer>> 	subs = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer>			sub = new ArrayList<Integer>();
		
		while(len < n)
		{
			for(int i=0; i<arr.length; i++)
			{
				if(i>=len+1)
					break;
				
				sub = new ArrayList<Integer>();
				
				for(int k=i; k<len+1; k++)
					sub.add(arr[k]);
				
				subs.add(sub);
			}
			
			len++;
		}
		
		System.out.println();
	}

	public static void main(String[] args) 
	{
		
		int[] arr = {1, 2, 3, 4};		// 4	(1), (2), (3), (4)
										// 3    (1,2), (2.3), (3,4)
										// 2    (1,2,3), (2,3,4)
										// 1    (1,2,3,4)  

		asd(arr);
		
		System.out.println();
	}

}
