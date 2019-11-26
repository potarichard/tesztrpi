package tree;

public class MyTreeSumNodes {
	
	
	static int sumOfNodes(Node root)
	{
		if(root == null)
			return 0;
		
		return  root.value + sumOfNodes(root.left) + sumOfNodes(root.right);
	}

	static int sumOfNodesFriendly(Node root)
	{
		if(root == null)
			return 0;
		
		int left = sumOfNodesFriendly(root.left);		
		int right = sumOfNodesFriendly(root.right);
		int value = root.value + left + right;
		
		return value;		
	}
	
	static int diffOfNodes(Node root)
	{
		if(root == null)
			return 0;
		
		return root.value - diffOfNodes(root.left) - diffOfNodes(root.right);
	}

	static int diffOfNodesFriendly(Node root)
	{
		if(root == null)
			return 0;
		
		int left = diffOfNodesFriendly(root.left);		
		int right = diffOfNodesFriendly(root.right);
		int value = root.value - left - right;
		
		return value;		
	}
	
	public static void main(String[] args) 
	{
	
		Node root = new MyTree().root;
		
		System.out.println("sum: " + sumOfNodes(root));
		System.out.println("sum friendlier: " + sumOfNodesFriendly(root));
		
		System.out.println("diff: " + diffOfNodes(root));
		System.out.println("diff friendlier: " + diffOfNodesFriendly(root));
	}

}









