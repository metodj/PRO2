package collatz;
import java.lang.Math;


public class Collatz2 {
	public static void main(String[] args) {
		int k = Integer.parseInt(args[0]);
		int najvecji = k;
		while (k != 1) {
			if (k % 2 == 0) {
				k /= 2;
			} else {
				k = k * 3 + 1;
			}
			najvecji = Math.max(najvecji, k);
		}
		System.out.println(najvecji);
	}
}
