package BackToBackSWE;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// look for self balancing BST  (called AVl trees)

public class SerializeTree 
{

	static class Node
	{
		int data;
		Node left, right;
		static Node root = new Node(10);
		
		public Node(int val)
		{
			this.data = val;
		}
		
		public Node() {}
		
		public void addNode(int value)
		{
			insertNode(root, value);
		}
		
		private Node insertNode(Node root, int value)
		{
			if (root == null) 
		        return new Node(value);
		 
		    if (value < root.data) 
		    	root.left = insertNode(root.left, value);
		   
		    else if (value >= root.data) 
		    	root.right = insertNode(root.right, value);
		 
		    return root;
				
		}
	}
	
	// serialize inorder travers concat datas to string, null as "x"
	// deserialize -> from string create a tree!
	
	public static String serialize(Node root)
	{
		String ser = "";
		
		ser = helperSerializer(root, ser);
		
		return ser;
	}
	
	private static String helperSerializer(Node root, String str)
	{
		if(root == null)
			return "X,";
		
		str = String.valueOf(root.data) + ",";
		
		str += helperSerializer(root.left, str);
		
		str += helperSerializer(root.right, str);
		
		
		return str;
	}
	
	public static Node deserialize(String str)
	{
		Node node = new Node(10);
		
		Queue<String> que = new LinkedList<String>();
		
		que.addAll(Arrays.asList(str.split(",")));
		
		return helperdeserialize(que);
	}
	
	private static Node helperdeserialize(Queue<String> que)
	{
		String nd  = que.poll();	
		
		if(nd.matches("X"))
			return null;
		
		Node node = new Node(Integer.valueOf(nd));
		
		node.left  = helperdeserialize(que);
		node.right = helperdeserialize(que);
		
		
		return node;
	}
	
	public static void main(String[] args) 
	{
		
		Node tree = Node.root;

		tree.addNode(1);
//		tree.addNode(2);
//		tree.addNode(3);
//		tree.addNode(4);
//		tree.addNode(5);
		tree.addNode(11);
//		tree.addNode(12);
//		tree.addNode(13);
//		tree.addNode(14);
//		tree.addNode(15);
		
		String anyad = serialize(tree);
		
		Node fos = deserialize(anyad);
	}

}
