BufferedReader vhod = new BufferedReader(new FileReader(imeVhod));
PrintWriter izhod = new PrintWriter(new FileWriter(imeIzhod));
while (vhod.ready()){
	String vrstica = vhod.readLine().trim();
	if (vrstica.equals(""))continue
	String[] besede = vrstica.split(" +");
	\\TODO
}
vhod.close();
izhod.close();