package mypackage;

public class WilliamGeneratePowerSet 
{
	private void subsetRecursive(int[] arr, Integer[] sub, int i)
	{		
		if(i == arr.length)
			printASubset(sub);
		
		else
		{
			sub[i] = null;
			subsetRecursive(arr, sub, i+1);	
			
			sub[i] = arr[i];
			subsetRecursive(arr, sub, i+1);	
		}		
	}
	
	
	private void printASubset(Integer[] sub) 
	{
		
		
		
	}


	public static void main(String[] args) 
	{
		
		

	}

}
