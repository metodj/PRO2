package graf;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Okno extends JFrame implements ActionListener{
	protected Platno platno;
	JMenuBar mb = new JMenuBar();
	JMenu datoteka = new JMenu("Datoteka");
	JMenu graf = new JMenu("Graf");
	JMenuItem poln = new JMenuItem("Poln");
	JMenuItem prazen = new JMenuItem("Prazen");
	JMenuItem cikel = new JMenuItem("Cikel");
	JMenuItem barva = new JMenuItem("Barva toèk");
	JMenuItem barva2 = new JMenuItem("Barva povezav");
	

	public Okno() { 
		this.platno = new Platno(600,600);
		setTitle("Graf");
		add(platno); //platno vstavis v okno
		poln.addActionListener(this);
		prazen.addActionListener(this);
		cikel.addActionListener(this);
		barva.addActionListener(this);
		barva2.addActionListener(this);
		datoteka.add(graf);
		datoteka.add(barva);
		datoteka.add(barva2);
		graf.add(prazen);
		graf.add(poln);
		graf.add(cikel);
		datoteka.addSeparator();
		mb.add(datoteka);
		setJMenuBar(mb);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == poln) {
			String n = JOptionPane.showInputDialog("Vnesi število toèk:");
			Graf g = Graf.poln(Integer.parseInt(n));
			g.razporedi(500, 500, 300);
			platno.narisi(g);
		}
		if (event.getSource() == cikel) {
			String n = JOptionPane.showInputDialog("Vnesi število toèk:");
			Graf g = Graf.cikel(Integer.parseInt(n));
			g.razporedi(500, 500, 300);
			platno.narisi(g);
		}
		if (event.getSource() == prazen) {
			String n = JOptionPane.showInputDialog("Vnesi število toèk:");
			Graf g = Graf.prazen(Integer.parseInt(n));
			g.razporedi(500, 500, 300);
			platno.narisi(g);
		}
		if (event.getSource() == barva) {
			Color c = JColorChooser.showDialog(this, "Izberi barvo toèke", platno.barva);
			if(c != null) {
				platno.barva = c;
			}
		}
		if (event.getSource() == barva2) {
			Color d = JColorChooser.showDialog(this, "Izberi barvo povezav", platno.barva_povezave);
			if(d != null) {
				platno.barva_povezave = d;
			}
		}
		
	}
	
	//TODO branje in shranjevanje grafa
	
	//TODO izhod iz programa
	
	
	
	

}
