package L04;

import java.util.Scanner;

public class AlphabetsOnly {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		char a = in.next().charAt(0);
		if (a>='A' && a <= 'Z') {
				System.out.println("Upper");
			} else if (a>='a'&& a<='z') {
				System.out.println("Lower");
			} else {
			System.out.println("invalid");

		}

	}

}
