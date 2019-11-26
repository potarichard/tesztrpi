package byteBybyte;

public class KnapSack01 {

	static int knapsack(int W, int[] weights, int[] values)
	{
		int[][] cache = new int[weights.length + 1][W + 1];		// elso sor es elso oszlop 0 mert 0 tomegu targy nem van, es oszlop
		
//		tabla sorok a targyak amibol valszthatunk, 
//			1. sor csak az 1 targayt rakhazom a zsakba
//			2. sor 1 es 2 targyat is rakhatom a zsakba
//			3. sor 1,2,3 targyat is rakhatom a zsakba
		
//		oszlopok az en zsakom tomege, ami megy 0 tol a max megengedett tomegig
		
//		folyamatosan nezem hogyha a zsakom pl 2 kg-s lehet es valaszthatok az 1 es targybol akkor mennyit rakhatok bele
//		aztan masodik sorba nezem 1, 2 targybol rakhatom a zsakom tomege 3 lehet akkor belerakhatom az 1 es es 2 targyat is, lenyeg h value maximalizalva legyen kozube
		
//		egy targyat csak egyszer rakhatok bele teheat nem lehet belerakni 2 db 10 ertekut...
		
		for (int item=1; item<=weights.length; item++)
		{
			for (int sack=1; sack<=W; sack++)
			{
				if(weights[item-1] > sack)																// then do not choose
					cache[item][sack] = cache[item-1][sack];
				else
					cache[item][sack] = Math.max(	cache[item-1][sack], 											// not choose option
											cache[item-1][sack - weights[item-1]] + values[item-1]);			// choose option
			}
		}
		
		return cache[weights.length][W];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] weights = {1, 2, 3};
		int[] values  = {6, 10, 12};
		
		int max_w = 5;
		
//		kivalasztom a 10 es 12 es erteku cuccot aminek tomege 2 + 3 = 5 igy meg belefer a zsakomba
		
		System.out.println(knapsack(max_w, weights, values));
	}

}
