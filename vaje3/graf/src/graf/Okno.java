package graf;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
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
	JMenuItem odpri = new JMenuItem("Uvozi graf");
	JMenuItem shrani = new JMenuItem("Shrani graf");
	JMenuItem izhod = new JMenuItem("Izhod");
	JFileChooser fc = new JFileChooser();
	

	public Okno() { 
		this.platno = new Platno(600,600);
		setTitle("Graf");
		add(platno); //platno vstavis v okno
		poln.addActionListener(this);
		prazen.addActionListener(this);
		cikel.addActionListener(this);
		barva.addActionListener(this);
		barva2.addActionListener(this);
		odpri.addActionListener(this);
		shrani.addActionListener(this);
		izhod.addActionListener(this);
		datoteka.add(graf);
		datoteka.add(barva);
		datoteka.add(barva2);
		datoteka.add(odpri);
		datoteka.add(shrani);
		graf.add(prazen);
		graf.add(poln);
		graf.add(cikel);
		datoteka.addSeparator();
		mb.add(datoteka);
		mb.add(izhod);
		setJMenuBar(mb);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		if (event.getSource() == odpri){
			int option = fc.showOpenDialog(this);
			if (option == JFileChooser.APPROVE_OPTION) {
				String ime = fc.getSelectedFile().getPath();
				try {
					BufferedReader vhod = new BufferedReader(new FileReader(ime));
					int stikalo = 0;
					Graf g = new Graf();
					while(vhod.ready()) {
						String vrstica = vhod.readLine().trim();
						String[] besede = vrstica.split(" +");
						//mal poenostavimo vhodno datoteko
						if (besede[0].equals("#vertices")) {
							stikalo = 1;
						} else if (besede[0].equals("#edges")){
							stikalo = 2;
						} else if (stikalo == 1) {
							Tocka t = new Tocka(besede[0]);
							t.x = Integer.parseInt(besede[1]);
							t.y = Integer.parseInt(besede[2]);
							g.dodajTocko(t);
						} else if (stikalo == 2) {
							for (int i = 1; i < besede.length; i++) {
								g.dodajPovezavo(g.tocka(besede[0]), g.tocka(besede[i]));
							}
						}

					}
					vhod.close();
					platno.narisi(g);
				} catch(IOException exc) {
					//TODO vrni komentar o napaki
				}
			}
		}
		if (event.getSource() == shrani){
			int option = fc.showSaveDialog(this);
			if (option == JFileChooser.APPROVE_OPTION) {
				String ime = fc.getSelectedFile().getPath();
				try {
					PrintWriter izhod = new PrintWriter(new FileWriter(ime));
					izhod.write("#vertices" + System.lineSeparator());
					int stevec = 1;
					for (Tocka t : platno.graf.slovar_tock.values()) {
						t.ime = stevec;
						izhod.write(Integer.toString(stevec) + " " + Double.toString(t.x) + " " +
								Double.toString(t.y) + System.lineSeparator());
						stevec ++;
					}
					izhod.write("#edges" + System.lineSeparator());
					for (Tocka t : platno.graf.slovar_tock.values()) {
						String tmp = "";
						tmp += t.ime;
						for (Tocka g : t.sosedi) {
							tmp += " ";
							tmp += g.ime;
						}
						izhod.write(tmp + System.lineSeparator());
					}
					izhod.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if (event.getSource() == izhod) {
			dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}
		
		
	}
	
	//TODO branje in shranjevanje grafa
	
	//TODO izhod iz programa
	
	
	
	

}
