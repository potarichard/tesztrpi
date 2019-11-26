package GeeksForGeeks;

public class JustAddByBitOperation 
{

	public static int getSum(int a, int b) 
	{
		int carry = 0;
		
	    while (b != 0) 
	    {		    
	      carry = a & b;
	   
	      a = a ^ b;

	      b = carry << 1;
	    }

	    return a;
	}
	
	public static void main(String[] args) 
	{
		
//		100 & 011  = 000 is the carry
//		a xor b = 111
//		b = 000 << 1 = 000
//		ret 111  = 7
		System.out.println(getSum(4, 3));		

//		001  &  011  = 001  carry
//		a = a xor b  = 010
//		b = 001 << 1 = 010
//		010 & 010  = 010 carry
//		a = a xor b = 000
//		b = 010 << 1 = 100
//		a & b = 0
//		a = a xor b = 100
//		b = 0 over
		System.out.println(getSum(1, 3));	
		
		
//		101 & 101 = 101 carry
//		a xor b = 0 = a
//		101 << 1 = 1010 = 10 = b
//		carry = a  & b = 0 & 1010 = 0
//		a = a xor b = 1010
//		b = 0
		System.out.println(getSum(5, 5));	
	}

}
