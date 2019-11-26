package HackerRank;

public class MiscComplementer 
{

	static int onesComplement(int n) 
    { 
        int number_of_bits =  (int)(Math.floor(Math.log(n) / Math.log(2))) + 1; 
  
        return ((1 << number_of_bits) - 1) ^ n; 
    } 
      
	
    public static void main(String[] args) 
    { 
        int n = 22; 
          
        System.out.print(onesComplement(n)); 
    } 
	
}
