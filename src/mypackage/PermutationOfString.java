package mypackage;

public class PermutationOfString {

	
	static void stringPermutations(String word)
	{
		printPermutn(word, "");
	}
	
	static void printPermutn(String str, String ans)
	{
		if (str.length() == 0) 
        { 
            System.out.println(ans); 
            return; 
        } 
		
		int k = 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		stringPermutations("abc");
		
	}

}
