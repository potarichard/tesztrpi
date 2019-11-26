package java8_lambdas;

public class WithFunctionalInterface {

	@FunctionalInterface			// makes sure, that only 1 method can be present, if someone add another method -> error
	public interface Greeting
	{
		void greet();
	}
	
	public interface Calculator
	{
		int execute(int a, int b);
	}
	
	public static class Greeter implements Greeting
	{

		@Override
		public void greet() {
			System.out.println("Szia barát");
		}
		
	}
	
	public static void main(String[] args) {
		
		// THE OLD WAY
		Greeter greeter_1 = new Greeter();
		greeter_1.greet();
		
		Greeter greeter_2 = new Greeter()
		{
			@Override
			public void greet() {
				System.out.println("Szia Gyula");
			}
		};
		greeter_2.greet();
		
		
		
		System.out.println();
		
		
		
		
		// LAMBDAS		
		// "implemented" just like this, use the interface's ONLY one method, the SIGNITURE MUST MATCH
		Greeting hello = () -> System.out.println("Hello friend");		
		Greeting bye = () -> System.out.println("Goodbye friend");
		Greeting halo = () -> System.out.println("Halo friend");
		
		hello.greet();
		bye.greet();
		halo.greet();
		
		
		
		
		System.out.println();		
		
		
		Calculator add = (int a, int b) -> a + b;			// int tipust nem kell kiirni tudja magatol a funtional interface 1 method signiturebol a tipust
		Calculator sub = (a, b) -> a - b;
		Calculator mul = (a, b) -> a * b;
		
		Calculator div = (a, b) -> 
		{
			if(b == 0) 
				return 0;
			return a / b;
		};
		
		System.out.println("add: " + add.execute(12, 6));
		System.out.println("sub: " + sub.execute(12, 6));
		System.out.println("mul: " + mul.execute(12, 6));
		System.out.println("div: " + div.execute(12, 6));
	}

}
