package L05;

import java.util.Scanner;

public class ReverseString {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = takeinput();
		int count = 0;
		while (count < (arr.length )/2) {
			reverse(arr,count);
			count++;

		}
		display(arr);
	}

	public static void reverse(int[] arr,int i) {
		int temp = arr[i];
		int len =arr.length - 1;
		arr[i]=arr[len-i];
		arr[len-i]= temp;
		

	}

	public static int[] takeinput() {
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
