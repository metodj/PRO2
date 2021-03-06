package razcep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Razcep {
	public static void main(String[] args) {
		int k = Integer.parseInt(args[0]); 
		List<Integer> prastevila = eratosten(k); //kako je celostevilsko deljenje v Javi? 
		// ali lahko take zadeve preverim v konzoli, kot npr. v Pythonu?
		List<Integer> sez = new ArrayList<Integer>();
		for (Integer pra : prastevila) {
			int temp = k;
			while (temp % pra == 0) {
				sez.add(pra);
				temp /= pra;
			}
		}
		Map<Integer, Integer> data = slovar(sez);
		String koncni = "";
		for (Entry<Integer,Integer> pair : data.entrySet()) {
			String vmesni = " " + Integer.toString(pair.getKey()) + "^" + Integer.toString(pair.getValue()) + " *";
			koncni += vmesni;
		}
		koncni = Integer.toString(k) + " =" + koncni.substring(0, koncni.length() - 1);
		System.out.println(koncni);
	}
	
	private static List<Integer> eratosten(int n) {
		List<Integer> veckratniki = new ArrayList<Integer>();
		List<Integer> prastevila = new ArrayList<Integer>();
		for (int i = 2; i <= n + 1; i++) {
			if (!(veckratniki.contains(i))) {
				prastevila.add(i);
				for (int j = i*i ; j <= n + 1; j += i) {
					veckratniki.add(j);
				}
			}
		}
		return prastevila;
		
	}
	
	private static Map<Integer, Integer> slovar(List<Integer> sez) {
		Map<Integer, Integer> data = new HashMap<Integer, Integer>();
		Set<Integer> mnozica = new HashSet<Integer>(sez);
		for (Integer i : mnozica) {
			data.put(i, frekvenca(i, sez));
		}
		
		return data;
		
	}

	private static Integer frekvenca(Integer i, List<Integer> sez) {
		int stevec = 0;
		for (Integer tmp : sez) {
			if (tmp == i) {
				stevec ++;
			}
		}
		return stevec;
	}



}
