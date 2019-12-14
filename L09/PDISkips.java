package L09;

public class PDISkips {

	public static void main(String[] args) {
		PdiSkip(8);

	}

	public static void PdiSkip(int n) {
		if (n == 0) {
			return;
		}
		if (n % 2 == 0) {
			System.out.println(n);
		}
		PdiSkip(n - 1);
		if (n % 2 != 0) {
			System.out.println(n);
		}
	}

}
