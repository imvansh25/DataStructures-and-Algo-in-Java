package L03;

import java.util.Scanner;

public class Decimaltobinary {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n1 = in.nextInt();
		int multiplier = 1;
		int total = 0;
		while (n1 != 0) {
			int rem = n1 % 2;
			n1 = n1 / 2;
			total += (rem * multiplier);
			multiplier *= 10;

		}
		System.out.print(total);

	}
}
