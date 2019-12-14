package L17and18;

import java.util.LinkedList;

public class ClientLinklist {

	public static void main(String[] args) throws Exception {
		LinkList ll = new LinkList();
		ll.addLast(10);
		ll.addLast(20);
		ll.addLast(30);
		ll.addLast(40);
		ll.addLast(50);
//		ll.display();
//		System.out.println(ll.getFirst());
//		System.out.println(ll.getLast());
//		System.out.println(ll.getAt(2));
		ll.addFirst(60);
//		ll.addFirst(70);
//		ll.addAt(3, 300);
//		ll.display();
//		System.out.println(ll.removeFirst());
//		ll.display();
//		System.out.println(ll.removeAt(2));
//		ll.display();
//		System.out.println(ll.removeLast());
//		ll.ReversedataIteratively();
//		ll.ReversePointerIteratively();
//		ll.RPointerRecursively();
//		ll.RDatarecursively();
//		ll.mid();
//		ll.fold();
//		ll.display();
//		ll.Kreverse(3);
//		ll.display();
		ll.KthFromLast(3);
	}

}
