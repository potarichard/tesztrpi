package executorService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class CompleatableFutureExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
// 1 block until get
//		CompletableFuture<Void> future = CompletableFuture.runAsync(new Runnable() {
//			
//		    @Override
//		    public void run() {
//		        try 
//		        {
//		            TimeUnit.SECONDS.sleep(1);
//		        } 
//		        catch (InterruptedException e) {throw new IllegalStateException(e);}
//		        
//		        System.out.println("I'll run in a separate thread than the main thread. And Block until get");
//		    }
//		});
		
//		future.get();
//
//		System.out.println("just main 1");
		
		
// 2 do not block, get result asyncrohnusly		
//		Run a task specified by a Supplier object asynchronously
//		CompletableFuture<String> future2 = CompletableFuture.supplyAsync(new Supplier<String>() {
//		    @Override
//		    public String get() {
//		        try {
//		            TimeUnit.SECONDS.sleep(1);
//		        } catch (InterruptedException e) {
//		            throw new IllegalStateException(e);
//		        }
//		        return "Result of the asynchronous computation";
//		    }
//		});
//
//		System.out.println(future2.get());		// blocking again
//		
//		System.out.println("just main 2");
		
		
//	3 2 future one after another
		// Create a CompletableFuture
//		CompletableFuture<String> whatsYourNameFuture = CompletableFuture.supplyAsync(() -> {
//		   try {
//		       TimeUnit.SECONDS.sleep(1);
//		   } catch (InterruptedException e) {
//		       throw new IllegalStateException(e);
//		   }
//		   return "Rajeev";
//		});
//
//		// Attach a callback to the Future using thenApply()
//		CompletableFuture<String> greetingFuture = whatsYourNameFuture.thenApply(name -> {
//		   return "Hello " + name;
//		});
//
//		// Block and get the result of the future.
//		System.out.println(greetingFuture.get()); // Hello Rajeev
		
//	3.5
//		CompletableFuture<String> welcomeText = CompletableFuture.supplyAsync(() -> {
//		    try {
//		        TimeUnit.SECONDS.sleep(1);
//		    } catch (InterruptedException e) {
//		       throw new IllegalStateException(e);
//		    }
//		    return "Rajeev";
//		}).thenApply(name -> {
//		    return "Hello " + name;
//		}).thenApply(greeting -> {
//		    return greeting + ", Welcome to the CalliCoder Blog";
//		});
//
//		System.out.println(welcomeText.get());
		
		
		
//	4 amit en akartam eredetileg
//		CompletableFuture.supplyAsync(() -> {
//			
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			return "Egy kefir";
//		}).thenAccept(product -> {
//			System.out.println("Got product detail from remote service: " + product);
//		});
//		
//		
//		System.out.println("just main 2");
		
		
// 4.5
		
//		CompletableFuture.supplyAsync(() -> 
//		{
//			return "Egy kefir";
//		})
//		.thenRun(() -> {
//		    System.out.println("just main 2");
//		});
		
		
		
//	5 rothadj meg		
//		CompletableFuture.supplyAsync(() -> {
//		    try {
//		       TimeUnit.SECONDS.sleep(1);
//		    } catch (InterruptedException e) {
//		      throw new IllegalStateException(e);
//		    }
//		    return "Some Result";
//		}).thenRun( () -> {
//		    /* 
//		      Executed in the same thread where the supplyAsync() task is executed
//		      or in the main thread If the supplyAsync() task completes immediately (Remove sleep() call to verify)
//		    */
//			System.out.println(") task completes imme");
//		});
//		
//		
//		
//		System.out.println("just main 2");
		
		
		
		CompletableFuture<String> welcome = CompletableFuture.supplyAsync(() -> {			
			try 
			{
				TimeUnit.SECONDS.sleep(1);
			} 
			catch (InterruptedException e) { throw new IllegalStateException(e); }
			
		    return "Some Result";
		}).thenApplyAsync(result -> {
		    // Executed in a different thread from ForkJoinPool.commonPool()
		    return result + " Processed Result";
		});
		
		System.out.println(welcome.get());
		
		System.out.println("just main 2");
		
	}		// end main
}






























