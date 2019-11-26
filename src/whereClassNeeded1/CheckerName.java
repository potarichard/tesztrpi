package whereClassNeeded1;

import java.util.Comparator;

public class CheckerName implements Comparator<Player>
{

	@Override
	public int compare(Player a, Player b) 
	{			
		return a.name.compareTo(b.name);		// names order ascending
//		return b.name.compareTo(a.name);		// names order descending
	}

}
