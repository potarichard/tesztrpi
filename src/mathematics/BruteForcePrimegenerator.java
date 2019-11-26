package mathematics;


public class BruteForcePrimegenerator 
{
	private int[] primeNumbers;
	
	public void generate(int n) 
	{	    
		primeNumbers = new int[n];
		int j = 0;
		
	    for (int i = 2; i <= n; i++) 
	    {
	        if (isPrimeBruteForce(i)) 
	            primeNumbers[j++] = i;
	    }	    
	}
	
	private boolean isPrimeBruteForce(int number) 
	{
	    for (int i = 2; i < number; i++) 
	    {
	        if (number % i == 0) 					// can divide with 2, 3, 4 ... number  ?
	            return false;
	    }
	    return true;
	}

	public void print()
	{
		for(Integer prime : primeNumbers)
		{
			if(prime == 0)
				break;
			System.out.print(prime + " ");
		}
			
	}
}
