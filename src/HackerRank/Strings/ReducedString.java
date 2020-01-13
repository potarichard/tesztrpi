package HackerRank.Strings;

public class ReducedString {

	
//	aaabccddd 	-> abd
//	aaabccbddd 	-> ad
	
	static String superReducedString(String s) 
	{
		boolean noMore = false;
		char[] word = s.toCharArray();
		
		while(!noMore)
		{
			s = "";
			noMore = true;
			
			for(int i=0; i<word.length; i++)
			{
				if(word[i] != 0 && i<word.length-1 && word[i] == word[i+1])
				{
					word[i] = word[i+1] = 0;
					noMore = false;
				}
				else if(word[i] != 0)
					s += word[i];
			}
			
			word = s.toCharArray();
		}		
		
		if(s.isEmpty())
			return "Empty String";
		
		return s;
    }
	
	public static void main(String[] args) {

		superReducedString("aaabccddd");

	}

}
