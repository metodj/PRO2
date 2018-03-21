package graf;

public class Test {

	public static void main(String[] args) {
		Graf g = Graf.cikel(5);
		g.razporedi(500, 500, 300);
//		Tocka t = new Tocka("kaj");
//		t.x = 600;
//		t.y = 600;
//		g.dodajTocko(t);
//		g.dodajPovezavo(t,  g.tocka(3));
//		g.odstraniTocko(g.tocka(2));
//		g.izpis();
		System.out.println(g.povezan());
		Okno okno = new Okno();
		okno.pack();
		okno.setVisible(true);
		okno.platno.narisi(g);

	}

}
