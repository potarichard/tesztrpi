package HackerRank.Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import tree.Node;


public class TreeViews {

	
	static class Node 
	{
	    int data;
	    Node left;
	    Node right;
	    
	    public Node() {}
	    
	    public Node(int val) 
	    {
	    	this.data = val;
	    }
	}	
	
	public static void topViewOwn(Node root)
	{		
		class NodeQ 
		{ 
            Node node; 
            int dist_left, dist_right; 
  
            public NodeQ(Node node)
            {
            	this.node = node; 
            }
            
            public NodeQ(Node node, int dist_left, int dist_right) 
            { 
                this.node = node; 
                this.dist_left = dist_left; 
                this.dist_right = dist_right; 
            } 
        } 
		
		Queue<NodeQ> que = new LinkedList<NodeQ>();		
		Stack<Integer> left_stack = new Stack<Integer>();
		Queue<Integer> right_que = new LinkedList<Integer>();
		
		if(root == null)
			return;
		
		int L = 0, R = 0;		
		
		que.add(new NodeQ(root, 0, 0));
		
		while(!que.isEmpty())
		{
			NodeQ quedN = que.poll();			
			
//			System.out.println("root: " + quedN.node.data + " L: " + quedN.dist_left + " R: " + quedN.dist_right);
			
			if(quedN.node.left != null)
			{
				NodeQ leftN = new NodeQ(quedN.node.left);
				
				leftN.dist_left = quedN.dist_left + 1;	
				leftN.dist_right = -1 * leftN.dist_left;
				
				if(leftN.dist_left > L)
				{
					left_stack.add(leftN.node.data);
					L = leftN.dist_left;
				}					
				
				que.add(leftN);
			}
				
			if(quedN.node.right != null)
			{
				NodeQ rightN = new NodeQ(quedN.node.right);
				
				rightN.dist_right = quedN.dist_right + 1;				
				rightN.dist_left  = -1 * rightN.dist_right;
				
				if(rightN.dist_right > R)
				{
					right_que.add(rightN.node.data);
					R = rightN.dist_right;
				}					
				
				que.add(rightN);
			}				
		}		
		
		while(!left_stack.isEmpty())
			System.out.print(left_stack.pop() + " ");
		
		System.out.print(root.data + " ");
		
		while(!right_que.isEmpty())
			System.out.print(right_que.poll() + " ");
	}
	
	public static void leftView(Node root)
	{
		System.out.println("\nimplement left view");
	}
	
	public static void rightView(Node root)
	{
		System.out.println("implement right view");
	}
	
	public static void printLargestEachRow(Node root)	{		
		
		Queue<Node> que = new LinkedList<Node>();	
		
		int count = 0;
		Node node;
		que.add(root);
		int max = Integer.MIN_VALUE;
		
		while(true)
		{
			count = que.size();
			
			if(count == 0)
				break;			
			
			while(count > 0)
			{
				node = que.poll();
				
				max = Math.max(max, node.data);
				
				if(node.left != null)
					que.add(node.left);
				
				if(node.right != null)
					que.add(node.right);
				
				count--;
			}	
			
			System.out.println(max);
			max = Integer.MIN_VALUE;
		}
	}
	
	public static void main(String[] args) {
		
//		Node 
//		root = new Node(1);
//		root.left = new Node(2);
//		root.right = new Node(3);
//		root.left.left = new Node(4);
//		root.left.right = new Node(5);
//		root.left.right.left = new Node(14);
//		root.left.right.right = new Node(6);
//		root.left.right.right.right = new Node(7);		
//		Node mr = root.left.right.right.right;
//		mr.left = new Node(8);
//		mr.left.left = new Node(9);
//		mr.left.left.left = new Node(10);
//		mr.left.left.left.left = new Node(11);
//		mr.left.left.left.left.left = new Node(12);
//		mr.right = new Node(666);
//		
//		
//		topViewOwn(root);
//
//		leftView(root);
//		
//		rightView(root);
		
		
		Node 
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		printLargestEachRow(root);
	}

}



























