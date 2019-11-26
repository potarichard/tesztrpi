package queues;

public class CSQueue<T> 
{
	
	
	private	T[] data;
	private int first = -1;
	private int last = -1;
	private int size; 
	    

    public CSQueue(int size) 
    {
        this.size = size;
        data = (T[])new Object[size];
    }

    private boolean isEmpty() {
        return first == -1 && last == -1;
    }

    private boolean isFull() {
        return (last + 1) % size == first;
    }

    public void enqueue(T el) throws IllegalStateException 
    {
        if(isFull()) 
            throw new IllegalStateException("Queue is full.");        
        
        if(isEmpty())
            first = last = 0;        
        else 
            last = (last + 1) % size;
        
        data[last] = el;
    }

    public T dequeue() throws IllegalStateException 
    {
        T tmp;
        
        if(isEmpty())
            throw new IllegalStateException("Queue is full.");
        
        if(first == last) 
        {
            tmp = data[first];
            first = last = -1;
        } 
        else 
        {
            tmp = data[first];
            first = (first +1) % size;
        }
        
        return tmp;
    }

    public T getFirst() throws IllegalStateException 
    {
        if(isEmpty())
            throw new IllegalStateException("Queue is empty.");
        
        return data[first];
    }

    public T getLast() throws IllegalStateException 
    {
        if(isEmpty()) 
            throw new IllegalStateException("Queue is empty.");
        
        return data[last];
    }

    public String toString() 
    {
        int count = (last +size- first) % size + 1;
        
        StringBuilder output = new StringBuilder("[");
        
        for(int i = 0; i <count; i++) 
        {
            int index = (first + i) % size;
            output.append(data[index]).append(", ");
        }
        
        return output.toString().trim() + "]";
    }
}
















