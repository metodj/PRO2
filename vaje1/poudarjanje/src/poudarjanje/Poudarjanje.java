package poudarjanje;

public class Poudarjanje {
	public static void main(String[] args) {
		String s = args[0];
		String koncni = "";
		for (int i = 0; i < s.length(); i++){
		    char c = s.charAt(i); 
		    c  = Character.toUpperCase(c);
		    //Process char
		    koncni = koncni + c + " ";
		}
		koncni = koncni.substring(0, koncni.length() - 1);
		System.out.println(koncni);
	}

}
