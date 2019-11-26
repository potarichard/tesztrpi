package mypackage;


// https://www.geeksforgeeks.org/count-set-bits-in-an-integer/#targetText=Brian%20Kernighan's%20Algorithm%3A&targetText=If%20we%20do%20n%20%26%20(n,bits%20in%20a%20given%20integer.

public class GreedyMinimumDiffArr 
{

	static int getMinDiff(int[] arr)
	{
		int max = (int) Math.pow(2, arr.length);
		int k, sum, min_sum = Integer.MAX_VALUE;
		Integer[] two = new Integer[2];
		
		
		for(int i=3; i<max; i++)
		{			
			k = 0;
			
			if( (i & i-1) == 0 )				// skip all where only 1 bit is set
				continue;
			
			for(int j=0; j<arr.length; j++)
			{					
				if((1<<j & i) > 0)
				{
					if(k<2)
						two[k++] = arr[j];
					else
					{
						k = 0;
						break;
					}						
				}					
			}
			
			if(k==2)
			{
				sum = Math.abs(two[0]-two[1]);
				min_sum = Math.min(min_sum, sum);
			}	
		}		
		
		return min_sum;		
	}
	
	
	
	static int justPLaying(int[] arr)
	{
		int max = (int) Math.pow(2, arr.length);
		String bin;
		
		for(Integer i=3; i<max; i++)
		{
			bin = i.toBinaryString(i);
			
			System.out.println(bin + " - " + Integer.bitCount(i) 
			+ " msb: " + Integer.highestOneBit(i)
			+ " lsb: " + Integer.lowestOneBit(i));
		}
		
		return 0;
	}
	
	
	static int getMinDiff3(int[] arr)
	{
		int max = (int) Math.pow(2, arr.length);
		int[] two = new int[2];
		int k, sum, min_sum = Integer.MAX_VALUE;
		
		for(Integer i=3; i<max; i++)
		{
			if(Integer.bitCount(i) != 2)
				continue;
			
			k = 0;
			sum = 0;
			
			for(int j=0; j<arr.length; j++)
			{					
				if((1<<j & i) > 0)
				{
					if(k<2)
						two[k++] = arr[j];
					if(k==2)
						break;
				}
			}
			
			sum = Math.abs(two[0]-two[1]);
			min_sum = Math.min(min_sum, sum);			
			
		}
		
		return min_sum;
	}
	
	static int getMinDiff4(int[] arr)
	{
		int max = (int) Math.pow(2, arr.length);
		int[] two = new int[2];
		int k, sum, min_sum = Integer.MAX_VALUE;
		
		for(Integer i=3; i<max; i++)
		{
			if(countSetBits(i) != 2)
				continue;
			
			k = 0;
			sum = 0;
			
			for(int j=0; j<arr.length; j++)
			{					
				if((1<<j & i) > 0)
				{
					if(k<2)
						two[k++] = arr[j];
					if(k==2)
						break;
				}
			}
			
			sum = Math.abs(two[0]-two[1]);
			min_sum = Math.min(min_sum, sum);			
			
		}
		
		return min_sum;
	}
	
	static int countSetBits(int n) //  O(logn)
    { 
        int count = 0; 
        while (n > 0) 
        { 
            n &= (n - 1) ; 
            count++; 
        } 
        return count; 
    } 
	
	public static void main(String[] args) 
	{
		
		int[] arr = {-2, 2, 4};
		
		getMinDiff4(arr);

	}

}


















