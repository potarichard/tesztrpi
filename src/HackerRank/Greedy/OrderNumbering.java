package HackerRank.Greedy;

import java.util.Arrays;

public class OrderNumbering {

	// order 1 - prep time 1
	// order 2 - prep time 2
	
	// ascending : order num+prep time
    static int[] jimOrders(int[][] orders) 
    {
    	class Order implements Comparable<Order>
    	{
    		int num, order, overall;

			public Order(int num, int order, int prep) {
				super();
				this.num = num+1;
				this.order = order;
				this.overall = order + prep;
			}

			@Override
			public int compareTo(Order o) 
			{
				if(this.overall > o.overall)
					return 1;
				if(this.overall < o.overall)
					return -1;
				if(this.overall == o.overall)
				{
					if(this.order > o.order)
						return 1;
					if(this.order < o.order)
						return -1;
				}
				
				return 0;					
			}
    	}
    	
    	Order[] order = new Order[orders.length];
    	
    	for(int i=0; i<orders.length; i++)
    		order[i] = new Order(i, orders[i][0], orders[i][1]);    		
    	
    	Arrays.sort(order);
    	
    	int[] ret = new int[orders.length];
    	
    	for(int i=0; i<order.length; i++)
    		ret[i] = order[i].num;
    	
    	return ret;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}










