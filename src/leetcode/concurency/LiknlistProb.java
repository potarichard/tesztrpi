package leetcode.concurency;

import java.util.LinkedList;
import java.util.Queue;

public class LiknlistProb {

	
	  public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }
	 
	  	static boolean carry = false; 
	  	static ListNode node = new ListNode();
	  
	    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        
	        ListNode head = node;
	        
	        while(l1 != null && l2 != null) {
	        	
	        	int sub = l1.val + l2.val;
	        	
	        	calculate(sub);
	        	
	        	l1 = l1.next;
	        	l2 = l2.next;
	        }
	        
	        while(l1 == null && l2 != null)
	        {	        	
	        	calculate(l2.val);	        	
	        	l2 = l2.next;
	        }
	        
	        while(l2 == null && l1 != null)
	        {
	        	calculate(l1.val);
	        	l1 = l1.next;
	        }
	        
	        if(carry)
	        	node.val = 1;
	        else
	        {
	        	ListNode stf = head;
	        	while(stf != null && stf.next != null) {
	        		if(stf.next.val == 0 && stf.next.next == null)
	        			stf.next = null;
	        		stf = stf.next;
	        	}
	        }
	        
	        return head;
	    }
	    
	    
	    
	    static void calculate(int sub) {
	    	
	    	if(carry)
        		sub += 1;
        	
        	carry = false;
        	
        	if(sub > 9)	        		
        		carry = true;
        	
        	node.val = sub%10;        	
        	
        	node.next = new ListNode();
        	node = node.next;
	    }
	    
	    
	    
	    
	    
	    
	    Integer getNum(ListNode ln) {
	        Queue<Integer> que = new LinkedList<Integer>();
	        
	        while(ln != null) {
	            que.add(ln.val);
	            ln = ln.next;
	        }
	        
	        int k = 1;
	        Integer ret = 0;
	        
	        while(!que.isEmpty()) {
	            ret += que.poll()*k;
	            k *= 10;
	        }
	           
	        return ret;
	    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 342
		ListNode l1 = new ListNode(9);
//		l1.next = new ListNode(4);
//		l1.next.next = new ListNode(3);
		
		// 921
		ListNode l2 = new ListNode(9);
//		l2.next = new ListNode(6);
//		l2.next.next = new ListNode(4);
//		l2.next.next.next = new ListNode(9);
		
		LiknlistProb das = new LiknlistProb();
		
		das.addTwoNumbers(l1, l2);
		
	}

}
