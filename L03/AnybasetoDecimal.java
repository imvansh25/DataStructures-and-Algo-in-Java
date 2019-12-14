package L03;

import java.util.Scanner;

public class AnybasetoDecimal {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("ENTER BASE :-");
		int n1 = in.nextInt();
		System.out.println("ENTER NUMBER :-");
		int n2 = in.nextInt();
		int multiplier = 1;
		int total = 0;
		while (n2 != 0) {
			int rem = n2 % 10;
			n2 = n2 / 10;
			total += (rem * multiplier);
			multiplier *= n1;

		}
		System.out.println(total);

	}
}
