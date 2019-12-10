package HackerRank.Stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class poisonusPlants {

	
	// use linked list!
	// while(mods)
//	{for loop plants
	
	static int poisonousPlants(int[] plants) 
	{
		class Plant
		{
			int val;
			Plant next;
			
			public Plant(int val)
			{
				this.val = val;
			}
		}
		
		int days = 0;
		boolean mods = true;
		
		Plant curr = new Plant(plants[0]);
		Plant root = curr;
		
		for(int i=1; i<plants.length; i++)
		{
			curr.next = new Plant(plants[i]);
			curr = curr.next;
		}
			
		curr = root;
		
		while(mods)
		{
			mods = false;
			
			while(curr != null)
			{
				if(curr.next != null && curr.next.val > curr.val)
				{
					mods = true;
					
					Plant break_point = curr.next;
					
					if(break_point.next == null)
						curr.next = null;
					
					else
					{
						while(break_point != null)
						{
							if(break_point.next != null && break_point.next.val < break_point.val)
							{
								curr.next = break_point.next;
								break;
							}
							break_point = break_point.next;
						}
					}					
				}
				
				curr = curr.next;
			}
			
			curr = root;
			
			if(mods)
				days++;
		}
		
		return days;
    }
	
	
	
	// stack lists!	
//	6>5, 8>7>4, 7>3>1>1, 10
	static int poisonousPlantsStackList(int[] plants) 
	{
		if(plants.length <= 0)
			return 0;
		
		int days = 0;
		List<Stack<Integer>> pests = new ArrayList<Stack<Integer>>();
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(plants[0]);
		
		for(int i=1; i<plants.length; i++)
		{
			if(plants[i] <= plants[i-1])
				stack.push(plants[i]);
			else
			{				
				pests.add(stack);
				stack = new Stack<Integer>();
				stack.push(plants[i]);
			}
		}
		
		pests.add(stack);
		
		return days;
	}
	
	// the first always lives
	static int poisonousPlantsList(int[] plants) 
	{		
		if(plants.length <= 0)
			return 0;
		
		int days = 0;
		boolean mods = true;
		boolean[] deaths = new boolean[plants.length];
		Stack<Integer> dieing = new Stack<Integer>();
		
		
		while(mods)
		{
			mods = false;
			
			for(int i=1; i<plants.length; i++)
			{
				if(deaths[i-1] && !deaths[i])
				{
					int living_index = i-2;
					
					while(deaths[living_index] && living_index >= 1)
						living_index--;
					
					if(plants[i] > plants[living_index])
						dieing.push(i);
				}
				else if(plants[i] > plants[i-1] && !deaths[i])
					dieing.push(i);
			}
			
			while(!dieing.isEmpty())
			{
				deaths[dieing.pop()] = true;
				mods = true;
			}
			
			if(mods)
				days++;
		}
		
		
		return days;
	}
	
	static int poisonousPlantsListSimpler(int[] plants) 
	{		
		if(plants.length <= 0)
			return 0;
		
		int days = 0;
		boolean mods = true;
		Stack<Integer> dieing = new Stack<Integer>();
		
		
		while(mods)
		{
			mods = false;
			
			for(int i=1; i<plants.length; i++)
			{
				if(plants[i-1] < 0 && plants[i] > 0)
				{
					int living_index = i-2;
					
					while(plants[living_index] < 0 && living_index >= 1)
						living_index--;
					
					if(plants[i] > plants[living_index])
						dieing.push(i);
				}
				else if(plants[i] > plants[i-1] && plants[i] > 0)
					dieing.push(i);
			}
			
			while(!dieing.isEmpty())
			{
				plants[dieing.pop()] *= -1;
				mods = true;
			}
			
			if(mods)
				days++;
		}
		
		
		return days;
	}
	
	// 1.  4, 3, -7, 5,  -6, 4, 2
	// 2.  4, 3, -7, -5, -6, 4, 2
	// 3.  4, 3, -7, -5, -6, -4, 2
	
	public static void main(String[] args) {
		
					//0  1  2  3  4  5  6
		int[] pest = {4, 3, 7, 5, 6, 4, 2};

//		poisonousPlants(pest);
		
//		poisonousPlantsList(pest);		// ez oke
		
		poisonousPlantsListSimpler(pest);
	}

}



// 1. -> 6 -> 5
// 2. -> 5 -> 8   5 -> 4,     5 <-4
// 3. -> 4 -> 7   4 -> 10
// 4. -> 10 -> 9  



//while(curr != null)
//{
//	if(curr.prev != null && curr.val > curr.prev.prev_val)
//	{
//		mods = true;
//		
//		curr.prev.next = curr.next;		// elozo athidal kovire
//		
//		if(curr.next != null)
//		{
//			curr.next.prev = curr.prev;
//			curr.next.prev.prev_val = curr.val;
//		}						
//	}					
//		
//	curr = curr.next;
//}





























