package L13;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = { 20, 40, 10, 50, 45, 6, 80 };
		int[] ans = mergesort(arr, 0, arr.length-1);
		for (int val : ans) {
			System.out.println(val + " ");

		}
		System.out.println();

	}

	public static int[] mergeTwoSortedArray(int[] one, int[] two) {
		int[] ans = new int[one.length + two.length];
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < one.length && j < two.length) {
			if (one[i] < two[j]) {
				ans[k] = one[i];
				i++;
				k++;
			} else {
				ans[k] = two[j];
				k++;
				j++;

			}
		}
		if (j == two.length) {
			while (i < one.length) {
				ans[k] = one[i];
				i++;
				k++;
			}
		}
		if (i== one.length) {
			while (j < two.length) {
				ans[k] = two[j];
				j++;
				k++;
			}
		}
		return ans;

	}

	public static int[] mergesort(int[] arr, int lo, int hi) {
		if (lo == hi) {
			int[] br = new int[1];
			br[0] = arr[lo];
			return br;
		}
		int mid = (hi + lo) / 2;
		int[] fp = mergesort(arr, lo, mid);
		int[] sp = mergesort(arr, mid + 1, hi);
		int[] ans = mergeTwoSortedArray(fp, sp);
		return ans;

	}
}
