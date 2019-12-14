package L25;

import java.util.ArrayList;

public class Heap {
	private ArrayList<Integer> data = new ArrayList<>();

	public int size() {
		return data.size();
	}

	public boolean isEmpty() {
		return data.size() == 0;
	}

	public void display() {
		System.out.println(data);
	}

	public void add(int item) {
		data.add(item);
		upheapify(data.size() - 1);
	}

	private void upheapify(int child) {
		int parent = (child - 1) / 2;
		if (data.get(parent) > data.get(child)) {
			swap(parent, child);
			upheapify(parent);
		}

	}

	private void swap(int one, int two) {
		int done = data.get(one);
		int dtwo = data.get(two);
		data.set(one, dtwo);
		data.set(two, done);
	}

	public int remove() {
		swap(0, data.size() - 1);
		int temp = data.remove(data.size() - 1);
		downheapify(0);
		return temp;
	}

	private void downheapify(int parent) {
		int lc = 2 * parent + 1;
		int rc = 2 * parent + 2;
		int min = parent;
		if (lc < data.size() && data.get(lc) < data.get(min)) {
			min = lc;
		}
		if (rc < data.size() && data.get(rc) < data.get(min)) {
			min = rc;
		}
		if (min != parent) {
			swap(min, parent);
			downheapify(min);
		}

	}

}
