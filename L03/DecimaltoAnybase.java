package L03;

import java.util.Scanner;

public class DecimaltoAnybase {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("ENTER BASE :-");
		int n1 = in.nextInt();
		System.out.println("ENTER NUMBER :-");
		int n2 = in.nextInt();
		int multiplier = 1;
		int total = 0;
		while (n2 != 0) {
			int rem = n2 % n1;
			n2 = n2 / n1;
			total += (rem * multiplier);
			multiplier *= 10;

		}
		System.out.println(total);

	}

}
