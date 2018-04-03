package graf;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JPanel;


public class Platno extends JPanel implements MouseListener, MouseMotionListener, KeyListener{
	protected int sirina;
	protected int visina;
	protected Graf graf;
	protected Set<Tocka> oznacene;
	protected Tocka aktivna;
	protected Color barva;
	protected Color barva_oznacene;
	protected Color barva_aktivne;
	protected Color barva_povezave;
	private static final int premer = 20;
	protected int x_klika;
	protected int y_klika;
	
	
	public Platno(int sirina, int visina) {
		this.oznacene = new HashSet<Tocka>();
		this.aktivna = null;
		this.barva = Color.black;
		this.barva_oznacene = Color.red;
		this.barva_aktivne = Color.yellow; 
		this.barva_povezave = Color.blue;
		this.sirina = sirina;
		this.visina = visina;
		this.graf = null;
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
		this.setFocusable(true); //fokus
	}
	
	public void narisi(Graf g) {
		this.graf = g;
		repaint();
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(sirina, visina);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g); //magija
		for (Tocka a : graf.slovar_tock.values()) {
			for (Tocka b : a.sosedi) {
			g.drawLine(round(a.x), round(a.y), round(b.x), round(b.y));
			}
		}
		int w = premer;
		int h = premer;
		for (Tocka a : graf.slovar_tock.values()) {
			if (a == aktivna) {
				g.setColor(barva_aktivne);
			} else if (oznacene.contains(a)) {
				g.setColor(barva_oznacene);
			} else {
				g.setColor(barva);
			}
			g.fillOval(round(a.x-premer/2), round(a.y-premer/2), premer, premer);
			}
			
		}
		
	
	
	//da v zgornji metodi lahko double spremenimo v int
	public static int round(double x) {
		return (int)(x + 0.5);
	}
	
	
	

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		x_klika = e.getX();
		y_klika = e.getY();
		for (Tocka t : graf.slovar_tock.values()) {
			if (Math.sqrt(Math.pow(t.x-e.getX(), 2) + Math.pow(t.y-e.getY(), 2)) < premer/2) {
				aktivna = t;
				break;
			}
		}
		repaint();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if ((aktivna == null) && (x_klika == e.getX()) && (y_klika == e.getY()) ) {
			//Tocka nova = new Tocka("nova"); //slab nacin za poimenovanje
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
			Tocka nova = new Tocka(timeStamp);
			nova.x = e.getX();
			nova.y = e.getY();
			graf.slovar_tock.put(nova.ime, nova);
			for (Tocka t : graf.slovar_tock.values()) {
				graf.dodajPovezavo(nova, t);
			}
			repaint();
		} else if ((x_klika == e.getX()) && (y_klika == e.getY()) ) {
			oznacene.add(aktivna);
			aktivna = null;
		} else {
			aktivna = null;
		}
		repaint();
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (aktivna != null) {
			aktivna.x = e.getX();
			aktivna.y = e.getY();
			repaint();
		} else {
			for (Tocka t : oznacene) {
				//TODO premikanje vseh oznacenih tock
			}
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//TODO zaenkrat ne dela
		if (e.getKeyChar() == '\b') {
			for (Tocka t: graf.slovar_tock.values()) {
				if (oznacene.contains(t)) {
					graf.odstraniTocko(t);
				}
			}
			repaint();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
	
	

}
