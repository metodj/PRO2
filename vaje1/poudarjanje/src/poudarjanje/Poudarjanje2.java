package poudarjanje;

public class Poudarjanje2 {

	public static void main(String[] args) {
		String s = args[0];
		String koncni = "";
		boolean stikalo = false;
		for (int i = 0; i < s.length(); i++){
		    char c = s.charAt(i); 
		    if (c == '*') {
		    	stikalo = !stikalo;
		    } else {
		    	if (stikalo) {
		    		c  = Character.toUpperCase(c);
					koncni += c;
		    	} else {
		    		koncni += c;
		    	}
		    	 
		    }
		   
		}
		System.out.println(koncni);

	}

}
