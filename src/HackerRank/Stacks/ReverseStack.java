package HackerRank.Stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReverseStack {

//	1. with recursion	
	public static void reverse(Stack<Integer> stack)
	{
		if(stack.isEmpty())
			return;
		
		int temp = stack.pop();
		reverse(stack);
		pushToBottom(stack, temp);
	}
	
	private static void pushToBottom(Stack<Integer> stack, int x)
	{
		if(stack.isEmpty())
		{
			stack.push(x);
			return;
		}
		
		int temp = stack.pop();
		pushToBottom(stack, x);
		stack.push(temp);
	}
	
	
//	2. using another stack
	public static void reverseEasy(Stack<Integer> stack)
	{
		List<Integer> rev = new ArrayList<Integer>();
		
		while(!stack.isEmpty())
			rev.add(stack.pop());
		
		// stack = rev;	// a stack a rev-re mutat ami csak a call frame vegeig él ...
		
		for(Integer num : rev)
			stack.push(num);
	}
	
	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack<Integer>();

		stack.push(1); 
		stack.push(2); 
		stack.push(3); 
		stack.push(4);
		
		
		reverse(stack);
		reverseEasy(stack);
	}

}












