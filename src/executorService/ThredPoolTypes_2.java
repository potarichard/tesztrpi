package executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class ThredPoolTypes_2 {

	public static void main(String[] args) {
		
// 1	fixed, same as before
//		.....
		
// 2	cached pool 
		
//		ExecutorService service = Executors.newCachedThreadPool();
//		
//		for(int i=0; i<100; i++)
//			service.execute(new CPUTask());
		
		
// 3	scheldued pool
		ScheduledExecutorService service_scheldued = Executors.newScheduledThreadPool(10);

		service_scheldued.schedule(new CPUTask(), 3, TimeUnit.SECONDS);						// run after 3 sec
		
		service_scheldued.scheduleAtFixedRate(new CPUTask(), 1, 1, TimeUnit.SECONDS);		// runs in every 1 second
		
		service_scheldued.scheduleWithFixedDelay(new CPUTask(), 1, 1, TimeUnit.SECONDS);	// runs in every 1 second, after prev task completes
	}
	
	
	static class CPUTask implements Runnable
	{
		@Override
		public void run() {			
			System.out.println("CPU Task Thread: " + Thread.currentThread().getName()); // + " - " + Math.random()*100);			
		}		
	}

}
