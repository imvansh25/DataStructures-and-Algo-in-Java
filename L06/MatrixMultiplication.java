package L06;

import java.util.Scanner;

public class MatrixMultiplication {
	static Scanner sn = new Scanner(System.in);

	public static void main(String[] args) {
		int[][] mat1 = { { 1, 2, 3 }, { 4, 5, 6 } };
		int[][] mat2 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		int[][] mat = mult(mat1, mat2);
		display(mat);
	}

	public static int[][] mult(int[][] mat1, int[][] mat2) {
		int r1 = mat1.length;
		int c1 = mat1[0].length;
		int r2 = mat2.length;
		int c2 = mat2[0].length;
		if (c1 != r2) {
			return null;
		}
		int[][] mat = new int[r1][c2];
		for (int r = 0; r < r1; r++) {
			for (int c = 0; c < c2; c++) {
				int temp = 0;
				for (int count = 0; count < mat1[0].length; count++) {
					temp += (mat1[r][count] * mat2[count][c]);
				}
				mat[r][c] = temp;

			}

		}
		return mat;

	}

	private static void display(int[][] arr) {
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[r].length; c++) {
				System.out.print(" " + arr[r][c] + " ");
			}
			System.out.println();

		}

	}

}
