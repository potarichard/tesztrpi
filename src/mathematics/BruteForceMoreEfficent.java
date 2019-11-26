package mathematics;

import java.util.LinkedList;
import java.util.List;

public class BruteForceMoreEfficent 
{
	private List<Integer> primeNumbers = new LinkedList<>();
	
	public List<Integer> generate(int n) 
	{	    
		primeNumbers.clear();
		
	    if (n >= 2) 
	        primeNumbers.add(2);
	    
	    for (int i = 3; i <= n; i += 2) 
	    {
	        if (isPrimeBruteForce(i)) 
	            primeNumbers.add(i);
	    }
	    
	    return primeNumbers;
	}
	
	
	private boolean isPrimeBruteForce(int number) 
	{
	    for (int i = 2; i*i <= number; i++) 
	    {
	        if (number % i == 0) 
	            return false;
	    }
	    
	    return true;
	}
	
	public void print()
	{
		for(Integer prime : primeNumbers)
			System.out.print(prime + " ");
	}
}
