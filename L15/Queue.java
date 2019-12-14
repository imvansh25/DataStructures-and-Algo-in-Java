package L15;

public class Queue {
	protected int[] data;
	protected int front;
	protected int size;

	public Queue() {
		this.data = new int[5];
		this.front = 0;
		this.size = 0;

	}

	public Queue(int n) {
		this.data = new int[n];
		this.front = 0;
		this.size = 0;

	}

	public void enqueue(int item) throws Exception {
		if (isFull()) {
			throw new Exception("Queue Full");
		}
		int idx = (this.front + this.size) % this.data.length;
		this.data[idx] = item;
		this.size++;
	}

	public int dequeue() throws Exception {
		if (isEmpty()) {
			throw new Exception("Queue Empty");
		}
		int n = this.data[front];
		this.front = (front + 1) % this.data.length;
		this.size--;
		return n;
	}

	public int getFront() throws Exception {
		if (isEmpty()) {
			throw new Exception("Queue Empty");
		}
		int n = this.data[(this.front % this.data.length)];
		return n;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public boolean isFull() {
		return this.size == this.data.length;
	}

	public void display() {
		for (int i = 0; i < this.size; i++) {
			int idx = (i + this.front) % this.data.length;
			System.out.println(this.data[idx]);
		}
	}

}


