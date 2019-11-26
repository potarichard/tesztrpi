package mypackage;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class LibTree {

	
	
	
	public static void main(String[] args) 
	{
	
		Map<String, Integer> treemap = new TreeMap<String, Integer>();
		
		treemap.put("One", 6);
		treemap.put("Two", 2);
		treemap.put("Three", 8);

		System.out.println();
		
		Map<String, Integer>  lhmap = new LinkedHashMap<String, Integer>(); 
		
		lhmap.put("One", 6);
		lhmap.put("Two", 2);
		lhmap.put("Three", 8);
		
		System.out.println();
		
		
		Queue<Integer> llq = new LinkedList<Integer>();
		
		llq.add(3);
		llq.add(1);
		llq.add(43);
		llq.add(32);
		
		while(llq.size() > 0)
		{
			int elem = llq.remove();
			System.out.println(elem);
		}
		
		
		System.out.println();
		
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(3);
		stack.push(1);
		stack.push(43);
		stack.push(32);
		
		
		while(stack.size() != 0)
		{
			int elem = stack.pop();
			System.out.println(elem);
		}
	}

}















