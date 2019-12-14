package L09;

import java.util.Scanner;

public class Powe {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int x = in.nextInt();

		int n1 = power(n, x);
		System.out.println(1);

	}

	public static int power(int x, int n) {
		if (n == 0) {
			return 1;
		}
		int pow = power(x, n - 1) * x;
		return pow;
	}

}
