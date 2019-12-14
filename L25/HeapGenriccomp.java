package L25;

import java.util.ArrayList;
import java.util.Comparator;

public class HeapGenriccomp<T> {
	private ArrayList<T> data = new ArrayList<>();
	private Comparator<T> comp;
	public HeapGenriccomp(Comparator<T> com) {
		comp=com;
	}

	public int size() {
		return data.size();
	}

	public boolean isEmpty() {
		return data.size() == 0;
	}

	public void display() {
		System.out.println(data);
	}

	public void add(T item) {
		data.add(item);
		upheapify(data.size() - 1);
	}

	private void upheapify(int child) {
		int parent = (child - 1) / 2;
		if (isLarger(data.get(parent), data.get(child)) < 0) {
			swap(parent, child);
			upheapify(parent);
		}

	}

	private void swap(int one, int two) {
		T done = data.get(one);
		T dtwo = data.get(two);
		data.set(one, dtwo);
		data.set(two, done);
	}

	public T remove() {
		swap(0, data.size() - 1);
		T temp = data.remove(data.size() - 1);
		downheapify(0);
		return temp;
	}

	private void downheapify(int parent) {
		int lc = 2 * parent + 1;
		int rc = 2 * parent + 2;
		int min = parent;
		if (lc < data.size() && isLarger(data.get(lc), data.get(min)) > 0) {
			min = lc;
		}
		if (rc < data.size() && isLarger(data.get(rc), data.get(min)) > 0) {
			min = rc;
		}
		if (min != parent) {
			swap(min, parent);
			downheapify(min);
		}

	}

	private int isLarger(T t, T o) {
		return comp.compare(t, o);
	}

}
