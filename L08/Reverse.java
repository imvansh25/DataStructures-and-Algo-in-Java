package L08;

import java.util.Scanner;

public class Reverse {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.next();
		char  n = str.charAt(str.length() - 1);
		String ans = "";
		int index = str.length();
		for (int i = str.length() - 1; i >= 0; i--) {
			if (str.charAt(i) == '/' || str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*'
					|| str.charAt(i) == '%') {
				ans = ans + str.substring(i + 1, index);
				ans = ans + str.substring(i, i + 1);
				index = i;
			}

		}
		ans = ans + str.substring(0, index);
		System.out.println(ans);

	}

}
