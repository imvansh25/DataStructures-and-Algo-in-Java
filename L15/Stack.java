package L15;

public class Stack {

	protected int[] data;
	protected int tos;

	public Stack() {
		this.data = new int[5];
		this.tos = -1;
	}

	public Stack(int n) {
		this.data = new int[n];
		this.tos = -1;
	}

	public void push(int n) throws Exception {
		if (isFull()) {
			throw new Exception("Stack  is Full");
		}
		tos++;
		this.data[this.tos] = n;
//		System.out.println(tos);
	}

	public int pop() throws Exception {
		if (isEmpty()) {
			throw new Exception("Empty Stack");
		}
		int n = this.data[this.tos];
		this.data[this.tos] = 0;
		this.tos--;
		return n;
	}

	public int peek() throws Exception {
		if (isEmpty()) {
			throw new Exception("Empty Stack");
		}
		int n = this.data[this.tos];
		return n;
	}

	public int size() {
		return (this.tos + 1);
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public boolean isFull() {
		return this.size() == this.data.length;

	}

	public void display() {
		for (int i = this.tos; i >= 0; i--) {
			System.out.println(this.data[i]);
		}
	}

}
