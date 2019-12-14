package L05;

import java.util.Scanner;

public class RotateString {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = takeinput();
		System.out.println("No of Rotations :-");
		int n = in.nextInt();
		n = n % arr.length;
		if (n < 0) {
			n = n + arr.length;

		}
		int count = 0;
		while (count < n) {
			int temp = arr[arr.length - 1];
			for (int i = arr.length - 1; i >= 1; i--) {
				arr[i] = arr[i - 1];
			}
			arr[0] = temp;
			count++;

		}
		display(arr);

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

	public static void display(int[] arr) {
		for (int val : arr) {
			System.out.print(val);
			System.out.print(" ");
		}
		System.out.println();
	}

}
