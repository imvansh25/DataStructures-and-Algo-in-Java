package L01;
import java.util.Scanner;

public class Prime {
	public static void main(String[] args) {
		System.out.println("Enter a number");
		Scanner num = new Scanner(System.in);
		int N = num.nextInt();
		if (N >= 2) {
			int count = 2;
			int piggy = 0;
			while (count < N) {
				if (N % 2 == 0) {
					piggy++;
				}
				count++;

			}
			if (piggy != 0) {
				System.out.println("Not Prime");

			}
			if (piggy == 0) {
				System.out.println("Prime");

			}
		}
	}
}