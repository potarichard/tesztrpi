package tesztrpi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class demo1 
{

	
	public static void main(String[] args) 
	{
////		0.
//		IntPojo intpojo1 = new IntPojo();	
//		System.out.println("eredeti integerpojo peldany kodja: " + intpojo1.hashCode() );
//		calc0(intpojo1);		
//		System.out.println("0. new value: " + intpojo1.first);
//		
////		1.
//		IntPojo intpojo2 = new IntPojo();		
//		calc1(intpojo2.first);		
//		System.out.println("1. new value: " + intpojo2.first);
//		
////		2.
//		Integer intst = new Integer(10);
//		System.out.println("eredeti integer peldany kodja: " + intst.hashCode() );
//		calc2(intst);		
//		System.out.println("2. new value: " + intst);
	
		
		// recursive problems
		
//		System.out.println(factorial(10));
		
//		System.out.println(fibonacci(9));
		
//		System.out.println(bunnyEars2(2));
		
//		System.out.println(triangle(3));
		
//		System.out.println(sumDigits(1269));
		
//		System.out.println(count7(1177771));
		
//		System.out.println(count8(18818));
		
//		System.out.println(powerN(3,3));
		
//		System.out.println(countX("sdaxxnlxll"));
		
//		System.out.println(makeBricks(3,1,8));
		
//		System.out.println(evenlySpaced(4,6,2));
		
//		System.out.println(xyzThere("abc.xyz"));
		
//		System.out.println(xyzMiddle("AAAxyzB"));
		
//		System.out.println(getSandwich("xxbreadjambreadyy"));
		
//		int[] arr = new int[]{1, 10, 10, 2};
//		
//		System.out.println(withoutTen(arr));
		
//		String[] strings = new String[]{"a", "b", "a", "c", "b"};
//		
//		System.out.println(wordCount(strings));
		
//		System.out.println(withoutString("Hello there", "llo"));
		
//		System.out.println(maxBlock("abbbcbbbxbbbx"));
		
//		System.out.println(sumNumbers("abc123xyz"));
		
//		System.out.println(notReplace("is right"));
		
//		System.out.println(Arrays.toString(squareUp(3)));
		
//		System.out.println(Arrays.toString(seriesUp(4)));
		
//		System.out.println(mirror());
		
//		System.out.println(endX("hexxxlxxlo"));
		
//		System.out.println(countPairs("axax"));
		
//		System.out.println(countAbc("abcxxabc"));
		
//		System.out.println(count11("11abc11"));
		
//		System.out.println(countHi2("xxxx"));
		
//		System.out.println(parenBit("xyz(abc)123"));
		
//		System.out.println(nestParen("((()))"));
		
//		System.out.println(strCount("catcowcat", "cat"));
		
//		System.out.println(strCopies("catcowcat", "cow", 2));
		
//		System.out.println(strDist("abccatcowcatcatxyz", "cat"));
		
//		int[] arr = new int[] {0, 0, 0, 1, 0, 0};
//		System.out.println(groupSum(0, arr, 10));		
//		System.out.println(groupNoAdj(0, arr, 14));		
//		System.out.println(splitArray(arr));		
//		System.out.println(groupSum5(0, arr, 9));
		
//		System.out.println(altPairs("Chocolate"));
		
//		System.out.println(has271(arr));
		
//		System.out.println(mittumen(2, arr));
		
//		System.out.println(sockMerchant(9, arr));
		
//		System.out.println(countingValleys("DDUUDDUDUUUD"));
		
//		System.out.println(jumpingOnClouds(arr));
		
		
//		2d array
//							 a, b, k
//		int[][] queries = {	{1, 5, 3}, 
//							{4, 8, 7},
//							{6, 9, 1}};
		
//		int[][] ia = new int[5][6];
//		System.out.println(ia.length);  	// sorok szama
//		System.out.println(ia[0].length);	// egy sor hany oszlop ? tehat az oszlopok szama
		
//		System.out.println(arrayManipulation(10, queries));
		
//		String[] magazine = {"give", "me", "one", "grand", "today", "night"};
//		String[] note = {"give", "one", "grand", "today"};
//		
//		checkMagazine(magazine, note);
		
//		System.out.println(sherlockAndAnagrams("ifailuhkqq"));
		
//		List<Long> the_list = Arrays.asList(1l, 3l, 9l, 9l, 27l, 81l);
//		
//		System.out.println(countTriplets(the_list, 3));
		
//		String[] mag = new String[] {"two", "times", "three", "is", "not", "four"};
//		String[] not = new String[] {"two", "times", "two", "is", "four"};
//		
//		checkMagazine2(mag, not);
		
//		List<Long> the_list = Arrays.asList(1l, 3l, 9l, 9l, 27l, 81l);	// immutable list, nem modosithato, add, remove nem mukodik...
//		List<Long> the_list = new ArrayList<Long>(Arrays.asList(1l, 3l, 9l, 9l, 27l, 81l));	// mutable, minden mukodik
//		
//		System.out.println(countTriplets1(the_list, 3));
		
		
//		wall of text for freqQuery problem ///////////////////////////////////////////////////////////////////////////////////////
//		List<Integer> in = new ArrayList<Integer>();
//    	List<List<Integer>> out = new ArrayList<List<Integer>>();
//    	
//    	// 1
//    	in.add(1); in.add(5);
//    	out.add(in);
//    	in = new ArrayList<Integer>();
//    	
//    	// 2
//    	in.add(1); in.add(6);
//    	out.add(in);
//    	in = new ArrayList<Integer>();
//    	
//    	// 3
//    	in.add(3); in.add(2);
//    	out.add(in);
//    	in = new ArrayList<Integer>();
//    	
//    	// 4
//    	in.add(1); in.add(10);
//    	out.add(in);
//    	in = new ArrayList<Integer>();
//    	
//    	// 5
//    	in.add(1); in.add(10);
//    	out.add(in);
//    	in = new ArrayList<Integer>();
//    	
//    	// 6
//    	in.add(1); in.add(6);
//    	out.add(in);
//    	in = new ArrayList<Integer>();
//    	
//    	// 7
//    	in.add(2); in.add(5);
//    	out.add(in);
//    	in = new ArrayList<Integer>();
//    	
//    	// 8
//    	in.add(3); in.add(2);
//    	out.add(in);
//    	in = new ArrayList<Integer>();
//    	
//    	freqQuery(out);
    	
		int[] arr = new int[] {5, 4, 9, 4, 9, 5};		
		
//		System.out.println(activityNotifications(arr, 4));
		
//		System.out.println(countInversions(arr));
		
//		fix45(arr);
		
//		squareUp(3);
		
//		System.out.println(commonChild("ABCD", "ABDC"));
		
//		arr = new int[] {-2, 1, 3, -4, 5};	
		
//		arr = new int[] {20, 10, 30, 20, 10};
		
//		System.out.println(maxSubsetSum2(arr));
    	
//		System.out.println(fibo(8));
//		
//		System.out.println(fiboRecStarter(8));
		
//		System.out.println(stepPerms(5));
		
		System.out.println(coinsStarter(4));
	}
	
	
	static List<Integer> combolist = new ArrayList<Integer>();
	
	static int stepPerms(int n)
	{
		int[] arr = new int[] {1,2,3};
		
		int ret = steps2(arr, n);
		
		return ret;
	}
	
	static int coinsStarter(int n)
	{
		int[] arr = new int[] {1,2};
		
		return coins(arr, n, 0);
	}
	
	static int steps2(int[] arr, int amount)
	{
		if(amount == 0)
		{
			System.out.println(combolist + "  was: " + amount + " a good combo");			
			combolist.remove(combolist.size()-1);
			
			return 1;
		}
			
		if(amount < 0)
		{
			System.out.println(combolist + "  was: " + amount + " NOT a good combo");
			combolist.remove(combolist.size()-1);
			
			return 0;
		}
			
		
		int count = 0;
		
		for(int i=0; i<arr.length; i++)
		{
			combolist.add(arr[i]);
			count += steps(arr, amount-arr[i]);			
		}
		
		if (combolist.size() > 0)
			combolist.remove(combolist.size()-1);
		
		return count;
	}
	
	static int steps(int[] arr, int amount)
	{
		if(amount == 0)			
			return 1;
			
		if(amount < 0)		
			return 0;
			
		
		int count = 0;
		
		for(int i=0; i<arr.length; i++)
			count += steps(arr, amount-arr[i]);	
		
		return count;
	}
	
	static int coins(int[] arr, int amount, int index)
	{
		if(amount == 0)
		{
			System.out.println(combolist + "  was: " + amount + " a good combo");			
			combolist.remove(combolist.size()-1);
			
			return 1;
		}
			
		if(amount < 0)
		{
			System.out.println(combolist + "  was: " + amount + " NOT a good combo");
			combolist.remove(combolist.size()-1);
			
			return 0;
		}
			
		
		int count = 0;
		
		for(int i=index; i<arr.length; i++)
		{
			combolist.add(arr[i]);
//			count += coins(arr, amount-arr[i], 0);		// mindig elorol loopol, tobbszor szamolja ugyanazt a kombot
			count += coins(arr, amount-arr[i], i);		// folytatja, ugyanaz a kombo nem lesz 2 szer.
		}
		
		if (combolist.size() > 0)
			combolist.remove(combolist.size()-1);
		
		return count;
	}
	
	static int fiboRec(int n, int[] memo)
	{		
		int result = 0;
		
		if(n==1)
			return 1;
		if(n==0)
			return 0;
		if(memo[n-1] != 0)
			return memo[n-1];
		else		
		{
			result = fiboRec(n-1, memo) + fiboRec(n-2, memo);
			memo[n-1] = result;
		}
			
		
		return result;
		
	}
	
	static int fiboRecStarter(int n)
	{
		int[] memo = new int[n];
		
		return fiboRec(n, memo);
	}
	
	static int fibo(int n)
	{
		if(n<2)
			return 1;
		
		int[] arr = new int[n];
		
		arr[0] = 1;
		arr[1] = 1;
		
		for (int i=2; i<n; i++)
			arr[i] = arr[i-1] + arr[i-2];
		
		return arr[arr.length-1];
		
	}
	
	public static class Node
	{
		int data;
    	Node left;
    	Node right;
	}
	
	
	
	// 2 elemnek a legkozelebbi kozos felettese
	public static Node lca(Node root, int v1, int v2) 
    {
      	 //Decide if you have to call rekursively
        //Samller than both
        if(root.data < v1 && root.data < v2){
            return lca(root.right,v1,v2);
        }
        //Bigger than both
        if(root.data > v1 && root.data > v2){
            return lca(root.left,v1,v2);
        }

        //Else solution already found
        return root;
    }
	
	// a magassagat adja a treenek...
	public static int height(Node root) 
    {
      	if (root != null)
            return 1 + Math.max(height(root.left), height(root.right));
        else
            return -1;
    }
	
	
	// a tomben a hazak magassagai vannak benne, mind 1 szeles
	// random erkeznek be, nem lehet oket rearrenge, mennyi a legnagyobb teglalap
	// amivel le lehet fedni a hazakat szembol
	// pl.  1 2 3 4 5   3 olyan elem van ami legalabb 3 magas  3 4 5 os hazakat le lehet fedni
	// 3x3 mas lappal azaz return 9
	
	// pl. 1 2 3 4 5 4 3 1 		3 4 5 4 3  elemeket le lehet fedni 3x5 lappal return 15
	
	// pl. 1 3 5 9 11		return 18 ->  9 11 et le lehet fedni 2x9 = 18 al
	
	// a legnagyobb mindig benne lesz ? -> nem
	// pl 1 23 1 22 20			lehet egy 23 magas, de 22 20    2x20 = 40 a max
	
    // Complete the largestRectangle function below.
    static long largestRectangle(int[] h) 
    {

    	// tomb hosszabbol visszafelé haladva
    	// legalabb h.length azaz 1 magassagu teglaval le lehet fedni mindet
    	
    	// a legnagyobb elem melletti elem jobbra ha melette levo kisebb akkor a legnagyobb =
    	// melette levovel
    	
    	// 1. legnagyobb elem magaba = max
    	// 2. legnagyobb elem melletti = legnagyobb a ketto egyutt nagyobb > max ?
    	// 3. legn > legn_m > next mindegyik = next  3x next >  max ? 
    	// igy tovabb rekurzivan
    	
    	
    	// a maxsubsethez hasonloan 2 erek kozotti max erteket keresek
    	
    	
    	
        return 8;

    }
    
    
	
	
    // Complete the isBalanced function below.  nem szimmetrikusnak kell lennie, hanem barhol ha van lezarasa akkor jo
//	{(([])[])[]}   ez is jo kell hogy legyen, YES kell return
    static String isBalanced(String s) 
    {

        for (int i=0; i<s.length(); i++)
        {
            switch (s.charAt(i))
            {
                case '{':
                    if (s.charAt(s.length()-1-i) != '}')
                        return "NO";
                break;

                case '[':
                    if (s.charAt(s.length()-1-i) != ']')
                        return "NO";
                break;

                case '(':
                    if (s.charAt(s.length()-1-i) != ')')
                        return "NO";
                break;
            }
        }

        return "YES";

    }
    
	
	// get the sum of all non-adjacent elements, return the max of them
    static int maxSubsetSum(int[] arr) 
    {
    	int max_group_size = arr.length%2 == 0 ? arr.length/2 : arr.length/2 + 1;
    	int group_size = 1;
    	int sum = 0;
    	int max = 0;
    	int j = 0;
    	int t_ind = 0;
    	
    	
    	for (int gs=group_size; gs<max_group_size; gs++)
    	{
    		for (int i=0; i<arr.length; i++)
    		{
    			j=i+2;
    			
    			if(j>=arr.length)
    				break;
    			
    			while(j<arr.length)
    			{        				
    				sum = arr[i];
    				t_ind = j; 
    				
    				for(int k=0; k<gs; k++)
    				{
    					if(t_ind >= arr.length)
    						break;
    					sum += arr[t_ind];
    					t_ind += gs;        					
    				}
				
    				if(sum > max)
    					max = sum;
    				
    				j += gs;
    			}
    			
    		}
    	}
    	
    	return max; 	
    }
    
	
	// 0. elemrol indulva lepek a 2. elemre, de kozben beallitom, a koztes elemet is, maximumot nezve 
    static int maxSubsetSum2(int[] arr) 
    {
    	if (arr.length == 0) 
    		return 0;
    	
    	int left, right, max = 0;
    	
    	arrayPrinter(arr);
    	
    	left = Math.max(0, arr[0]);        
    	arr[0] = left;   
    	
    	arrayPrinter(arr);
    	
    	right = Math.max(arr[0], arr[1]);        
        arr[1] = right;
        
        arrayPrinter(arr);
        
        for (int i = 2; i < arr.length; i++)
        {
        	left = arr[i-1];
        	right = arr[i] + arr[i-2];
        	
        	max = Math.max(left, right);
        	arr[i] = max;
        	
        	arrayPrinter(arr);
        }
         
        
        return max;    	
    }
	
	// Complete the luckBalance function below.
    static void arrayPrinter(int[] arr) 
    {    	
    	for(int i=0; i<arr.length; i++)
    		System.out.print(arr[i] + " ");
    	System.out.println();
    }
	
	// Complete the commonChild function below.
    static int commonChild(String s1, String s2) 
    {

    	String fst = "", sec = "";
    	
    	for (int i=0; i<s1.length(); i++)
    	{
    		for (int j=0; j<s2.length(); j++)
        	{
        		if(s1.charAt(i) == s2.charAt(j) && i <= j)
        		{
        			fst += s1.charAt(i);
        			break;
        		}
        			
        	}
    	}
    	
    	for (int i=0; i<s2.length(); i++)
    	{
    		for (int j=0; j<s1.length(); j++)
        	{
        		if(s2.charAt(i) == s1.charAt(j) && i <= j)
        		{
        			sec += s2.charAt(i);
        			break;
        		}
        			
        	}
    	}
    	
    	if(sec.length() > fst.length())
    		return sec.length();
    	
    	return fst.length();
    }
	
	public static int[] fix45(int[] nums) 
	{
	  	int j = 0;
		  
		  for(int i=0; i<nums.length-1; i++)
		  {
		    if (nums[i]==4 && nums[i+1] != 5)
		    {
		    	  while (nums[j] != 5 || (j > 0 && nums[j - 1] == 4))
	            j++;
	            
	          // csere
	          nums[j] = nums[i + 1];
	          nums[i + 1] = 5;
		    }
		  }
		  
		  return nums;  
	}
	
	
    static long countInversions(int[] arr) 
    {

    	int temp;
    	
    	for(int i=0; i<arr.length-1; i++)
    	{
    		if(arr[i+1] < arr[i])
    		{
    			temp = arr[i];
    			arr[i] = arr[i+1];
    			arr[i+1] = temp;
    			return 1 + countInversions(arr);
    		}
    	}
    	
    	
    	return 0;
    	
    }
	
    static int activityNotifications(int[] expenditure, int d) 
    {

        int notifications = 0;
        float median, current;

        for(int i=d; i<expenditure.length; i++)
        {
        	median = getMedian(expenditure, d, (i-d));
        	current = expenditure[i];
        	
        	System.out.println(median);
        	
        	if(current >= median*2)
        		notifications++;      	
        }        

        System.out.println();
        return notifications;
    }
    
    static float getMedian(int[] arr, int num, int start_index)
    {
    	int[] arr_to_test = new int[num];
    	int k = 0;
    	int temp;
    	float ret;
    	
    	// 1. interval in for median
    	for(int i=start_index; i<start_index+num; i++)
    		arr_to_test[k++] = arr[i];
    	
    	// 2. ascending
    	for(int i=0; i<arr_to_test.length; i++)
    	{
    		for(int j=i+1; j<arr_to_test.length; j++)
        	{
        		if(arr_to_test[j] < arr_to_test[i])
        		{
        			temp = arr_to_test[i];
        			arr_to_test[i] = arr_to_test[j];
        			arr_to_test[j] = temp;
        		}
        	}
    	}
    	
    	// 2 case, array to test is even/odd
    	if(num % 2 == 1)
    		return arr_to_test[num/2];
    	else
    	{
    		ret = arr_to_test[num/2] + arr_to_test[(num/2)-1];
    		ret /= 2.0;
    		return ret;
    	}
    }
	
    static List<Integer> freqQuery(List<List<Integer>> queries) 
    {		
        // query : 1-muvelet, 2-mit
        // 1. tipus, 1 add x elemet to the array
        // 2. tipus, 2 remove x element from array
        // 3. tipus, 3 count x, if any element in the array appears x times, print 1

    	List<Integer> array = new ArrayList<Integer>();
    	List<Integer> ret_array = new ArrayList<Integer>();
    	Integer operation, parameter, frequency;    	
    	Set<Integer> unique_elements;
    	boolean success = false;
    	
    	for(List<Integer> query : queries)
    	{
    		operation = query.get(0);
    		parameter = query.get(1);
    		
    		switch(operation)
    		{
	    		case 1:
	    			array.add(parameter);
	    			break;
	    		case 2:
	    			array.remove(parameter);
	    			break;
	    		case 3:
	    			// van e olyan elem ami x-szer fordul elo pontosan
	    			success = false;
	    			unique_elements = new HashSet<Integer>(array);
	    	    	for(Integer  element : unique_elements)
	    	    	{
	    	    		frequency = Collections.frequency(array, element);
	    	    		//System.out.println(element + " times: " + frequency);
	    	    		if(frequency.equals(parameter))
	    	    		{
	    	    			ret_array.add(1);
	    	    			success = true;
	    	    			break;
	    	    		}	    	    			
	    	    	}
	    	    	
	    	    	if(!success)
	    	    		ret_array.add(0);
	    	    	
	    			break;
    		}
    	}
    	
        
    	return ret_array;
    }
	
    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) 
    {
        // 1. melyik a rovidebb
        // 2. a rovidebbel meg kell nezni loopba, hogy substring hogy all
        // pl. buaoo  len = 5
        //1. b u a o o
        //2. bu ua ao oo
        //3. bua uao aoo
        //4. buao uaoo
        //5. buaoo
        String sub = "";
        int len = s1.length();
        char[] ads = s1.toCharArray();

        if(s2.length() < len)
            len = s2.length();

        // lanc hosszat novelo loop
        for(int i=0; i<len; i++)
        {
            // vizsgalt karakter
            for(int j=0; j<len-i; j++)
            {
                sub = s1.substring(j, j+1+i);
                if(s2.contains(sub))
                    return "YES";
            }
        }

        return "NO";
    }
	
	
	// a bejovo listaban 3 tagu mertani sorokat kell megszamolni, r = parameter r
	static long countTriplets1(List<Long> arr, long r) 
    {
		
		// 1. tag, 2. tag, 3. tag
		// 1. tag, 2. tag, uj 3. tag
		// 1. tag, 2. tag, uj 3. tag
		// end
		// 1. tag, uj 2. tag, 3. tag
		// 1. tag, 2. tag, uj 3. tag
		// end
		// uj 1. tag....
		
		// 3 leagazos for loop megoldas lehet ?, vagy rekurziv
		Long[] array = arr.toArray(new Long[arr.size()]);
		
		int i,j,k, count=0;
		Long fst,sec,thr;
		
		
		for(i=0; i<array.length; i++)
		{
			fst = array[i];
			
			for(j=i+1; j<array.length; j++)
			{				
				sec = array[j];
				
				if(sec == fst*r)
				{
					for(k=j+1; k<array.length; k++)
					{
						thr = array[k];
						
						if(thr == sec*r)
							count++;
					}
				}					
			}
		}
		
		
		
		return count;
    }
	
	static void checkMagazine2(String[] magazine, String[] note) 
    {
        // vegignezem es kiveszem belole, majd loop elorol, addig amig anote el nem fogy
        // vagy nics benne az a szo, vagy egyszerubb egy stringkent kezelni
		  
        List<String> note_l = new ArrayList<String>(Arrays.asList(note));
        List<String> magazine_l = new ArrayList<String>(Arrays.asList(magazine));
        
        
        boolean result = helpMagazine2(note_l, magazine_l);
        
        if(result)  	
        	System.out.println("Yes");
        else
        	System.out.println("No");
    }
	
	
	
	static boolean helpMagazine2(List<String> note, List<String> maga)
	{		
        for(int i=0; i<note.size(); i++)
        {
        	for(int j=0; j<maga.size(); j++)
            {
            	if(maga.get(j).matches(note.get(i)))
            	{
            		note.remove(i);
            		maga.remove(j);
            		i--;
            		j = 0;
            		break;
            	}            	
            }
        }
        
        if(note.size() == 0)
        	return true;
        
        return false;
        
	}
	
	
	
	static void checkMagazine1(String[] magazine, String[] note) 
    {
        // vegignezem es kiveszem belole, majd loop elorol, addig amig anote el nem fogy
        // vagy nics benne az a szo, vagy egyszerubb egy stringkent kezelni
		  
        List<String> note_l = new ArrayList<String>(Arrays.asList(note));
        List<String> magazine_l = new ArrayList<String>(Arrays.asList(magazine));
        
        
        boolean result = helpMagazine1(note_l, magazine_l);
        
        if(result)  	
        	System.out.println("Yes");
        else
        	System.out.println("No");
    }
	
	static boolean helpMagazine1(List<String> note, List<String> maga)
	{
		String to_remove = null;
		
		if(note.size() == 0)
			return true;
		
        for(String not : note)
        {
        	for(String mag : maga)
            {
            	if(mag.matches(not))
            	{
            		to_remove = not;
            		break;
            	}            	
            }
        	break;
        }
        
        if(to_remove != null)
        {
        	note.remove(to_remove);
        	maga.remove(to_remove);
        	
        	return helpMagazine1(note, maga);
        }
        
        return false;
        
	}
	
	
	
    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) 
    {
        HashMap<Integer, long[]> map = new HashMap<Integer, long[]>();        
        long[] triplet = new long[3];
        int start = 0;
        
        // elso elem a kiindulas, a start, ahhoz kepest nezzuk a kovitû//
        // TRIPLET INDEXEKET KELL TAROLNI, NEM AZ ERTEKUKET !
        // csak pakoljam bele az elemeket, aztan majd valaki megnezi hogy a 3mas az triplet e, ha nem, akkor 
        // utolso elem ki, es problaja tovabb, ha az se jo akkor a masodik elem is ki ...
        while(start<arr.size()-2)
        {
        	triplet = new long[3];
        	triplet[start] = arr.get(start);
        	
        	for(int j=1; j<triplet.length; j++)
        	{
        		for(int i=start+1; i<arr.size(); i++)
                {
            		if(arr.get(i) == triplet[j-1]*r)
            		{
            			
            		}
                }
        	}  	
        	
        	start++;
        }      
        
        return map.size();

    }
	
	// Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) 
    {
    	boolean anagram = false;
        int count = 0;
        int exp = 1;
        String fi = "";
        String se = "";
        
        while(exp<s.length())
        {
        	for(int i=0; i<s.length(); i++)
            {
        		fi = "";
        		
        		if ((i+exp) <= s.length())
        			fi = s.substring(i,i+exp);	
        		
        		for(int j=i+1; j<s.length(); j++)
                {        			
        			se = "";	
        			
        			if ((j+exp) <= s.length())
        			{
        				se = s.substring(j,j+exp);        				
        				anagram = isAnagram(fi, se);        				
        				if(anagram)
        					count++;
        			}        				
                }	
            }
        	
        	exp++;
        }

        return count;
    }
    
    // ifa, fai
    static boolean isAnagram(String fi, String se)
    {
    	char[] fic = fi.toCharArray();
    	char[] sec = se.toCharArray();
    	
    	Arrays.sort(fic);
        Arrays.sort(sec);
        return Arrays.equals(fic, sec);
    }
    
