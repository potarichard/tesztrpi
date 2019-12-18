package HackerRank.Implementation;

public class PatternSearch {

   static String gridSearch(String[] G, String[] P) 
   {
	   int count = 0;
	   String wo = "";
	   boolean found = false;
	   
	   for(int i=0; i< G.length; i++)
	   {
		   for(int k=0; k<G[i].length(); k++)
		   {
			   if((k+P[0].length()) <= G[i].length())
			   {
				   wo = G[i].substring(k, k+P[0].length());
				   
				   if(wo.equals(P[0]))
				   {
					   count = i+1;
					   found = true;
					   
					   for(int c=1; c<P.length; c++)
					   {
						   if(count<G.length)
						   {
							   wo = G[count].substring(k, k+P[c].length());
							   
							   if(wo.equals(P[c]))
							   {
								   count++;
								   continue;
							   }
							   else
							   {
								   found = false;
								   break;
							   } 
						   }
						   else
						   {
							   found = false;
							   break;
						   }
					   }
					   
					   if(found)
						   return "YES";
				   }
					   
			   }
			   else
				   break;			   
		   }
	   }

	   return "NO";
   }
   

	
	public static void main(String[] args) {
		
		String[] grid = {	"7283455864",
							"6731158619",
							"8988242643",
							"3830589324",
							"2229505813",		// 9505
							"5633845374",		// 3845
							"6473530293",		// 3530
							"7053106601",
							"0834282956",
							"4607924137"};
		
		String[] pattern = {"9505",
							"3845",
							"3537"};

		gridSearch(grid, pattern);
	}

}
