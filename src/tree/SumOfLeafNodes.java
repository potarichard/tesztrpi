package tree;

public class SumOfLeafNodes {

	static int sumOfLeafNodes(Node node)
	{
		int sum = 0;
		
		if(node == null)
			return 0;
		
		if(node.left == null && node.right == null)
			return node.value;
		
		sum += sumOfLeafNodes(node.left) + sumOfLeafNodes(node.right);
		
		return sum;
	}
	
	public static void main(String[] args) {
		
		Node root = new MyTree().root;

		sumOfLeafNodes(root);
	}

}
