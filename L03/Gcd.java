package L03;
import java.util.Scanner;

public class Gcd {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n1 = in.nextInt();         // divident
		int n2 = in.nextInt();         // divisor
		int count = 0;
		while (n1 % n2 != 0) {
			int rem = n1 % n2;        // remender
			n1 = n2;
			n2 = rem;
		}
		System.out.println(n2);

	}

}
