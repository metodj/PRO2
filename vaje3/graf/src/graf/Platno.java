package graf;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Platno extends JPanel{
	protected int sirina;
	protected int visina;
	protected Graf graf;
	
	public Platno(int sirina, int visina) {
		this.sirina = sirina;
		this.visina = visina;
		this.graf = null;
	}
	
	public void narisi(Graf g) {
		this.graf = g;
		repaint();
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(sirina, visina);
	}
	
	public void paintComponent(Graphics g) {
		for (Tocka a : graf.slovar_tock.values()) {
			for (Tocka b : a.sosedi) {
			g.drawLine(round(a.x), round(a.y), round(b.x), round(b.y));
			}
		}
		int w = 20;
		int h = 20;
		for (Tocka a : graf.slovar_tock.values()) {
			g.fillOval(round(a.x-w/2), round(a.y-h/2), w, h);
		}
	}
	
	public static int round(double x) {
		return (int)(x + 0.5);
	}
	
	

}