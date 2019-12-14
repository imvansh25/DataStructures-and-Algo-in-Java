package L10;

import java.util.Scanner;

public class BoardPath {
	static int count = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		getBoardPAth(0, n, m, "");
		System.out.println();
		System.out.println(count);

	}

	public static void getBoardPAth(int curr, int end, int m, String ans) {
		if (curr == end) {
			count++;
			System.out.print(ans + " ");
			return;
		}
		if (curr > end) {
			return;
		}

		for (int i = 1; i <= m && curr + i <= end; i++) {

			getBoardPAth(curr + i, end, 3, ans + i);

		}

	}

}
