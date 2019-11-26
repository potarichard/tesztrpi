package java8_lambdas;

public class Person {

	public String first_name;
	public String last_name;
	public int age;
	
	public Person() {
		super();
	}

	public Person(String first_name, String last_name, int age) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [first_name=" + first_name + ", last_name=" + last_name + ", age=" + age + "]";
	}

	
}
