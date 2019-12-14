package L12;

public class CoinToss {

	public static void main(String[] args) {
		toss(3, "");

	}

	public static void toss(int n, String ans) {
		if (ans.length() != 0) {
			for (int i = 0; i < ans.length() - 1; i++) {
				if (ans.charAt(i) == 'h' && ans.charAt(i + 1) == 'h') {
					return;

				}
			}
		}
		if (n == 0) {
			System.out.println(ans);
			return;
		}
		

		toss(n - 1, ans + "h");
		toss(n - 1, ans + "t");

	}

}
