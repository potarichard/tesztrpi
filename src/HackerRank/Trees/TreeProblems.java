package HackerRank.Trees;

import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class TreeProblems {

	static class Node 
	{
	    int data;
	    int dist_left, dist_right;	
	    Node left;
	    Node right;
	    
	    public Node() {}
	    
	    public Node(int val) 
	    {
	    	this.data = val;
	    }
	}	


	
	public static int height(Node root) 
    {
      	if (root == null)
            return -1;
      	
      	return 1 + Math.max(height(root.left), height(root.right));
    }
	
	public static void preOrder(Node root) 
	{
		if(root == null)
			return;
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
    }
	
    public static void postOrder(Node root) 
    {
    	if(root == null)
			return;		
    	postOrder(root.left);
    	postOrder(root.right);
		System.out.print(root.data + " ");
    }
	
    public static void inOrder(Node root) 
    {
    	if(root == null)
			return;		
    	inOrder(root.left);
    	System.out.print(root.data + " ");
    	inOrder(root.right);		
    }
    
	
	public static void levelOrder(Node root)
	{
		Queue<Node> que = new LinkedList<Node>();
		
		if(root == null)
			return;
		
		que.add(root);
		
		while(!que.isEmpty())
		{
			Node node = que.poll();
			
			System.out.print(node.data + " ");
			
			if(node.left != null)
				que.add(node.left);
			if(node.right != null)
				que.add(node.right);
		}
	}
    
	public static void topViewOwn(Node root)
	{
		Queue<Node> que = new LinkedList<Node>();		
		Stack<Integer> left_stack = new Stack<Integer>();
		Queue<Integer> right_que = new LinkedList<Integer>();
		
		if(root == null)
			return;
		
		int L = 0, R = 0;
		
		
		que.add(root);
		
		while(!que.isEmpty())
		{
			Node node = que.poll();			
			
//			System.out.println("root: " + node.data + " L: " + node.dist_left + " R: " + node.dist_right);
			
			if(node.left != null)
			{
				node.left.dist_left = node.dist_left + 1;				
				node.left.dist_right = -1 * node.left.dist_left;
				
				if(node.left.dist_left > L)
				{
					left_stack.add(node.left.data);
					L = node.left.dist_left;
				}					
				
				que.add(node.left);
			}
				
			if(node.right != null)
			{
				node.right.dist_right = node.dist_right + 1;				
				node.right.dist_left  = -1 * node.right.dist_right;
				
				if(node.right.dist_right > R)
				{
					right_que.add(node.right.data);
					R = node.right.dist_right;
				}					
				
				que.add(node.right);
			}				
		}
		
		while(!left_stack.isEmpty())
			System.out.print(left_stack.pop() + " ");
		
		System.out.print(root.data + " ");
		
		while(!right_que.isEmpty())
			System.out.print(right_que.poll() + " ");
	}
	
	public static void topViewOwn2(Node root)
	{
		
		class NodeQ 
		{ 
            Node node; 
            int dist_left, dist_right; 
  
            public NodeQ(Node node, int dist_left, int dist_right) 
            { 
                this.node = node; 
                this.dist_left = dist_left; 
                this.dist_right = dist_right; 
            } 
        } 
		
		Queue<NodeQ> que = new LinkedList<NodeQ>();		
		Stack<Integer> left_stack = new Stack<Integer>();
		Stack<Integer> right_stack = new Stack<Integer>();
		
		if(root == null)
			return;
		
		int L = 0, R = 0;
		
		
		que.add(new NodeQ(root, 0, 0));
		
		while(!que.isEmpty())
		{
			NodeQ qN = que.poll();			
			
			System.out.println("root: " + qN.node.data + " L: " + qN.dist_left + " R: " + qN.dist_right);
			
			if(qN.node.left != null)
			{
				qN.node.left.dist_left = qN.dist_left + 1;				
				qN.node.left.dist_right = -1 * qN.node.left.dist_left;
				
				if(qN.node.left.dist_left > L)
				{
					left_stack.add(qN.node.left.data);
					L = qN.node.left.dist_left;
				}					
				
				que.add(new NodeQ(qN.node.left, qN.dist_left, qN.dist_right));
			}
				
			if(qN.node.right != null)
			{
				qN.node.right.dist_right = qN.dist_right + 1;				
				qN.node.right.dist_left  = -1 * qN.node.right.dist_right;
				
				if(qN.node.right.dist_right > R)
				{
					right_stack.add(qN.node.right.data);
					R = qN.node.right.dist_right;
				}					
				
				que.add(new NodeQ(qN.node.right, qN.dist_left, qN.dist_right));
			}				
		}
		
		while(!left_stack.isEmpty())
			System.out.print(left_stack.pop() + " ");
		
		System.out.print(root.data + " ");
		
		while(!right_stack.isEmpty())
			System.out.print(right_stack.pop() + " ");
	}
	
    // legfelsot ki kell, aztan balra, aztan mindent jobbra
	public static void topViewStandard(Node root) 
	{
		class QueueObj 
		{ 
            Node node; 
            int distance; 
  
            public QueueObj(Node node, int distance) 
            { 
                this.node = node; 
                this.distance = distance; 
            } 
        } 
		
        Queue<QueueObj> que = new LinkedList<QueueObj>(); 
        Map<Integer, Node> topViewMap = new TreeMap<Integer, Node>(); 
  
        if (root == null)  
            return; 
        
        que.add(new QueueObj(root, 0)); 
          
        while (!que.isEmpty()) 
        { 
            QueueObj tmpNode = que.poll(); 
            
            if (!topViewMap.containsKey(tmpNode.distance)) 
                topViewMap.put(tmpNode.distance, tmpNode.node); 
  
            if (tmpNode.node.left != null) 
                que.add(new QueueObj(tmpNode.node.left, tmpNode.distance - 1)); 
            
            if (tmpNode.node.right != null)  
                que.add(new QueueObj(tmpNode.node.right, tmpNode.distance + 1)); 
  
        } 
        
        for (Entry<Integer, Node> entry : topViewMap.entrySet())  
            System.out.print(entry.getValue().data + " "); 
        
    }
	
	public static void main(String[] args) 
	{
		
		Node 
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.right = new Node(6);
		root.left.right.right.right = new Node(7);
		
		Node mr = root.left.right.right.right;
		mr.left = new Node(8);
		mr.left.left = new Node(9);
		mr.left.left.left = new Node(10);
		mr.left.left.left.left = new Node(11);
		mr.left.left.left.left.left = new Node(12);
		
		mr.right = new Node(666);
		
//		System.out.println(height(root));
//		preOrder(root);
//		postOrder(root);
//		inOrder(root);
//		topView(root);
//		levelOrder(root);
		topViewOwn(root);
		System.out.println();
		topViewStandard(root);
//		topViewOwn2(root);
	}

}













