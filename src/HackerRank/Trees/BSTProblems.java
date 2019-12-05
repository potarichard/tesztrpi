package HackerRank.Trees;

public class BSTProblems {

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
	
	
	public static Node insert(Node root,int data) 
	{
		if(root == null)
			return new Node(data);
		
		if(data < root.data)
			root.left = insert(root.left, data);
		else if(data > root.data)
			root.right = insert(root.right, data);
		
    	return root;
    }
	
	public static void main(String[] args) 
	{
		
		Node
		root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(7);
		root.left.left = new Node(1);
		root.left.right = new Node(3);

		insert(root, 6);
		
		System.out.println();
	}

}
