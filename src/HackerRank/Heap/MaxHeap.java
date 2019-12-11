package HackerRank.Heap;

import java.util.PriorityQueue;

public class MaxHeap {

	// max heap
	
		// insert
		// remove
		// print
		
		int[] heap;
		int index = 0;
		
		public MaxHeap(int size)
		{
			this.heap = new int[size]; 
		}
		
		public void insert(int val)
		{
			if (index >= heap.length)
				return;
			
			int parent = (index-1)/2;
			int child = index;
			
			heap[index++] = val;		
			
			while(parent >= 0)
			{
				if(heap[child] > heap[parent])
					swap(parent, child);
				else
					break;
				
				child = parent;
				parent = (child-1)/2;
			}
		}
		
		public void insertMin(int val)
		{
			if (index >= heap.length)
				return;
			
			int parent = (index-1)/2;
			int child = index;
			
			heap[index++] = val;		
			
			while(parent >= 0)
			{
				if(heap[child] < heap[parent])
					swap(parent, child);
				else
					break;
				
				child = parent;
				parent = (child-1)/2;
			}
		}
		
		public void remove()
		{
			if(index <= 0)
				return;
			
			swap(0, --index);
			heap[index] = 0;
			
			int parent = 0;
			int left   = 2*parent+1;
			int right  = 2*parent+2;
			
			while(left < heap.length && right < heap.length)
			{
				if(heap[parent] < heap[left] && heap[left] >= heap[right])
				{
					swap(parent, left);
					
					parent = left;
					left   = 2*parent+1;
					right  = 2*parent+2;
				}			
				else if(heap[parent] < heap[right] &&  heap[right] > heap[left])
				{
					swap(parent, right);
					
					parent = right;
					left   = 2*parent+1;
					right  = 2*parent+2;
				}
				else
					break;
			}
			
		}
		
		private void swap(int a, int b)
		{
			int temp = heap[a];
			heap[a] = heap[b];
			heap[b] = temp;		
		}
		
		public void printHeap()
		{
			System.out.println();
			for(int a : heap)
			{
				if(a == 0)
					break;
				System.out.print(a + ", ");
			}
				
		}
	
	public static void main(String[] args) {
		
		MaxHeap mh = new MaxHeap(10);
		MaxHeap minh = new MaxHeap(10);
		
//		mh.insert(5);
//		mh.insert(4);
//		mh.insert(3);
//		mh.insert(2);
//		mh.insert(1);
//		mh.insert(2);
//		mh.insert(1);
//		
//		mh.printHeap();
//		mh.insert(7);	
//		mh.printHeap();
//		mh.remove();
//		mh.printHeap();
//		
//		mh.remove();
//		mh.printHeap();
//		
//		mh.remove();
//		mh.printHeap();
//		
//		mh.remove();
//		mh.printHeap();
//		
//		mh.remove();
//		mh.printHeap();
//		
//		mh.insert(5);
//		mh.printHeap();
//		mh.insert(4);
//		mh.printHeap();
//		mh.insert(3);
//		mh.printHeap();
//		
//		mh.remove();
//		mh.printHeap();
//		mh.remove();
//		mh.printHeap();
//		mh.remove();
//		mh.printHeap();
//		mh.remove();
//		mh.printHeap();
//		mh.remove();
//		mh.printHeap();
//		mh.remove();
//		mh.printHeap();
//		
//		mh.remove();
//		mh.printHeap();
//		System.out.println();
		
		mh.insert(1);
		mh.printHeap();
		mh.insert(2);
		mh.printHeap();
		mh.insert(3);
		mh.printHeap();
		mh.insert(4);
		mh.printHeap();
		mh.insert(5);
		mh.printHeap();
		mh.insert(6);
		mh.printHeap();
		mh.insert(7);
		mh.printHeap();
		mh.insert(8);
		mh.printHeap();
		mh.insert(9);
		mh.printHeap();
		mh.insert(10);
		mh.printHeap();
		
		System.out.println();
		
		minh.insertMin(10);
		minh.printHeap();
		minh.insertMin(9);
		minh.printHeap();
		minh.insertMin(8);
		minh.printHeap();
		minh.insertMin(7);
		minh.printHeap();
		minh.insertMin(6);
		minh.printHeap();
		minh.insertMin(5);
		minh.printHeap();
		minh.insertMin(4);
		minh.printHeap();
		minh.insertMin(3);
		minh.printHeap();
		minh.insertMin(2);
		minh.printHeap();
		minh.insertMin(1);
		minh.printHeap();

		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((n1,n2) -> n2-n1);
		
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		for(int i=0; i<arr.length; i++)
			maxHeap.add(arr[i]);
		
		for(int i=arr.length-1; i>=0; i--)
			minHeap.add(arr[i]);
		
		System.out.println();
	}

}





























