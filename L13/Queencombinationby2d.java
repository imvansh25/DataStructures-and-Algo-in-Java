package L13;

public class Queencombinationby2d {

	public static void main(String[] args) {
		QueenCombinationbyBox2d(new boolean[2][4], 0, 0, "", 0, 2);

	}

	public static void QueenCombinationbyBox2d(boolean[][] arr, int row, int col, String ans, int noqp, int tq) {

		if (noqp == tq) {
			System.out.println(ans);
			return;
		}

		if (col == arr[0].length) {
			row++;
			col = 0;
		}
		if (row == arr.length) {
			return;
		}
		arr[row][col] = true;
		QueenCombinationbyBox2d(arr, row, col + 1, ans + "b[" + row + "-" + col + "]", noqp + 1, tq);
		arr[row][col] = false;
		QueenCombinationbyBox2d(arr, row, col + 1, ans, noqp, tq);
	}

}
