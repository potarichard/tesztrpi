package mypackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SearchTripleSum 
{

	// 3 arr, sort, kozepso loop, meg ket pointer egy az a nak egy a bnek
	// csinaljon 3 tagu arrayt hameg nincs olyan szamolja meg
	// arrays.sort O?
	
	public static int triplets(int[] a, int[] b, int[] c)
	{
		int count = 0;		
		int ai = 0, bi = 0, ci = 0;
		
		boolean other = false;
		
		while(bi < b.length)
		{
			
			if(a[ai] > b[bi] || c[ci] > b[bi])
			{
				bi++;
				ai = 0;
				ci = 0;
				continue;
			}
			
			
			if(ai < a.length && a[ai] <= b[bi])
			{
				if(c[ci] <= b[bi])
				{
					count++;
					System.out.println(a[ai] + ", " + b[bi] + ", " + c[ci]);	// ezeket el lehetne tarolni...
				}
				
				ai++;	
				
				if(ai >= a.length)
				{
					ai = 0;
					ci++;
					
					if(ci >= c.length)
						break;
				}
			}
			

			
			
		}
		
		System.out.println();
		
		return count;
	}
	
	
	
	
	
	public static int triplets3(int[] a, int[] b, int[] c)
	{	
		int ai = 0, bi = 0, ci = 0;
		
		Set<ArrayList<Integer>> trips = new HashSet<ArrayList<Integer>>();
		ArrayList<Integer> trip;
		
		while (bi < b.length)
		{
			while (ai < a.length && a[ai] <= b[bi])			// a tomb ai ig jo az index
				ai++;      
		        
			while (ci < c.length && c[ci] <= b[bi])
				ci++;		        
		        
//		    System.out.println("b index: " + bi + " a max: " + ai + " c max: " + ci);
		    
		    
		    for(int i=0; i<ai; i++)
		    {		    	
		    	for(int j=0; j<ci; j++)
		    	{		    		
		    		trip =  new ArrayList<Integer>(3);
		    		trip.add(a[i]);
		    		trip.add(b[bi]);
		    		trip.add(c[j]);
		    		
		    		trips.add(trip);
		    	}
		    }
		    
		    bi++;
		}
		       
			
		
		return trips.size();
	}
	
	
	
	public static void main(String[] args) 
	{
		
		int[] a = {1, 3, 5, 7};
		int[] b = {5, 7, 9};
		int[] c = {7, 9, 11, 13};
		
//		int[] a = {1, 4, 5};
//		int[] b = {2, 3, 3};
//		int[] c = {1, 2, 3};
		
		
		System.out.println(triplets3(a,b,c));
	}

}
















