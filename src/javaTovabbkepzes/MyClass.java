package javaTovabbkepzes;

public class MyClass implements MyInterface{

	
	public MyInterface myInterface;
	
	public void anyad()
	{
		myInterface = (p1, p2) -> 
		{ 
			return p2 + p1; 
		};
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyClass mc = new MyClass();
		
		mc.anyad();
		
	}





	@Override
	public String doSomething(int param1, String param2) {

		System.out.println("doing time");
		
		return null;
	}

}
