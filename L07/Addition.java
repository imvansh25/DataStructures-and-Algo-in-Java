package L07;

import java.util.ArrayList;

public class Addition {
	public static void main(String[] args) {
		int[] a = { 9, 9, 7, 9 };
		int[] b = { 8, 8 };
		ArrayList<Integer> ans = sum(a, b);
		System.out.println(ans);
	}

	public static ArrayList<Integer> sum(int[] one, int[] two) {
		ArrayList<Integer> ans = new ArrayList<>();
		int i = one.length - 1;
		int j = two.length - 1;
		int rem = 0;
		while (i >= 0 || j >= 0) {
			int sum = rem;
			if (i >= 0) {
				sum += one[i];
			}
			if (j >= 0) {
				sum += two[j];
			}

			int temp = sum % 10;
			ans.add(0, temp);
			rem = sum / 10;

			i--;
			j--;
		}
		if (rem != 0) {
			ans.add(0, rem);
		}
		return ans;

	}
}
