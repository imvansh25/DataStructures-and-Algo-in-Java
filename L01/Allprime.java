package L01;
import java.util.Scanner;

public class Allprime {
	public static void main(String args[]) {
		int count = 2;
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		while (count <= N) {
			int div = 2;
			int p = 0;
			while (div <= count) {
				if (count % div == 0) {
					p++;
				}
				div++;
			}
			if (p == 1) {
				System.out.println(count);
			}
			count++;
		}
	}
}
