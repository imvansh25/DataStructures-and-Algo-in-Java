package L04;

import java.util.Scanner;

public class AllPrime {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("ENTER Lower no. :-");
		int n1 = in.nextInt();
		System.out.println("ENTER Higher no. :-");
		int n2 = in.nextInt();
		AllPrime(n1,n2);
		

	}

	public static void AllPrime(int lower, int higher) {
		for (int i = lower; i <= higher; i++) {
			if (isprime(i)) {
				System.out.println(i);
			}

		}

	}

	public static boolean isprime(int n) {
		int count = 2;
		int piggy = 0;
		while (count < n) {
			if (n % count == 0) {
				piggy++;
			}
			count++;

		}
		if (piggy == 0) {
			return true;
		} else {
			return false;
		}

	}

}
