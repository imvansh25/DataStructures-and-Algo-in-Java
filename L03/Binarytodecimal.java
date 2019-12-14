package L03;

import java.util.Scanner;

public class Binarytodecimal {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n1 = in.nextInt();
		int multiplier = 1;
		int total = 0;
		while (n1 != 0) {
			int rem = n1 % 10;
			n1 = n1 / 10;
			total += (rem * multiplier);
			multiplier*=2;

		}
		System.out.print(total);

	}

}
