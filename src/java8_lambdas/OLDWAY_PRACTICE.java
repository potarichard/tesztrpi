package java8_lambdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OLDWAY_PRACTICE {	
	
	private static void printAll(List<Person> people) {
		System.out.println();
		
		for(Person p : people)
			System.out.println(p);
	}
	
	private static void printAllWithC(List<Person> people, Condition c) {
		System.out.println();
		
		for(Person p : people)
			if(c.test(p))
				System.out.println(p);	
	}
	
	private interface Condition
	{
		boolean test(Person p);
	}
	
	public static void main(String[] args) {
		
		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Carol", 42),
				new Person("Thomas", "Caryle", 51),
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39));
				
		
//		0. stream sort
		people = people.stream()
			.sorted((p1,p2) -> 	p1.last_name.compareTo(p2.last_name))
			.collect(Collectors.toList());
		
		System.out.println();
		
//		1. sort by lastname
		Collections.sort(people, new Comparator<Person>() {
			
			@Override
			public int compare(Person o1, Person o2) {
				return o1.last_name.compareTo(o2.last_name);
			}
		});
		
//		2. print the bastards
		printAll(people);
		

		
//		3. print all with last name begin with C
		printAllWithC(people, new Condition() {
			@Override
			public boolean test(Person p) {
				return p.last_name.startsWith("C");
			}			
		});
		
//		4. same but with different conditon
		printAllWithC(people, new Condition() {
			@Override
			public boolean test(Person p) {
				return p.last_name.startsWith("A");
			}			
		});
		
	}





}
