package java8_lambdas;

public class LambdaThisReference {

	public interface Process
	{
		void process(int i);
	}
	
	public void doProcess(int i, Process p)	{
		p.process(i);
	}
	
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
		return "LambdaThisReference [<- ez az osztaly]";
	}

	public static void main(String[] args) {
		
		LambdaThisReference ltr = new LambdaThisReference();
		
		ltr.doProcess(10, i -> 
		{
			System.out.println("value of i: " + i);
//			System.out.println(this); 	// static main method, nincs this, es nem is az "anonymus Process-t implementalo classra mutat" mert olyan nincs is lambda esetén
		});

		ltr.execute();
	}

}
