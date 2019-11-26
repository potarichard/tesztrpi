package mypackage;

/**
 * This file contains a dynamic programming solutions to the classic 0/1 knapsack problem where are
 * you are trying to maximize the total profit of items selected without exceeding the capacity of
 * your knapsack.
 */

public class WillKnapSack 
{

   /**
   * @param capacity - The maximum capacity of the knapsack
   * @param Weights - The weights of the items
   * @param Values - The values of the items
   * @return The maximum achievable profit of selecting a subset of the elements such that the
   *     capacity of the knapsack is not exceeded
   */
  public static int knapsack(int capacity, int[] Weights, int[] Values) 
  {
    if (Weights == null || Values == null || Weights.length != Values.length || capacity < 0)
      throw new IllegalArgumentException("Invalid input");

    final int N = Weights.length;

    // Initialize a table where individual rows represent items
    // and columns represent the weight of the knapsack
    int[][] DP = new int[N + 1][capacity + 1];

    for (int i = 1; i <= N; i++) 
    {

      // Get the value and weight of the item
      int 	w = Weights[i - 1], 
    		v = Values[i - 1];

      for (int sz = 1; sz <= capacity; sz++) 
      {
        // Consider not picking this element
        DP[i][sz] = DP[i - 1][sz];

        // Consider including the current element and
        // see if this would be more profitable
        if (sz >= w && DP[i - 1][sz - w] + v > DP[i][sz]) 
        	DP[i][sz] = DP[i - 1][sz - w] + v;
      }
    }

    int sz = capacity;
    java.util.List<Integer> itemsSelected = new java.util.ArrayList<>();

    // Using the information inside the table we can backtrack and determine
    // which items were selected during the dynamic programming phase. The idea
    // is that if DP[i][sz] != DP[i-1][sz] then the item was selected
    for (int i = N; i > 0; i--) 
    {
      if (DP[i][sz] != DP[i - 1][sz]) 
      {
        int itemIndex = i - 1;
        itemsSelected.add(itemIndex);
        sz -= Weights[itemIndex];
      }
    }

    // Return the items that were selected
    // java.util.Collections.reverse(itemsSelected);
    // return itemsSelected;

    // Return the maximum profit
	    return DP[N][capacity];
	}
  
  	public void knapsackRec()
  	{
  		Integer[] sub = new Integer[4];
  		
  		ksRH(sub, 0);
  	}

    int[] selected = new int[4];
    int capacity = 10;
    int weight = 0;
    int amount = 0;
    int maxval = 0;
    int[] V = {1, 4, 8, 5};
    int[] W = {3, 3, 5, 6};
    
  	public void ksIterative()
  	{
  		this.weight = 0;
  		this.amount = 0;
  		this.maxval = 0;
  		this.selected = new int[4];
  		
  		int max_subsets = 1 << this.W.length;
  		int mask = 0;
  		
  		for(int i=1; i<max_subsets; i++)
  		{
  			this.weight = 0;
  	  		this.amount = 0;
  	  		
  			for(int j=0; j<W.length; j++)
			{
				mask = 1<<j;						
				if((mask & i) > 0)
				{
					this.weight += W[j];
					this.amount += V[j];
				}
				if(this.weight > this.capacity)
					break;
			}
  			
  			if(this.amount > this.maxval && this.weight <= this.capacity)
  			{
  				this.maxval = this.amount;
  				this.selected = new int[4];
  				
  				for(int k=0; k<W.length; k++)
  	  			{
  					mask = 1<<k;						
  					if((mask & i) > 0)
  	  					this.selected[k] = 1;
  	  			}
  			} 
  		}
  		
  		System.out.println();
  	}
    
  	private void ksRH(Integer[] sub, int i)
  	{
  		if(i == sub.length)
  		{
  			this.weight = 0;
  			this.amount = 0;
  			
  			for(int k=0; k<sub.length; k++)
  			{
  				if(sub[k] != null)
  				{
  					this.weight += W[k];  
  					this.amount += V[k];
  				}
  				
  				if(this.weight > this.capacity)
  				{
  					this.amount = 0;
  					break;
  				}
  				
  			}
  			
  			if(this.amount > this.maxval)
  			{
  				this.maxval = this.amount;
  				this.selected = new int[4];
  				
  				for(int k=0; k<sub.length; k++)
  	  			{
  	  				if(sub[k] != null)
  	  					this.selected[k] = 1;
  	  			}
  			}  			
  		}
  		
  		else
		{
			sub[i] = null;
			ksRH(sub, i+1);
			
			sub[i] = this.V[i];
			ksRH(sub, i+1);
		}
  	}
  	
	  public static void main(String[] args) 
	  {
	
	    int capacity = 10;
	    int[] V = {1, 4, 8, 5};
	    int[] W = {3, 3, 5, 6};
	    System.out.println(knapsack(capacity, W, V));
	
	    capacity = 7;
	    V = new int[] {2, 2, 4, 5, 3};
	    W = new int[] {3, 1, 3, 4, 2};
	    System.out.println(knapsack(capacity, W, V));
	    
	    WillKnapSack wks = new WillKnapSack();
	    
	    wks.knapsackRec();
	    
	    wks.ksIterative();
	    
	    System.out.println();
	  }
	
}
