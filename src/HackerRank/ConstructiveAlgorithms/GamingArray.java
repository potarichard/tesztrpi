package HackerRank.ConstructiveAlgorithms;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class GamingArray {

	// Bob start Andy next
	// remove max item and all of its right
	// if removed Item's index was 0 its over
	// track even and odd turn
    public static String gamingArray(List<Integer> arr) 
    {    
    	class Item
    	{
    		int val, index;

			public Item(int val, int index) {
				super();
				this.val = val;
				this.index = index;
			}
    	}
    	
    	boolean bob_s_turn = true;
    	
    	PriorityQueue<Item> que = new PriorityQueue<Item>( (a,b) -> b.val-a.val);

    	for(int i=0; i<arr.size(); i++)
    		que.add(new Item(arr.get(i), i));    		
    	
    	int index = que.peek().index;
    	
    	while(!que.isEmpty())
    	{
    		Item item = que.poll();
    		
    		while(item.index > index && !que.isEmpty())
    			item = que.poll();
    		
    		index = item.index;
    		
    		if(index == 0)
    			break;
    		
    		bob_s_turn = !bob_s_turn;
    	}
    	
    	if(!bob_s_turn)
    		return "Andy";
    	
    	return "Bob";
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> arr = Arrays.asList(2, 3, 6, 5, 4, 1);
		
		gamingArray(arr);
	}

}












