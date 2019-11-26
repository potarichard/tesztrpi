package whereClassNeeded1;

import java.util.Comparator;

public class Checker implements Comparator<Player>
{

	@Override
	public int compare(Player a, Player b) 
	{
		int ret;
		
		if(a.score != b.score)
		{
			ret = b.score - a.score;
			System.out.println("score - "+"a(" + a.name + "," + a.score + ")   b(" +  b.name + "," + b.score + ")");
			if(ret<0)
				System.out.println("a>b");
			else
				System.out.println("a<b");
			return ret;
		}
            
		ret = a.name.compareTo(b.name);		
		System.out.println("name - "+"a(" + a.name + "," + a.score + ")   b(" +  b.name + "," + b.score + ")");
		if(ret<0)
			System.out.println("a<b");
		else
			System.out.println("a>b");
        return ret;
	}

}
