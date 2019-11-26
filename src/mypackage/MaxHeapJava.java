package mypackage;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxHeapJava 
{

	
	
	public static void main(String[] args) 
	{
		PriorityQueue<Integer> minHeapQueue =  new PriorityQueue<Integer>(); 
		PriorityQueue<Integer> maxHeapQueue =  new PriorityQueue<Integer>(Collections.reverseOrder()); 
	  
//		max heap
        maxHeapQueue.add(10); 
        maxHeapQueue.add(30); 
        maxHeapQueue.add(20); 
        maxHeapQueue.add(400);         
        maxHeapQueue.poll();
        
        System.out.println();
        
//		min heap
        minHeapQueue.add(10); 
        minHeapQueue.add(3); 
        minHeapQueue.add(2); 
        minHeapQueue.add(40);         
        minHeapQueue.poll();
        
        System.out.println();
	}

}
