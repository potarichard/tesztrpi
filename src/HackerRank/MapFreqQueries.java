package HackerRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapFreqQueries 
{
	static List<Integer> freqQuery(List<List<Integer>> queries) 
    {
		Integer operation, parameter;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<Integer> ret = new ArrayList<Integer>();
		Integer val;
		
		// kell egy array ahol elofordulas a tomb indexe, ertek true false
		// pl.  1 true, 2 true, 
		
		// egyszeruen csak egy int ami a max elofordulast tartalmazza
		int max_freq = 0;
		
		for(List<Integer> query : queries)
        {
            operation = query.get(0);
            parameter = query.get(1);
            
            switch(operation)
            {
                case 1:		// add 'parameter'
                	val = map.get(parameter);
                	
                    if(val != null)
                    {
                    	val++;
                    	map.put(parameter, val);
                    }
                    	
                    else
                    {
                    	val = 1;
                    	map.put(parameter, val);
                    }                    	
                    
                    break;
                case 2:		// remove 'parameter'
                	val = map.get(parameter);
                	
                    if(val != null)
                    {
                    	val--;
                    	map.put(parameter, val);
                    	
                    }
                    	
                    break;
                case 3:		// van e olyan elem ami 'parameter'-szer fordul elo pontosan
//                	if(map2.get(parameter) != null)
//                		ret.add(1);
//                	else
//                		ret.add(0);
                    break;
            }
        }
		
		return ret;
    }

	public static void main(String[] args) 
	{
		
		

	}

}
