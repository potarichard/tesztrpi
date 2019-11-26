package mypackage;

import java.util.HashMap;
import java.util.Map;

public class SearchIceCream 
{

	// a money alapjan kell 2 itemet valasztani a costbol a ketto osszege money kell hogy legyen
	// ki kell printelni a ket cost indexet (index+1 mert nem 0 as bazisut akar latni)
	public static void whatFlavors(int[] cost, int money) 
	{

		// ez a feladat olyan mint a twosum
		
		//   k-ertek, v-index
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		// loop on elements , if sum - elem benne van a mapban akkor adja vissza az indexet

		int remainder = 0;
		int index_1 = 0, index_2 = 0;
		
		for(int i=0; i<cost.length; i++)
		{
			remainder = money-cost[i];
			if(map.get(remainder) != null)
			{
				index_1 = map.get(remainder) + 1;
				index_2 = i + 1;
				break;
			}
			else
				map.put(cost[i], i);
		}
		
		System.out.println(index_1 + " " + index_2);
    }
	
	public static void main(String[] args) 
	{
		
		int[] cost = new int[] {2, 1, 3, 5, 6};
		
		whatFlavors(cost, 5);
		
	}

}
