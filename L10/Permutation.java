package L10;

import java.util.ArrayList;

public class Permutation {

	public static void main(String[] args) {
		String st = "abc";
		System.out.println(perm(st));

	}

	public static ArrayList<String> perm(String str) {
		if (str.length() == 0) {
			ArrayList<String> list = new ArrayList<String>();
			list.add("");
			return list;
		}
		char ch = str.charAt(0);
		String rem = str.substring(1);
		ArrayList<String> arr = perm(rem);
		ArrayList<String> ans = new ArrayList<String>();
		for (String val : arr) {

			for (int i = 0; i <= val.length(); i++) {
				String add = val.substring(0, i) + ch + val.substring(i);
				ans.add(add);
			}
		}
		return ans;
	}

}
