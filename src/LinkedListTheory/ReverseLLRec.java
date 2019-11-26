package LinkedListTheory;

public class ReverseLLRec 
{

	
	public static Node revRecursive(Node node)
	{
		if(node == null || node.next == null)
			return node;
		
		Node head = revRecursive(node.next);
		
		node.next.next = node;
		
		node.next = null;
		
		return head;
	}
	
	
	public static void main(String[] args) 
	{
		
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		
		Node reversed = revRecursive(node1);
		
		System.out.println();

	}

}
