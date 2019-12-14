package L09;

import java.util.Scanner;

public class ArrRecursion {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] arr = takeinput();
//		System.out.println(max(arr,0));
//		System.out.println(last(arr, 8, 0));
		display(allOcuurance(arr, 8, 0, 0));

	}

	public static int max(int[] arr, int varx) {
		if (varx == arr.length - 1) {
			return arr[varx];
		}
		int max = max(arr, varx + 1);
		if (arr[varx] > max) {
			max = arr[varx];

		}
		return max;

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

	public static int first(int[] arr, int item, int varx) {
		if (varx == arr.length) {
			return -1;
		}
		if (arr[varx] == item) {
			return varx;

		}
		int x = first(arr, item, varx + 1);
		return x;

	}

	public static int last(int[] arr, int item, int varx) {
		if (varx == arr.length) {
			return -1;
		}
		int x = last(arr, item, varx + 1);
		if (x == -1) {
			if (arr[varx] == item) {
				return varx;

			}
		}

		return x;

	}

	public static int [] allOcuurance(int[] arr, int item, int varx, int count) {
		
		if(varx == arr.length) {
			int[] ans = new int[count];
			return ans ;
		}
		if(arr[varx] == item) {
			int ans [] =allOcuurance(arr, item, varx+1, count+1);
			ans[count] = varx;
			return ans;
		}
		int ans [] =allOcuurance(arr, item, varx+1, count);
		return ans;
	}
	public static void display(int[] arr) {
		for (int val : arr) {
			System.out.print(val);
			System.out.print(" ");
		}
		System.out.println();
	}

}
