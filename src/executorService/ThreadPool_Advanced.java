package executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool_Advanced {

	public static void main(String[] args) {
		
		ExecutorService service = Executors.newFixedThreadPool(10);
		
//		igy lehetne constructorral emghivni
		ExecutorService service_contructed = 
				new ThreadPoolExecutor(10, 10, 1L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

		
	}

}
