package tree;

public class MyTreeTravers 
{
	
	static void inOrder(Node root)
	{
		if(root == null)
			return;
		
		inOrder(root.left);
		System.out.print(root.value + " ");
		inOrder(root.right);
	}
	
	static void preOrder(Node root)
	{
		if(root == null)
			return;
		
		System.out.print(root.value + " ");
		inOrder(root.left);		
		inOrder(root.right);
	}
	
	static void PostOrder(Node root)
	{
		if(root == null)
			return;
		
		inOrder(root.left);		
		inOrder(root.right);
		System.out.print(root.value + " ");
	}

	public static void main(String[] args) 
	{
		
		Node root = new MyTree().root;
		
				
		System.out.println("InOrder");
		inOrder(root);
		System.out.println();

		
		System.out.println("PreOrder");
		preOrder(root);
		System.out.println();
		
		
		System.out.println("PostOrder");
		PostOrder(root);
		System.out.println();
				
	}

}
