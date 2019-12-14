package L10;

import java.util.ArrayList;

public class GetssAscii {

	public static void main(String[] args) {
		String str = "abc";
		System.out.println(getAscii(str));

	}

	public static ArrayList<String> getAscii(String str) {
		if (str.length() == 0) {
			ArrayList<String> st = new ArrayList<String>();
			st.add("");
			return st;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> small = getAscii(ros);
		ArrayList<String> ans = new ArrayList<String>();
		for (String val : small) {
			ans.add(val);
			ans.add(ch + val);
			ans.add((int) ch + val);
		}
		return ans;

	}

}
