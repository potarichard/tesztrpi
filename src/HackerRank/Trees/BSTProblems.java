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
	
	// ez csak BST esetén ilyen jó
	public static Node lca(Node root, int v1, int v2) 
    {
        //Samller than both
        if(root.data < v1 && root.data < v2)
            return lca(root.right, v1, v2);
        
        //Bigger than both
        if(root.data > v1 && root.data > v2)
            return lca(root.left, v1, v2);

        //Else solution already found
        return root;
    }
	
	public static boolean isBST(Node root) 
	{
		Integer max = Integer.MAX_VALUE;
		Integer min = Integer.MIN_VALUE;
		
		return isBSThelper(root, min, max);
	}
	
	public static boolean isBSThelper(Node root, int min, int max) 
	{
		if(root == null)
			return true;
		
		if(root.data > min && root.data < max)
			if(isBSThelper(root.left, min, root.data) && isBSThelper(root.right, root.data, max))
				return true;			
		
		return false;
	}
	
	public static void main(String[] args) 
	{
		
//		Node
//		root = new Node(4);
//		root.left = new Node(2);
//		root.right = new Node(7);
//		root.left.left = new Node(1);
//		root.left.right = new Node(3);

		
		
//		lca(root, 1, 7);
//		
//		isBST(root);
		
		
		// this is not good -> need self balancing!
		Node root = new Node(10);		
		insert(root, 20);
		insert(root, 30);
		insert(root, 40);
		insert(root, 50);
		insert(root, 25);
		
		System.out.println();
	}

}














