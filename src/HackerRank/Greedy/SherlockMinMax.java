package HackerRank.Greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SherlockMinMax {

	// arr - 
    static int sherlockAndMinimax(int[] arr, int p, int q) {

    	class Min implements Comparable<Min>
    	{
    		int val, index;

			public Min(int val, int index) {
				super();
				this.val = val;
				this.index = index;
			}

			@Override
			public int compareTo(Min o) 
			{
				if(this.val > o.val)
					return 1;
				if(this.val < o.val)
					return -1;
				if(this.val == o.val)
				{
					if(this.index > o.index)
						return -1;
					if(this.index < o.index)
						return 1;
				}
				
				return 0;					
			}
    	}
    	
    	int len = (q-p) + 1;
    	int[] range = new int[len];
    	Min[] mins = new Min[len];	
    	
    	for(int i=0; i<len; i++)
    		range[i] = p+i;
    	
    	for(int k=0; k<len; k++)
		{
    		int min = Integer.MAX_VALUE;
			
			for(int i=0; i<arr.length; i++)
				min = Math.min(min, Math.abs(arr[i]-range[k]));
			
			mins[k] = new Min(min, p+k);
		}
    	
    	Arrays.sort(mins, Collections.reverseOrder());
    	
    	return mins[0].index;
    }
    
    
    static int sherlockAndMinimax22(int[] arr, int p, int q) {

    	Arrays.sort(arr);
    	
    	int max_val = Integer.MAX_VALUE;
    	int min_ind = q;
    	
    	for(int k=p; k<=q; k++)
		{
    		int num = findClosest(arr, k);
    		
    		if(Math.abs(k-num) <= max_val)
    		{
    			max_val = Math.abs(k-num);    			
    			min_ind = Math.min(min_ind, k);
    		}
		}
    	
    	return min_ind;
    }
    
    static int findClosest(int arr[], int target)
    {
        int l=0, h = arr.length-1, diff = Integer.MAX_VALUE, val=arr[0];
        
        while(l<=h)
        {
            int mid = l+(h-l)/2;
            
            if(Math.abs(target-arr[mid]) < diff)
            {
                diff 	= Math.abs(target-arr[mid]);
                val		= arr[mid];
            }            
            if(arr[mid] < target)
                l = mid+1;
            else
                h = mid-1;
        }
        
        return val;
    }
	
    static int modifiedBinarySearch(int[] arr, int curr, int start, int end)
    {
    	int mid = (start+end)/2;
    	
    	if(start < end)
    	{
    		if(arr[mid] == curr)
    			return mid;
    		if(curr < arr[mid])
    		{    			
    			mid = modifiedBinarySearch(arr, curr, start, mid);
    		}    			
    		else
    		{
    			mid = modifiedBinarySearch(arr, curr, mid+1, end);
    		}    			
    	}
    	
    	return mid;
    }
    
    static int getClosest(int[] arr, int curr)
    {
    	int index = modifiedBinarySearch(arr, curr, 0, arr.length);
    	
    	return arr[index];
    }
    

    
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		int[] range = {635179944, 592614358, 645156538, 601132234, 72927588, 782907998, 26680576, 571904512,
				253411364, 368495632, 668408894, 715988190, 473032290, 221000496, 166917988, 579752154, 157507364,
				169860230, 693307354, 154889188, 598650762, 721921752, 691564182, 40331570, 680814954, 699857994,
				283203518, 248907756, 42917082, 510182506, 103334006, 659157584, 68613710, 41025968, 514681540,
				388857390, 732578568, 312342822, 544403214, 414550896, 401504698, 342138612, 578598706,
				455969120, 673917170, 671475360, 622813896, 327454610, 742037798, 192108990, 115056746,
				453856008, 67302432, 568454084, 178080688, 624229470, 47759236, 7828940, 554075052, 636698586,
				56519734, 254355714, 149844386, 684772334, 714305610, 572611200, 740611006, 350803732, 625347950,
				27623254, 429722502, 772950450, 508854614, 18633596, 529333176, 635794634, 102605328, 122897004,
				595455366, 105384508, 220658676, 370461750, 782829740, 371224392, 595323626, 302478768, 448101966,
				213876262, 477578452, 724776600, 623913570, 456079206, 284937928, 441662568, 21517112, 446207966,
				467159802, 620366990, 178426646, 130044896};
		
		int[] range2 = {5, 8, 14};
		
		sherlockAndMinimax22(range, 64214888, 789945206);
		
//		sherlockAndMinimax22(range2, 4, 9);
		
//		findClosest(range2, 6);
	}

}


















