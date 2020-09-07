package generics;


class Base {
	public void base( ) {
		System.out.println("I am base");
	}
}

class Roof extends Base {
	
}

class Box<T> {
	
	   private T t;

	   public void add(T t) {
	      this.t = t;
	   }

	   public T get() {
	      return t;
	   }
	   
	   public <U extends Number> void inspect(U u){
	        System.out.println("T: " + t.getClass().getName());
	        System.out.println("U: " + u.getClass().getName());
	    }
}

class SpecialBox<T extends Number> {
	
	   private T t;

	   public void add(T t) {
		  
		  System.out.println(t.intValue());
		   
	      this.t = t;
	   }

	   public T get() {
	      return t;
	   }
	   
	   public T getDouble() {
	      return t;
	   }
}

class UltraSpecialBox<T extends Base> {
	
	   private T t;

	   public void add(T t) {
		  
		  t.base();
		   
	      this.t = t;
	   }

	   public T get() {
	      return t;
	   }
	   
	   public T getDouble() {
	      return t;
	   }
}

public class MainExample {

	public static void main(String[] args) {
		
		  Box<Integer> integerBox = new Box<Integer>();
		  Box<String> stringBox = new Box<String>();
	    
	      integerBox.add(new Integer(1085));
	      stringBox.add(new String("Hello World"));

	      System.out.printf("Integer Value :%d\n\n", integerBox.get());
	      System.out.printf("String Value :%s\n", stringBox.get());
	      
	      integerBox.inspect(integerBox.get());
//	      integerBox.inspect("asd");
	      
	      
//	      2. special case
//	      SpecialBox<String> sbox = new SpecialBox<String>();		// csak olyat lehet ami number osztlyt kiterjeszti
	      
	      SpecialBox<Integer> sbox = new SpecialBox<Integer>();
	      sbox.add(123);
	      
//	      3. spec custom
	      UltraSpecialBox<Roof> uspbox = new UltraSpecialBox<Roof>();
	      uspbox.add(new Roof());
	   }
	
}










