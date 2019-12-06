package HackerRank.Trees;

// left rotation, right rotation

public class AVL_Tree {

	static class Node 
	{ 
	    int data, height; 
	    Node left, right; 
	  
	    public Node(int data) 
	    { 
	        this.data = data; 
	        this.height = 1; 
	    } 
	} 
	
	private Node root;	
	
	public AVL_Tree(Node node)	{
		this.root = node;
	}
	
	 int height(Node node) 
	 { 
        if (node == null) 
            return 0; 
  
        return node.height; 
	 } 
	
    Node rightRotate(Node node) 
    { 
        Node leftN  = node.left; 
        Node tempN  = leftN.right; 
  
        // Perform rotation 
        leftN.right = node; 
        node.left   = tempN; 
  
        // Update heights 
        node.height 	= Math.max(height(node.left), height(node.right)) + 1; 
        leftN.height 	= Math.max(height(leftN.left), height(leftN.right)) + 1; 
  
        return leftN; 
    } 
    
    Node leftRotate(Node node) 
    { 
        Node rightN = node.right; 
        Node tempN  = rightN.left; 
  
        // Perform rotation 
        rightN.left = node; 
        node.right  = tempN; 
  
        //  Update heights 
        node.height 	= Math.max(height(node.left), height(node.right)) + 1; 
        rightN.height 	= Math.max(height(rightN.left), height(rightN.right)) + 1; 
  
        return rightN; 
    } 
    
    int getBalance(Node node) 
    { 
        if (node == null) 
            return 0; 
  
        return height(node.left) - height(node.right); 
    } 
    
    Node insertHelper(Node node, int data) 
    {     	  
        //  Perform the normal BST insertion
        if (node == null) 
            return (new Node(data)); 
  
        if (data < node.data) 
            node.left = insertHelper(node.left, data); 
        else if (data > node.data) 
            node.right = insertHelper(node.right, data); 
        else // Duplicate keys not allowed 
            return node; 
        
        node.height = 1 + Math.max(height(node.left), height(node.right));   
       
        int balance = getBalance(node);   
        
        // Left Left Case 
        if (balance > 1 && data < node.left.data) 
            return rightRotate(node); 
  
        // Right Right Case 
        if (balance < -1 && data > node.right.data) 
            return leftRotate(node); 
  
        // Left Right Case 
        if (balance > 1 && data > node.left.data) 
        { 
            node.left = leftRotate(node.left); 
            return rightRotate(node); 
        } 
  
        // Right Left Case 
        if (balance < -1 && data < node.right.data) 
        { 
            node.right = rightRotate(node.right); 
            return leftRotate(node); 
        } 
  
        return node; 
    } 
    
    public void insert(int data) 
    {     	  
        this.root = insertHelper(this.root, data);
    } 
	
	public static void main(String[] args) 
	{
		
		AVL_Tree tree = new AVL_Tree(new Node(10));		
		
		tree.insert(20);
		tree.insert(30);
		tree.insert(40);
		tree.insert(50);
		tree.insert(25);
		
        
        System.out.println();
	}

}

































