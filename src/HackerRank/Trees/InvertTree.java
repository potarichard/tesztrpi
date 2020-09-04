package HackerRank.Trees;

import java.util.LinkedList;
import java.util.Queue;

import HackerRank.Trees.BSTProblems.Node;

public class InvertTree {

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
	
	public static void invertIterative(Node root)	{
		
		Queue<Node> que = new LinkedList<InvertTree.Node>();		
		
		que.add(root);
		que.add(root.left);
		que.add(root.right);
		
		while(!que.isEmpty())
		{
			Node main = que.poll();
			Node left = que.poll();
			Node right = que.poll();
			
			main.left = right;
			main.right = left;
			
			if(left != null)
			{
				que.add(left);
				que.add(left.left);
				que.add(left.right);
			}
			if(right != null)
			{
				que.add(right);
				que.add(right.left);
				que.add(right.right);
			}
		}
		
		System.out.println();
	}
	
	public static Node invertRecursive(Node root)	{
		
		if(root == null)
			return root;
		
		Node left = invertRecursive(root.left);
		Node right = invertRecursive(root.right);
		
		root.left = right;
		root.right = left;
		
		return root;
	}
	
	public static void main(String[] args) {
		
		
		Node tree = new Node(4);
		
		tree.left = new Node(2);
		tree.right = new Node(7);
		
		tree.left.left = new Node(1);
		tree.left.right = new Node(3);
		
		tree.right.left = new Node(6);
		tree.right.right = new Node(9);
		
		invertRecursive(tree);
		
		invertIterative(tree);		

	}

}
