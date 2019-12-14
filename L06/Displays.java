package L06;

public class Displays {

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 },
				{ 19, 20, 21, 22, 23, 24 }, { 25, 26, 27, 28, 29, 30 } };
//		vertial(arr);
//		wavedisplay(arr);
		springdisplay(arr);

	}

	private static void springdisplay(int[][] arr) {
		int min_row = 0;
		int max_row = arr.length - 1;
		int min_col = 0;
		int max_col = arr[0].length - 1;
		int count = 0;
		int num = arr.length * arr[0].length;
		while (count < num) {
			for (int r = min_row; r <= max_row && count < num; r++) {
				System.out.print(arr[r][min_col]+" ");
				count++;
			}
			min_col++;
			for (int c = min_col; c <= max_col && count < num; c++) {
				System.out.print(arr[max_row][c]+" ");
				count++;
			}
			max_row--;
			for (int r = max_row; r >= min_row && count < num; r--) {
				System.out.print(arr[r][max_col]+" ");
				count++;
			}
			max_col--;
			for (int c = max_col; c >= min_col && count < num; c--) {
				System.out.print(arr[min_row][c]+" ");
				count++;
			}
			min_row++;

		}

	}

	private static void wavedisplay(int[][] arr) {
		for (int c = 0; c < arr[0].length; c++) {
			for (int r = 0; r < arr.length; r++) {
				if (r % 2 == 0) {
					System.out.print(" " + arr[r][c] + " ");
				} else {
					System.out.print(" " + arr[arr.length - r - 1][c] + " ");
				}

			}
		}

	}

	private static void vertial(int[][] arr) {
		for (int c = 0; c < arr[0].length; c++) {
			for (int r = 0; r < arr.length; r++) {
				System.out.print(" " + arr[r][c] + " ");
			}
		}
	}

}
