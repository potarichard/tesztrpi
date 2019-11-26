package tree;

public class MyTree 
{

	public Node root;
	
	public MyTree()
	{
		root = new Node(4);
		
		root.left = new Node(3);				// 4
		root.right = new Node(5);				// 4
		
		root.left.left = new Node(2);			// 3
		root.left.right = new Node(1);			// 3
		root.right.right = new Node(6);			// 5
		
		root.left.right.left = new Node(7);		// 1
		root.left.right.right = new Node(8);	// 1
		root.right.right.left = new Node(9);	// 6
	}
	
}
