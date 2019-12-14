package L17and18;

public class LinkList {
	private class Node {
		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	public int getFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("Empty List");
		}
		return this.head.data;
	}

	public int getLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("Empty List");
		}
		return this.tail.data;
	}

	public int getAt(int n) throws Exception {
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

	public Node getNodeAt(int n) throws Exception {
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
		return temp;

	}

	public void display() {
		Node temp = head;
		System.out.println("*****************************");
		for (int i = 0; i < this.size; i++) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
		System.out.println("*****************************");

	}

	public void addLast(int item) {
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

	public void addFirst(int item) {
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

	public void addAt(int n, int item) throws Exception {
		if (n == 0) {
			addFirst(item);
		} else if (n == this.size) {
			addLast(item);
		} else {
			Node nn = new Node();
			nn.data = item;
			Node np = getNodeAt(n - 1);
			Node nn2 = np.next;
			np.next = nn;
			nn.next = nn2;
			this.size++;

		}

	}

	public int removeFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("Empty LL");
		}
		int temp = this.head.data;
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

	public int removeLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("Empty LL");
		}
		int temp = this.tail.data;
		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size = 0;

		} else {
			Node nm2 = this.getNodeAt(this.size - 2);
			this.tail = nm2;
			this.tail.next = null;
			this.size--;
		}
		return temp;
	}

	public int removeAt(int n) throws Exception {
		if (n == 0) {
			return removeFirst();
		} else if (n == this.size - 1) {
			return removeLast();
		} else {
			Node nm = this.getNodeAt(n - 1);
			Node nt = nm.next;
			nm.next = nt.next;
			this.size--;
			return nt.data;
		}
	}

	public void ReversedataIteratively() throws Exception {
		int l = 0;
		int h = this.size - 1;
		while (l <= h) {
			Node nl = getNodeAt(l);
			Node nh = getNodeAt(h);
			int temp = nl.data;
			nl.data = nh.data;
			nh.data = temp;
			l++;
			h--;
		}
	}

	public void ReversePointerIteratively() throws Exception {
		Node prev = this.head;
		Node curr = this.head.next;
		while (curr != null) {
			Node temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}

		this.tail = this.head;
		this.head = prev;
		this.tail.next = null;

	}

	private void RPointerRecursively(Node prev, Node curr) {
		if (curr == null) {
			return;
		}
		RPointerRecursively(curr, curr.next);
		curr.next = prev;

	}

	public void RPointerRecursively() {
		RPointerRecursively(this.head, this.head.next);
		Node prev = this.tail;
		this.tail = this.head;
		this.head = prev;
		this.tail.next = null;
	}

	private class HeapMover {
		Node left;
		int count = 0;
	}

	public void RDatarecursively() {
//		RDatarecursively(this.head, this.head, 0);
		HeapMover mover = new HeapMover();
		mover.left = this.head;
		RDatarecursively(mover, this.head, 0);
	}

	private Node RDatarecursively(Node left, Node right, int count) {
		if (right == null) {
			return left;
		}
		left = RDatarecursively(left, right.next, count + 1);
		if (count >= (this.size / 2)) {
			int temp = left.data;
			left.data = right.data;
			right.data = temp;
		}
		return left.next;

	}

	private void RDatarecursively(HeapMover mover, Node right, int count) {
		if (right == null) {
			return;
		}
		RDatarecursively(mover, right.next, count + 1);
		if (count >= (this.size / 2)) {
			int temp = mover.left.data;
			mover.left.data = right.data;
			right.data = temp;
		}
		mover.left = mover.left.next;

	}

	public void mid() {
		HeapMover mover = new HeapMover();
		mover.left = this.head;
		Node ans = mid(mover, this.head);
		System.out.println(ans.data);
	}

	private Node mid(HeapMover mover, Node right) {
		if (right == null) {
			return null;
		}
		Node ans = mid(mover, right.next);
		if (mover.left == right || mover.left.next == right) {
			ans = mover.left;
		}
		mover.left = mover.left.next;
		return ans;
	}

	public void KthFromLast(int k) {
		HeapMover mover = new HeapMover();
		mover.left = this.head;
		Node ans = KthFromLast(mover, this.head, 0, k);
		System.out.println(ans.data);
	}

	private Node KthFromLast(HeapMover mover, Node right, int count, int k) {
		if (right == null) {
			return null;
		}
		Node ans = KthFromLast(mover, right.next, count, k);
		count++;
		if (count == k) {
			ans = right;
		}
		return ans;
	}

	public void fold() {
		fold(this.head, this.head, 0);
	}

	public Node fold(Node left, Node right, int count) {
		if (right == null) {
			return left;
		}
		Node cl = fold(left, right.next, count + 1);
		if (count > (this.size / 2)) {
			Node ahead = cl.next;
			cl.next = right;
			right.next = ahead;
		}
		if (count == (this.size / 2)) {
			this.tail = right;
			tail.next = null;

		}
		return right.next;

	}

	public void Kreverse(int k) throws Exception {
		LinkList prev = null;
		while (this.size != 0) {
			LinkList curr = new LinkList();
			for (int i = 0; i < k && this.size != 0; i++) {
				curr.addFirst(this.removeFirst());
			}
			if (prev == null) {
				prev = curr;
			} else {
				prev.tail.next = curr.head;
				prev.tail = curr.tail;
				prev.size += curr.size;
			}
		}
		this.head = prev.head;
		this.tail = prev.tail;
		this.size = prev.size;

	}

}
