package generics;

class Test<T> 
{ 
    T obj; 
    
    public Test(T obj) 
    {  
    	this.obj = obj;  
    }

	public T getObj() 
	{
		return obj;
	}

	public void setObj(T obj) 
	{
		this.obj = obj;
	}
    
   
    public static <U> void genericDisplay (U element) 
    { 
        System.out.println(element.getClass().getName() + " = " + element); 
    } 
    
    
} 