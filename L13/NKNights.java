package L13;

import java.util.Scanner;

public class NKNights {
	static int count = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		knights(new boolean[n][n], 0, 0, "", 0, n);
		System.out.println();
		System.out.println(count);
	}

	public static void knights(boolean[][] arr, int row, int col, String ans, int noqp, int tq) {

		if (noqp == tq) {
			count++;
			System.out.print(ans + " ");
			return;
		}

		if (col == arr[0].length) {
			row++;
			col = 0;
		}
		if (row >= arr.length) {
			return;
		}
		if (isItsafe(arr, row, col)) {
			arr[row][col] = true;
			knights(arr, row, col + 1, ans + "{" + row + "-" + col + "}", noqp + 1, tq);
			arr[row][col] = false;
		}
		knights(arr, row, col + 1, ans, noqp, tq);

	}

	public static boolean isItsafe(boolean[][] arr, int row, int col) {
		int r = row - 2;
		int c = col - 1;
		if (r >= 0 && c >= 0) {
			if (arr[r][c] == true) {
				return false;
			}
			r = r - 2;
			c = c - 1;
		}
		r = row - 2;
		c = col + 1;
		if (r >= 0 && c < arr[0].length) {
			if (arr[r][c] == true) {
				return false;
			}
			r = r - 2;
			c = c + 1;
		}
		r = row + 2;
		c = col - 1;
		if (r < arr.length && c >= 0) {
			if (arr[r][c] == true) {
				return false;
			}
			r = r + 2;
			c = c - 1;
		}
		r = row + 2;
		c = col + 1;
		if (r < arr.length && c < arr[0].length) {
			if (arr[r][c] == true) {
				return false;
			}
			r = r + 2;
			c = c + 1;

		}
		r = row - 1;
		c = col - 2;
		if (r >= 0 && c >= 0) {
			if (arr[r][c] == true) {
				return false;
			}
			r = r - 1;
			c = c - 2;
		}
		r = row - 1;
		c = col + 2;
		if (r >= 0 && c < arr[0].length) {
			if (arr[r][c] == true) {
				return false;
			}
			r = r - 1;
			c = c + 2;
		}
		r = row + 1;
		c = col - 2;
		if (r < arr.length && c >= 0) {
			if (arr[r][c] == true) {
				return false;
			}
			r = r + 1;
			c = c - 2;
		}
		r = row + 1;
		c = col + 2;
		if (r < arr.length && c < arr[0].length) {
			if (arr[r][c] == true) {
				return false;
			}
			r = r + 1;
			c = c + 2;
		}
		return true;
	}

}
