package L07;

import java.util.ArrayList;

import javax.lang.model.type.IntersectionType;

public class interchange {

	public static void main(String[] args) {
		int[] one = { 10, 10, 20, 20, 30, 35, 35, 40, 40, 50 };
		int[] two = { 10, 10, 10, 10, 20, 35, 35, 35, 35, 50, 50 };
		ArrayList<Integer> ans1 = intersection(one, two);
		System.out.println(ans1);

	}

	public static ArrayList<Integer> intersection(int[] one, int[] two) {
		ArrayList<Integer> ans = new ArrayList<>();
		int i = 0;
		int j = 0;
		while (i < one.length && j < two.length) {
			if (one[i] < two[j]) {
				i++;

			} else if (one[i] > two[j]) {
				j++;
			} else {
				ans.add(one[i]);
				i++;
				j++;
			}
		}
		return ans;
	}

	public static ArrayList<Integer> sum(int[] one, int[] two) {
		ArrayList<Integer> ans = new ArrayList<>();
		int len1 = one.length;
		int len2 = two.length;
		if (len1 > len2) {
			int rem = 0;
			int p = 0;
			for (int i = 0; i < len1; i++) {
				if ((len2 - 1 - i) < 0) {
					p = 0;
				} else {
					p = two[len2 - 1 - i];
				}
				int piggy = one[len1 - 1 - i] + p + rem;
				System.out.println(piggy);
				if (piggy >= 10) {
					int carry = piggy % 10;
					ans.add(0, carry);
					piggy = piggy / 10;
					rem = piggy;
					System.out.println(rem);
				} else {
					ans.add(0, piggy);
				}

			}

		}
		return ans;

	}

}
