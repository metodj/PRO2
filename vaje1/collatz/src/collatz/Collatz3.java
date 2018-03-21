package collatz;

import java.util.ArrayList;
import java.util.List;

public class Collatz3 {
	public static void main(String[] args) {
		int k = Integer.parseInt(args[0]);
		List<Integer> seznam = new ArrayList<Integer>();
		seznam.add(k);
		while (k != 1) {
			if (k % 2 == 0) {
				k /= 2;
			} else {
				k = k * 3 + 1;
			}
			seznam.add(k);
		} 
		for (Integer i : seznam) {
			System.out.println(i);
		}	
	}

}
