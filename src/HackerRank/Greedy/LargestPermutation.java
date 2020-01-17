package HackerRank.Greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LargestPermutation {

	// ex: 2,1,3 k=1 => 3,1,2
    static int[] largestPermutation(int k, int[] arr) {
    	
		PriorityQueue<Integer> max_heap = new PriorityQueue<Integer>( (a,b) -> b-a);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=0; i<arr.length; i++)
		{
			max_heap.add(arr[i]);			
			map.put(arr[i], i);
		}			
		
		int i = 0;
		
		while(k>0 && i<arr.length && !max_heap.isEmpty())
		{
			Integer num = max_heap.poll();
			Integer max_index = map.get(num);
			
			int temp = arr[i];
			arr[i] = num;
			arr[max_index] = temp;
			
			map.put(temp, max_index);
			map.put(num, i);
			
			i++;
			k--;
		}

		return arr;
    }
    
    // very similar problem
    static int maximumToys(int[] a, int k) 
    {
    	int count = 0;
    	PriorityQueue<Integer> min_heap = new PriorityQueue<Integer>();
    	
    	for(int i=0; i<a.length; i++)
			min_heap.add(a[i]);
    	
    	while(k>0)
    	{
    		k -= min_heap.poll();
    		if(k>0)
    			count++;
    	}
    	
    	return count;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {2,1,3};
		
		largestPermutation(2, arr);
		
	}

}











