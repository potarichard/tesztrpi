package HackerRank.Stacks;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MaximumElement {

	static class StackNode 
	{
	    int val;
	    int curMax;
	    
	    public StackNode(int val, int curMax) 
	    {
	        this.val = val;
	        this.curMax = curMax;
	    }
	}
	
	static class Query 
	{
		int type;
		Integer val;
		
		public Query(int type) 
		{
			this.type = type;
		}
		
		public Query(int type, int val) 
		{
			this.type = type;
			this.val  = val;
		}
	}
	
	
	// 25					25
	// 25, 12				25
	// 25, 12, 85			85
	// -> 85
	// 25, 12, 85, 39		85
	// 25, 12, 85			85
	// 25, 12				25
	// -> 25
	public static void main(String[] args) {
		
		List<Query> queries = Arrays.asList( 
										new Query(1, 25),
										new Query(1, 12),
										new Query(1, 85),
										new Query(3),
										new Query(1, 39),
										new Query(2),
										new Query(2),
										new Query(3));

		maxElements(queries);
	}
	
	
	public static void maxElements(List<Query> queries) 
	{	    
	    int max = Integer.MIN_VALUE;
	    Stack<StackNode> stack = new Stack<StackNode>();

	    for(Query query : queries)
	    {	    	
	    	switch (query.type)
	    	{
	    	case 1:
	    		max = Math.max(query.val, max);
	            stack.add(new StackNode(query.val, max));
	    		break;
	    		
	    	case 2:
	    		if(!stack.isEmpty())
	                stack.pop();
	    		
	            if(stack.isEmpty())
	                max = Integer.MIN_VALUE;
	            
	            else
	                max = stack.peek().curMax;
	            
	    		break;
	    		
	    	case 3:
	    		if(!stack.isEmpty())
	                System.out.println(stack.peek().curMax);
	    		break;
	    	}
	    }	    
	}



}
