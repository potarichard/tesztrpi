package GeeksForGeeks;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Endecode {

	public static void main(String[] args) throws UnsupportedEncodingException 
	{
		
		String pwd = "hé@|llõ1";
		
		String saved = Base64.getEncoder().encodeToString(pwd.getBytes());
		
		byte[] loaded = Base64.getDecoder().decode(saved);
		
		String load = new String(loaded);

	}

}
