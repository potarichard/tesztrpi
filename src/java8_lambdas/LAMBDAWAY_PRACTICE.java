package java8_lambdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;


public class LAMBDAWAY_PRACTICE 
{
	
	@SuppressWarnings("unused")
	private static void printAllWithConditionOwn(List<Person> people, Condition c) {
		System.out.println();
		
		for(Person p : people)
			if(c.test(p))
				System.out.println(p);	
	}
	
	@FunctionalInterface
	private interface Condition				// van sok gyári functional interface, nem szukseges letrehozni
	{
		boolean test(Person p);
	}
	
	
	// gyari java megoldassal
	private static void printAllWithCondition(List<Person> people, Predicate<Person> predicate) {
		System.out.println();
		
		for(Person p : people)
			if(predicate.test(p))
				System.out.println(p);	
	}
	
	// nem csaka  feltetelt, de a viselkedest is beszedi parameterkent (Consumer<T>) -> return void
	private static void performAllWithCondition(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
		System.out.println();
		
		for(Person p : people)
			if(predicate.test(p))
				consumer.accept(p);	
	}
	
	public static void main(String[] args) 
	{
		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Carol", 42),
				new Person("Thomas", "Caryle", 51),
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39));				
		
		
//		1. sort by lastname
		Collections.sort(people, (p1, p2) -> p1.last_name.compareTo(p2.last_name));		
		
//		2. print all the bastards
		performAllWithCondition(people, p -> true, p -> System.out.println(p));		
		
//		3. print all with last name begin with C
		printAllWithCondition(people, p ->  p.last_name.startsWith("C"));
		
//		4. same but with different conditon
		printAllWithCondition(people, p ->  p.last_name.startsWith("A"));
		
//		5. same but with different conditon, and explicit behaviour
		performAllWithCondition(people, p ->  p.last_name.startsWith("C"), p -> System.out.println(p.last_name));
	}

}











