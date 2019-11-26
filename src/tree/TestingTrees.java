package tree;

public class TestingTrees 
{

//	LCA
	
	static Node lowestCommonAncestor(Node root, Node p, Node q) {
		  return search(root, p, q);
	}
	
	static Node search(Node root, Node p, Node q) 
	{
	  if (root == null) 
		  return null;
	  if (root.value == p.value || root.value == q.value)
		  return root;	  
	  
	  Node leftSearchResult = search(root.left, p, q);
	  Node rightSearchResult = search(root.right, p, q);
	  
	  if (leftSearchResult == null) 
		  return rightSearchResult;

	  if (rightSearchResult == null) 
		  return leftSearchResult;
	  
	  return root;
	}
	
	
//	TEST if balanced
	
	private static class BalanceStatusWithHeight 
	{
	  public boolean isBalanced;
	  public int height;

	  public BalanceStatusWithHeight(boolean isBalanced, int height) {
	    this.isBalanced = isBalanced;
	    this.height = height;
	  }
	}
	
	static boolean isBalanced(Node root) {
	  return checkBalanced(root).isBalanced;
	}

	private static BalanceStatusWithHeight checkBalanced(Node root) 
	{
	  if (root == null) 
	    return new BalanceStatusWithHeight(true , -1);

	  BalanceStatusWithHeight leftResult = checkBalanced(root.left);
	  if (!leftResult.isBalanced) 
	    return leftResult; 

	  BalanceStatusWithHeight rightResult = checkBalanced(root.right);
	  if (!rightResult.isBalanced) 
	    return rightResult; 

	  
	  boolean subtreesAreBalanced = Math.abs(leftResult.height - rightResult.height) <= 1;
	  
	  int height = Math.max(leftResult.height, rightResult.height) + 1;

	  return new BalanceStatusWithHeight(subtreesAreBalanced, height);
	}
	
	
	
	
	public static void main(String[] args) 
	{
		
		Node root = new MyTree().root;

		lowestCommonAncestor(root, root.left.left, root.left.right.right);
		
		System.out.println(isBalanced(root));
	}

}











