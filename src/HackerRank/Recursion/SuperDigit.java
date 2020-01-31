package HackerRank.Recursion;

public class SuperDigit {

	// max k steps, sum digits, if one digit return
	static int superDigit(String n, int k) 
	{
		long num = 0l;
		
		String asd = n;
		
		while(k>1)
		{
			n += asd;
			k--;
		}
		
		while(n.length() > 1)
		{
			num = 0l;
			
			for(int i=0; i<n.length(); i++)
				num += Integer.valueOf(n.charAt(i)-48);
			
			n = String.valueOf(num);
		}
		
		return (int) num;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		superDigit("9875", 4);
	}

}
