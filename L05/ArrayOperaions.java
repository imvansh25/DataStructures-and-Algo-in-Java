package L05;

import java.util.Scanner;

public class ArrayOperaions {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = takeinput();
		display(arr);
		int maxno = max(arr);
		System.out.println("Max no " + maxno);
		System.out.println("Enter number to be searched(Linear Search) ?");
		int n = in.nextInt();
		int index = search(arr, n);
		System.out.println(index);
		System.out.println("Enter number to be searched(Binary Search) ?");
		int n1 = in.nextInt();
		int index1 = BinarySearch(arr, n1);
		System.out.println(index1);

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

	public static int max(int[] arr) {
		int piggy = 0;
		for (int val : arr) {
			if (val > piggy) {
				piggy = val;
			}
		}
		return piggy;
	}

	public static int search(int[] arr, int n) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == n) {
				return i;
			}
		}
		return -1;
	}

	public static int BinarySearch(int[] arr, int n) {
		int l = 0;
		int h = arr.length-1;
		while (l <= h) {
			int mid = (l + h) / 2;
			if (arr[mid] == n) {
				return mid;
			}
			if (n < arr[mid]) {
				h = mid - 1;
			}
			if (n > arr[mid]) {
				l = mid + 1;
			}
		}
		return -1;
	}

}
