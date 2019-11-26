package mypackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraySubset 
{

	// new array same length all null, 
	// 1. case add current item
	// 2. case do not add current item
	public void printAllSubsetsRecursively(int[] arr)
	{
		System.out.print("\n Recursive subset \n ");
		Integer[] subset = new Integer[arr.length];
		
		subsetRecursive(arr, subset, 0);
		
		return;
	}
	
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
	
//	bitshift
//	1 << 0 = `0000 0001`		1 = 2^0
//	1 << 1 = `0000 0010`		2 = 2^1
//	1 << 2 = `0000 0100`		4 = 2^2
//	....
	
	public void printAllSubsetsIterative(int[] arr)
	{		
		// ugy kell elkepzelni itt a tonmbot mint egy binarisan felirt szam   000, 001, 010, 100, 011, ... ha az adott indexen 1 es akkor beletesz
				
		System.out.print("\n Iterative subset \n ");
		
//		int teszt = 0;
//		
//		teszt = 23 << 2;
		
//		
//		teszt = 1 >> 0;
//		teszt = 1 >> 1;
//		teszt = 1 >> 2;
//		teszt = 1 >> 3;
		
//		int max = (int) Math.pow(2, arr.length);		
		int max = 1 << arr.length;
		
		int mask;
		
		for(int i=0; i<max; i++)
		{
			
			System.out.print("\n{ ");
			
			for(int j=0; j<arr.length; j++)
			{
				mask = 1<<j;						// az index maskja, vagy maskeppen a bitminta azon a helyierteken levo erteke igy lehet : 1, 2, 4, 8, 16 ... 2^i
				if((mask & i) > 0)
					System.out.print(arr[j] + " ");
			}
			
			System.out.print("}\n");
		}
		
	}
	
	public List<List<Integer>> getAllSubsetsIterative(int[] arr)
	{
		
		// ugy kell elkepzelni itt a tonmbot mint egy binarisan felirt szam   000, 001, 010, 100, 011, ... ha az adott indexen 1 es akkor beletesz
		
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		List<Integer> temp;
		
		int max = (int) Math.pow(2, arr.length);
		
		for(int i=0; i<max; i++)
		{			
			temp = new ArrayList<Integer>();
			
			for(int j=0; j<arr.length; j++)
			{
				if((1<<j & i) > 0)
					temp.add(arr[j]);
			}
			
			ret.add(temp);
		}
		
		return ret;
		
	}
	
	public List<List<Integer>> getAllSubsetsRecursively(int[] arr)
	{
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Integer[] subset = new Integer[arr.length];
		
		
		backtrack(list, subset, arr, 0);
		
		return list;
	}
	
	private void backtrack(List<List<Integer>> list, Integer[] sub, int[] arr, int i)
	{			
		
		if(i == arr.length)
		{			
			List<Integer> temp = new ArrayList<Integer>();
			for(int k=0; k<sub.length; k++)
				if(sub[k] != null)
					temp.add(sub[k]);
			
			list.add(temp);
		}
			
		
		else
		{
			sub[i] = null;
			backtrack(list, sub, arr, i+1);
			
			sub[i] = arr[i];
			backtrack(list, sub, arr, i+1);
		}		
				
	}
	
	private void printASubset(Integer[] sub)
	{
		System.out.print("\n{ ");
		for(int i=0; i<sub.length; i++)
			if(sub[i] != null)
				System.out.print(sub[i] + " ");
		System.out.print("}\n");
	}
	
	
	public List<List<Integer>> getSubsetsOfSum(int[] arr, int sum)
	{		
		List<List<Integer>> list = new ArrayList<List<Integer>>();		
		
		backtrackOfSumStandard(list, new ArrayList<Integer>(), arr, sum, 0);
		
		Arrays.sort(arr);		
		
		@SuppressWarnings("unused")
		int count = backtrackOfSum(list, arr, sum, arr.length-1);			// arr must be sorted

		
		return list;
	}
	
	private int backtrackOfSum(List<List<Integer>> list, int[] arr, int sum, int i)
	{		
		int count = 0;
		
		if(sum == 0)
			return 1;
		else if(sum<0)
			return 0;
		else if(i<0)
			return 0;	
		
		
		else if(sum < arr[i]) 	// gon on, subset cant be good
			count = backtrackOfSum(list, arr, sum, i-1);
		else
			return count = backtrackOfSum(list, arr, sum-arr[i], i-1) + backtrackOfSum(list, arr, sum, i-1);		
		
		return count;
	}

	private void backtrackOfSumStandard(List<List<Integer>> list, List<Integer> temp, int[] arr, int sum, int i)
	{			
		if(sum < 0)
			return;
		if(sum == 0)
			list.add(new ArrayList<>(temp));
		
		else
		{			
			for(int k=i; k<arr.length; k++)
			{
				temp.add(arr[k]);
				backtrackOfSumStandard(list, temp, arr, sum-arr[k], k+1);
				temp.remove(temp.size()-1);				
			}
		}
		
	}
	
	public static void main(String[] args) 
	{		
		
		int[] arr = new int[] {0, 4, 2, 6};	// subsets 2^3 = 8db,  {}, {0}, {4}, {2}, {0,4}, {0,2}, {4,2}, {0,4,2}	

		ArraySubset as = new ArraySubset();
		
		as.printAllSubsetsRecursively(arr);
		
		as.printAllSubsetsIterative(arr);
		
		as.getAllSubsetsRecursively(arr);
		
		as.getAllSubsetsIterative(arr);
		
		as.getSubsetsOfSum(arr, 6);
		
		System.out.println();
	}
	
}












