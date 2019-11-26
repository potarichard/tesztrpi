package BackToBackSWE;

public class LinkedLists 
{

	static class Node
	{
		int val;
		Node next;
		
		public Node () {}
		
		public Node(int val)
		{
			this.val = val;
		}		
	}
	
	static Node reverse(Node node)
	{
		Node prev = null;
		Node next;
		Node current = node;
		
		
		while(current != null)
		{			
			// set new pointers
			next 			= current.next; 
            current.next 	= prev; 
            prev 			= current; 
            
            // iterate
            current 		= next; 
		}
		
		return prev;
	}
	
	static void traversal(Node node)
	{
		System.out.println();
		
		Node current = node;
		
		while(current != null)
		{
			System.out.print(current.val + " ");
			current = current.next;
		}
	}
	
	public static void main(String[] args) 
	{
		
		Node head;
		
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		
		traversal(head);
		
		head = reverse(head);
		
		traversal(head);
	}

}

























