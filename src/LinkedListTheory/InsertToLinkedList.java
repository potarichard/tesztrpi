package LinkedListTheory;

public class InsertToLinkedList 
{
	Node Insert(Node head, int data, int position) 
	{
	    Node trackedHeadNode = head;	    
	    Node nodeToInsert = new Node(data); 
	    
	    if (head==null)
	    	return nodeToInsert;
	    
	    //Inserting a Node ahead of the List
	    if (position == 0)
	    {
	    	nodeToInsert.next = head; 
	    	return nodeToInsert;
	    }	    	    
	    
	    //Traverse the Singly Linked List to 1 Position Prior, Stop traversing if you reached the end of the List
	    int currPosition = 0;
	    
	    while (currPosition < position -1 && head.next != null)
	    {
	        head = head.next;        
	        currPosition++;       
	    }

	    //Inserting a Node in-between a List or at the end of of a List
	    Node nodeAtPosition 	= head.next;			// amit a vegere csapunk
	    head.next 				= nodeToInsert;			// amit be kell szurni, beszurjuk a helyere, most a head.next azona pozicion all
	    head 					= head.next;			// 
	    head.next 				= nodeAtPosition;		// a vegere csapjuk amii a beszurt utan jon
	        
	    return trackedHeadNode;							// ebben az eleje megmarad, csak a megfelelo .next utan irodik felul
	}
}
