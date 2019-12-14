package L24;


public class GenericLinklist<T> {
	private class Node {
		T data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	public T getFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("Empty List");
		}
		return this.head.data;
	}

	public T getLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("Empty List");
		}
		return this.tail.data;
	}

	public T getAt(int n) throws Exception {
		if (this.size == 0) {
			throw new Exception("Empty List");
		}
		if (n < 0 || n >= this.size) {
			throw new Exception("Invalid Index");
		}
		Node temp = head;
		for (int i = 0; i < n; i++) {
			temp = temp.next;
		}
		return temp.data;

	}


	public void display() {
		Node temp = head;
		System.out.println("*****************************");
		for (int i = 0; i < this.size; i++) {
			System.out.println(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
		System.out.println("*****************************");

	}

	public void addLast(T item) {
		// create node
		Node nn = new Node();
		nn.data = item;
		// link node
		if (this.size > 0) {
			this.tail.next = nn;
		}
		// update data member
		if (this.size == 0) {
			this.head = nn;
		}
		this.tail = nn;
		this.size++;

	}

	public void addFirst(T item) {
		// create node
		Node nn = new Node();
		nn.data = item;
		// link node

		if (this.size > 0)
			nn.next = this.head;

		// update data member
		if (this.size == 0) {
			this.tail = nn;
		}

		this.head = nn;

		this.size++;

	}


	public T removeFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("Empty LL");
		}
		T temp = this.head.data;
		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size = 0;

		} else {
			this.head = this.head.next;
			this.size--;

		}
		return temp;
	}

	public T removeLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("Empty LL");
		}
		T temp = this.tail.data;
		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size = 0;

		} else {
//			Node nm2 = this.getNodeAt(this.size - 2);
//			this.tail = nm2;
			this.tail.next = null;
			this.size--;
		}
		return temp;
	}

	


}
