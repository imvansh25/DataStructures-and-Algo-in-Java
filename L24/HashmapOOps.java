package L24;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.omg.PortableInterceptor.INACTIVE;

public class HashmapOOps {

	public static void main(String[] args) {

//		Scanner in = new Scanner(System.in);
//		String str = in.next();
		int[] one = {10,20,40,10,30,10,60};
		int[] two = {60,40,10,80,10,90,40};
		int[] arr = { 2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6, 4 };
//		maxFreqChar(str);
//		ArrayList<Integer> ans =intersection(one, two);
		ArrayList<Integer> ans = longestseq(arr);
		for(int val :ans) {
			System.out.print(val+" ");
		}
	}

	public static char maxFreqChar(String str) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
		}
		char maxchar = ' ';
		int max = Integer.MIN_VALUE;
		for (char key : map.keySet()) {
			if (max < map.get(key)) {
				maxchar = key;
				max = map.get(key);
			}
		}
		return maxchar;
	}

	public static ArrayList<Integer> intersection(int[] one, int[] two) {
		ArrayList<Integer> ans = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < one.length; i++) {
			int ch = one[i];
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
		}
		for (int i = 0; i < two.length; i++) {
			if (map.containsKey(two[i])) {
				ans.add(two[i]);
				map.put(two[i], map.get(two[i]) - 1);
				if (map.get(two[i]) == 0) {
					map.remove(two[i]);
				}
			}
		}
		return ans;
	}

	public static ArrayList<Integer> longestseq(int[] arr) {
		ArrayList<Integer> ans = new ArrayList<>();
		HashMap<Integer, Boolean> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i] - 1)) {
				map.put(arr[i], false);
			} else {
				map.put(arr[i], true);
			}
			if (map.containsKey(arr[i] + 1)) {
				map.put(arr[i] + 1, false);
			}

		}
		int max = Integer.MIN_VALUE;
		int mkey = 0;
		for (int key : map.keySet()) {
			if (map.get(key)) {
				int count = 1;
				while (map.containsKey(key + count)) {
					count++;
				}
				if (count > max) {
					max = count;
					mkey = key;
				}

			}
		}
		for (int i = mkey; i < max; i++) {
			ans.add(i);
		}
		return ans;
	}

}
