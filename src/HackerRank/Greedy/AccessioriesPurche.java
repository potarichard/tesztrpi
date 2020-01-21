package HackerRank.Greedy;

public class AccessioriesPurche {

	// type = price
	// example 6 5 3 2
	// 6 item to buy, 5 types, 3 subset, 2 different
	// want to spend maximum money
	// for any subset there must be 2 different items
	
	// types {1, 2, 3, 4, 5}
	// solution: {3, 4, 5, 5, 4, 3}
	
	// orderes solution: {5, 5, 4, 4, 3, 3}
	
	// subset = 3
	
	// 1 diff element
	// {5, 5, 5, 5, 5, 5}
	
	// 2 diff element
	// {5, 5, 4, 4, 3, 3}
	
	// 3 diff element
	// {5, 4, 3, 2, 1, 1}	// no solution
	
	// 3 diff but 6 type
	// {6, 5, 4, 3, 2, 1}
	
	// its not an algorithm it can be solved in O(1), with the right math formula.
    static String acessoryCollection(int wanted_total, int types, int subset_size, int min_number_of_types) 
    {
    	if(min_number_of_types > types)
    		return "SAD";
    	
    	if(min_number_of_types >= subset_size)
    		return "SAD";
    	
    	
		return null;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
