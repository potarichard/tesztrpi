package HackerRank.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class EasyProblems {

    static int alternate(String s) {

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        PriorityQueue<Integer> maxque = new PriorityQueue<Integer>((a,b) -> b-a);

        for(int i=0; i<s.length(); i++)
        {
        	Integer num = map.get(s.charAt(i));
        	
        	if(num == null)
        		map.put(s.charAt(i), 1);
        	else
        		map.put(s.charAt(i), num+1);
        }
        
        for(Integer val : map.values())
        	maxque.add(val);
        
        int fst = maxque.poll();
        int sec = maxque.poll();
        
        if(fst > sec)
        	return 2*sec + 1;
        
        return 2*sec;
    }
    
//  hereiamstackerrank	->	yes
//  hackerworld			->	no
    static String hackerrankInString(String s) 
    {

    	String hack = "hackerrank";
    	Map<Character, PriorityQueue<Integer>> map = new HashMap<Character, PriorityQueue<Integer>>();
    	List<PriorityQueue<Integer>> ques = new ArrayList<PriorityQueue<Integer>>();
    	 for(int i=0; i<s.length(); i++)         
    	 {
    		 PriorityQueue<Integer> indexes = map.get(s.charAt(i));
    		 
    		 if(indexes == null)
    		 {
    			 PriorityQueue<Integer> inds = new PriorityQueue<Integer>();
    			 inds.add(i);
    			 map.put(s.charAt(i), inds);
    		 }
    		 
    		 else
    		 {
    			 indexes.add(i);
    			 map.put(s.charAt(i), indexes);
    		 }          		
    	 }         	
    	 
    	 for(int i=0; i<hack.length(); i++)
    		 ques.add(map.get(hack.charAt(i)));
    	 
    	 return "YES";
    }
    
    static String hackerrankInString2(String s) 
    {
    	String hack = "hackerrank";
    	boolean[] arr = new boolean[hack.length()];
    	
    	int hi = 0, si = 0;
    	
    	while(si < s.length() && hi < hack.length())
    	{
    		if(s.charAt(si) == hack.charAt(hi))
    		{
    			arr[hi] = true;
    			hi++;
    			si++;
    		}
    		else
    			si++;
    	}
    	
    	for(int i=0; i<arr.length; i++)
    		if(!arr[i])
    			return "NO";
    	
    	return "YES";
    }
    
//    static boolean hackerrankInStringHelper(String s) 
//    {
//    	
//    }
	
    
	public static void main(String[] args) {
		
		alternate("beabeefeab");

		hackerrankInString2("hereiamstackerrank");
	}
    
}



































