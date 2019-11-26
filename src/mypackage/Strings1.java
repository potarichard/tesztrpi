package mypackage;

public class Strings1 
{

    public static String camelCase(String str) 
    {
        // your code here
        if(str == null)
          return null;
        if(str.length()==0)
          return "";
          
        str = str.substring(0,1).toUpperCase() + str.substring(1);
        
        for(int i=1; i<str.length(); i++)
        {
          if(str.substring(i-1,i).matches(" "))
          {
        	  str = str.substring(0,i-1) + str.substring(i,i+1).toUpperCase() + str.substring(i+1);
        	  i--;
          }            
        }
        
        if(str.endsWith(" "))
        	str = str.substring(0, str.length()-1);
        
        return str;
    }
	
	public static void main(String[] args) 
	{
	
		camelCase("test case  stuff  ");

	}

}
