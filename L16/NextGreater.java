package L16;

import L15.Stack;

public class NextGreater {

	public static void main(String[] args) throws Exception {
		int[] arr = { 10, 20, 5, 3, 15, 30, 25, 60, 70, 2 };
		int[] ans = Greater(arr);
		for(int  i = 0 ;i<arr.length ; i++) {
			System.out.println(arr[i]+" ->"+ans[i]);
		}
		System.out.println();

	}

	public static int[] Greater(int[] arr) throws Exception {
		int[] ans = new int[arr.length];
		DYanamic_stack dy = new DYanamic_stack();
		for (int i = 0; i < arr.length; i++) {
			while (dy.isEmpty() == false && arr[i] > arr[dy.peek()]) {
				ans[dy.pop()] = arr[i];

			}
			dy.push(i);
		}
		while (dy.isEmpty() == false) {
			ans[dy.pop()] = -1;

		}
		return ans;
	}
}