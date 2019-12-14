package L16;

public class stockspan {

	public static void main(String[] args) throws Exception {
		int[] arr = { 100, 20, 30, 90, 60, 50, 70, 80, 120, 110, 50 };
		int[] ans = Stockspan(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(ans[i]+" ");
		}
		System.out.println();

	}

	public static int[] Stockspan(int[] arr) throws Exception {

		int[] ans = new int[arr.length];
		DYanamic_stack dy = new DYanamic_stack();
		for (int i = 0; i < arr.length; i++) {
			while (dy.isEmpty() == false && arr[i] > arr[dy.peek()]) {
				dy.pop();

			}
			if (dy.isEmpty()) {
				ans[i] = i + 1;
			} else {
				ans[i] = i - dy.peek();
			}
			dy.push(i);

		}
		return ans;

	}
}
