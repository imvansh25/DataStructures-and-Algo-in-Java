package L11;

public class PrintValidParanthesis {

	public static void main(String[] args) {
		Parantesis(0, 0, 2, "");

	}

	public static void Parantesis(int open, int close, int n, String ans) {
		if (open == n && close == n) {
			System.out.println(ans);
			return;
		}
		if (open > n || close > n || close > open) {
			return;
		}
		Parantesis(open, close + 1, n, ans + ")");

		Parantesis(open + 1, close, n, ans + "(");

		

	}

}
