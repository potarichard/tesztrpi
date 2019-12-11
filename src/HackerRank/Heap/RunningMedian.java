package HackerRank.Heap;

import java.util.PriorityQueue;

public class RunningMedian {

	// kell egy min es egy max heap
	// uj elem kisebb mint maxheap peek akkor a minheapbe megy
	static double[] runningMedian(int[] a) 
	{
		 double[] ret = new double[a.length];
		 double median;
 		 boolean even = true;
		 int num;
		 
		 PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		 PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((n1,n2) -> n2-n1);
		 
		 for(int i=0; i<a.length; i++)
		 {
			 num = a[i];
			 
			 if(even)
			 {				 				 
				 minHeap.add(num);
				 even = false;
			 }
			 else
			 {
				 maxHeap.add(num);
				 even = true;
			 }
			 
			 if(even)
			 {
				 median = minHeap.peek() + maxHeap.peek();
				 median /= 2;
			 }
			 else
				 median = minHeap.peek();
			 
			 ret[i] = median;
		 }
		 
		 return ret;
	}
	
	static double[] runningMedianQ(int[] a) 
	{
		 double[] ret = new double[a.length];
		 double median = a[0];
		 int num;
		 
		 PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		 PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((n1,n2) -> n2-n1);			 
		 
		 for(int i=0; i<a.length; i++)
		 {
			num = a[i];
			
			if(num > median)
				minHeap.add(num);
			else
				maxHeap.add(num);
			
			if(minHeap.size() - maxHeap.size() > 1)
				maxHeap.add(minHeap.poll());
			if(maxHeap.size() - minHeap.size() > 1)
				minHeap.add(maxHeap.poll());
			
			if(minHeap.size() == maxHeap.size())
				median = (minHeap.peek() + maxHeap.peek()) / 2.0;
			else
			{
				if(minHeap.size() > maxHeap.size())
					median = minHeap.peek();
				else
					median = maxHeap.peek();
			}
			 
			ret[i] = median;
		 }
		 
		 return ret;
	}
	
	public static void main(String[] args) {


		int[] arr = {12, 4, 5, 3, 8, 7};
		
//		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		runningMedianQ(arr);
	}

}













