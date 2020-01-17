package tree;

public class HeightOfTree {

	static int heightOfNode(Node node)
	{
		if(node == null)
			return 0;
		
		return Math.max(1+heightOfNode(node.left), 1+heightOfNode(node.left));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node root = new MyTree().root;
		
		heightOfNode(root);
	}

}
