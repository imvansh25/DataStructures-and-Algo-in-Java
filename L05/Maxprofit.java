package L05;

import java.util.Scanner;

public class Maxprofit {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = takeinput();
		int piggy = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++)
				if ((arr[j] - arr[i]) > piggy) {
					piggy = arr[j] - arr[i];
				}
		}
		System.out.println(piggy);
	}

	public static int[] takeinput() {
		System.out.println("Size ?");
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = in.nextInt();
		}
		return arr;

	}

}
