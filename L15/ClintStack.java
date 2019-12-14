package L15;

public class ClintStack {

	public static void main(String[] args) throws Exception {
		Stack s = new Stack(5);
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(50);
		System.out.println(s.peek());
		s.display();
		System.out.println(s.pop());
		

	}

}
