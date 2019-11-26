package mypackage;

import java.util.Stack;

public class StackOperation 
{
	private Stack<Integer> stack = new Stack<Integer>();
	
	int min = Integer.MAX_VALUE;
	
	public void push(int x)
	{
		if(x<min)
		{
			stack.push(min);
			min = x;
		}
		
		stack.push(x);
	}
	
	public int pop()
	{
		if(stack.peek() == min)
			min = stack.peek();
		return stack.pop();
	}
	
	public int getMin()
	{
		return min;
	}
	
	public int top()
	{
		return stack.peek();
	}
	
	
	
	
	public static void main(String[] args) 
	{
		
		

	}

}









