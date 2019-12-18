package HackerRank.Strings;

public class LongestCommonSubsecuence {

	
//	ABCD and ABDC -> ABC, ABD length is 3
	static int commonChildRec(String s1, String s2) 
    {
		int longest = 0;
		int s1L = s1.length();
		int s2L = s2.length();
		
		if(s1.isEmpty() || s2.isEmpty())
			return 0;
		
		if(!s1.substring(s1L-1, s1L).equals(s2.substring(s2L-1, s2L)))
			longest = Math.max( commonChildRec(s1.substring(0, s1L-1), s2), commonChildRec(s1, s2.substring(0, s2L-1)));
		else
			longest = 1 + commonChildRec(s1.substring(0, s1L-1), s2.substring(0, s2L-1));
		
		return longest;
    }
	
	static int commonChildRec2(String s1, String s2) 
    {
		int longest = 0;
		
		if(s1.isEmpty() || s2.isEmpty())
			return 0;
		
		if(!s1.substring(0, 1).equals(s2.substring(0, 1)))
			longest = Math.max( commonChildRec2(s1.substring(1), s2), commonChildRec2(s1, s2.substring(1)));
		else
			longest = 1 + commonChildRec2(s1.substring(1), s2.substring(1));
		
		return longest;
    }
	
	static int commonChildDynamicProg(String s1, String s2) 
    {
		int s1L = s1.length();
		int s2L = s2.length();
		char a=0,b=0;
		int[][] table = new int[s2L+1][s1L+1];
		
		
		 for (int s2Row=1; s2Row<=s2L; s2Row++)					// rows
		 {
			 a = s2.charAt(s2Row - 1);
			 
		     for (int s1Col=1; s1Col<=s1L; s1Col++) 			// cols
		     {	    		  
		    	 b = s1.charAt(s1Col - 1);
		    	 
	    		 if (a == b) 
	    			 table[s2Row][s1Col] = table[s2Row - 1][s1Col - 1] + 1;									 // elozo +1
	    		 else 
	    			 table[s2Row][s1Col] = Math.max(table[s2Row - 1][s1Col], table[s2Row][s1Col - 1]);		 // elozoekbol a nagyobb       
		     }
		 }
		
		 return table[s2.length()][s1.length()];
    }
	
	static int longestCommonsubsequenceLength(String s1, String s2) {

	    /*
	      s2 will be on the rows, s1 will be on the columns.
	      +1 to leave room at the left for the "".
	    */
	    int cache[][] = new int[s2.length() + 1][s1.length() + 1];

	    /*
	      cache[s2.length()][s1.length()] is our original subproblem. Each entry in the
	      table is taking a substring operation against whatever string is
	      on the rows or columns.
	      It goes from index 0 to index s2Row/s1Col (exclusive)
	      So if my s1 = "azb" and s1Col = 2...then my substring that I pass
	      to the lcs() function will be:
	       0  1  2
	      "a  z  b"
	      "az" (index 2...our upper bound of the snippet...is excluded)
	    */
	    for (int s2Row = 0; s2Row <= s2.length(); s2Row++) {
	      for (int s1Col = 0; s1Col <= s1.length(); s1Col++) {

	        if (s2Row == 0 || s1Col == 0) {

	          /*
	            Base case...empty strings being solved against.
	            Remember:
	              lcs("", anything...) == 0
	              lcs(anything..., "") == 0
	              lcs("", "") == 0
	          */
	          cache[s2Row][s1Col] = 0;

	        } else if (s2.charAt(s2Row - 1) == s1.charAt(s1Col - 1)) {

	          /*
	            Characters match. Remove both and lengthen the best answer at the
	            subproblem without either final character. That is the answer
	            to this subproblem.
	          */
	          cache[s2Row][s1Col] = cache[s2Row - 1][s1Col - 1] + 1;
	        }
	        else {

	          /*
	            Character mismatch. No +1 happens, we can't lengthen the lcs. But we
	            do need to compete subproblems to find the answer to this one.
	          */
	          cache[s2Row][s1Col] = Math.max(cache[s2Row - 1][s1Col], cache[s2Row][s1Col - 1]);

	        }

	      }
	    }

	    return cache[s2.length()][s1.length()];
	  }
	
	public static void main(String[] args) {

//		commonChildRec2("aab", "azb");
		
		longestCommonsubsequenceLength("GXTXAYB", "AGGTAB");
		
		commonChildDynamicProg("AGGTAB", "GXTXAYB");
	}

}










