package HackerRank.Queues;

import java.util.Stack;

public class QueueWith2Stacks {

	Stack<Integer> order 	= new Stack<Integer>();
	Stack<Integer> reverse 	= new Stack<Integer>();
	
	// O(n)
	public void enque(Integer item)
	{
//		if(order.isEmpty() && reverse.isEmpty())
//			order.push(item);
//		else if(!order.isEmpty() && reverse.isEmpty())
//		{
//			reverse.push(item);
//			reverse.push(order.pop());			
//		}
//		
//		else if(order.isEmpty() && !reverse.isEmpty())
//		{
//			while(!reverse.isEmpty())
//				order.push(reverse.pop());
//			
//			reverse.push(item);
//			
//			while(!order.isEmpty())
//				reverse.push(order.pop());
//		}
		
		while(!reverse.isEmpty())
			order.push(reverse.pop());
		
		reverse.push(item);
		
		while(!order.isEmpty())
			reverse.push(order.pop());
	}
	
	// O(1)
	public Integer deque()
	{
		if(reverse.isEmpty() && !order.isEmpty())
			return order.pop();
		else if(!reverse.isEmpty())
			return reverse.pop();
		
		return -1;
	}
	
	// O(1)
	public void printFirst()
	{
		if(reverse.isEmpty() && !order.isEmpty())
			System.out.println(order.peek());
		else if(!reverse.isEmpty())
			System.out.println(reverse.peek());
	}
	
	public static void main(String[] args) 
	{
		QueueWith2Stacks que = new QueueWith2Stacks();
		
		que.enque(1);
		que.enque(2);
		que.enque(3);
		que.enque(4);
		que.enque(5);
		que.enque(6);
		
		System.out.println(que.deque());
		System.out.println(que.deque());
		
		que.enque(10);
		que.enque(20);
		
		que.printFirst();
	}
	
}


