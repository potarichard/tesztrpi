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
            case '[':
            case '(':
            	stack.push(ch);
                break;
                
            case '}':
                if(stack.empty() || stack.pop() != '{')
                    return "NO";
                break;
            case ']':
                if(stack.empty() || stack.pop() != '[')
                    return "NO";
                break;
            case ')':
                if(stack.empty() || stack.pop() != '(')
                    return "NO";
                break;
            }
        }
        
        if(stack.size() == 0)
            return "YES";
        
        return "NO";

    }
	
	public static void main(String[] args) 
	{
		
		System.out.println( isBalanced("{{[[(())]]}}") );
		
		System.out.println( isBalanced("{[])[))[)}}]}([}()}{{]}[)}{)}[}}]])}((((])[)[[()[{({](}]") );

	}
	
}

















