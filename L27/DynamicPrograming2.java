package L27;

import java.util.ArrayList;
import java.util.Scanner;

public class DynamicPrograming2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
//
////		System.out.println(MCM(arr, 0, arr.length - 1, new int[arr.length][arr.length]));
//		System.out.println(MCMBU(arr));
//		System.out.println(sellWine(arr, 0, arr.length - 1, new int[arr.length][arr.length]));
//		System.out.println(sellWineBU(arr));
//		int[] price = { 1, 4, 5, 7 };
//		int[] wt = { 1, 3, 4, 5 };
//		System.out.println(Knapscak(wt, price, 7, 0, new int[wt.length][7 + 1]));
//		System.out.println(KnapscakBU(wt, price, 7));
//		int[] arr = { 40, 60, 20 };
		int[][] strg = new int[arr.length][arr.length];
		System.out.println(HarryPotter(arr, 0, arr.length - 1, strg));
//		System.out.println(HarryPotterBU(arr));
//		String src = "baaabab";
//		String pat = "*******ba*****ab";
//		System.out.println(WildcardPAtern(src, pat, new int[src.length() + 1][pat.length() + 1]));
//		System.out.println(WildcardEntryBU(src, pat));
		int[] price = { 0, 1, 5, 8, 9, 10, 17, 17, 20 };
		System.out.println(MaxprofitRod(price, price.length - 1, new int[price.length]));
		System.out.println(MaxprofitRodBU(price, price.length - 1));
	}

	public static int MCM(int[] arr, int si, int ei, int[][] strg) {
		if (si - ei == -1) {
			return 0;

		}
		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}
		int min = Integer.MAX_VALUE;
		for (int k = si + 1; k < ei; k++) {
			int fp = MCM(arr, si, k, strg);
			int sp = MCM(arr, k, ei, strg);
			int ma = arr[si] * arr[k] * arr[ei];
			int total = fp + sp + ma;
			if (total < min) {
				min = total;
			}
		}
		strg[si][ei] = min;
		return min;
	}

	public static int MCMBU(int[] arr) {
		int[][] strg = new int[arr.length][arr.length];
		for (int slide = 1; slide <= arr.length - 2; slide++) {
			for (int si = 0; si <= arr.length - slide - 2; si++) {
				int ei = si + slide + 1;
				int min = Integer.MAX_VALUE;
				for (int k = si + 1; k < ei; k++) {
					int fp = strg[si][k];
					int sp = strg[k][ei];
					int ma = arr[si] * arr[k] * arr[ei];
					int total = fp + sp + ma;
					if (total < min) {
						min = total;
					}
				}
				strg[si][ei] = min;
			}

		}
		return strg[0][arr.length - 1];
	}

	public static int sellWine(int[] arr, int left, int right, int[][] str) {
		int yr = arr.length - (right - left);
		if (left == right) {
			return arr[left] * yr;
		}
		if (str[left][right] != 0) {
			return str[left][right];
		}
		int ls = sellWine(arr, left + 1, right, str) + arr[left] * yr;
		int rs = sellWine(arr, left, right - 1, str) + arr[right] * yr;
		str[left][right] = Math.max(ls, rs);
		return Math.max(ls, rs);

	}

	public static int sellWineBU(int[] arr) {
		int[][] strg = new int[arr.length][arr.length];
		for (int slide = 0; slide < arr.length; slide++) {
			for (int left = 0; left <= arr.length - slide - 1; left++) {
				int right = left + slide;
				int yr = arr.length - (right - left);
				if (left == right) {
					strg[left][right] = arr[left] * yr;
					continue;
				}

				int rs = strg[left][right - 1] + arr[right] * yr;
				int ls = strg[left + 1][right] + arr[left] * yr;
				strg[left][right] = Math.max(rs, ls);
			}

		}
		return strg[0][arr.length - 1];
	}

	public static int Knapscak(int[] wt, int[] price, int cap, int vidx, int[][] strg) {
		if (vidx == wt.length) {
			return 0;
		}
		if (strg[vidx][cap] != 0) {
			return strg[vidx][cap];
		}
		int include = 0;
		if (cap >= wt[vidx]) {
			include = Knapscak(wt, price, cap - wt[vidx], vidx + 1, strg) + price[vidx];
		}
		int leave = Knapscak(wt, price, cap, vidx + 1, strg);
		int sum = Math.max(include, leave);
		strg[vidx][cap] = sum;
		return sum;
	}

	public static int KnapscakBU(int[] wt, int[] price, int cap) {
		int r = wt.length;
		int c = cap;
		int[][] arr = new int[r + 1][c + 1];
		for (int i = 1; i <= r; i++) {
			for (int j = 1; j <= c; j++) {
				int include = 0;
				if (j >= wt[i - 1]) {
					include = price[i - 1] + arr[i - 1][j - wt[i - 1]];
				}

				int exclude = arr[i - 1][j];
				arr[i][j] = Math.max(exclude, include);
			}
		}
		return arr[r][c];
	}

	public static int HarryPotter(int[] mix, int si, int ei, int[][] strg) {
		if (si == ei) {
			return 0;
		}
		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}
