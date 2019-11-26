package mathematics;

public class SieveOfEratosthenes 
{

	boolean[] prime;
	int[] primes;
	
	void generate(int n) 
    { 
        // Create a boolean array "prime[0..n]" and initialize 
        // all entries it as true. A value in prime[i] will 
        // finally be false if i is Not a prime, else true. 
        prime = new boolean[n+1]; 
        
        for(int i=0; i<n; i++) 
            prime[i] = true; 
          
        for(int p = 2; p*p <=n; p++) 
        { 
            // If prime[p] is not changed, then it is a prime 
            if(prime[p] == true) 
            { 
                // Update all multiples of p 
                for(int i = p*p; i <= n; i += p) 
                    prime[i] = false; 
            } 
        }               
    } 
	
	
	public void print()
	{
		int j = 0;
		primes = new int[prime.length];
		
		for(int i = 2; i < prime.length; i++) 
        { 
            if(prime[i] == true)
            	primes[j++] = i;
        }
		
        for(int i = 0; i < primes.length; i++) 
        { 
            if(primes[i] == 0) 
            	break;
                
            System.out.print(primes[i] + " "); 
        } 
	}
	
}
















