package L12;

public class QueenCombination {

	public static void main(String[] args) {
		queens(new boolean[4], 2, 0, "", -1);

	}

	public static void queens(boolean[] board, int nq, int noqp, String ans, int pos) {
		if (nq == noqp) {
			System.out.println(ans);
			return;
		}
		for (int i = pos + 1; i < board.length; i++) {

			board[i] = true;
			queens(board, nq, noqp + 1, ans + "  " + "q" + (noqp + 1) + "p" + i, i);
			board[i] = false;

		}
	}

}
