package HackerRank.Greedy;

import java.util.Arrays;

public class MarcsCakeWalk {

	
    static long marcsCakewalk(int[] calorie) {


    	for(int i=0; i<calorie.length; i++)
    		calorie[i] *= -1;
    	
    	Arrays.sort(calorie);
    	
    	for(int i=0; i<calorie.length; i++)
    		calorie[i] *= -1;
    	
    	
    	int min = 0, k = 0;
    	
    	for(int c : calorie)
    		min += Math.pow(2, k++) * c;
    	
    	return min;
    	
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] calorie = {1, 3, 2};
		
		marcsCakewalk(calorie);
		
	}

}
