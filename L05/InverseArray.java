package L05;

import java.util.Scanner;

public class InverseArray {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = takeinput();
		int [] arr1 = new int[arr.length];
		int count=0;
		while(count<arr.length) {
			int temp = arr[count];
			arr1[temp] = count;
			count++;
		}
		display(arr1);

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
