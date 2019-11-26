package mypackage;

public class MaxHeapStandard 
{

	private int[] Heap; 
    private int size; 
    private int maxsize; 
  
    
    public MaxHeapStandard(int maxsize) 
    { 
        this.maxsize = maxsize; 
        this.size = 0; 
        Heap = new int[this.maxsize + 1]; 
        Heap[0] = Integer.MAX_VALUE; 
    } 
  
    
    private int parent(int pos) 
    { 
        return pos / 2; 
    }   
    
    private int leftChild(int pos) 
    { 
        return (2 * pos); 
    } 
    private int rightChild(int pos) 
    { 
        return (2 * pos) + 1; 
    } 
  
    private boolean isLeaf(int pos) 
    { 
        if (pos >= (size / 2) && pos <= size) 
            return true; 
        
        return false; 
    } 
  
    private void swap(int i, int k)  
    { 
        int tmp 	= Heap[i]; 
        Heap[i] 	= Heap[k]; 
        Heap[k] 	= tmp; 
    } 
  

    private void maxHeapify(int pos) 
    { 
        if (isLeaf(pos)) 
            return; 
  
        if (Heap[pos] < Heap[leftChild(pos)] ||  
            Heap[pos] < Heap[rightChild(pos)]) 
        { 
  
            if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) 
            { 
                swap(pos, leftChild(pos)); 
                maxHeapify(leftChild(pos)); 
            } 
            else 
            { 
                swap(pos, rightChild(pos)); 
                maxHeapify(rightChild(pos)); 
            } 
        } 
    } 
    
    private void maxHeapifyIterative(int pos) 
    { 
        
    } 
  
    public void insert(int element) 
    { 
        Heap[++size] = element; 
  
        int current = size; 
        while (Heap[current] > Heap[parent(current)]) 
        { 
            swap(current, parent(current)); 
            current = parent(current); 
        } 
    } 
  
    public void print() 
    { 
        for (int i = 1; i <= size / 2; i++) 
        { 
            System.out.print(" PARENT : " + Heap[i] 
            				+ " LEFT CHILD : " + Heap[2 * i] 
            				+ " RIGHT CHILD :" + Heap[2 * i + 1]); 
            System.out.println(); 
        } 
    } 
  
    public int pop() 
    { 
        int popped = Heap[1]; 
        Heap[1] = Heap[size--]; 
        maxHeapify(1); 
        return popped; 
    } 
	
	public static void main(String[] args) 
	{
		
		MaxHeapStandard maxHeap = new MaxHeapStandard(15); 
        maxHeap.insert(5); 
        maxHeap.insert(3); 
        maxHeap.insert(17); 
        maxHeap.insert(10); 
        maxHeap.insert(84); 
        maxHeap.insert(19); 
        maxHeap.insert(6); 
        maxHeap.insert(22); 
        maxHeap.insert(9); 
  
        maxHeap.print(); 
        System.out.println("The max val is " + maxHeap.pop()); 

	}

}
