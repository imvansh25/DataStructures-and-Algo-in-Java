package L25;

import java.util.ArrayList;

public class HeapProblems {

	public static void main(String[] args) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		ans.add(2);
		ans.add(10);
		ans.add(3);
		ans.add(1);
		ans.add(15);
		ans.add(4);
		System.out.println(KLargestElements(ans, 3));

	}

	private static class pair implements Comparable<pair> {
		int data;
		int arr;
		int index = 0;

		@Override
		public int compareTo(pair o) {

			return o.data - this.data;
		}
	}

	public static ArrayList<Integer> mergeKsortedLists(ArrayList<ArrayList<Integer>> list) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		HeapGenric<pair> heap = new HeapGenric<HeapProblems.pair>();
		for (int i = 0; i < list.size(); i++) {
			pair pp = new pair();
			pp.data = list.get(i).get(0);
			pp.arr = i;
			heap.add(pp);
		}
		while (!heap.isEmpty()) {
			pair gp = heap.remove();
			ans.add(gp.data);
			gp.index++;
			if (gp.index < list.get(gp.arr).size()) {
				gp.data = list.get(gp.arr).get(gp.index);
				heap.add(gp);

			}

		}
		return ans;

	}

	public static ArrayList<Integer> KLargestElements(ArrayList<Integer> list, int k) {
		Heap heap = new Heap();
		int n = 0;
		while (n != k) {
			heap.add(list.get(n));
			n++;
		}
		while (n < list.size()) {
			int val = heap.remove();
			if (val < list.get(n)) {
				heap.add(list.get(n));
			} else {
				heap.add(val);
			}
			n++;
		}
		ArrayList<Integer> ans = new ArrayList<Integer>();
		while (!heap.isEmpty()) {
			ans.add(heap.remove());

		}
		return ans;

	}

}
