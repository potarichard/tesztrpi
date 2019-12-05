package HackerRank.LinkedLists;

import java.util.HashSet;
import java.util.Set;

public class PrintElementsAndMore {

	static class SinglyLinkedListNode 
	{
      int data;
      SinglyLinkedListNode next;
      
      public SinglyLinkedListNode() {}
      
      public SinglyLinkedListNode(int val)
      {
    	  this.data = val;
      }
	}
	
	static void print(SinglyLinkedListNode head)
	{
		
		while(head != null)
		{
			System.out.println(head.data);
			head = head.next;
		}
		
	}
	
	static SinglyLinkedListNode insertTail(SinglyLinkedListNode node, int val)
	{
		if(node == null)
			return new SinglyLinkedListNode(val);
		
		SinglyLinkedListNode head = node;
		
		while(node.next != null)
			node = node.next;
		
		node.next = new SinglyLinkedListNode();
		node.next.data = val;
		
		return head;
	}
	
	static SinglyLinkedListNode insertHead(SinglyLinkedListNode node, int val)
	{
		SinglyLinkedListNode newhead = new SinglyLinkedListNode(val);
		
		newhead.next = node;
		
		return newhead;
	}
	
	static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode node, int data, int position) 
	{
		int pos = 0;
		SinglyLinkedListNode head = node;
		
		while(node != null)
		{			
			if(++pos == position)
				break;
			node = node.next;
		}
		
		SinglyLinkedListNode temp = node.next;
		
		node.next = new SinglyLinkedListNode(data);
		node.next.next = temp;
		
		
		return head;
    }
	
    static SinglyLinkedListNode deleteNode(SinglyLinkedListNode node, int position) 
    {
    	if(position == 0)
    		return node.next;
    	
    	int pos = 0;
    	SinglyLinkedListNode head = node;
    	
    	while(node.next != null)
		{	
    		if(++pos == position)
				break;
			node = node.next;
		}

		if(node.next != null)
			node.next = node.next.next;			

		return head;
    }
    
	
    static void reversePrint(SinglyLinkedListNode head) 
    {
    	if(head == null)
    		return;
    	reversePrint(head.next);
    	System.out.println(head.data);
    }

    
    static SinglyLinkedListNode reverse(SinglyLinkedListNode node) 
    {
    	SinglyLinkedListNode prev = null;
    	SinglyLinkedListNode next = null;
    	
    	while(node != null)
    	{
    		next = node.next;
    		node.next = prev;
    		prev = node;
    		
    		node = next;
    	}
    	
    	return prev;
    }
    
    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) 
    {

    	if(head1 == null && head2 == null)
    		return true;

    	while(head1.next != null && head2.next != null)
    	{
    		if(head1.data != head2.data)
    			return false;
    		
    		head1 = head1.next;
    		head2 = head2.next;
    	}
    	
    	if(head1.data == head2.data && head1.next == null && head2.next == null)
			return true;
    	
    	return false;
    }
    
    
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) 
    {
    	if(head1 == null && head2 == null)
    		return null;
    	if(head1 != null && head2 == null)
    		return head1;
    	if(head1 == null && head2 != null)
    		return head2;
    	
    	if(head1.data < head2.data)
    	{
    		SinglyLinkedListNode head_of_1 = head1;
    		
    		while(head1 != null)
    		{
    			if(head1.data == head2.data || head1.next == null)
    			{
    				head1.next = head2;
    				return head_of_1;
    			}    				
    			
    			head1 = head1.next;
    		}
    	}    	

    	else if(head2.data < head1.data)
    	{
    		SinglyLinkedListNode head_of_2 = head2;
    		
    		while(head2 != null)
    		{
    			if(head1.data == head2.data  || head2.next == null)
    			{
    				head2.next = head1;
    				return head_of_2;
    			}    				
    			
    			head2 = head2.next;
    		}
    	}
    	
    	else if(head2.data == head1.data)
    	{
    		head1.next = head2;
    		return head1;
    	}
    	
    	return null;
    }
    
    static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode node) {

    	SinglyLinkedListNode head = node;
    	
    	while(node.next != null)
    	{
    		if(node.data == node.next.data)
    			node.next = node.next.next;
    		else
    			node = node.next;
    	}
    	
    	return head;
    }
    
//          d         s	 
    // 1 -> 2 -> 3 -> 4
//    		|		  |
//    		----------- 
    static boolean hasCycle(SinglyLinkedListNode head) {


    	SinglyLinkedListNode sim = head;
    	SinglyLinkedListNode dob = head;
    	
    	while(sim != null && dob != null && dob.next != null)
    	{
    		sim = sim.next;
    		dob = dob.next.next;
    		
    		if(sim == dob)
    			return true;
    	}
    	
    	return false;
    }
    
    
    // return node data where merged
    // 10 -> 20 -> 30 -> 40
    //			   |
    // 1 -> 2 -> 3-|
    
    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

    	SinglyLinkedListNode h1 = head1;
    	SinglyLinkedListNode h2 = head2;
    	
    	Set<SinglyLinkedListNode> set1 = new HashSet<SinglyLinkedListNode>();
    	Set<SinglyLinkedListNode> set2 = new HashSet<SinglyLinkedListNode>();
    	
    	while(head1 != null)
    	{
    		set1.add(head1);
    		head1 = head1.next;
    	}
    	
    	while(head2 != null)
    	{
    		set2.add(head2);
    		head2 = head2.next;
    	}
    	
    	head1 = h1;
    	head2 = h2;
    	
    	while(head1 != null)
    	{
    		if(set2.contains(head1))
    			return head1.data;
    		
    		head1 = head1.next;
    	}
    	
    	while(head2 != null)
    	{
    		if(set1.contains(head2))
    			return head2.data;
    		
    		head2 = head2.next;
    	}
    	
    	return 0;
    }
    
	public static void main(String[] args) 
	{
		
		SinglyLinkedListNode hed = new SinglyLinkedListNode(10);		
		hed.next = new SinglyLinkedListNode(20);
		hed.next.next = new SinglyLinkedListNode(30);
		hed.next.next.next = new SinglyLinkedListNode(40);
		
		
		SinglyLinkedListNode hed2 = new SinglyLinkedListNode(1);
		hed2.next = new SinglyLinkedListNode(2);
		hed2.next.next = new SinglyLinkedListNode(3);
		hed2.next.next.next = hed.next.next;
		
//		insertNodeAtPosition(hed, 98, 2);		
//		insertTail(hed, 4);
//		hed = insertHead(hed, 0);
//		hed = insertHead(hed, -1);
//		deleteNode(hed, 0);
//		reversePrint(hed);
//		reverse(hed);		
//		compareLists(hed, hed2);		
//		mergeLists(hed, hed2);		
//		removeDuplicates(hed);		
//		hasCycle(hed);
		
		findMergeNode(hed, hed2);
		
		System.out.println();
	}

}



















