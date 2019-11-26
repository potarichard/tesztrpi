package LinkedListTheory;

public class ReverseLinkedList 
{
	
	Node reverse(Node node) 
    { 
		Node current 	= node;
        Node prev 		= null;          
        Node next 		= null; 
        
        while (current != null) 
        { 
            next 			= current.next; 
            current.next 	= prev; 
            prev 			= current; 
            current 		= next; 
        } 
        
        return prev; 
    } 
}
