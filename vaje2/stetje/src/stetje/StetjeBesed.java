package stetje;

import java.io.*;

public class StetjeBesed {

	public static void main(String[] args) throws IOException {
		String vhod = args[0];
		String izhod = args[1];
		System.out.println(stetje(vhod, izhod));

	}
	
	private static int stetje(String imeVhod, String imeIzhod) throws IOException {
		BufferedReader vhod = new BufferedReader(new FileReader(imeVhod));
		PrintWriter izhod = new PrintWriter(new FileWriter(imeIzhod));
		int stevec = 0;
		while (vhod.ready()){
			String vrstica = vhod.readLine().trim();
			if (vrstica.equals("")) { 
				continue; 
				} else {
					String[] besede = vrstica.split(" +");
					stevec += besede.length;
					for (String beseda : besede) {
						izhod.write(beseda + System.lineSeparator());
					}
					}
			
				}
		vhod.close();
		izhod.close();
		return stevec;
		}
	
	}


