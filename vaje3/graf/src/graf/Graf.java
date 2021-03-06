package graf;

import java.util.*;

public class Graf {
	protected Map<Object, Tocka> slovar_tock;

	public Graf() {
		this.slovar_tock = new HashMap<Object, Tocka>();
	}
	
	public Tocka tocka(Object ime) {
		return slovar_tock.get(ime);
		
	}
	
	public boolean povezava(Tocka a, Tocka b) {
		return (b.sosedi.contains(a));
	}
	
	public void dodajTocko(Tocka tocka) {
		if (!slovar_tock.containsKey(tocka.ime)) {
			slovar_tock.put(tocka.ime, tocka);
		}
	}
	
	public void dodajPovezavo(Tocka a, Tocka b) {
		if ((a != b) && (!a.sosedi.contains(b))) {
			a.sosedi.add(b);
			b.sosedi.add(a);
			slovar_tock.put(a.ime, a);
			slovar_tock.put(b.ime, b);
		}
	}
	
	public void odstraniPovezavo(Tocka a, Tocka b) {
		if (a.sosedi.contains(b)) {
			a.sosedi.remove(b);
			b.sosedi.remove(a);
			slovar_tock.put(a.ime, a);
			slovar_tock.put(b.ime, b);	
		}
	}
	
	public void odstraniTocko(Tocka a) {
		for(Object ime : slovar_tock.keySet()) {
			Tocka tmp = slovar_tock.get(ime);
			if (tmp.sosedi.contains(a)) {
				tmp.sosedi.remove(a);
				slovar_tock.put(ime, tmp);
			}
		}
		slovar_tock.remove(a.ime, a);
	}
	
	public static Graf prazen(int n) {
		Graf g = new Graf();
		for (int i = 1; i <= n; i++) {
			Tocka t = new Tocka(i);
			g.dodajTocko(t);
		}
		return g;
	}
	
	public static Graf cikel(int n) {
		Graf g = prazen(n);
		for (int i = 2; i <= n; i++) {
			g.dodajPovezavo(g.tocka(i), g.tocka(i-1));
		}
		g.dodajPovezavo(g.tocka(1), g.tocka(n));
		return g;
	}
	
	public static Graf poln(int n) {
		Graf g = prazen(n);
		for (int i = 1 ; i <= n ; i++) {
			for (int j = 1; j <= n; j++) {
				g.dodajPovezavo(g.tocka(i), g.tocka(j));
			}
		}
		return g;
	}
	
	public static Graf polnDvodelen(int n) {
		Graf g = prazen(n);
		//TODO
		return g;
	}
	
	//ne rabimo pisat 'Graf g' v argumentu...
	public boolean povezan() { 
		int pointer = 0;
		Vector<Tocka> vozlisca = new Vector<Tocka>();
		Map.Entry<Object,Tocka> entry = slovar_tock.entrySet().iterator().next();
		Tocka prva = entry.getValue();
		vozlisca.add(prva); //dodam eno poljubno tocko
		while (pointer < vozlisca.size()) {
			for (Tocka t : vozlisca.get(pointer).sosedi) {
				if (!vozlisca.contains(t)) {
					vozlisca.add(t);
				}
			}
			pointer ++;
		}
		return (pointer == slovar_tock.size());
	}
	
	//ne rabimo pisat 'Graf g' v argumentu...
	public int steviloKomponent() {
		//TODO
		return 5;
	}
	
	public void razporedi(double x, double y, double r) {
		int st_tock = slovar_tock.size();
		int counter = 0;
		//lahko bi uporabu lepso for zanko, da iteriram direktno po slovarju
		for (Tocka a : slovar_tock.values()) {  
			a.x = x + Math.cos(counter*2*Math.PI/st_tock)*r;
			a.y = y + Math.sin(counter*2*Math.PI/st_tock)*r;
			counter++;
		}
		
	}
	
	public void izpis() {
		for(Tocka t : slovar_tock.values()) {
			System.out.print("Tocka:");
			System.out.print(t.ime);
			//System.out.print("   x koordinata: ");
			//System.out.print(t.x);
			System.out.print("  Sosedi:");
			System.out.println(t.sosedi);
		}
	}
	
	
	
	
	
	

}
