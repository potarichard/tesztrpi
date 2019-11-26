package queues;

public class QueueMain {

	public static void main(String[] args) 
	{
		
		CSQueue<Integer> myqueue = new CSQueue<Integer>(10);
		
		myqueue.enqueue(5);

		
		System.out.println(myqueue.toString());
	}

}
