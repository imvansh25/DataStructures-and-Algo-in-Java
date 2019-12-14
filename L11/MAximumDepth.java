package L11;
import java.util.Scanner;

public class MAximumDepth {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int ts = in.nextInt();
		while (ts > 0) {
			String str = in.next();
			int curr_max = 0;
			int max = 0;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(') {
					curr_max++;
					if (curr_max > max) {
						max = curr_max;
					}
				} else if (str.charAt(i) == ')') {
					curr_max--;
				}
			}
			if (curr_max != 0) {
				max = -1;
			}
			System.out.println(max);
			ts--;
		}
	}

}
