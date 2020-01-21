package HackerRank.Greedy;

public class CheifHopper {

	// backward energy is >= 0 at last
	// energy at any point mst be > 0 !
	// 0 2 3 5 7 10 4 2 6
    // minimum start energy to reach the end (6)
	// 1. if energy = 4 es next height = 7  -> newenergy = energy - (height - energy)  so 4 - (7-4) = 1
	// 2. if energy = 4 es next height = 2  -> newenergy = energy + (energy - height)  so 4 + (4-7) = 1
	
	// same 	ne = 2e-h 		e = (ne+h)/2  
	
	// example: 2,3,4,3,2  -> minimum = 3    
	
	// from 3 to 2 what is the min ? 2 nel legyen new energy = 1
	// 1 = energy + (2 - energy) -> 1 = e + 2 -e
	// end ne = 0 ? 
	static int chiefHopper(int[] arr) 
	{
		int i = arr.length-1;		
		int energy = 0;	
		
		while(i >= 0)
			energy = (int) Math.ceil((energy + arr[i--]) / 2.0);	
		
    	return energy;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {2,3,4,3,2};
		
		chiefHopper(arr);

	}

}
