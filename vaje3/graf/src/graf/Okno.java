package graf;


import javax.swing.JFrame;

public class Okno extends JFrame{
	protected Platno platno;

	public Okno() { 
		this.platno = new Platno(600,600);
		setTitle("Graf");
		add(platno); //platno vstavis v okno
		
	}
	
	
	

}
