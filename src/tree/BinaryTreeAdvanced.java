package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeAdvanced 
{
	static class Node 
	{
	    int value;
	    Node left;
	    Node right;
	 
	    Node(int value) 
	    {
	        this.value = value;
	    }
	}
	
	Node root;
	
//	add
	public void add(int value) {
	    root = addRecursive(root, value);
	}
	
	private Node addRecursive(Node current, int value) 
	{
	    if (current == null) 
	        return new Node(value);
	 
	    if (value < current.value) 
	        current.left = addRecursive(current.left, value);
	   
	    else if (value >= current.value) 
	        current.right = addRecursive(current.right, value);
	 
	    return current;
	}
	
//	contains
	public boolean containsNode(int value) {
	    return containsNodeRecursive(root, value);
	}
	
	private boolean containsNodeRecursive(Node current, int value) 
	{
	    if (current == null)
	        return false;
	    
	    if (value == current.value)
	        return true;
	    
	    return value < current.value
	      ? containsNodeRecursive(current.left, value)
	      : containsNodeRecursive(current.right, value);
	}
	
//	find
	public Node findNode(int value) {
	    return findNodeRecursive(root, value);
	}
	
	private Node findNodeRecursive(Node current, int value) 
	{
	    if (current == null)
	        return null;
	    
	    if (value == current.value)
	        return current;
	    
	    if(value < current.value)
	    	return findNodeRecursive(current.left, value);
	    else
	    	return findNodeRecursive(current.right, value);
	    	
	}
	
//	delete
	public void delete(int value) {
	    root = deleteRecursive(root, value);
	}
	
	private Node deleteRecursive(Node current, int value) 
	{
	    if (current == null)
	        return current;
	    
	    else if (value < current.value) 
	        current.left = deleteRecursive(current.left, value);
	    
	    else if(value > current.value)
	    	current.right = deleteRecursive(current.right, value);
	    
	    else if (value == current.value) 
	    {
	    	if (current.left == null && current.right == null) 
	    	    return null;
	    	
	    	if (current.right == null) 
	    	    return current.left;
	    	 
	    	if (current.left == null)
	    	    return current.right;
	    	
	    	int smallestValue = findSmallestValue(current.right);
			current.value = smallestValue;
			current.right = deleteRecursive(current.right, smallestValue);
			return current;
	    } 
	    

	    
	    return current;
	}
	
	private int findSmallestValue(Node root) {
	    return root.left == null ? root.value : findSmallestValue(root.left);
	}
	
//	Traversing
	
//	DFS recursive
	public void DFStraversePreOrder(Node node) 
	{
	    if (node == null)
	    	return;
	    
        System.out.print(" " + node.value);
        DFStraversePreOrder(node.left);
        DFStraversePreOrder(node.right);
	    
	}
	public void DFStraverseInOrder(Node node) 
	{
		if (node == null)
	    	return;
		
        DFStraverseInOrder(node.left);
        System.out.print(" " + node.value);
        DFStraverseInOrder(node.right);
	}
	public void DFStraversePostOrder(Node node) 
	{
		if (node == null)
	    	return;
		
        DFStraversePostOrder(node.left);
        DFStraversePostOrder(node.right);
        System.out.print(" " + node.value);
	}	
	
//	BFS
	public void BFStraverseLevelOrder(Node root) 
	{
	    if (root == null) 
	        return;
	 
	    Queue<Node> nodes = new LinkedList<>();
	    
	    nodes.add(root);
	 
	    while (!nodes.isEmpty()) 
	    {	 
	        Node node = nodes.remove();
	 
	        System.out.print(" " + node.value);
	 
	        if (node.left != null)
	            nodes.add(node.left);
	 
	        if (node.right!= null)
	            nodes.add(node.right);
	    }
	}
	
	
//	DFS interative
	public void DFStraverseInOrderIterative(Node root) 
	{ 	    
	    if (root == null) 
	        return;
	    
	    Stack<Node> stack = new Stack<Node>(); 
        Node trackedNode = root; 
  
        while (trackedNode != null || stack.size() > 0) 
        { 
            while (trackedNode !=  null) 
            { 
                stack.push(trackedNode); 
                trackedNode = trackedNode.left; 
            } 
  
            trackedNode = stack.pop(); 
  
            System.out.print(" " + trackedNode.value); 
  
//          Now, it's right subtree's turn
            trackedNode = trackedNode.right; 
        } 	    
	    
	    
	    System.out.println();
	}
	

	
//	isBinarySearchTree -> all left node is lesser, al right node is GE
//	ANY SUB TREE IN THE BST MUST BE A BST, ONLY THAN THE TREE IS A BST
	public boolean isBinarySearchTree(Node root)
	{		
		return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private boolean isBSTUtil(Node root, int min, int max)
	{
		if (root == null)
			return true;
		
		if(root.value >= min && root.value < max)
			if(isBSTUtil(root.left, min, root.value) && isBSTUtil(root.right, root.value, max))
				return true;
		
		return false;
	}
	
	
//	create tree
	public static BinaryTreeAdvanced generateTree()
	{
		BinaryTreeAdvanced bt = new BinaryTreeAdvanced();		 
	  
	    bt.add(6);
	    bt.add(4);
	    bt.add(8);
	    bt.add(3);
	    bt.add(5);
	    bt.add(7);
	    bt.add(9);
	    bt.add(3);
	    
	    return bt;
	}
	
	public static BinaryTreeAdvanced generateBSTree()
	{
		BinaryTreeAdvanced bt = new BinaryTreeAdvanced();
		 
	    bt.add(7);
	    bt.add(4);
	    bt.add(9);
	    bt.add(1);
	    bt.add(6);
		    
	    
	    return bt;
	}
	
	
//	     6
//	   /   \
//	  4     8
//   / \   / \
//	3   5 7   9
	
	public static void main(String args[])
	{
		BinaryTreeAdvanced bt = generateTree();		
//		BinaryTreeAdvanced bt = generateBSTree();
	    
//	    DFS
	    bt.DFStraverseInOrder(bt.root);	    
	    System.out.println();
	    bt.DFStraversePreOrder(bt.root);	    
	    System.out.println();
	    bt.DFStraversePostOrder(bt.root);	    
	    System.out.println();
	    
//	    BFS
	    bt.BFStraverseLevelOrder(bt.root);
	    System.out.println();
	 
//	    search	    
	    Node 	node_2 = bt.findNode(4);
	    
	    bt.BFStraverseLevelOrder(node_2);
	    System.out.println();
	    
//	    iterative DFS
	    bt.DFStraverseInOrderIterative(bt.root);
	    
//	    is BST
	    boolean isBST = bt.isBinarySearchTree(bt.root);
	    System.out.println("BST? : " + isBST);
	    
//	    search and delete
	    if(bt.containsNode(9))
	    	bt.delete(9);
	    
	    System.out.println();
	    
	}
	
}
