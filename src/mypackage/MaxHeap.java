package mypackage;

public class MaxHeap 
{
	int[] heap;
	int size;
	
	public MaxHeap(int size)
	{
		heap = new int[size];
		this.size = 0;
	}

	public void push(int value) throws MyExc
	{
		if(this.size == this.heap.length)
			throw new MyExc();
		
		heap[size] = value;			// put the new element to the end of the heap!  then do bubbling
		
		int 	pos = size;
		int		parent;
		
		while(pos > 0)
		{			
			parent = (pos + 1) / 2 - 1;
			
			if(heap[parent] >= heap[pos]) 
				break;			
			swap(parent, pos);
			pos = parent;			
		}
		
		size++;
	}
	
	public int pop() throws MyExc
	{
		if(size == 0)
			throw new MyExc();
		
		int ret = heap[0];
		heap[0] = heap[size-1];						// root = to the last element in the heap! then do bubbling
		heap[size-1] = 0;
		size--;
		
		int pos = 0;
		int left, right;
		
		while(pos < size/2)							// eddig vannak childok egy adott indexen levo elemnek		
		{
			left  = pos * 2 + 1;
			right = pos * 2 + 2;
			
			if(right < size && heap[left] < heap[right])
			{
				if(heap[pos] >= heap[right])
					break;
				swap(pos, right);
				pos = right;
			}
			
			else
			{
				if(heap[pos] >= heap[left])
					break;
				swap(pos, left);
				pos = left;
			}
		}
		
		return ret;
	}
	
	public void printHeap()
	{
		for(int i=0; i<size; i++)
		{
			System.out.println(heap[i]);
		}
	}
	
	private void swap(int i, int j) 
	{		
		int temp = heap[i];
		heap[i]  = heap[j];
		heap[j]  = temp;		
	}

	private static class MyExc extends Exception
	{
		private static final long serialVersionUID = 1L;

		public MyExc()
		{
			System.out.println("Allj, szar!");
		}
		
	}
	
	
	public static void main(String[] args) throws MyExc 
	{
		
		MaxHeap maxheap = new MaxHeap(10);
		
		maxheap.push(8);		
		maxheap.push(4);
		maxheap.push(3);		
		maxheap.push(6);
		maxheap.push(9);		
		maxheap.push(8);		
		maxheap.push(4);
		maxheap.push(3);
		maxheap.push(13);		
		maxheap.push(1);
		

		maxheap.pop();
		
		maxheap.printHeap();
		
		System.out.println();
	}

	
	

}












