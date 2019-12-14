package L13;

public class BlockedMaze {
	static int count = 0;

	public static void main(String[] args) {
		int[][] arr = { { 0, 1, 0, 0 }, { 0, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0 } };

		blockedmaze(arr, 0, 0, "");
		System.out.println();
		System.out.println(count);

	}

	public static void blockedmaze(int[][] board, int cr, int cc, String ans) {
		if (cr == board.length - 1 && cc == board[0].length - 1) {
			System.out.println(ans);
			count++;
			return;
		}
		if (cr < 0 || cr >= board.length || cc < 0 || cc >= board[0].length || board[cr][cc] == 1) {
			return;
		}
		board[cr][cc] = 1;

		blockedmaze(board, cr + 1, cc, ans + "B");

		blockedmaze(board, cr, cc + 1, ans + "R");

		blockedmaze(board, cr - 1, cc, ans + "T");

		blockedmaze(board, cr, cc - 1, ans + "L");

		board[cr][cc] = 0;

	}

}
