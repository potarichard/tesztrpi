package HackerRank.Trees;

public class HuffmanDecoding {

	static class Node
	{
		public  int frequency;
		public  char data;
		public  Node left, right;
		
		public Node() {}
		
		public Node(char val)
		{
			this.data = val;
		}
		
		public Node(char val, int freq)
		{
			this.data = val;
			this.frequency = freq;
		}
	}
	
	static String decodeH(String s, Node root) 
	{
       if(root.left == null && root.right == null)
       {
    	   System.out.print(root.data);
    	   return s;
       }
       
       else if(s.startsWith("0"))
    	   s = decodeH(s.substring(1), root.left);   
    	   
       else if(s.startsWith("1"))
    	   s = decodeH(s.substring(1), root.right);   
       
       return s;
    }
	
	static void decode(String s, Node root) 
	{
		while(s.length() > 0)
			s = decodeH(s, root);
	}
	
	
	public static void main(String[] args) 
	{
		
		Node 
		root = new Node();
		root.left = new Node();
		root.right = new Node('A');
		root.left.left = new Node('B');
		root.left.right = new Node('C');
		
		decode("1001011", root);
	}

}
























