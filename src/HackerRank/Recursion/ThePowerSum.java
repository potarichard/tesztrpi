package HackerRank.Recursion;

public class ThePowerSum {

	
//	N is the power, X is the neumber, 
//	find all uniquesets of nubers so that pow(a1, N) + pow(a2, N) ... = X
	
//	ex: X = 10, N = 2     pow(3,2) + pow(1,2)
	
//	13 = pow(2,2) + pow(3,2)
    static int powerSum(int X, int N) {

    	return powerSumUtil(X, N, 1);

    }
    
    static int powerSumUtil(int X, int N, int num) {

    	if(Math.pow(num,N)<X)
            return powerSumUtil(X,N,num+1) + powerSumUtil((int) (X-Math.pow(num,N)),N,num+1);
        else if(Math.pow(num,N)==X)
            return 1;
        else
            return 0;
    	
    	

//    	for(int i=index; i<X; i++)
//    	{
//    		int num = (int) (Math.pow(i, N));
//    		
////    		if(num < X)
//    			ways += powerSumUtil(X, N, i+1, num);
////    		else
////    			return ways;
//    	}
    	
//    	return ways;
    }
    
    // olyan mint a coin change csak itt egy olyan array kell ami max negyzeten elem kisebb mint a target
    static int powerSumi(int X, int N, int num)
    {    	
    	int ways = 0;    	
    	int current = (int) Math.pow(num,N);
    	
    	if(current < X)
    	{
    		ways += powerSumi(X,N,num+1);								// lentrol fel
    		ways += powerSumi((int) (X-Math.pow(num,N)),N,num+1);		// kivon
    	}
    	
    	else if(current == X)
    		return 1;
    	else
    		return 0;
    	
    	
    	return ways;    	
    }
	
    static int powerSumownWay(int X, int N)
    {
    	int[] coins = {1, 4, 9};	// ha X 13, es N=2 akkor csak ezek a coinok fordulhatnak elo
    	
    	return powerSumownWayUtil(X, coins, 0);
    }
    
    static int powerSumownWayUtil(int X, int[] arr, int index)
    {
    	int ways = 0;
    	
    	if(X == 0)
    		return 1;
    	if(X < 0)
    		return 0;
    	
    	for(int i=index; i<arr.length; i++)
    		ways += powerSumownWayUtil(X-arr[i], arr, i+1);
    	
    	return ways;
    }
    
    // can easily turn to DP
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		powerSumi(5, 2, 1);
		
		int[] coins = {1, 4, 9};
		
		powerSumownWayUtil(13, coins, 0);
		
		int[] coins2 = {1, 4, 9, 16, 25, 36, 49, 64, 81, 100};
		
		powerSumownWayUtil(100, coins2, 0);
	}

}

















