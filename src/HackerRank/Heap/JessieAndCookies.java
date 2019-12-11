package HackerRank.Heap;

import java.util.PriorityQueue;

public class JessieAndCookies {
	
	// easy priority que
	static int cookies(int k, int[] A) 
	{
       PriorityQueue<Integer> cookiesQ = new PriorityQueue<Integer>();
       int count = 0;
       
       for(int a : A)
    	   cookiesQ.add(a);
       
       int new_cookie;
       
       while(cookiesQ.size() >= 2)
       {
    	   if(cookiesQ.peek() >= k)
    		   return count;
    	   
    	   new_cookie = cookiesQ.poll() + 2*cookiesQ.poll();
    	   
    	   cookiesQ.add(new_cookie);
    	   
    	   count++;    	   
       }
		
		
       return -1;
    }

	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3, 9, 10, 12};

		cookies(7, arr);
	}

}







































