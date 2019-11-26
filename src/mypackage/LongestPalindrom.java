package mypackage;

// https://algorithmsandme.com/longest-palindrome-substring/

public class LongestPalindrom 
{

	public String longestPal(String word)
	{
		String pal = "";
		String ret = "";
		int len = word.length();
		int end = len-1;		// az eppen leghosszabb szo aktualis veg
		
		for(int i=0; i<len; i++)
		{			
			for(int k=end; k>=0; k--)		// k>i+max ???
			{				
				if(word.charAt(i) == word.charAt(k))
				{
					pal += word.charAt(k);
					
					if(pal.length() > ret.length())
						ret = new String(pal);		
					
					if(k>0 && i<len-1)
					{
						if(word.charAt(i+1) != word.charAt(k-1))
						{
							pal = "";
							end = len-1;
							break;
						}
						else
						{
							end = k-1;
							break;
						}	
					}	
				}				
			}
		}
		
		return ret;
	}
	
	
	
	public String longestPalBruteForce(String word)
	{
		int longest = Integer.MIN_VALUE;
	    int start = 0; 
	    int end = -1;
	     
	    for(int i=0; i<word.length(); i++)
	    {
	        int currentLength = 1;
	        
	        for(int j= i-1, k= i+1; j>=0 && k < word.length() && word.charAt(j) == word.charAt(k); j--, k++)
	        	currentLength+= 2;
	        
	        if(currentLength >= longest) 
	        {
	            longest = currentLength;
	            start = i - currentLength / 2;
	            end = i + currentLength / 2;
	        }
	    }
	 
	    for(int i=0; i<word.length(); i++)
	    {
	        int currentLength = 0;
	        
	        for(int j= i, k= i+1; j>=0 && k < word.length() && word.charAt(j) == word.charAt(k); j--, k++)
	        	currentLength+=  2;
	 
	        if(currentLength >= longest) 
	        {
	            start = (i - currentLength/2) + 1;
	            end = (i + currentLength /2 );
	            longest = currentLength;
	        }
	    }
	 
	    return word.substring(start,end+1);
	}
	
	
	public String longestPalindromeSubstring(String s) 
	{
        if(s.length() == 0 ) 
        	return ""; 
        
        int 	longest = 0,
        		start = 0,
        		end = 0;
        
        boolean[][] table = new boolean[s.length()][s.length()];
        
        table[0][0] = true;
 
        for (int i = 1; i < s.length(); i++) 
        {
            //All single characters are palindrome in itself
            table[i][i] = true;
    
            //All two characters are palindrome if two characters are equal
            table[i - 1][i] = s.charAt(i - 1) == s.charAt(i);
            
            if(table[i-1][i] && longest <= 2)
            {
                longest = 2;
                start = i-1;
                end = i;
            }
 
        }
 
        for (int L = 3; L <= s.length(); L++) 
        {
            for (int i = 0; i <= s.length()-L; i++) 
            {
                int j = i + L - 1;
                
                table[i][j] = table[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
 
                if(table[i][j] && longest <= L)
                {
                    longest = L;
                    start = i;
                    end = j;
                }
            }
        }
 
        return s.substring(start, end+1);
 
    }
	
	public String bruteForce2(String word)
	{
		// kezdoindex 0 tol, +1 ig, + 2 ig
		int len = word.length();
		String check = "";
		String ret = "";
		
		for(int start=0; start<len; start++)				// O(n)
		{
			for(int next=start; next<len; next++)			// O(n*n)
			{
				check = word.substring(start, next);
				check = isPalindrom(check);					// o(n*n*n/2)
				if(check.length() > ret.length())
					ret = new String(check);
			}
		}
		
		return ret;
	}
	
	public String isPalindrom(String s)
	{
		int k = s.length()-1;
		
		for(int i=0; i<=k; i++)
		{
			if(s.charAt(i) != s.charAt(k--))
				return "";
		}
		
		return s;
	}
	
	
	
	public static void main(String[] args) 
	{
		
		LongestPalindrom pal = new LongestPalindrom();
		
		//										9               25
//		System.out.println(pal.longestPal("bcnsauhasindulagorogaludnicnjbsa"));
//
//		System.out.println(pal.longestPalBruteForce("bcnsauhasindulagorogaludnicnjbsa"));
//		
		System.out.println(pal.longestPalindromeSubstring("xkek8"));
		
		System.out.println(pal.bruteForce2("bcnsauhasindulagorogaludnicnjbsa"));
		
		System.out.println(pal.bruteForce2("bcnsauhgorogasinddulago3rogaluddnicnjbsaindulagorogaludnisdas89d "));
	}

}




















