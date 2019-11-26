package sorting;

public class LinkedFuckingList 
{
	
	static Node head;
	
    public static class Node 
    {   
        int data; 
//      Node prev;		// lehetne ugy is megcvsinlani, de ez nem kell a reveshez, csak ugy itt van
        Node next; 
  
        Node(int d) 
        { 
            data = d; 
            next = null; 
        } 
    } 
  
    /* Function to reverse the linked list */
    Node reverse(Node node) 
    { 
        Node prev = null; 
        Node current = node; 
        Node next = null; 
        
        while (current != null) 
        { 
            next = current.next; 
            current.next = prev; 
            prev = current; 
            current = next; 
        } 
        
        node = prev; 
        return node; 
    } 
  
    // prints content of double linked list 
    void printList(Node node) 
    { 
        while (node != null) 
        { 
            System.out.print(node.data + " "); 
            node = node.next; 
        } 
    } 
    
    public Node fillTestData()
    {    	
    	Node head = new Node(85); 
        head.next = new Node(15); 
        head.next.next = new Node(4); 
        head.next.next.next = new Node(20); 
        
        return head;
    }
	
}


















