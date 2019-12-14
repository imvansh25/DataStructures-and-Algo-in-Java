package L25;

public class Heapclient {

	public static void main(String[] args) {
		Heap heap = new Heap();
		heap.add(20);
		heap.add(10);
		heap.add(30);
		heap.add(3);
		heap.add(2);
		heap.display();
		while(!heap.isEmpty()) {
			System.out.println(heap.remove());
			heap.display();
		}

	}

}
