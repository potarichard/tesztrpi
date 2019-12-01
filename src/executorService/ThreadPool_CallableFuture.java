package executorService;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;


public class ThreadPool_CallableFuture {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService service = Executors.newFixedThreadPool(10);
		
//		Future<Integer> future = service.submit(new Task());			// like a promise/placeholder/monobody  takes a place for the future value
		

// 1. csak siman visszakerjuk		
// 		System.out.println(future.get());	// block until gets back
		
// 2. varjuk az erteket 1 timeout ideig
//		try {
//			System.out.println(future.get(1, TimeUnit.SECONDS));
//		} 
//		catch (TimeoutException e) {System.out.println("Future.get timed out");}	
		
// 3. ha kesz akkor irjuk ki, de mire ideér még boven nincs kesz
//		if(future.isDone())
//			System.out.println(future.get());
		
		
// 4. a megoldas => CompleatableFuture (callbacket ad)
		
//		CompletableFuture.supplyAsync( () -> )
		
		
//		5 sajat callback
		
		CallbackTask cbt = new CallbackTask(new Task_1(), () -> System.out.println("Vegzett a rohadek"));
		service.execute(cbt);
		
		System.out.println("---Main Thread: " + Thread.currentThread().getName());
	}

	static class Task implements Callable<Integer>
	{
		
		@Override
		public Integer call() throws Exception {
			Thread.sleep(2500);
			return new Random().nextInt();
			
		}		
	}
	
	static class Task_1 implements Runnable
	{		
		@Override
		public void run() {
			try 
			{
				Thread.sleep(2500);
			} 
			catch (InterruptedException e) {e.printStackTrace();}			
		}		
	}
	
	static class CallbackTask implements Runnable {

		  private final Runnable task;

		  private final Runnable callback;

		  CallbackTask(Runnable task, Runnable callback) {
		    this.task = task;
		    this.callback = callback;
		  }

		  public void run() {
		    task.run();
		    callback.run();
		  }

		}
	
}
