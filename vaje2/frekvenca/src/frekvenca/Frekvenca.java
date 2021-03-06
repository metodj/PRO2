package frekvenca;

import java.io.*;
import java.util.*;


public class Frekvenca {

	public static void main(String[] args) throws IOException {
		String vhod = args[0];
		System.out.println(slovar(vhod));

	}
	
	private static Map<String, Integer> slovar(String imeVhod) throws IOException {
		Map<String, Integer> koncni = new HashMap<String, Integer>();
		BufferedReader vhod = new BufferedReader(new FileReader(imeVhod));
		Set<String> stop_besede = nepomembne();
		while (vhod.ready()){
			String vrstica = vhod.readLine().trim();
			StringTokenizer st = new StringTokenizer(vrstica, " .,?:;");
			while (st.hasMoreTokens()) {
				String beseda = st.nextToken();
				if (stop_besede.contains(beseda)) {
					continue;
				}else if (koncni.containsKey(beseda)) {
					koncni.put(beseda, koncni.get(beseda) + 1);
				} else {
					koncni.put(beseda, 1);
				}
			}
		 }
		vhod.close();
		return koncni;
	}
	
	private static Set<String> nepomembne() throws IOException {
		Set<String> pre = new HashSet<String>();
		BufferedReader vhod = new BufferedReader(new FileReader("SloStopWords.txt"));
		while (vhod.ready()) {
			String vrstica = vhod.readLine().trim();
			pre.add(vrstica);
		}
		
		return pre;
	}
	
	private static Vector<String> vektor(Map<String, Integer> slovar) {
		//TODO urediti padajo�e po frekvencah
		Vector<String> rezultat = new Vector<>(slovar.keySet());
		return rezultat;
	}
	
}

// ASISTENT REKEL, DA SE NE SPLACA TAKOLE DELATI
//	private static List<String> zdruzi(String imeVhod) throws IOException {
//		BufferedReader vhod = new BufferedReader(new FileReader(imeVhod));
//		List<String> vreca = new ArrayList<String>(); 
//		while (vhod.ready()){
//			String vrstica = vhod.readLine().trim();
//			if (vrstica.equals("")) { 
//				continue; 
//				} else {
//					String[] besede = vrstica.split(" +");
//					vreca.addAll(besede);
//					}
//			
//				}
//		vhod.close();
//		return vreca;
//		}
	



