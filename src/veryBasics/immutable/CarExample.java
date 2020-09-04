package veryBasics.immutable;

final class Car {
	
	private final int id;
	private final String name;
	private final Engine engine;
	
	public int mutable_field;
	
	public Car(int id, String name, Engine engine) {
		super();
		this.id = id;
		this.name = name;
		this.engine = new Engine(engine.speed);
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", engine=" + engine.speed + "]";
	}		
}

class Engine {
	int speed;

	public Engine(int speed) {
		this.speed = speed;
	}
	
}

//class SportCar extends Car { }				// mivel final nem lehet kiterjeszteni

public class CarExample {

	public static void main(String[] args) {
		
		Engine engine = new Engine(50);
		Car car = new Car(1, "Renu", engine);

		// 1. usecase
		System.out.println(car);
		engine.speed = 85;
		System.out.println(car);			// mivel a car nem a refenciat hasznalja, hanem lecopyzta maganak az enginet igy nem valtozik a speed
		
		// 2. usecase
		Car car2 = car;
		
		System.out.println(car.hashCode() + " - " +car2.hashCode());
		
		System.out.println(car.hashCode() == car2.hashCode());
		
		car.mutable_field = 15;		// megvaltozik minda kettoben hiszen ugyanarra a referenciara mutatnak
		
		System.out.println(car.mutable_field + " - " + car2.mutable_field);
		
		car2 = new Car(2, "Wagon", engine);
		
		System.out.println(car.mutable_field + " - " + car2.mutable_field);
		
		// 2.nd example
		int[] arr_1 = {6,7,3,1};
		int[] arr_2 = {8,9,5,3};
		
		arr_2 = arr_1;		// ugyan az a ref
		
		arr_2 = new int[]{80,90,50,30};	// arr_1 marad ami volt, arr_2 uj ref, semmi extra
		
		// 3. example
		String egy = "egy";
		String ketto = "ketto";
		
		ketto = egy.toUpperCase();		// egy nem lesz uppercase !
		
		System.out.println(egy + " - " + ketto);
			
		ketto = egy;					// ugyan az lesz a referenciajuk
		
		System.out.println(egy + " - " + ketto);
		
		egy = "masfel";					// a ketto nem valtozik meg
		
		System.out.println(egy + " - " + ketto);
		
		ketto = egy;
		egy = new String("sokleszma");	// a ketto mivel immutable, nem veszi fel az egy referenciavaltozasat, mert nem ugyanoda mutatnak
		
		System.out.println(egy + " - " + ketto);
	}

}



















