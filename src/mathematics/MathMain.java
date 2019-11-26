package mathematics;

public class MathMain {

	public static void main(String[] args) 
	{
		try 
		{
			Thread.sleep(2000);
		} catch (InterruptedException e) {e.printStackTrace();}
		
		long start = System.currentTimeMillis();
		
//		SieveOfAtkin satk = new SieveOfAtkin();
//		satk.generatePrimes(100000000);			// 100,000 -> 6 ms ; 1,000,000 -> 15 ms ; 10,000,000 -> 128 ms ; 100,000,000 -> 1311 ms
		
//		SieveOfEratosthenes serat = new SieveOfEratosthenes();		
//		serat.generate(10000000);				// 100,000 -> 2 ms ; 1,000,000 -> 11 ms; 10,000,000 -> 130 ms ; 100,000,000 -> 1580 ms
//		serat.print();
		
//		BruteForcePrimegenerator bfpg = new BruteForcePrimegenerator();
//		bfpg.generate(20);						// 1,000 -> 2 ms ; 10,000 -> 21 ms ; 100,000 -> 1329 ms ; 1,000,000 -> terminated due to timeout
//		bfpg.print();
		
//		BruteForceMoreEfficent bfme = new BruteForceMoreEfficent();
//		bfme.generate(1000000);					// 10,000 -> 3 ms ; 100,000 -> 15 ms; 1,000,000 -> 260 ms
//		bfme.print();
		
		
		
		long runtime = System.currentTimeMillis() - start;
		System.out.println("\n\n" + runtime + " ms");
	}

}
