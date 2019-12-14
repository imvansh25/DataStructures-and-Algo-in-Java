package L26;

import java.util.Arrays;
import java.util.Scanner;

public class Dyanamicprograming {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s1 = in.next();
		String s2 = in.next();
//		System.out.println(fibotd(6, new int[7]));
//		System.out.println(fibobu(6));
//		System.out.println(fibobute(6));
//		System.out.println(BoardPathTd(0, 10, new int[10]));
//		System.out.println(BoardpathBu(0, 10));
//		System.out.println(BoardpathBuse(0, 10));
//		System.out.println(minnoTd(10,new int[11]));
//		System.out.println(mazepathtd(0, 0, 2, 2, new int[3][3]));
//		System.out.println(mazepathBU(0, 0, 2, 2));
//		System.out.println(mazepathBUSE(0, 0, 2, 2));
//		String s1 = "anjcd";
//		String s2 = "acjnd";
		int[][] arr = new int[s1.length() + 1][s1.length() + 1];
		System.out.println(Lcsbu(s1, s2));
//		System.out.println(EditDistance(s1, s2));
//		System.out.println(EditDistancebu(s1, s2));
//		int[][] arr = new int[s1.length() + 1][s2.length() + 1];
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < arr[0].length; j++) {
//				arr[i][j] = -1;
//			}
//		}
//		System.out.println(EditDistanceTD(s1, s2, arr));
	}

	public static int fibotd(int n, int[] arr) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (arr[n] != 0) {
			return arr[n];
		}
		int sum = fibotd(n - 1, arr) + fibotd(n - 2, arr);
		arr[n] = sum;
		return sum;

	}

	public static int fibobu(int n) {
		int[] arr = new int[n + 1];
		arr[0] = 0;
		arr[1] = 1;
		for (int i = 2; i < arr.length; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		return arr[n];

	}

	public static int fibobute(int n) {
		int[] arr = new int[2];
		arr[0] = 0;
		arr[1] = 1;
		for (int i = 2; i <= n; i++) {
			int temp = arr[0] + arr[1];
			arr[0] = arr[1];
			arr[1] = temp;
		}
		return arr[1];

	}

	public static int BoardPathTd(int curr, int end, int[] arr) {
		if (curr == end) {
			return 1;
		}
		if (curr > end) {
			return 0;
		}
		if (arr[curr] != 0) {
			return arr[curr];
		}
		int sum = 0;
		for (int i = 1; i <= 6; i++) {
			sum += BoardPathTd(curr + i, end, arr);
		}
		arr[curr] = sum;
		return sum;

	}

	public static int BoardpathBu(int curr, int end) {
		int[] arr = new int[end + 6];
		arr[end] = 1;
		for (int i = end - 1; i >= 0; i--) {
			int sum = 0;
			for (int j = i + 1; j <= i + 6; j++) {
				sum += arr[j];
			}
			arr[i] = sum;
		}
		return arr[0];
	}

	public static int BoardpathBuse(int curr, int end) {
		int[] arr = new int[6];
		arr[0] = 1;
		while (curr < end) {
			int sum = 0;
			for (int i = 0; i < arr.length; i++) {
				sum += arr[i];
			}
			for (int i = arr.length - 1; i > 0; i--) {
				arr[i] = arr[i - 1];
			}
			arr[0] = sum;
			curr++;
		}
		return arr[0];
	}

	public static int mazepathtd(int cc, int cr, int er, int ec, int[][] arr) {
		if (cr == er && cc == ec) {
			return 1;
		}
		if (cr > er || cc > ec) {
			return 0;
		}
		if (arr[cc][cr] != 0) {
			return arr[cc][cr];
		}
		int col = mazepathtd(cc + 1, cr, er, ec, arr);
		int row = mazepathtd(cc, cr + 1, er, ec, arr);
		arr[cr][cc] = col + row;
		return col + row;
	}

	public static int mazepathBU(int cr, int cc, int er, int ec) {
		int[][] arr = new int[er + 1][ec + 1];
		for (int i = 0; i < arr.length; i++) {
			arr[i][ec] = 1;
		}
		for (int i = 0; i < arr[0].length; i++) {
			arr[er][i] = 1;
		}
		for (int i = er - 1; i >= 0; i--) {
			for (int j = ec - 1; j >= 0; j--) {
				arr[i][j] = arr[i + 1][j] + arr[i][j + 1];
			}
		}
		return arr[0][0];

	}

	public static int mazepathBUSE(int cr, int cc, int er, int ec) {
		int[] arr = new int[ec + 1];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 1;
		}
		while (cr < er) {
			for (int i = arr.length - 2; i >= 0; i--) {
				arr[i] += arr[i + 1];

			}
			cr++;
		}
		return arr[0];
	}

	public static int minnoTd(int n, int[] arr) {
		if (n == 1) {
			return 0;
		}
		if (arr[n] != 0) {
			return arr[n];
		}
		int min = Integer.MAX_VALUE;
		if (n % 2 == 0) {
			int temp = minnoTd(n / 2, arr) + 1;
			min = Math.min(min, temp);
		}
		if (n % 3 == 0) {
			int temp = minnoTd(n / 3, arr) + 1;
			min = Math.min(min, temp);
		}
		int ans = minnoTd(n - 1, arr) + 1;
		min = Math.min(min, ans);
		arr[n] = min;
		return min;

	}

	public static int minnobu(int n) {
		int[] arr = new int[n + 1];
		arr[1] = 0;
		return 0;
	}

	public static int Lcs(String s1, String s2, int[][] arr) {
		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}
		if (arr[s1.length()][s2.length()] != 0) {
			return arr[s1.length()][s2.length()];
		}
		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);
		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);
		if (ch1 == ch2) {
			arr[s1.length()][s2.length()] = Lcs(ros1, ros2, arr) + 1;
		} else {
			int o1 = Lcs(s1, ros2, arr);
			int o2 = Lcs(ros1, s2, arr);
			arr[s1.length()][s2.length()] = Math.max(o1, o2);
		}
		return arr[s1.length()][s2.length()];
	}

	public static int Lcsbu(String s1, String s2) {
		int[][] arr = new int[s1.length() + 1][s2.length() + 1];
		for (int i = arr.length - 2; i >= 0; i--) {
			for (int j = arr[0].length - 2; j >= 0; j--) {
				if (s1.charAt(i) == s2.charAt(j)) {
					arr[i][j] = arr[i + 1][j + 1] + 1;
				} else {
					arr[i][j] = Math.max(arr[i + 1][j], arr[i][j+1]);
				}
			}
		}
		return arr[0][0];
	}

	public static int EditDistance(String s1, String s2) {
		if (s1.length() == 0 || s2.length() == 0) {
			return Math.max(s1.length(), s2.length());
		}
		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);
		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);
		if (ch1 == ch2) {
			return EditDistance(ros1, ros2);
		} else {
			int insert = EditDistance(ros1, s2);
			int delete = EditDistance(s1, ros2);
			int rpl = EditDistance(ros1, ros2);
			return Math.min(delete, Math.min(insert, rpl)) + 1;
		}
	}

	public static int EditDistanceTD(String s1, String s2, int[][] arr) {
		if (s1.length() == 0 || s2.length() == 0) {
			return Math.max(s1.length(), s2.length());
		}
		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);
		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);
		if (arr[s1.length()][s2.length()] != -1) {
			return arr[s1.length()][s2.length()];
		}
		int sum = 0;
		if (ch1 == ch2) {
			sum = EditDistance(ros1, ros2);
		} else {
			int insert = EditDistance(ros1, s2);
			int delete = EditDistance(s1, ros2);
			int rpl = EditDistance(ros1, ros2);
			sum = Math.min(delete, Math.min(insert, rpl)) + 1;
		}
		arr[s1.length()][s2.length()] = sum;
		return sum;
	}

	public static int EditDistancebu(String s1, String s2) {
		int[][] arr = new int[s1.length() + 1][s2.length() + 1];
		for (int i = s1.length(); i >= 0; i--) {
			for (int j = s2.length(); j >= 0; j--) {
				if (i == s1.length()) {
					arr[i][j] = s2.length() - j;
					continue;
				}
				if (j == s2.length()) {
					arr[i][j] = s1.length() - i;
					continue;

				}

				if (s1.charAt(i) == s2.charAt(j)) {
					arr[i][j] = arr[i + 1][j + 1];
				} else {
					int add = arr[i + 1][j];
					int rem = arr[i][j + 1];
					int rep = arr[i + 1][j + 1];
					arr[i][j] = Math.min(rem, Math.min(add, rep)) + 1;
				}

			}
		}
		return arr[0][0];
	}
}