//	 fi = s.substring(i,i+exp);
//
//     se = s.substring(i+exp,i+exp+1);
//     re = new StringBuilder(se).reverse().toString();
//
//     if(fi.matches(se) || fi.matches(re))
//         count++;
//     
//	exp++;
	
	static void checkMagazine(String[] magazine, String[] note) 
    {

        // uzenetet akar hagyni, szavakat hasznalhat ujsagbol kivagva
        // case sensitive, uj szavakat osszerakni, subetring tilos

        boolean ok = false;
        int[] used_indexes = new int[magazine.length];
        int i,j,k=0;
        
        for(j=0; j<used_indexes.length; j++)
        	used_indexes[j] = -1;
        
        for(String nw : note)
        {
            ok = false;
            
            // felhasznalt szavak indexet mar ne nezze
            for(i=0; i<magazine.length; i++)
            {   
            	for(j=0; j<used_indexes.length; j++)
            	{
            		if(i==used_indexes[j])
            		{
            			i++;
            			break;
            		}
            	}
            	
                if(nw.matches(magazine[i]))
                {  
                	used_indexes[k++] = i;
                    ok = true;
                    break;
                }
                    
            }
            
            if(!ok)
            	break;
        }

        if(ok)
            System.out.println("Yes");
        else
            System.out.println("No");

    }
	
