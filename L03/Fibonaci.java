package L03;

import java.util.Scanner;

public class Fibonaci {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int count = 0;
		int n1 = 0;
		int n2 = 1;
		while (n2 <= n) {
			int s = 0;
			if (n1 <= n) {
				System.out.print(n1);
				System.out.println();
			}
			s = n1 + n2;
			n1 = n2;
			n2 = s;
			count++;

		}

	}

}
