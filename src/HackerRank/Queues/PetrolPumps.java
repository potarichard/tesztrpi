package HackerRank.Queues;

import java.util.LinkedList;
import java.util.Queue;

public class PetrolPumps {

	
	static int truckTour(int[][] petrolpumps) 
	{
        
		int start = 0, end = 0;		
		int gas = 0, distanceToNext;
		int tank = 0;
		
		boolean round = false;
		
		for(int i=start; i<petrolpumps.length; i++)
		{
			gas 			= petrolpumps[i][0] + tank;
			distanceToNext 	= petrolpumps[i][1];			
			
			if(gas < distanceToNext)
			{
				end = i+1;
				round = false;
				tank = 0;
				continue;
			}
			
			else if(round && i == end)
				return end;			
			else if(!round && i == end)
			{
				end = -1;
			}
			
			tank = gas - distanceToNext;
			
			if(i >= petrolpumps.length-1 && i != end)
			{
				i = -1;
				round = true;
			}				
		}
		
		return 0;		
    }
	
	
	static int truckTourQ(int[][] petrolpumps) 
	{
		class GasPump
		{
			int gas, distance;

			public GasPump(int gas, int distance) {
				super();
				this.gas = gas;
				this.distance = distance;
			}
		}
		
       Queue<GasPump> stations = new LinkedList<GasPump>();
       
       int start = 0, tank = 0;
       boolean[] visited = new boolean[petrolpumps.length];
       
       stations.add(new GasPump(petrolpumps[start][0], petrolpumps[start][1]));
       visited[start] = true;
       
       while(!stations.isEmpty())
       {
    	   GasPump stop = stations.poll();
    	   
    	   tank += stop.gas - stop.distance;
    	   
    	   start++;
    	   
    	   if(start >= petrolpumps.length)
			   start = 0;
    	   
    	   if(tank < 0)
    	   {
    		   visited = new boolean[petrolpumps.length];    		   
    		   tank = 0;
    	   }
    	   else if(visited[start])
    		   return start;
    	   
    	   stations.add(new GasPump(petrolpumps[start][0], petrolpumps[start][1]));
		   visited[start] = true;
       }
       
       return 0;
	}
	
	// ahhoz hogy vegigmenjen 2 es kuttól kell indulni
	// 1. start 10
	// 2. 10 - 3 = 7 + 3 = 10
	// 3. 10 - 4 = 6 + 1 = 7
	// 4. finish 7 - 5 = 2-
	
	
	// 
	public static void main(String[] args) 
	{
		
		int[][] petrolpumps = { {1,5}, {10,3}, {3,4} };

		truckTourQ(petrolpumps);
	}

}