//	HACKERRANK
	
	static long arrayManipulation(int n, int[][] queries) 
    {

        // n - array length
        // 1. sorok
        // 2. az oszlopok szama az 3: a,b,k oszlop van

        int[] arr = new int[n];
        int[] ops = new int[3];
        int a,b,k;
        int max = 0;

        for(int i=0; i<queries.length; i++)
        {
            ops = queries[i];		// aktualis operaciok
            
            a = ops[0];
            b = ops[1];
            k = ops[2];
            
            for(int j=a-1; j<b; j++)	// az arrayen megyunk
            	arr[j] += k;  	
        }
        
        for(int j=0; j<n; j++)
        {
        	if(arr[j]>max)
        		max = arr[j];
        }

        return max;
    }
	
    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) 
    {

        int min_jumps = 0;

        for(int i=0; i<c.length; i++)
        {
            if(i<c.length-2 && c[i+2]==0)
            {
                min_jumps++;
                i=i+1;
            }
            else if(i<c.length-1 && c[i+1]==0)
            {
                min_jumps++;
            }
        }

        return min_jumps;
    }
	
    static int countingValleys(String s) 
    {

        int count = 0;     // # of valleys
        int lvl = 0;   // current level
        char[] road = s.toCharArray();
        for(char c : road)
        {
            if(c == 'U') lvl++;
            if(c == 'D') lvl--;
            
            // if we just came UP to sea level
            if(lvl == 0 && c == 'U')
                count++;
        }

        return count;
    }
	
    static int sockMerchant(int n, int[] ar) 
    {
        // foglalt parok
        int[] pairs_index = new int[n];
        for(int i=0; i<n; i++)
        {
            pairs_index[i] = -1;
        }
        int k=0, pairs=0;
        boolean ok = true;

        for(int i=0; i<n; i++)
        {
            for(int j=i+1; j<n; j++)
            {
                if(ar[i]==ar[j])
                {
                    ok = true;
                    for(int z=0; z<n; z++)
                    {
                        if(pairs_index[z]==i || pairs_index[z]==j)
                        {
                    	   ok = false;
                           break;
                        }                         
                    }
                    
                    if(ok)
                    {
                        pairs_index[k++] = i;
                        pairs_index[k++] = j;
                        pairs ++;
                        break;
                    }
                       
                }
            }
        }

        return pairs;

    }
	
	
	//////////////////// CODINGBAT 
	
	public static int mittumen(int n, int[] T)
	{
		int prod=1;
		
		for(int i=0; i<n; i++)
			prod = prod*T[i];
		
		return prod;
	}
	
	public static boolean has271(int[] nums) 
	{
	  for(int i=0; i<nums.length-2; i++)
	  {
	    if(nums[i]==nums[i+1]-5)
	    {
	      if(nums[i+1]==nums[i]-1)
	        return true;
	    }
	  }
	  
	  return false;
	}
	
	public static String altPairs(String str) 
	{
	  String result = "";
	  
	  for(int i=0; i<str.length(); i+=4)
	  {
	      result += str.substring(i, i+1);
	      if(i<str.length()-1)
	    	  result += str.substring(i+1, i+2);
	  }
	  
	  return result;
	}
	
	public static boolean groupSum5(int start, int[] nums, int target) 
	{
	  if (start>=nums.length) 
	    return (target == 0);
	  if (check(start, nums) && groupSum5(start+1, nums, target-nums[start]))
	    return true;
	  if (nums[start]%5 != 0 && groupSum5(start+1, nums, target)) 
	    return true;
	    
	  return false;
	}

	public static boolean check(int i, int[] nums)
	{
	  if(i<nums.length-2 && nums[i]%5==0 && nums[i+1]==1)
	    return false;
	  
	  return true;
	}
	
	
	public static boolean splitArray(int[] nums) 
	{
		  int index = 0;
		  int sum1 = 0;
		  int sum2 = 0;
		  
		  return recArray(nums, index, sum1, sum2);
	}

	private static boolean recArray (int[] nums, int i, int sum1, int sum2 ) 
	{
		boolean ret1 = false;
		boolean ret2 = false;
		
		if (i>=nums.length) 
			return sum1 == sum2;
		
		int value = nums[i];
		
		ret1 = recArray(nums, i+1, sum1+value, 	sum2);
		ret2 = recArray(nums, i+1, sum1, 		sum2+value);
		return ret1 | ret2;
	}
	
	public static boolean splitArray2(int[] nums) 
	{
		int i=0, target = nums[0];		
		
		helper2(i, nums, target);
	 
		
	  return true;
	}
	
	public static boolean helper2(int i, int[] nums, int target)
	{
		if(i>=nums.length)
		{
			System.out.println("check");
			return target==0;
		}
			
		
		if (helper2(i+1, nums, target-nums[i]))
		{
			return true;
		}
		
		if (helper2(i+1, nums, target))
		{
			return true;
		}
		
		return false;
	}
	
	public static boolean groupNoAdj(int i, int[] nums, int target) 
	{
		if (i >= nums.length) 
			return (target == 0);		
		if (groupNoAdj(i + 2, nums, target - nums[i]))
			return true;
			
		if (groupNoAdj(i + 1, nums, target)) 
			return true;
		  
		return false;
	}
	
	public static boolean groupSum(int i, int[] nums, int target) 
	{		
		if (i >= nums.length) 							// ha vegigment a tombon => vizsgalat
			return (target == 0);
		if (groupSum(i + 1, nums, target-nums[i])) 		// 1. verzio a muveletbe bevesszuk az aktualis elemet (kivonjuk)
			return true;
		if (groupSum(i + 1, nums, target)) 				// 2. verzio a muveletbe nem veszi bele az aktualis elemet (nem vonja ki) (backtrack lepes)
			return true;
		  
		return false;
	  
	}
	
	public static int strDist(String str, String sub) 
	{
		if (str.equals("") || str.length()==sub.length()-1)	
		    return 0;
		
		if(str.substring(0, sub.length()).equals(sub))
		{
			if(!str.substring(str.length()-sub.length()).equals(sub))
				return strDist(str.substring(0, str.length()-1), sub);
			return str.length();
		}
		
		return strDist(str.substring(1), sub);
	}
	
	public static boolean strCopies(String str, String sub, int n) 
	{
		  if (n==0)	
			  return true;
		  if(str.length() < sub.length())
			  return false; 
		    
		  if(str.substring(0, sub.length()).equals(sub))
		    return strCopies(str.substring(1), sub, --n);
		    
		  return strCopies(str.substring(1), sub, n);
	}
	
	public static int strCount(String str, String sub) 
	{
	  if (str.equals("") || str.length()==sub.length()-1)	
	    return 0;
	    
	  if(str.substring(0, sub.length()).equals(sub))
	    return 1 + strCount(str.substring(sub.length()), sub);
	    
	  return strCount(str.substring(1), sub);
	}
	
	public static boolean nestParen(String str) 
	{
		boolean ret = false;
	  if (str.equals(""))	
				return true;
				
		if(str.charAt(0)=='(')
		{
			if(str.charAt(str.length()-1)==')')
			{
				ret = nestParen(str.substring(1, str.length()-1));
				return ret;
			}
				
		}
		
		return false;
	}

	
	// ha van egy "(" akkor onnantol a substring onnan megy
	public static String parenBit(String str) 
	{
		if (str.equals("") || str.length() <= 1)	
			return str;
		
		if(str.charAt(0)=='(')			// megvan a kezdo, innentol a str vegerol 
            							// kezdjuk levagni a betuket a rekurzioban
		{
			if(str.charAt(str.length()-1)==')')
				return str;
			else
				return  parenBit(str.substring(0, str.length()-1));
		}
			
		
		return parenBit(str.substring(1));
	}
	
	public static int countHi2(String str) 
	{
	    if (str.equals("") || str.length() <= 1)	
			  return 0;
					  
		if (str.length()>2 && str.charAt(0)=='x' && str.substring(1,3).equals("hi"))
			return countHi2(str.substring(2));		
		else if(str.substring(0,2).equals("hi"))
		  return 1 + countHi2(str.substring(1));
			  
		return countHi2(str.substring(1));
	}
	
	public static int count11(String str) 
	{
	  if (str.equals("") || str.length() <= 1)	
			  return 0;
			  
		if(str.substring(0,2).equals("11"))
			  return 1 + count11(str.substring(2));
			  
		return count11(str.substring(1));
	}
	
	public static int countAbc(String str) 
	{
	  if (str.equals("") || str.length() <= 2)	
		  return 0;
		  
		if(str.substring(0,3).equals("abc") || str.substring(0,3).equals("aba"))
		  return 1 + countAbc(str.substring(1));
		  
		return countAbc(str.substring(1));
	}
	
	public static int countPairs(String str) 
	{
	  if (str.equals("") || str.length() <= 2)	
			  return 0;
			  
		if(str.charAt(0)==str.charAt(2))
			  return 1 + countPairs(str.substring(1));
			  
		return countPairs(str.substring(1));
	}
	
	public static String endX(String str) 
	{
	  if (str.equals("") || str.length() == 1)	
		  return str;
		  
		 if(str.charAt(0)=='x')
		  return endX(str.substring(1)) + "x";
				  
	  return str.charAt(0) + endX(str.substring(1));
	}
	
	public static String pairStar(String str) 
	{
		  if (str.equals("") || str.length() == 1)	// utolso karaktert mar csak adja vissza
		    return str;
		    
		  if(str.charAt(0)==str.charAt(1))
			  return str.charAt(0) + "*" + pairStar(str.substring(1)); 

		  return str.charAt(0) + pairStar(str.substring(1));
	}
	
	
	public static int mirror() 
	{
		// get a array return len of largest mirror
		int[] nums = new int[] {21, 22, 9, 8, 7, 6, 23, 24, 6, 7, 8, 9, 25, 7, 8, 9};		// 1,2,3 | 3,2,1	->3
		int cc=0, ind=0, max=0, n1, n2, indi;
		
		for(int i=nums.length-1; i>=0; i--)
		{
			indi = i;
			//if(ind>i) ind = 0;
			for(int j=ind; j<i; j++)
			{
				n1 = nums[indi];
				n2 = nums[j];
				System.out.println(indi+".back: " + n1 + "   " + j +".front: " + n2);
				if(n1==n2)
				{
					cc++;
					ind=j+1;
					indi--;
					if(cc>max)
						max=cc;
				}
				else
				{
					cc=0;
					indi = i;
				}
					
			}
		}
		
		return max;
	}
	
	public static int[] seriesUp(int n) 
	{
	   int[] ret = new int[n*(n + 1)/2];
	   int index = 0, i= 0, k = 2;
	   
	   while(index<ret.length)
	   {
		 i++;
		 ret[index] = 1;
	     index += i;	 
	     k = 2;
	     for(int j=index; j<ret.length-1; j++)
	     {
	    	 if(ret[j+1]!=1)
	    		 ret[j+1] = k++;
	     }
	   }
	   
	   return ret;
	}
	
	public static int[] squareUp(int n) 
	{
	  if(n==0) return new int[0];
	  
	  int[] result = new int[n*n];
	  int group_count = 1;   // hany elemet kell modositani a csoportban (ami nem marad 0)
	  int group_index = 0;		// segedvaltozo hogy a csoport vegerol visszafelé lehessen feltolteni..	  
	  int group_length = n;
	  
	  // lényeg a tomb feltoltese, n-es csoportonkent, a csoport vegerol visszafelé
	  for(int i=group_length-1; i<result.length; i+=group_length) 
	  {
	    group_index = i;
	    for(int k=1; k<=group_count; k++) 
	    {
	       result[group_index] = k;
	       group_index--; 
	    }
	    group_count++;
	  }
	  return result;
		
//	  
//	  int[] ret = new int[n*n];
//	  int num, ss;
//	  
//	  for(int i=0; i<ret.length; i++)
//	  {
//		ss = (i/3)+1;
//	    for(int k=0; k<n; k++)
//	    {
//	    	if(k==n-1)
//	    		num = 1;		
//	    	
//	    	else
//	    		num = ss-k*i;	
//	    	
//	    	ret[i] = num;	        
//	    	
//	        if(k<n-1)	i++;
//	    }
//	  }
//	  
//	  return ret;
	}
	
	public static String notReplace(String str) 
	{
	  	  int len = str.length();
		  String ret = "", chk = "";
			  
		  for(int i=0; i<len; i++)
		  {
		    ret += str.charAt(i);
		    if(i<len-1 && str.substring(i,i+2).equals("is"))
		    {
		      chk = str.substring(i+2);
		      if(chk.isEmpty() || !Character.isLetter(str.charAt(i+2)))
		      {
		    	  if(i==0)
		    	  {
		    		  ret += "s not";
				      i++; 
		    	  }
		          else if(i>0 && !Character.isLetter(str.charAt(i-1)))
		    	  {
		    		  ret += "s not";
				      i++; 
		    	  }		    	  
    		  }	    
		    }
		  }
		  
		  return ret;
	}
	
	public static int sumNumbers(String str) 
	{
	  int len = str.length();
	  int sum = 0;
	  String num = "";
		  
	  for(int i=0; i<len; i++)
	  {
	    if(Character.isDigit(str.charAt(i)))
	    {
	      num += str.charAt(i);
	      if(i+1 == len || !Character.isDigit(str.charAt(i+1)))
	        sum += Integer.parseInt(num);
	    }
	    else
	      num = "";
	  }
	  
	  return sum;
	}
	
	public static int maxBlock(String str) 
	{
	  int len = str.length();
	  int cc = 0, max = 0;
	  char buff = ' ';
	  
	  for(int i=0; i<len; i++)
	  {
	    if(i<len-1)
	    {	      
	      if(str.charAt(i) == str.charAt(i+1))
	      {
	        if(buff != str.charAt(i))
	        {	   
        	  buff = str.charAt(i);
	          cc = 1;
	        }
	        cc++;
	        if(cc > max)
	        	max = cc;
	      }
	      else
	    	  buff = ' ';
	        
	    }
	  }
	  
	  return max;
	}
	
	public static String sameEnds(String str) 
	{
	  int ccc=0;
	  int len = str.length();
	  String beg, end;
	  
	  for(int i=1; i<=len; i++)
	  {
	    beg = str.substring(0,i);
	    end = str.substring(len-i);
	    end = rev(end);
	    
	    if(beg.equals(end))
	    {
    	  ccc = beg.length();
//    	  if(beg.length()>1 && beg.endsWith(end.substring(0,1)))
//  	    	ccc--;
	    }
	    
	  }
	  
	  return str.substring(0, ccc);
	}
	
	private static String rev(String str)
	{
		String ret = "";
		
		for (int i = (str.length() - 1); i >= 0; i--)
		{
	        ret += str.charAt(i);
	    }
		
		return ret;
	}
	
	public static String withoutString(String base, String remove) 
	{
	  int len_r = remove.length();
	  String chk ="";
	  String ret = "";
	  
	  for(int i=0; i<base.length(); i++)
	  {
		chk = "";
		if(i<base.length()-len_r-1)
			chk = base.substring(i, i+len_r);
	    
	    if(chk.equals(remove))
	    {
	      i += len_r-1;
	      continue;
	    }
	    
	    ret += base.substring(i, i+1);
	  }
	  
	  return ret;
	}
	
	public List<Integer> doubling(List<Integer> nums) 
	{
	  nums.replaceAll(n -> n * 2);
	  
	  return nums;
	}
	
	public static Map<String, Integer> wordCount(String[] strings) 
	{
	  Map<String, Integer> map = new HashMap<String, Integer>();
	  int count = 0;
	  
	  for(int i=0; i<strings.length; i++)
	  {
	    count = 1;
	    for(int j=i+1; j<strings.length; j++)
	    {
	      if(strings[i].equals(strings[j]))
	        count++;
	    }
	    if(!map.containsKey(strings[i]))
	    	map.put(strings[i], count);
	  }
	  
	  return map;
	}

	
	public static int[] withoutTen(int[] nums) 
	{
	  int[] arr = new int[nums.length];
	  int j = 0;
	  for(int i=0; i<nums.length; i++)
	  {
		  if(nums[i] != 10)
			  arr[j++] = nums[i];
	  }
	  
	  return nums;
	}
	
	public static String getSandwich(String str) 
	{
	  String search = "bread";
	  String temp = "";
	  String ret = "";
	  int len = str.length();
	  int first = 0, last = 0;
	  
	  for(int i=0; i<len-4; i++)
	  {
		temp = str.substring(i,i+5);
		  
	    if(temp.equals(search))       // 1. bread found
	    {
	    	first = i;
	      for(int j=i+5; j<len-4; j++)
	      {
	    	temp = str.substring(j,j+5);
	        if(temp.equals(search))   // 2. bread found
	        {
//	          ret = str.substring(j-(j-5-i),j);
//	          return ret;
	        	last = j;
	        }
	      }
	      break;
	    }
	  }
	  
	  // first last
	  
	  
	  
	  if(last>=(first+5))
	  {
		  System.out.println(first + " - " + last);
		  String what = str.substring((first+5), last);
		  System.out.println(what);
		  return ret;
	  }
	  
	  return ret;
	}
	
	public static boolean xyzMiddle(String str) 
	{
		  String ret = "";
		  int len = str.length();
		  int temp = 0;
		  
		  for(int i=0; i<len-2; i++)
		  {
		    ret = str.substring(i,i+3);
		    
		    if(ret.equals("xyz"))
		    {
		      temp = i+3;                 // 3 a hossza a "xyz" nek
		      temp = len - temp;
		      if(Math.abs(temp-i)<=1)
		        return true;
		    }
		  }
		  
		  return false;
	}

	
	public static int factorial(int n) 
	{	
	  int fact = 0;
		
	  if(n>1)
	  {
		  fact = factorial(n-1);
		  fact = n*fact;
		  return fact;
	  }	    
	  
	  return 1;
	}
	
	public static long fibonacci(long n) 
	{
	  long sum = 0;
	  long one = 0;
	  long two = 0;
	  
	  if(n>2)
	  {
	    one = fibonacci(n-2);
	    two = fibonacci(n-1);
	    sum = one + two;
	    return sum;
	  }
	  
	  if(n==0)
	    return 0;
	  
	  return 1;
	}
	
	
	public static int bunnyEars2(int bunnies) 
	{
	  int sum = 0;	
	  
	  if(bunnies>0)
	  {
	    if(bunnies%2==1)
	    {
	      sum = bunnyEars2(bunnies-1);
	      sum = 2 + sum;
	      return sum;
	    }
	    if(bunnies%2==0)
	    {
	      sum = bunnyEars2(bunnies-1);
	      sum = 3 + sum;
	      return sum;
	    }
	  }
	  
	  return 0;
	}
	
	
	public static int triangle(int rows) 
	{
	  int sum = 0;
	  
	  if(rows>1)
	  {
	    sum = triangle(rows-1);
	    sum = sum+rows;
	    return sum;
	  }
	  
	  if(rows==0)
	    return 0;
	  
	  return 1;
	}
	
	
	public static int sumDigits(int n) 
	{
	  int len = String.valueOf(n).length();
	  int left = 0;
	  int right = 0;
	  int sum = 0;
	  
	  if(len>1)
	  {
	    left  = sumDigits(n/10);
	    right = sumDigits(n%10);
	    
	    sum = left+right;
	    return sum;
	  }
	  
	  return n;
	}
	
	
	public static int count7(int n) 
	{
	      int len = String.valueOf(n).length();
		  int left = 0;
		  int right = 0;
		  
		  if(len>1)
		  {			    
		    left  = count7(n/10);
		    right = count7(n%10);			
		    		    
		    return left+right;
		  }		  
		  
		  if( (n!=0 && n%7==0) )
		  {
			  return 1;
		  }
		  
		  return 0;
	}
	
	
	public static int count8(int n) 
	{
		  int len = String.valueOf(n).length();
		  int left = 0;
		  int right = 0;		  
		  
		  
		  if(len>1)
		  {			    
		    left  = count8(n/10);				
		    		    
		    return left+right;
		  }		  
		  
		  if( (n!=0 && n%8==0) )
		  {
			  return 1;
		  }
		  
		  return 0;
	}
	
	
	public static int powerN(int base, int n) 
	{
	  int pow=0;
	  
	  if(n>1)
	  {
	    pow = powerN(base, n-1);
	    pow = base*pow;
	    
	    return pow;
	  }
	  
	  if(n==1)
	    return base;
	  
	  return 1;
	}
	
		
	public static int countX(String str)
	{
		int sum = 0;
		
		if (str.equals("")) 
			return 0;
		
		if (str.charAt(0) == 'x')
		{
			str = str.substring(1);
			sum = 1 + countX(str);
			return sum;
		}
			
		else 
		{
			str = str.substring(1);
			return countX(str);
		}
			
	}
	
	public static boolean makeBricks(int small, int big, int goal) 
	{
	  // 8%3 = 2  2/1 = 2  8 ?= 2*3 + 2*1
	  // big*5 pl bsum =  1*5 = 5;   8-bsum = 3,  ssum = 3*1 
	  
	  int bsum, ssum, bside, sside;
	  
	  bsum = big*5;
	  ssum = small;
	  
	  if(goal-bsum == 0)
	    return true;
	  if(ssum >= goal)
	    return true;
	  
	  if(bsum>0)
	  {
	    bside = goal-bsum;
	    while(bside<0)
	    {
	      bsum -=5;
	      if(bsum<0)
	        break;
	      bside = goal-bsum;
	    }
	   if( (goal-bsum) <= ssum)
	    return true; 
	  }	  
	    
	  
	  return false;
	}

	public static boolean evenlySpaced(int a, int b, int c) 
	{
	  int[] nums = new int[3];
	  nums[0] = a;
	  nums[1] = b;
	  nums[2] = c;
	  int temp;
	  
	  for(int i=0; i<3; i++)
	  {
	    for(int j=0; j<3; j++)
	    {
	      if(nums[j]<nums[i])
	      {
	        temp = nums[i];
	        nums[i] = nums[j];
	        nums[j] = temp;
	      }
	    }
	  } 
	  
	  int diff1 = nums[1]-nums[0];
	  int diff2 = nums[2]-nums[1];
	  
	  if(diff1==diff2)
	    return true;
	    
	  return false;
	}

	public static boolean xyzThere(String str) 
	{
	      String ret = "";
		  char dot = '0';
		  
		  for(int i=0; i<str.length()-2; i++)
		  {
		    ret = str.substring(i,i+3);
		    dot = str.charAt(i);
		    if(i>0)
		    	dot = str.charAt(i-1);
		    if(dot != '.' && ret.equals("xyz"))
		      return true;
		  }
		  
		  return false;
	}
	
//	sajat
	
	// a referenciat koveti
	public static void calc0(IntPojo num)
	{
		System.out.println("referenciaba atvett integerpojo peldany kodja: " + num.hashCode() );
		num.first += 53;
	}
	
	// a referenciat nem koveti, lemasolja az erteket hozzad, de a referenciaba nem kerul vbele
	public static void calc1(int num)
	{
		num += 530;
	}
	
	public static void calc2(Integer num)
	{
		System.out.println("lemasolt integer peldany kodja: " + num.hashCode() );
		num += 53;
	}

}













