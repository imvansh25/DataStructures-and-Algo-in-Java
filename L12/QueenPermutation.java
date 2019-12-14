package L12;

public class QueenPermutation {

	public static void main(String[] args) {
		Queens(new boolean[4], 2, 0, "");

	}

	public static void Queens(boolean[] board, int nq, int noqp, String ans) {
		if (noqp == nq) {
			System.out.println(ans);
			return;

		}
		for (int i = 0; i < board.length; i++) {
			if (board[i] == false) {
				board[i] = true;
				Queens(board, nq, noqp + 1, ans + 'q' + (noqp + 1) + 'b' + i);
				board[i] = false;
			}
		}
	}

}
