package executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool_1 {

	public static void main(String[] args) throws InterruptedException 
	{
//		csak veges szamu thread futhat az appomban, pl. 10 db,
//		igy nincs az hogy szetbassza a cput meg leterheli szarra a rendszert
//		10 thread mehet, amikor egy vegzwett akkor egy masik szal elindulhat
		ExecutorService service = Executors.newFixedThreadPool(10);
		
		
//		be lehet allitani a cpu max core szalakat is poolnak
		int cores = Runtime.getRuntime().availableProcessors();
		service = Executors.newFixedThreadPool(cores);				// hiaba irom felul, az 1-es pool mar letezik valahol !!!
		
//		100. taskot futaassunk le, max 10 szalon, ha egy szal lefut mehet egy uj tassk rajta
		for(int i=0; i<100; i++)
			service.execute(new CPUTask());
		
		
		
//		sleep
		Thread.sleep(1000);
		System.out.println("\n_________________________\n");
		
		
//		io intensive tasks pool can be much larger
		ExecutorService io_service = Executors.newFixedThreadPool(100);
		
//		100 task egyszerre mehet 100 szalon
		for(int i=0; i<100; i++)
			io_service.execute(new IOTask());
		
		

		System.out.println("---Main Thread: " + Thread.currentThread().getName());
	}
	
	static class CPUTask implements Runnable
	{
		@Override
		public void run() {			
			System.out.println("CPU Task Thread: " + Thread.currentThread().getName()); // + " - " + Math.random()*100);			
		}		
	}

	static class IOTask implements Runnable
	{
		@Override
		public void run() {			
			System.out.println("IO Task Thread: " + Thread.currentThread().getName()); // + " - " + Math.random()*100);			
		}		
	}
}
