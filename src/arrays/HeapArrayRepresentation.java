package arrays;

public class HeapArrayRepresentation {

	
	// max heap
	// insert
	// remove
	
	int[] heap;
	int index = 0;
	
	public HeapArrayRepresentation(int size)
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
	
	public static void main(String[] args) 
	{		
		
		HeapArrayRepresentation mh = new HeapArrayRepresentation(10);
		
		mh.insert(5);
		mh.insert(4);
		mh.insert(3);
		mh.insert(2);
		mh.insert(1);
		mh.insert(2);
		mh.insert(1);
		
		mh.printHeap();
		mh.insert(7);	
		mh.printHeap();
		mh.remove();
		mh.printHeap();
		
		mh.remove();
		mh.printHeap();
		
		mh.remove();
		mh.printHeap();
		
		mh.remove();
		mh.printHeap();
		
		mh.remove();
		mh.printHeap();
		
		mh.insert(5);
		mh.printHeap();
		mh.insert(4);
		mh.printHeap();
		mh.insert(3);
		mh.printHeap();
		
		mh.remove();
		mh.printHeap();
		mh.remove();
		mh.printHeap();
		mh.remove();
		mh.printHeap();
		mh.remove();
		mh.printHeap();
		mh.remove();
		mh.printHeap();
		mh.remove();
		mh.printHeap();
		
		mh.remove();
		mh.printHeap();
		System.out.println();
	}
	
}








