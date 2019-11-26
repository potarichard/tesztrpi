package tesztrpi.stackproblems;

import java.util.Stack;

public class BalancedBrackets {

	public static void main(String[] args) 
	{
		System.out.println(isBalanced("[]()([{}])[]{}[]"));
	}

	
//	{[()]}
//	{[(])}
//	{{[[(())]]}}
	
//	pakolom a stackbe
//	ha a stackbe balos jon menjen a stackbe
//	ha jobbos akkor  nezze meg a stack tetejet pop es ha az ellenkezoje akkor ok, ha nem akkor retrn no
	static String isBalanced(String s) 
    {
		Stack<Character> stack = new Stack<Character>();
		char[] sarr = s.toCharArray();
		
		if(sarr[0] == '}' || sarr[0] == ']' ||sarr[0] == ')')
			return "NO";
		
		for(char ch : sarr)
		{
			switch(ch)
			{
			case '{':
				stack.push(ch);
				break;
			case '[':
				stack.push(ch);
				break;
			case '(':
				stack.push(ch);
				break;
				
			case '}':
				if(stack.pop() != '{')
					return "NO";
				break;
			case ']':
				if(stack.pop() != '[')
					return "NO";
				break;
			case ')':
				if(stack.pop() != '(')
					return "NO";
				break;
			}
		}
		
		if(stack.size() == 0)
			return "YES";
		
		return "NO";
    }
}
