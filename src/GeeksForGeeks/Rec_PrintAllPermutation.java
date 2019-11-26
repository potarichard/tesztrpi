package GeeksForGeeks;

import java.util.ArrayList;
import java.util.List;

public class Rec_PrintAllPermutation 
{

	static String word = "";
	
	static void printAll(String word)
	{
		
		printPermutn(word, "");
		
	}
	
	static void printPermutn(String str, String ans) 
    { 
		if (str.length() == word.length()-1) 
            System.out.println();
		
        if (str.length() == 0) 
        { 
            System.out.println(ans); 
            return; 
        } 
  
        int k = 0;
        
        while(k < str.length()) 
        { 
            char ch = str.charAt(k);   
           
            String possibilities = str.substring(0, k) + str.substring(k + 1);   
            
            k++;
            
            printPermutn(possibilities, ans + ch); 
        } 
        
        
    } 
	
	public static void main(String[] args) 
	{
		word = "123";
		
		printAll(word);

	}

}
