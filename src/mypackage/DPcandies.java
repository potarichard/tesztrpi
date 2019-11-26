package mypackage;

public class DPcandies 
{

	static int minCandies(int[] rates, int n)
	{
		int candy = 1;
		int sum = 0;
		
		for(int i=0; i<rates.length; i++)
		{
			if(i>0 && rates[i] > rates[i-1])
				candy++;
			else if(i>0 && rates[i] <= rates[i-1])
				candy /= 2;
			
			sum += candy;
				
		}
		
		return sum;
	}
	
	public static void main(String[] args) 
	{
	
		int[] ratings = {4, 6, 4, 5, 6, 2}; 		// loop elsonek 1 candy kovi ha tobb candy+1, ha kovi kisebb = candy resets to 1  ret 10

		System.out.println(minCandies(ratings, 10));
		
//		2, 4, 2, 6, 1, 7, 8, 9, 2, 1		// ret 19  1 2 1 2 1 2 3 4 1 1
	}

}
