package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class MyTreeLevels 
{

//	nem 0 base, a root node 1 es szint!
	static void printOnALevel(Node node, int level)
	{
		if(node == null)
			return;
		
		if(level == 1)
		{
			System.out.print(node.value + " ");
			return;
		}
		
		printOnALevel(node.left, level-1);
		printOnALevel(node.right, level-1);
	}
	
	static void printLevelOrderTraversal(Node node)
	{
		if(node == null)
			return;
		
		int height = MyTreeNumbers.heightOfNode(node);
		
		for(int i=0; i<=height; i++)
		{
			printOnALevel(node, i+1);
			System.out.println();
		}
	}
	
	static void printLevelOrderTraversalReversed(Node node)
	{
		if(node == null)
			return;
				
		int height = MyTreeNumbers.heightOfNode(node);
		
		for(int i=height; i>=0; i--)
		{
			printOnALevel(node, i+1);
			System.out.println();
		}
	}
	
	static void getNodesOfALevel(List<Node> list, Node node, int level)
	{
		if(node == null)
			return;
		
		if(level == 1)
		{
			list.add(node);
			return;
		}			
		
		getNodesOfALevel(list, node.left, level-1);
		getNodesOfALevel(list, node.right, level-1);
	}
	
	
	
	
	static void printLevelOrderTraversalIterative(Node node)
	{
		if(node == null)
			return;
		
		Queue<Node> que = new LinkedList<Node>();
		
		Node head;
		
		que.add(node);
		
		while(que.size() > 0)
		{
			head = que.remove();
			
			System.out.print(head.value + " ");
			
			if(head.left != null)
				que.add(head.left);
			
			if(head.right != null)
				que.add(head.right);
		}		
	}
	
	
	static void printLevelOrderTraversalIterativeReversed(Node node)
	{
		if(node == null)
			return;
		
		Queue<Node> que = new LinkedList<Node>();
		Stack<Node> stack = new Stack<Node>();
		
		Node head;
		
		que.add(node);
		
		while(que.size() > 0)
		{
			head = que.remove();			
			
			if(head.left != null)
				que.add(head.left);
			
			if(head.right != null)
				que.add(head.right);
			
			stack.push(head);
		}		
		
		while(stack.size() > 0)
			System.out.print(stack.pop().value + " ");
	}
	
	
	static void printLevelOrderTraversalIterativeLineByLine(Node node)
	{
		if(node == null)
			return;
		
		int count = 0;
		Node head;
		Queue<Node> que = new LinkedList<Node>();			
		que.add(node);
		
		while(true)
		{
			count = que.size();
			
			if(count == 0)
				break;
			
			
			while(count > 0)
			{
				head = que.remove();
				
				System.out.print(head.value + " ");
				
				if(head.left != null)
					que.add(head.left);
				
				if(head.right != null)
					que.add(head.right);
				
				count--;
			}	
			
			System.out.println();
		}
	}
	  
	  // Prints level order traversal line  line using two queues. 
	  static void levelOrderIterativeAnother(Node root) 
	  { 
	    if (root == null) 
	      return; 
	  
	    Queue<Node> q = new LinkedList<>(); 
	  
	    // Pushing root node into the queue. 
	    q.add(root); 
	  
	    // Pushing delimiter into the queue. 
	    q.add(null); 
	  
	    // Executing loop till queue becomes 
	    // empty 
	    while (!q.isEmpty()) { 
	  
	      Node curr = q.poll(); 
	  
	      // condition to check the 
	      // occurence of next level 
	      if (curr == null) { 
	        if (!q.isEmpty()) { 
	          q.add(null); 
	          System.out.println(); 
	        } 
	      } else { 
	        // Pushing left child current node 
	        if (curr.left != null) 
	          q.add(curr.left); 
	  
	        // Pushing right child current node 
	        if (curr.right != null) 
	          q.add(curr.right); 
	  
	        System.out.print(curr.value + " "); 
	      } 
	    } 
	  } 

	
//	Node maxlevel azert van igy atadva, mert ez igy refencia atadas, es a maxlevel, minden stackben ugyan annyi, teccikerteni
	static void printLeftView(Node node, Node maxlevel, int level)
	{
		if(node == null)
			return;
		
		if(level >= maxlevel.value)
		{
			System.out.println(node.value + " ");
			maxlevel.value++;
		}
		
		printLeftView(node.left, maxlevel, level+1);
		printLeftView(node.right, maxlevel, level+1);
	}
	
	static void printRightView(Node node, Node maxlevel, int level)
	{
		if(node == null)
			return;
		
		if(level >= maxlevel.value)
		{
			System.out.println(node.value + " ");
			maxlevel.value++;
		}
		
		printRightView(node.right, maxlevel, level+1);		//	go right first !
		printRightView(node.left, maxlevel, level+1);		
	}
	
	
	static void inOrderIterative(Node node)
	{
		if(node == null)
			return;
		
		Node current, tmp;
		Stack<Node> stack = new Stack<Node>();
		
		while(node != null)
		{
			stack.push(node);
			node = node.left;
		}
		
		while(stack.size() > 0)
		{
			current = stack.pop();
			System.out.print(current.value + " ");
			
			if(current.right != null)
			{
				tmp = current.right;
				
				while(tmp != null)
				{
					stack.push(tmp);
					tmp = tmp.left;
				}
			}
		}
	}
	
	static void printpreOrderTraversalIterative(Node node)
	{
		if(node == null)
			return;
		
		Stack<Node> stack = new Stack<Node>();
		
		Node current;
		
		stack.push(node);
		
		while(stack.size() > 0)
		{
			current = stack.pop();
			
			System.out.print(current.value + " ");
			
			if(current.right != null)
				stack.push(current.right);
			
			if(current.left != null)
				stack.push(current.left);
		}		
	}
	
	static Node mirrorTree(Node node)
	{
		if(node == null)
			return null;
		
		Node tmp = node.left;
		node.left = node.right;
		node.right = tmp;
		
		mirrorTree(node.left);
		mirrorTree(node.right);
		
		return node;
	}
	
	static boolean identicalTree(Node t1, Node t2)
	{
		if(t1 == null && t2 == null)
			return true;
		
		if(t1 == null || t2 == null)
			return false;
		
		if(t1.value == t2.value)
		{
			if(identicalTree(t1.left, t2.left) && identicalTree(t1.right, t2.right))
				return true;
		}
		
		return false;
	}
	
	static int levelOfNode(Node node, int val, int level)
	{
		if(node == null)
			return 0;
		
		int lev;
		
		if(node.value == val)
			return level;
		
		lev = levelOfNode(node.left, val, level+1);
		
		if(lev != 0)
			return lev;
		
		lev = levelOfNode(node.right, val, level+1);
		
		return lev;
	}
	
	static Node lcaDriver(Node root, Node child_1, Node child_2)
	{
		List<Node> path_1 = new ArrayList<Node>();
		List<Node> path_2 = new ArrayList<Node>();
		
		lca(root, child_1, path_1);
		lca(root, child_2, path_2);
		
		int i=0;
		
		while(i<path_1.size() && i<path_2.size())
		{
			if(path_1.get(i) == path_2.get(i))
				root = path_1.get(i);
			
			i++;
		}
		
		return root;
	}
	
	static boolean lca(Node root, Node child, List<Node> path)
	{
		if(root == null)
			return false;
		if(root == child)
			return true;
		
		path.add(root);
		
		if(lca(root.left, child, path))
			return true;
		
		if(lca(root.right, child, path))
			return true;
		
		path.remove(path.size()-1);
		
		return false;
	}
	
	
	
	public static void main(String[] args) 
	{
		
		Node root = new MyTree().root;
		
		printOnALevel(root, 1);
		
		System.out.println("\n\nlevel order\n");		
		printLevelOrderTraversal(root);
		
		System.out.println("\nlevel order reversed\n");		
		printLevelOrderTraversalReversed(root);
		
		System.out.println("\nnodes to list \n");
		List<Node> list = new ArrayList<Node>();		
		getNodesOfALevel(list, root, 2);
		System.out.println();
		
		System.out.println("level ordfer iterative");
		printLevelOrderTraversalIterative(root);
		
		System.out.println("\nlevel order reversed iterative");
		printLevelOrderTraversalIterativeReversed(root);
		
		System.out.println("\n\nlevel order liny by line iterative\n");
		printLevelOrderTraversalIterativeLineByLine(root);
		
		System.out.println("\nLeft view\n");
		printLeftView(root, new Node(0), 0);
		
		System.out.println("\nRight view\n");
		printRightView(root, new Node(0), 0);
		
		System.out.println("\ninorder iterative");
		inOrderIterative(root);
		
		System.out.println("\npreorder iterative");
		printpreOrderTraversalIterative(root);
		
		System.out.println("\n\nmirror fucking tree");
		Node mirrored = mirrorTree(root);
		printLevelOrderTraversal(mirrored);
		
		System.out.println("\n\nidentical fucking tree");
		System.out.println(identicalTree(root, root));
		
		System.out.println("\n\nNot identical fucking tree");
		System.out.println(identicalTree(root, root.left));
		
		System.out.println("\n\nLeevel of a node");
		System.out.println(levelOfNode(root, 11, 1));
		
		
		System.out.println("Another level order stuff");
		levelOrderIterativeAnother(root);
		
		System.out.println("lowest common anscestor");
		root = new MyTree().root;
		lcaDriver(root, root.left.left, root.left.right.right);		// 2, 8
	}

}































