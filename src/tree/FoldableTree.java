package tree;

public class FoldableTree 
{
	
	static boolean isSymetric(Node tree)
	{
		return tree == null || check(tree.left, tree.right);
	}
	
	static boolean check2(Node left, Node right)
	{
		if(left == null && right == null)
			return true;
		
		if(left != null && right != null)
		{
			return 	left.value == right.value &&
					check(left.left, right.right) &&
					check(left.right, right.left);
		}
		
		return false;
	}
	
	static boolean check3(Node left, Node right)
	{
		if(left == null && right == null)
			return true;
		
		boolean left_ok = false, right_ok = false;		
		
		if(left != null && right != null)
		{
			if(left.value == right.value)
			{
				left_ok  = check(left.left, right.right);
				right_ok = check(left.right, right.left);
			}
		}
		
		return left_ok && right_ok;
	}
	
	static boolean check(Node left, Node right)
	{
		if(left == null && right == null)
			return true;		
		
		if(left != null && right != null)
		{
			if(left.value == right.value)
				return check(left.left, right.right) && check(left.right, right.left);
		}
		
		return false;
	}

	public static void main(String[] args) 
	{
		
		Node root = new Node(1);

		root.left = new Node(2);
		root.right = new Node(2);
		
		root.left.left   = new Node(3);
		root.left.right  = new Node(4);
		root.right.left  = new Node(4);
		root.right.right = new Node(3);
		
		System.out.println(isSymetric(root));
	}

}
