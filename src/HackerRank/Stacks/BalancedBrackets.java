package HackerRank.Stacks;

import java.util.Stack;

public class BalancedBrackets {

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
                if (stack.empty() || (stack.peek() != '{')) {
                    return "NO";
                }
                stack.pop();
                break;
            case ')':
                if (stack.empty() || (stack.peek() != '(')) {
                    return "NO";
                }
                stack.pop();
                break;
            case ']':
                if (stack.empty() || (stack.peek() != '[')) {
                    return "NO";
                }
                stack.pop();
                break;
            }
        }
        
        return stack.empty() ? "YES" : "NO";

    }
	
	public static void main(String[] args) 
	{
		
		System.out.println( isBalanced("{{[[(())]]}}") );
		
		System.out.println( isBalanced("{[])[))[)}}]}([}()}{{]}[)}{)}[}}]])}((((])[)[[()[{({](}]") );

	}
	
}

















