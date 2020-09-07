package mypackage;

public class LookAndSay 
{

	// 112, megy egy marker i tol,  ha uj szam jon a marker = i, ha ugyanaza  szam jon marker = i
	
	
	
	public String LNS(String num)
	{		
		String 	ret  = "";
		char	what = num.charAt(0);
		int 	marker = 0,	i = 0;
		
		
		for(i=0; i<num.length(); i++)
		{
			if(what != num.charAt(i))
			{		
				what = num.charAt(i);
				ret += getWhat(marker, i, num);
				marker = i;				
			}				
		}
		
		ret += getWhat(marker, i, num);
		
		return ret;
		
	}
	
	private String getWhat(int marker, int i, String word) {
		
		int count = word.substring(marker, i).length();
		String value = word.substring(marker, marker+1);
		
		return count + value;
	}
	
	public void printToN(int n)
	{
		String result = "1";
		for(int i=1; i<=n; i++)
		{
			result = LNS(result);
			System.out.println(result);
		}
	}
	
	public static void main(String[] args) 
	{
		
		LookAndSay lns = new LookAndSay();
		
		String result = lns.LNS("112");		// should return 2112

		System.out.println(result + "\n" );
		
//		lns.printToN(20);
	}

}
















