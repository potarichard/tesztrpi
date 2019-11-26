package mypackage;

public class DPabbreviation 
{

	static String abbrevation(String a, String b)		// O(n^2)  runtime worst case
	{
		if(a.length() < b.length())
			return "NO";
				
		int k = 0;
		String mem, upp;
		
		for(int i=0; i<b.length(); i++)
		{
			while(k < a.length())
			{				
				if(b.charAt(i) == a.charAt(k))
				{
					k++;
					break;
				}
				
				else
				{
					mem = a.substring(k, k+1);
					upp = a.substring(k, k+1).toUpperCase();
					
					if(mem.equals(upp))
						return "NO";
					
					else if(b.charAt(i) == upp.charAt(0))		// mostmar egyezik b vel ?
					{
						k++;
						break;
					}
					
					else
						a = a.substring(0, k) + a.substring(k+1);
				}
			}
		}
		
		
		
		if(a.length() > b.length())		// maradt nagybetu ?
		{			
			while(k<a.length())
			{
				if(Character.isUpperCase(a.charAt(k)))
					return "NO";
				k++;
			}			
		}
			
		if(a.length() < b.length())
			return "NO";
		
		return "YES";
	}
	
	public static void main(String[] args) 
	{
		
		String aaa = "cxAbcDEds", bbb = "ABDE";
		
		String aaaa = "cXAbcDEds", bbbb = "AFDE";
		
		String a = "AbcDE", b = "ABDE";				// 1. to upper: ABcDE,  2. remove lower: ABDE
		
		String aa = "AbcDE", bb = "AFDE";			// cant convert
		
		
		String a4 = "AfPZN", b4 = "APZNC";			// NO
		
		System.out.println(abbrevation(a, b));	
	}

}


