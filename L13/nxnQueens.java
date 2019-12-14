package L13;

import java.util.Scanner;

public class nxnQueens {
	static int count = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		QueenCombination(new boolean[n][n], 0, 0, "", 0, n);
		System.out.println();
		System.out.println(count);

	}

	public static void QueenCombination(boolean[][] arr, int row, int col, String ans, int noqp, int tq) {

		if (noqp == tq) {
			count++;
			System.out.print(ans + " ");
			return;
		}

		if (col == arr[0].length) {
			row++;
			col = 0;
		}
		if (row == arr.length) {
			return;
		}
		if (isItsafe(arr, row, col)) {
			arr[row][col] = true;
			QueenCombination(arr, row, col + 1, ans + "{" + (row + 1) + "-" + (col + 1) + "} ", noqp + 1, tq);
			arr[row][col] = false;
		}
		QueenCombination(arr, row, col + 1, ans, noqp, tq);
	}

	public static boolean isItsafe(boolean[][] arr, int row, int col) {
		int r = row - 1;
		while (r >= 0) {
			if (arr[r][col] == true) {
				return false;
			}
			r--;
		}
		int c = col - 1;
		while (c >= 0) {
			if (arr[row][c] == true) {
				return false;
			}
			c--;
		}
		r = row - 1;
		c = col - 1;
		while (r >= 0 && c >= 0) {
			if (arr[r][c] == true) {
				return false;
			}
			c--;
			r--;
		}
		r = row - 1;
		c = col + 1;
		while (r >= 0 && c < arr[0].length) {
			if (arr[r][c] == true) {
				return false;
			}
			c++;
			r--;
		}
		return true;

	}
}
