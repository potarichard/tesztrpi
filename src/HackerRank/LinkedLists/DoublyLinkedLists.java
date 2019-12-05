package HackerRank.LinkedLists;

public class DoublyLinkedLists {

	
    static class DoublyLinkedListNode 
    {
         int data;
         DoublyLinkedListNode next;
         DoublyLinkedListNode prev;
         
         public DoublyLinkedListNode() {}
         
         public DoublyLinkedListNode(int val) 
         {
        	 this.data = val;
         }
    }
	
    // insert new data to a sorted list
    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode node, int data) 
    {
    	DoublyLinkedListNode head = node;  
		
		if(node != null && data <= node.data)					// to head
		{
			node.prev = new DoublyLinkedListNode(data);			
			node.prev.next = node;
			
			head = node.prev;
			
			return head;
		}
    	
    	while(node != null)
    	{
    		if(node.next == null)								// to tail
    		{
    			node.next = new DoublyLinkedListNode(data);
    			node.next.prev = node;
    			
    			return head;
    		}
    		
    		else if(data >= node.data && data < node.next.data)	// to somewhere between
    		{
    			DoublyLinkedListNode next = node.next;
    			
    			node.next = new DoublyLinkedListNode(data);    			
    			node.next.prev = node;
    			
    			node.next.next = next;
    			node.next.next.prev = node.next;
    			
    			return head;
    		}
    		
    		node = node.next;
    	}

    	return null;
    }
    
    static DoublyLinkedListNode reverse(DoublyLinkedListNode node) 
    {    	
    	DoublyLinkedListNode next;
    	
    	next = node.next;
    	node.next = null;
    	node = next;
    	
    	while(node != null)
    	{
    		next = node.next;
    		
    		node.next = node.prev;
    		node.next.prev = node;
    		
    		if(next == null)
    		{
    			node.prev = null;
    			return node;
    		}
    		
    		node = next;
    	}
    	
    	return node;
    }
    
    static DoublyLinkedListNode reverseStandard(DoublyLinkedListNode head) 
    {
    	
    	DoublyLinkedListNode temp = null; 
    	DoublyLinkedListNode current = head;  
        
        while (current != null) 
        { 
            temp = current.prev; 
            current.prev = current.next; 
            current.next = temp; 
            current = current.prev; 
        } 
  
        if (temp != null) { 
            head = temp.prev; 
            return head;
        } 
        
        return head;
    } 
    
	public static void main(String[] args) {
		
		DoublyLinkedListNode 
		head = new DoublyLinkedListNode(1);
		head.next = new DoublyLinkedListNode(2);		
		head.next.next = new DoublyLinkedListNode(3);		
		head.next.next.next = new DoublyLinkedListNode(14);		
		
		head.next.prev = head;
		head.next.next.prev = head.next;
		head.next.next.next.prev = head.next.next;
		
//		sortedInsert(head, 3);
//		reverse(head);
		reverseStandard(head);

	}

}