//		if (si + 1 == ei) {
//			return mix[si] * mix[ei];
//		}

		int min = Integer.MAX_VALUE;
		for (int i = si; i < ei; i++) {
			int fp = HarryPotter(mix, si, i, strg);
			int sp = HarryPotter(mix, i + 1, ei, strg);
			int colors = color(mix, i + 1, ei);
			int colorf = color(mix, si, i);
			int total = fp + sp + colors * colorf;
			if (min > total) {
				min = total;
			}
		}
		strg[si][ei] = min;
		return min;
	}

	public static int color(int[] mix, int si, int ei) {
		int color = 0;
		for (int i = si; i <= ei; i++) {
			color += mix[i];
		}
		return color % 100;
	}

	public static int HarryPotterBU(int[] mix) {
		int[][] strg = new int[mix.length][mix.length];
		for (int slide = 1; slide <= mix.length - 1; slide++) {
			for (int si = 0; si <= mix.length - slide - 1; si++) {
				int ei = si + slide;
				int min = Integer.MAX_VALUE;
				for (int i = si; i < ei; i++) {
					int fp = strg[si][i];
					int sp = strg[i + 1][ei];
					int colors = color(mix, i + 1, ei);
					int colorf = color(mix, si, i);
					int total = fp + sp + colors * colorf;
					if (min > total) {
						min = total;
					}
				}
				strg[si][ei] = min;
			}

		}
		return strg[0][mix.length - 1];
	}

	public static boolean WildcardPAtern(String src, String pat, int[][] strg) {
		if (src.length() == 0 && pat.length() == 0) {
			return true;
		}
		if (src.length() == 0 && pat.length() != 0) {
			for (int i = 0; i < pat.length(); i++) {
				if (pat.charAt(i) != '*') {
					return false;
				}
			}
			return true;
		}
		if (src.length() != 0 && pat.length() == 0) {
			return false;
		}
		if (strg[src.length()][pat.length()] != 0) {
			if (strg[src.length()][pat.length()] == 1) {
				return true;
			}

			return false;
		}
		boolean bn;
		if (pat.charAt(0) == '?' || pat.charAt(0) == src.charAt(0)) {
			bn = WildcardPAtern(src.substring(1), pat.substring(1), strg);
		} else if (pat.charAt(0) == '*') {
			bn = WildcardPAtern(src, pat.substring(1), strg) || WildcardPAtern(src.substring(1), pat, strg);
		} else {
			bn = false;
		}
		if (bn) {
			strg[src.length()][pat.length()] = 1;
		} else {
			strg[src.length()][pat.length()] = 2;
		}
		return bn;

	}

	public static boolean WildcardEntryBU(String src, String pat) {
		boolean[][] strg = new boolean[src.length() + 1][pat.length() + 1];
		for (int i = src.length(); i >= 0; i--) {
			for (int j = pat.length(); j >= 0; j--) {
				if (i == strg.length - 1 && j == strg[0].length - 1) {
					strg[i][j] = true;

				} else if (j == strg[0].length - 1) {
					strg[i][j] = false;
				} else if (i == strg.length - 1) {
					if (pat.charAt(j) == '*') {
						strg[i][j] = strg[i][j + 1];
					} else {
						strg[i][j] = false;
					}
				} else {
					boolean bn;
					if (pat.charAt(j) == '?' || pat.charAt(j) == src.charAt(i)) {
						bn = strg[i + 1][j + 1];
					} else if (pat.charAt(j) == '*') {
						bn = strg[i][j + 1] || strg[i + 1][j];
					} else {
						bn = false;
					}

					strg[i][j] = bn;

				}

			}
		}
		return strg[0][0];
	}

	public static int MaxprofitRod(int[] price, int n, int[] strg) {

		int max = price[n];
		int left = 1;
		int right = n - 1;
		if (strg[n] != 0) {
			return strg[n];
		}
		while (right >= left) {
			int fh = MaxprofitRod(price, left, strg);
			int sf = MaxprofitRod(price, right, strg);
			int temp = fh + sf;
			if (max < temp) {
				max = temp;
			}
			left++;
			right--;
		}
		strg[n] = max;
		return max;
	}

	public static int MaxprofitRodBU(int[] price, int n) {
		int[] strg = new int[n + 1];
		for (int i = 1; i < strg.length; i++) {
			int max = price[i];
			int left = 1;
			int right = i - 1;
			while (right >= left) {
				int fh = strg[left];
				int sf = strg[right];
				int temp = fh + sf;
				if (max < temp) {
					max = temp;
				}
				left++;
				right--;
			}
			strg[i] = max;
		}
		return strg[n];

	}
}