package L16;

public class ClientDQ {

	public static void main(String[] args) throws Exception {
		DYnamicQueue dq = new DYnamicQueue();
		dq.enqueue(10);
		dq.enqueue(20);
		dq.enqueue(30);
		dq.enqueue(40);
//		Display_revese(dq, 0);
		Actual_revese(dq);
		dq.display();

	}

	public static void Display_revese(DYnamicQueue dq, int count) throws Exception {
		if (dq.size() == count) {
			return;
		}
		int n = dq.dequeue();
		dq.enqueue(n);
		Display_revese(dq, count + 1);
		System.out.println(n);

	}

	public static void Actual_revese(DYnamicQueue dq) throws Exception {
		if (dq.isEmpty()) {
			return;
		}
		int n = dq.dequeue();

		Actual_revese(dq);
		dq.enqueue(n);

	}

}
