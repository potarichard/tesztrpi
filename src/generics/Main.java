package generics;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) 
	{
		System.out.println("Create objects from generic class\n");
		
        Test <Integer> iObj = new Test<Integer>(15);        
        iObj.setObj(44);
        iObj.setObj(iObj.getObj() + 134);
        System.out.println(iObj.getObj()); 
   
        Test <String> sObj = new Test<String>("GeeksForGeeks");        
        System.out.println(sObj.getObj()); 

        
        System.out.println("\nGeneric method that accepts any type as parameter\n");
        
        Test.genericDisplay(11); 
   
        Test.genericDisplay("GeeksForGeeks"); 
   
        Test.genericDisplay(1.0); 
        
        
// 1    generic arraylist
//      Creatinga an ArrayList without any type specified 
        ArrayList al = new ArrayList(); 
  
        al.add("Sachin"); 
        al.add("Rahul"); 
        al.add(10); // Compiler allows this 
  
        String s1 = (String)al.get(0); 
        String s2 = (String)al.get(1); 
  
        // Causes Runtime Exception 
//        String s3 = (String)al.get(2); 
        
// 2    specified type
        // Creating a an ArrayList with String specified 
        ArrayList <String> a2 = new ArrayList<String> (); 
  
        a2.add("Sachin"); 
        a2.add("Rahul"); 
  
        // Now Compiler doesn't allow this 
//        a2.add(10);  
  
        String s10 = (String)a2.get(0); 
        String s20 = (String)a2.get(1); 
	}

}
