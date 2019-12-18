package HackerRank.Implementation;

import java.util.ArrayList;
import java.util.List;

//array objectel, score es a helyezs amit felulirunk
// binary search, update helyezes

// scores 100, 90, 90, 80, 75, 60
// alice  50,  65, 77, 90, 102
// ret	  6,   5,  4,  2,  1

public class LeaderBoard {

	static class Player
	{
		int score;
		int num;
		
		public Player(int score, int num) {
			super();
			this.score = score;
			this.num = num;
		}
	}
	
	
    static int[] climbingLeaderboard(int[] scores, int[] alice) 
    {

    	
    	int[] ret = new int[alice.length];
    	
    	List<Player> players = new ArrayList<Player>();
    	
    	int num = 1;
    	players.add(new Player(scores[0], num));
    	
    	for(int i=1; i<scores.length; i++)
    	{
    		if(scores[i] != scores[i-1])
    		{
    			num++;
    			players.add(new Player(scores[i], num));
    		}
    			
    	}
    	
    	Player[] players_arr = players.stream().toArray(Player[]::new);
    	
    	
    	int k=0;
    	
    	for(int sc : alice)
    	{
    		int number = binarySearch(players_arr, sc, 0, players_arr.length-1, players_arr.length-1);
    		
    		if(number > players_arr.length-1)
    		{
    			number = players_arr[players_arr.length-1].num + 1;
    			ret[k++] = number;
    			continue;
    		}
    			
    		if(number <= 0)
    		{
    			ret[k++] = 1;
    			continue;
    		}
    		
    		ret[k++] = players_arr[number].num;
    	}
    	
		return ret;
    }
    
    static int binarySearch(Player[] arr, int x, int start, int end, int abs_end)
    {
    	int mid = (end+start) / 2;
    	
    	if(arr[mid].score == x)
    		return mid;
    	
    	else if(mid == 0)
    		return 0;
    	else if(mid == abs_end)
    		return mid+1;
    	else if(mid > 0 && arr[mid].score > x && arr[mid-1].score < x)
    		return mid-1;
    	else if(mid < abs_end && arr[mid].score > x && arr[mid+1].score < x)
    		return mid+1;
    	
    	else if(start < end)
    	{
    		if(x < arr[mid].score)
    			mid = binarySearch(arr, x, mid+1, end, abs_end);
    		else
    			mid = binarySearch(arr, x, start, mid, abs_end);
    	}
    	
		return mid;    	
    }
	
	public static void main(String[] args) {
		
		int[] scores = {100, 90, 90, 80, 75, 60};
		int[] alice = {50,  65, 77, 90, 102};
		
		climbingLeaderboard(scores, alice);
	}

}








