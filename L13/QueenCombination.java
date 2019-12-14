package L13;

public class QueenCombination {

	public static void main(String[] args) {
		QueenCombinationbyBox(new boolean[4], 0, "", 0, 2);

	}

	public static void QueenCombinationbyBox(boolean[] arr, int idx, String ans, int noqp, int tq) {

		if (noqp == tq) {
			System.out.println(ans);
			return;
		}
		if (idx == arr.length) {
			return;
		}
		arr[idx] = true;
		QueenCombinationbyBox(arr, idx + 1, ans + "b" + (idx + 1), noqp + 1, tq);
		arr[idx] = false;
		QueenCombinationbyBox(arr, idx + 1, ans, noqp, tq);
	}

}
