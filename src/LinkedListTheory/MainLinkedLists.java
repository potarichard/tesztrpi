package LinkedListTheory;

public class MainLinkedLists {

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
		
//		InsertToLinkedList insTo = new InsertToLinkedList();
//		insTo.Insert(node1, 421, 3);
		
		ReverseLinkedList revl = new ReverseLinkedList();
		revl.reverse(node1);
		
		
		System.out.println(node1);
		

	}

}
