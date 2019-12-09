package HackerRank.Stacks;

import java.util.Stack;

public class TextEditor {

	
	static Stack<String> stack = new Stack<String>();
	static String word = "";
	
	public static String edit(int type, String str)
	{
		switch(type)
		{
		case 1:
			word += str;
			stack.push(word);
			break;
		case 2:
			try
			{
				Integer num = Integer.valueOf(str);
				num = word.length() - num;
				word = word.substring(0, num);
				stack.push(word);
			}			
			catch(Exception e) {System.out.println("error");};
			
			break;
		case 3:
			try
			{
				Integer num = Integer.valueOf(str);
				if(num != null)
					System.out.println(word.charAt(Integer.valueOf(str)-1));
			}			
			catch(Exception e) {};
				
			break;
		case 4:
			if(!stack.isEmpty())
			{
				word = stack.pop();
				if(!stack.isEmpty())
					word = stack.pop();
			}				
			else
				word = "";
			break;
		}
		
		return word;
	}
	
	public static void main(String[] args) {
		
		// 1 - append
		// 2 - delete x num of chars from word
		// 3 - print the x. char
		// 4 - undo, (word = stack.pop())
		edit(1, "abc");
		edit(3, "3");
		edit(2, "3");
		edit(1, "xy");
		edit(3, "2");
		edit(4, "");
		edit(4, "");
		edit(3, "1");
	}

}
