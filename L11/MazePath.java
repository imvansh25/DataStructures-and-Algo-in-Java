package L11;

import java.util.ArrayList;
import java.util.Scanner;

public class MazePath {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int er = in.nextInt();
		int ec = in.nextInt();
		System.out.println(maze(0, 0, er, ec));

	}

	public static ArrayList<String> maze(int cr, int cc, int er, int ec) {
		if (cr == er && cc == ec) {
			ArrayList<String> sub = new ArrayList<>();
			sub.add("");
			return sub;

		}

		ArrayList<String> ans = new ArrayList<>();
		if (cr < er) {
			ArrayList<String> sub = maze(cr + 1, cc, er, ec);
			for (String val : sub) {
				ans.add("H" + val);
			}
		}

		if (cc < er) {
			ArrayList<String> sub = maze(cr, cc + 1, er, ec);
			for (String val : sub) {
				ans.add("V" + val);
			}
		}
		return ans;
	}

	public static ArrayList<String> multiplemaze(int cr, int cc, int er, int ec) {
		if (cr == er && cc == ec) {
			ArrayList<String> sub = new ArrayList<>();
			sub.add("");
			return sub;

		}

		ArrayList<String> ans = new ArrayList<>();
		if (cr < er) {
			for (int i = 1; i <= er; i++) {
				ArrayList<String> sub = multiplemaze(cr + i, cc, er, ec);
				for (String val : sub) {
					ans.add("H"+i + val);
				}
			}
		}

		if (cc < er) {
			for (int i = 1; i <= ec; i++) {
				ArrayList<String> sub = multiplemaze(cr, cc + i, er, ec);
				for (String val : sub) {
					ans.add("V"+i + val);
				}
			}
		}
		return ans;
	}

}
