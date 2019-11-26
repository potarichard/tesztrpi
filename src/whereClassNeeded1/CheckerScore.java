package whereClassNeeded1;

import java.util.Comparator;

public class CheckerScore implements Comparator<Player>
{

	@Override
	public int compare(Player a, Player b) 
	{			
		return a.score - b.score;		// ordering ascending
//		return b.score - a.score;		// ordering descending
	}

}
