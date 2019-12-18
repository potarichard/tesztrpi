package HackerRank.Implementation;

public class PermutBiggerString {

	// check f the next permut is bigger, return it
    // Complete the biggerIsGreater function below.
	
	// one loop -> map
	// next lop from back
    static String biggerIsGreater(String w) {

    	char[] word = w.toCharArray();
    	char min_char = Character.MAX_VALUE; 
    	int min_index = 0;
    	
    	for(int i=0; i<word.length; i++)
    	{
    		if(Character.toLowerCase(word[i]) < min_char)
    		{
    			min_char = word[i];
    			min_index = i;
    		}
    	}
    		
    		
    	for(int i=0; i<word.length; i++)
    	{    		
    		if(Character.toLowerCase(word[i]) > Character.toLowerCase(min_char))
    		{
    			char temp = word[i];    			
    			word[i] = min_char;
    			word[min_index] = temp;
    			
    			break;
    		}
    	}
    	
    	if(String.valueOf(word).equals(w))
    		return "no answer";
    	
    	return String.valueOf(word);
    }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		biggerIsGreater("dkhc");

	}

}
