package java8_lambdas;

import java.util.Arrays;
import java.util.List;

public class METHODREFERENCE_WAY {

	public static void main(String[] args) throws InterruptedException {

		// there is a "void run()" method inside in which substitute a lambda, or method reference 		
		Thread th1 = new Thread(() -> printMsg());
		th1.start();
		
		Thread th2 = new Thread(METHODREFERENCE_WAY::printMsg);
		th2.start();
		
		Thread.sleep(100);
		System.out.println();
		
		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Carol", 42),
				new Person("Thomas", "Caryle", 51),
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39));
		
		
		
		people.forEach(p -> System.out.println(p));
		
		System.out.println();
		
		people.forEach(System.out::println);	
		
		
		
		System.out.println("\n______________________________\n");		
		
		
		
		people.forEach(p -> referred(p));
		
		System.out.println();
		
		people.forEach(METHODREFERENCE_WAY::referred);
	}

	static void printMsg()
	{
		System.out.println("hello friend");
	}
	
	static void referred(Person p)
	{
		System.out.println("hello friend: " + p.first_name);
	}
}







