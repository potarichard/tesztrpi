package tree;

public class MyTreeNumbers 
{	
	static int numberOfNodes(Node node)
	{
		if(node == null)
			return 0;		
		
		return 1 + numberOfNodes(node.left) + numberOfNodes(node.right);
	}
	
	static int numberOfNodesFriendly(Node node)
	{
		if(node == null)
			return 0;
		
		int left_num = numberOfNodes(node.left);
		int right_num = numberOfNodes(node.right);
		
		return 1 + left_num + right_num;
	}
	
	static int numberOfLeafNodes(Node node)
	{
		if(node == null)
			return 0;		
		if(node.left == null && node.right == null)
			return 1;
		
		return numberOfLeafNodes(node.left) + numberOfLeafNodes(node.right);
	}
	
	public static int heightOfNode(Node node)
	{
		if(node == null)
			return -1;
		
		int left_h = heightOfNode(node.left);
		int right_h = heightOfNode(node.right);
		int max = Math.max(left_h, right_h);
		
		return max + 1;
	}
	
	public static void main(String[] args) 
	{
		
		Node root = new MyTree().root;
		
		System.out.println("number of nodes: " + numberOfNodes(root));
		System.out.println("number of nodes friendly: " + numberOfNodesFriendly(root));
		
		System.out.println("number of leaf nodes: " + numberOfLeafNodes(root));
		
		System.out.println("height of tree: " + heightOfNode(root));
	}

}
















