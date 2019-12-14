package L03;

import java.util.Scanner;

public class Inverse {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("ENTER Number :-");
		int n1 = in.nextInt();
		int piggy = 0;
		int count = 1;
		while (n1 != 0) {
			int rem = n1 % 10;
			n1 = n1 / 10;
			int mul = (int) Math.pow(10, rem - 1);
			piggy += (count * mul);
			count++;

		}
		System.out.println(piggy);

	}

}
