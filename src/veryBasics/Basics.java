package veryBasics;

public class Basics {

	public static void main(String[] args) 
	{
		
		int max = 0;
		int min = Integer.MAX_VALUE;
		int fst = 23;
		int sec = 11;
		
		max = Math.max(fst, sec);
		min = Math.min(fst, sec);
		
		System.out.println("max " + max);
		System.out.println("min " + min);
		
		
		fst = 44;
		sec = 98;
		
		min = Math.min(fst, sec);
		max = Math.max(fst, sec);
		
		System.out.println("max " + max);
		System.out.println("min " + min);
	}

}
