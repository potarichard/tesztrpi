package mypackage;

public class RemoveDuplicatesLinkedList 
{

	private static class Node
	{
		int value;
		Node next;
		
		public Node(int value)
		{
			this.value = value;
		}
	}
	
	static Node createLL()
	{
		Node n0 = new Node(1);
		Node n1 = new Node(2);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(4);
		Node n6 = new Node(4);
		Node n7 = new Node(5);
		
		n0.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		
		return n0;
	}
	
	
	static Node removeRecursive(Node node)
	{
		if(node == null)
			return null;
		
		node.next = removeRecursive(node.next);
		
		if(node != null && node.next != null && node.value == node.next.value)
			return node.next;
		else
			return node;
	}
	
	static Node removeIterative(Node node)
	{
		if(node == null)
			return null;
		
		Node track = node;							// track pointer = node pointer
		
		while(track.next != null)
		{			
			
			if(track.next.value == track.value)
			{
				track.next = track.next.next;
				continue;
			}
			
			track = track.next;		
		}
		
		
		return node;
	}
	
	
	
	public static void main(String[] args) 
	{
	
		Node head = createLL();

//		Node removed1 = removeRecursive(head);
		
		Node removed2 = removeIterative(head);
		
		System.out.println();
	}

}

















