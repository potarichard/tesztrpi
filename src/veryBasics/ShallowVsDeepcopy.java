package veryBasics;


class CarShallow {
	
	int id;
	String name;
	Engine engine;
	
	public CarShallow(CarShallow original) {
		super();
		this.id = original.id;
		this.name = original.name;
		this.engine = original.engine;					// only the parents field copyed, the children reference the same
	}

	
	public CarShallow(int id, String name, Engine engine) {
		super();
		this.id = id;
		this.name = name;
		this.engine = engine;
	}


	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", engine=" + engine.speed + "]";
	}		
}

class CarDeep {
	
	int id;
	String name;
	Engine engine;
	
		
	public CarDeep(int id, String name, Engine engine) {
		super();
		this.id = id;
		this.name = name;
		this.engine = engine;
	}

	public CarDeep(CarDeep original) {
		super();
		this.id = original.id;
		this.name = original.name;
		this.engine = new Engine(original.engine.speed);					// children also copied
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

public class ShallowVsDeepcopy {

	public static void main(String[] args) {
		
//		1. shallow copy
		Engine eng_shallow = new Engine(55);		
		CarShallow car_s_1 = new CarShallow(1, "Vegan", eng_shallow);
		CarShallow car_s_2 = new CarShallow(car_s_1);
		
		car_s_2.name = "Madon";
		eng_shallow.speed = 66;
		
		System.out.println(car_s_1 + " | " + car_s_2);			// engine same reference, both changed
		
//		1. deep copy
		Engine eng_deep = new Engine(75);		
		CarDeep car_d_1 = new CarDeep(1, "Demon", eng_deep);
		CarDeep car_d_2 = new CarDeep(car_d_1);
		
		car_d_2.name = "Draiman";
		eng_deep.speed = 98;
		
		System.out.println(car_d_1 + " | " + car_d_2);			// engine is also copied , not the same reference, car_2 has a different engine, which was originally the same as car_1
	}

}























