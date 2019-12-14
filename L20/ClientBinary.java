package L20;

public class ClientBinary {
// 10 true 20 true 40 false false true 50 false false true 30 false true 60 false false
	// 1 true -2 true 4 false false true 5 false false true 3 true 2 false false true -6 false false
	public static void main(String[] args) {
		int[] pre = {10,20,40,80,90,120,50,100,110,30,60,70};
		int[] in = {80,40,120,90,20,50,100,110,10,60,30,70};
		BinaryTree bt = new BinaryTree(pre,in);
//		bt.display();
//		System.out.println(bt.size());
//		System.out.println(bt.max());
//		System.out.println(bt.ht());
//		System.out.println(bt.find(20));
//		System.out.println(bt.diameter());
//		System.out.println(bt.diameter2());
//		System.out.println(bt.isbalanced());
//		System.out.println(bt.isbalanced2());
//		System.out.println(bt.largestsum());
//		bt.preorder();
//		bt.preorderI();
//		bt.inorder();
//		System.out.println(bt.isBst());
		bt.verticleorderprint();
	
	}

}
