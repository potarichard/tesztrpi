package HackerRank.Searching;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IceCreamParlor {

	// make a map -> loop each value, get the other, ret indexes
	
	   static class IceCream implements Comparable<IceCream>
	   {
		   int cost, index;

		   public IceCream(int cost, int index) 
		   {
				this.cost = cost;
				this.index = index;
		   }

		@Override
		public int compareTo(IceCream o) 
		{			
			if(this.cost > o.cost)
				return 1;
			else if(this.cost < o.cost)
				return -1;
			return 0;
		}		   
		   
	   }
	
	// make icecream class, sort by cost, save index, binary search
   static int[] icecreamParlor(int m, int[] arr) 
   {
	   IceCream[] ices = new IceCream[arr.length];
	   
	   for(int i=0; i<arr.length; i++)
		   ices[i] = new IceCream(arr[i], i+1);
		   
	   Arrays.sort(ices);
	   
	   for(IceCream ice : ices)
	   {
		   int pair = m - ice.cost;
		   int pair_index = bSearch(ices, pair, ice.index, 0, ices.length);
		   
		   if(pair_index != -1)
		   {
			   int[] ret = {ice.index, pair_index};
			   return ret;
		   }
	   }
	   
	   return null;	   
   }
   
   static int bSearch(IceCream[] ices, int num, int index, int start, int end)
   {
	   int mid = (start+end)/2;
	   
	   if(start < end)
	   {
		   if(num == ices[mid].cost && index != ices[mid].index)
			   return ices[mid].index;
		   else if(num < ices[mid].cost)
			   mid = bSearch(ices, num, index, 0, mid);
		   else
			   mid = bSearch(ices, num, index, mid+1, end);
	   }	   
	  
	   else
		   return -1;
	   
	   return mid;
   }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {1, 4, 5, 3, 2};
		
		icecreamParlor(4, arr);
		
	}

}









