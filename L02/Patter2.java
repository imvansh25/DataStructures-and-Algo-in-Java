package L02;

public class Patter2 {

	public static void main(String[] args) {
		int n = 5;
		int nsp = n - 1;
		int nst = 1;
		int row = 1;
		while (row <= (2 * n - 1)) {
			int csp = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp++;
			}
			int cst = 1;
			while (cst <= nst) {
				System.out.print("*");
				cst++;
			}
			System.out.println();
			if (row <= n - 1) {
				nsp--;
				nst++;
			} else {
				nsp++;
				nst--;
			}
			row++;
		}

	}

}
