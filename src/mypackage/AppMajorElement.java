package mypackage;

import java.util.Arrays;
import java.util.Collections;

public class AppMajorElement 
{

	static void major(int[] arr)
	{
		Arrays.sort(arr);
//		Collections.reverseOrder();
		
		int 	major = arr[0],
				count = 1;
		
		for(int i=1; i<arr.length; i++)
		{			
			if(count <= 0)
			{
				major = arr[i];
				count = 1;
			}
			else if(arr[i] == major)
			{
				count++;
				if(count >= arr.length/2)
				{
					System.out.println(major);
					return;
				}
					
			}
				
			else
				count--;
		}
		
		
	}
	
	public static void main(String[] args) 
	{
		
		int[] arr = {2, 43, 54, 64, 6, 43, 43, 6, 10, 43, 43, 43, 43};		// melyik elem ami legalabb a tomb felét teszi ki ?

		major(arr);
	}

}
