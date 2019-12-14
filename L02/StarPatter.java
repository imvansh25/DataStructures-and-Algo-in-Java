package L02;
import java.util.Scanner;

public class StarPatter {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int nst = 1;
		int nsp = N / 2;
		int row = 1;
		while (row <= N) {
			int csp = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp++;
			}
			int cst = 1;
			while (cst <= nst) {
				System.out.print(" ");
				cst++;
			}
			if (row <= (N / 2)) {
				nsp--;
				nst += 2;
			} else {

				nsp++;
				nst -= 2;
			}
			System.out.println();
			row++;
		}
	}
}
