package leetcode.concurency;

import java.util.HashMap;
import java.util.Map;

class Foo {

    static Object lock = new Object();
    boolean fst = false, sec = false;
    
    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        synchronized(lock)
        {
            printFirst.run();
            fst = true;
            notifyAll(); // can wake from wait state
        }
        
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        synchronized(lock)
        {               
            while(!fst)
                wait(); 
            
            printSecond.run();
            sec = true;
            notifyAll(); // can wake from wait state
        }
        
    }

    public void third(Runnable printThird) throws InterruptedException {
        
       
        synchronized(lock)
        {
            while(!fst && !sec)
                wait(); 
            printThird.run();           
        }
    }
    
    public int[] twoSum(int[] nums, int target) {
    	
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i=0; i<nums.length; i++)
        {            
            map.put(nums[i], i);
        }
        
        for(int i=0; i<nums.length; i++)
        {   
        	int nm = target-nums[i];
        	
            if(map.containsKey(nm))
            	return new int[] {i, map.get(nm)};
        }
        
        return null;
    }
    
    public static void main()
    {
    	
    }
}




