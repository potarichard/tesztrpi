package java8_lambdas;

import java.util.Arrays;
import java.util.List;

// lenyeg, hogy nem egy iteratorral megyek vegig a listan es csinalok dolgokat
// mi egyhelyben allunk es a lista megy el elottunk, amin tobb muvelet megy vegbe egyszerre 
public class StreamsIntroduction {
	
	
	public static void main(String[] args) 
	{
		
		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Carol", 42),
				new Person("Thomas", "Caryle", 51),
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39));
		
//		1. egy muvelet egyhelyben megy at elotte stream a lista
		people.stream()
		.forEach(p -> System.out.println(p));
		
		System.out.println("\n__________________________________________________\n");
		
//		2. minden muvelet valtoztathat a streamen, igy a kovetkezo lepesre hatassal lehet
		people.stream()
		.filter(p -> p.last_name.startsWith("C"))
		.forEach(p -> System.out.println(p));

		
//		people.stream()										// stream source
//		.filter(p -> p.last_name.startsWith("C"))			// operations on stream
//		.forEach(p -> System.out.println(p));				// stream termintor\end condititon (tells what to do on the stream finally)
	
	
//		3.
		System.out.println();
		
		long count = people.stream()
		.filter(p -> p.last_name.startsWith("C"))
		.count();
	
		System.out.println("counted: " + count);
	}

}




















