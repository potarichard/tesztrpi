package java8_lambdas;

public class LambdaThisReference {

	public interface Process
	{
		void process(int i);
	}
	
	public interface Pow
	{
		int process(int i);
	}
	
	public void doProcess(int i, Process p)	{
		p.process(i);
	}
	

	
	// az interface helyere a benne levo 1 db (csak 1 lehet ezert functional interface) methoddal kell passzolni az argumenteknek
	public void execute()	
	{
		doProcess(10, i -> 
		{
			System.out.println("value of i: " + i);
			System.out.println(this); 	// itt mar mukodik mert a this a LambdaThisReference-re mutat
		});
	}
	
	
	
	@Override
	public String toString() {
		return this.getClass().getName() + " [<- ez az osztaly]";
	}

	public static void main(String[] args) {
		
		LambdaThisReference ltr = new LambdaThisReference();
		
//		ltr.doProcess(10, i -> 
//		{
//			System.out.println("value of i: " + i);
////			System.out.println(this); 	// static main method, nincs this, es nem is az "anonymus Process-t implementalo classra mutat" mert olyan nincs is lambda esetén
//		});

		ltr.execute();
		
		
		Pow power = i -> i+i;			// ez JS nel is igy van, const pow = i => i+i,   then call like: pow(5)
		
		System.out.println("power ami sum: " + power.process(5));
	}

}
