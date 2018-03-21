package zaporedje;

import java.util.*;

//pomojem se tole da veliko lepse resiti z uporabo rekurzije...
public class Zaporedje {

	public static void main(String[] args) {
		int k = Integer.parseInt(args[0]);
		List<String> rezultat = new ArrayList<String>();
		rezultat.add("1");
		for (int i = 1; i < k; i++) {
			String tmp = rezultat.get(i-1);
			rezultat.add(preberi(tmp));
		}
		System.out.println(rezultat);

	}

	private static String preberi(String tmp) {
		String koncni = "";
		int counter = 1;
		char trenutni = tmp.charAt(0);
		for (int j = 1; j < tmp.length(); j++) {
			if (tmp.charAt(j-1)==tmp.charAt(j)) {
				counter ++;
			} else {
				koncni = koncni + Integer.toString(counter) + trenutni;
				counter = 1;
				trenutni = tmp.charAt(j);	
			}
			
		}
		koncni = koncni + Integer.toString(counter) + trenutni;
		return koncni;
	}

}
