package GeeksForGeeks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// givena  binary tree, and a node which is the start
// from that start node print the nodes that are x layer distance from the start node
// so make the tree to an undirected graph, do bfs layered search

public class TreeAsGraphBFSOnLayer 
{

	static class TreeNode
	{
		int val;
		TreeNode left, right;
		
		public TreeNode(int value)
		{
			this.val = value;
		}
	}
	
	public List<Integer> distanceK(TreeNode treeRoot, TreeNode startNode, int targetDistance) 
	{
		  Map<TreeNode, TreeNode> nodeToParentMap = new HashMap();
		  Queue<TreeNode> queue = new LinkedList();
		  Set<TreeNode> visited = new HashSet();
		  int currentLayer = 0;
		  
		  
		  
		  populateNodeToParentMap(nodeToParentMap, treeRoot, null);
		  
		  queue.add(startNode);
		  
		  visited.add(startNode);

		  

		  while (!queue.isEmpty()) 
		  {
		    if (currentLayer == targetDistance) 
		      return extractLayerFromQueue(queue);

		    int layerSize = queue.size();
		    
		    for (int i = 0; i < layerSize; i++) 
		    {
		      TreeNode currentNode = queue.poll();

		      
		      if (currentNode.left != null && !visited.contains(currentNode.left)) 
		      {
		          visited.add(currentNode.left);
		          queue.add(currentNode.left);
		      }

		      if (currentNode.right != null && !visited.contains(currentNode.right)) 
		      {
		        visited.add(currentNode.right);
		        queue.offer(currentNode.right);
		      }

		      TreeNode parentOfCurrentNode = nodeToParentMap.get(currentNode);
		      
		      if (parentOfCurrentNode != null && !visited.contains(parentOfCurrentNode)) 
		      {
		        visited.add(parentOfCurrentNode);
		        queue.offer(parentOfCurrentNode);
		      }

		    }
		    
		    currentLayer++;
		  }

		  return new ArrayList<Integer>();
		}

		
		private void populateNodeToParentMap(Map<TreeNode, TreeNode> nodeToParentMap, TreeNode root, TreeNode parent) 
		{
		  if (root == null) 
		    return;

		  nodeToParentMap.put(root, parent);

		  populateNodeToParentMap(nodeToParentMap, root.left, root);
		  populateNodeToParentMap(nodeToParentMap, root.right, root);
		}

		private List<Integer> extractLayerFromQueue(Queue<TreeNode> queue) 
		{
		  List<Integer> extractedList = new ArrayList<Integer>();
		  
		  for (TreeNode node: queue) 
		    extractedList.add(node.val);
		  
		  return extractedList;
		}
	
	public static void main(String[] args) 
	{
		
		TreeNode node = new TreeNode(3);
		
		node.left = new TreeNode(5);
		node.right = new TreeNode(1);

		node.left.left = new TreeNode(6);
		node.left.right = new TreeNode(2);
		
		node.right.left = new TreeNode(0);
		node.right.right = new TreeNode(8);
		
		node.left.right.left = new TreeNode(7);
		node.left.right.right = new TreeNode(4);
		
		
		TreeAsGraphBFSOnLayer tasgbfs = new TreeAsGraphBFSOnLayer();
		
		List<Integer> nodes = tasgbfs.distanceK(node, node.left, 2);
		
		System.out.println();
	}

}





















