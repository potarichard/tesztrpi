package HackerRank;

public class StringTransform 
{

	// 1. can delte lastchar in one move
	// 2. can append a char in one move
	// can end == start in moves ?
	
//  example
//	hackerhappy
//	hackerrank
//	9
	static String appendAndDelete(String start, String end, int moves) 
    {

		int i=0;
		
		if(start.length() >= end.length())
		{
			for(i=0; i<start.length(); i++)
	        {
	        	if(start.charAt(i) != end.charAt(i))
	        	{
	        		moves -= ((start.length() - i) + (end.length() -i));
	        		break;
	        	}
	        }
		}
		
        

        if(moves >=0)
        	return "Yes";
        
        return "No";
        
    }
	
	public static void main(String[] args) 
	{
		
		System.out.println(appendAndDelete("hackerhappy", "hackerrank", 9));

	}

}
