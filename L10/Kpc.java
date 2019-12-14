package L10;

import java.util.ArrayList;
import java.util.Scanner;

public class Kpc {
	

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.next();
		ArrayList<String> arr = kpc(str);
		
		for(int i =0 ; i<arr.size() ; i++) {
			System.out.print(arr.get(i) +" ");
		}
		System.out.println();
		System.out.println(arr.size());
		

	}

	public static ArrayList<String> kpc(String str) {
		if (str.length() == 0) {
			ArrayList<String> arr = new ArrayList<String>();
			arr.add("");
			return arr;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> small = kpc(ros);
		ArrayList<String> ans = new ArrayList<String>();
		String get = getCode(ch);
		for (int i = 0; i < get.length(); i++) {
			for (String val : small) {
				ans.add(get.charAt(i) + val);
				
			}
		}
		return ans;

	}

	public static String getCode(char ch) {

		if (ch == '1')
			return "abc";
		else if (ch == '2')
			return "def";
		else if (ch == '3')
			return "ghi";
		else if (ch == '4')
			return "jk";
		else if (ch == '5')
			return "lmno";
		else if (ch == '6')
			return "pqr";
		else if (ch == '7')
			return "stu";
		else if (ch == '8')
			return "vwx";
		else if (ch == '9')
			return "yz";
		else if (ch == '0')
			return "@#";
		else
			return "";
	}

}
