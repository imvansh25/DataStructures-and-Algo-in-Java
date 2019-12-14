package L22;

public class Bstclient {

	public static void main(String[] args) {
		int[] arr = {10,20,30,40,50,60};
		bst bt = new bst(arr);
		bt.display();
//		System.out.println(bt.size());
//		System.out.println(bt.max());
//		System.out.println(bt.ht());
//		System.out.println(bt.find(20));
//		bt.inrange(20, 50);
//bt.printdec();
		
//		bt.replacewithsumlarger();
		bt.display();
		bt.remove(30);
		bt.display();
	}

}
