package polinomi;

import java.util.*;

//kako nastavim, da je red 1 v primeru, da ne vnesem argumenta za red?

//vnasam polinome takole: "3,1,1,2"
//vnasam red odvoda = "n"
public class Polinomi {

	public static void main(String[] args) {
		List<String> koef = 
			     new ArrayList<String>(Arrays.asList(args[0].split(",")));
		int red =  Integer.parseInt(args[1]);
		for (int j = 1; j <= red; j++) {
			koef = odvod(koef);
		}
		System.out.println(koef);
	}

	private static List<String> odvod(List<String> koef) {
		int counter = 1;
		List<String> rez = new ArrayList<String>();
		if (koef.size() <= 1) {
			return rez;
		}
		for (int j = 1; j < koef.size(); j++) {
			int tmp = Integer.parseInt(koef.get(j)) * counter;
			rez.add(Integer.toString(tmp));
			counter ++;
		}
		
		return rez;
	}

}
