package HackerRank.Stacks;


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
	
	public static void main(String[] args) {
		
		int[] pest = {6, 5, 8, 4, 7, 10, 9};

		poisonousPlants(pest);
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





























