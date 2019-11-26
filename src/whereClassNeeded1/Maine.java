package whereClassNeeded1;

import java.util.Arrays;


public class Maine {

	public static void main(String[] args) 
	{
		
		Player[] players = new Player[3];
        Checker checker 		= new Checker();				// sort desc by score, and asc by name
        CheckerName checker2 	= new CheckerName();     		// sort asc only by name
        CheckerScore checker3 	= new CheckerScore();			// sort asc only by score
        
        players[0] = new Player("Smith", 20);
        players[1] = new Player("Jones", 15);
		players[2] = new Player("Jones", 20);
        
		System.out.println();
		
        Arrays.sort(players, checker);
        
        System.out.println();
        
        for(int i = 0; i < players.length; i++)
            System.out.println(players[i].name + " - " + players[i].score);
        
	}

}
