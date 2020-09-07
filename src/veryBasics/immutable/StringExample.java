package veryBasics.immutable;

public class StringExample {

	// stringek specialisak, heapen belul stringpool, imuutablek
	public static void main(String[] args) {
		
		String s1 = "Apple";		// String_pool: "Apple"
		String s2 = "Mango";		// String_pool: "Apple", "Mango"
		String s3 = "Apple";		// String_pool: "Apple", "Mango"    // nem keszult uj object s3 is "Apple"-re mutat
		
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		
		s3 = s1;					// gyakorlatilag hatastalan, mmar eleve ugyanarra mutatnak
		
		s1 += "Pie";				// s3 nem valtozik meg, az tovabbra is "Apple"-re mutat, s1 uj String kepzodik es az lesz az s1 erteke,
									// NA EZ A LENYEG (nem az Apple referenciat "bantja" azt lemasolva keszul egy uj string, es az lesz az erteke)
		
									// String_pool: "Apple", "Mango", "Banana"
		s3 = "Banana";				// s3 "Banana" lesz, de mivel immutables, igy s1 nem valtozik meg
		
		System.out.println();
		
		
		/////////////////// StringBuilder mar mutable
		
		StringBuilder sb1 = new StringBuilder("Apple");
		StringBuilder sb2 = sb1;
		
		System.out.println(sb1.toString() + " | " + sb2.toString());
		
		sb1.append("Pie");														// ugye mar normal mutable szabalyoknak megfeleloen, a sb1 es sb2
																				// ugyanarra az objectre mutat, amikor modosul, az object modusul, nem egy masolatat kapja vissza sb1, 
																				// emiatt az sb2 is "latja" ugyanezt a valtozast
		
		System.out.println(sb1.toString() + " | " + sb2.toString());
		
		
		////////////////////////// String as new String() igy mar sima mutable mert nem a STringpoolba vannak EZ NEM IGAZ!
		
		String st1 = new String("Apple");
		String st2 = st1;
		
		st1 = st1.concat("Pie");					// nem stringpoolba van, de ugyan az a lenyeg, STring immutable
		
		System.out.println(st1 + " | " + st2);		// ApplePie | Apple lesz, st1 nem modosul egy copyt kap vissza ami mar ApplePie lesz, st2 nem modosul
	}

}
