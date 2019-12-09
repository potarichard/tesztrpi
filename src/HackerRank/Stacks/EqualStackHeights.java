package HackerRank.Stacks;

import java.util.Stack;

public class EqualStackHeights {

	// a stackben a szamok osszege = magasság
	// mindegyikbol annyit kell kivenni hogy egyfdorma magasak legyenek
	static int equalStacks(int[] h1, int[] h2, int[] h3) 
	{		
		if(h1.length == 0 || h2.length == 0 || h3.length == 0)
			return 0;
		
		int ind_h1 = h1.length-1, ind_h2 = h2.length-1, ind_h3 = h3.length-1;
		int sum_height1 = 0, sum_height2 = 0, sum_height3 = 0;
		
		Stack<Integer> stack_h1 = new Stack<Integer>();
		Stack<Integer> stack_h2 = new Stack<Integer>();
		Stack<Integer> stack_h3 = new Stack<Integer>();
		
		// nem kell a stack, elég az elejérõl kivenni majd a dolgokat, sum után indexeket 0 és kész
		
		while(true)
		{
			if(ind_h1 >= 0)
			{
				stack_h1.push(h1[ind_h1]);
				sum_height1 += h1[ind_h1--];
			}
				
			if(ind_h2 >= 0)
			{
				stack_h2.push(h2[ind_h2]);
				sum_height2 += h2[ind_h2--];
			}
				
			if(ind_h3 >= 0)
			{
				stack_h3.push(h3[ind_h3]);
				sum_height3 += h3[ind_h3--];
			}
				
			
			if(ind_h1 < 0 && ind_h2 < 0 && ind_h3 < 0)
				break;
		}
		
		while(true)
		{
			if(stack_h1.isEmpty() && stack_h2.isEmpty() && stack_h3.isEmpty())
			{
				if(sum_height1 == sum_height2 && sum_height2 == sum_height3)
					return sum_height1;
				else
					return 0;
			}
				
			if(sum_height1 == sum_height2 && sum_height2 == sum_height3)
				return sum_height1;
			
			
//			1.			
			if(sum_height1 > sum_height2)
			{
				sum_height1 -= stack_h1.pop();
				continue;
			}
			
//			2.
			else if(sum_height1 < sum_height2)
			{
				sum_height2 -= stack_h2.pop();
				continue;
			}
			
//			3.
			else if(sum_height1 == sum_height2)
			{
				// ha h3 nagyobb akkor elvesz belole
				if(sum_height3 > sum_height2)
				{
					sum_height3 -= stack_h3.pop();
					continue;
				}
				
				// ha h3 kissebb akkor elvesz h1bol
				if(sum_height3 < sum_height2)
				{
					sum_height1 -= stack_h1.pop();
					continue;
				}
			}
			
			break;
		}
		
		return 0;
	}
	
	// h1 = h2 , ha ez megvan akkor h2 es h3 osszevetése
	
	public static void main(String[] args) 	
	{
		
		int[] h1 = {3, 2, 1, 1, 1};		// 8
		int[] h2 = {4, 3, 2};			// 9
		int[] h3 = {1, 10, 2, 1};		// 7
		
		
		equalStacks(h1, h2, h3);
	}

}













