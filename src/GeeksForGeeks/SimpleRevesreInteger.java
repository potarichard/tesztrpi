package GeeksForGeeks;

public class SimpleRevesreInteger 
{

//	1. megoldas alakitsuk stringge es ugy konynnyebb
	
//	2. mod es /10 cuccok
	static int reverseInt(int num)
	{
		int result = 0;
		int remain = Math.abs(num);
		
		while(remain != 0)
		{
			result *= 10;
			result += remain % 10;
			remain /= 10;
		}
		
		return num < 0 ? -result : result;
	}
	
	public static void main(String[] args) 
	{
		
		System.out.println(reverseInt(123));
		System.out.println(reverseInt(-123));

	}

}
