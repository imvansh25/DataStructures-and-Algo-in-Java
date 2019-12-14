package L19;

public class ClientTree {

	public static void main(String[] args) {
		// 10 3 20 2 50 0 60 0 30 0 40 2 70 0 80 0
		// 10 3 20 2 50 0 60 2 100 2 160 0 170 0 110 0 30 0 40 3 70 0 80 2 120 2 140 0 150 0 130 0 90 0
		GenericTrees tree = new GenericTrees();
//		tree.display();
//		System.out.println(tree.size());
//		System.out.println(tree.find(90));
//		System.out.println(tree.find(50));
//		System.out.println(tree.ht());
//		tree.mirror();
//		tree.display();
//		tree.PrintatLevel(2);
//		System.out.println();
//		tree.preorder();
//		System.out.println();
//		tree.postorder();
//		tree.levelorder();
//		tree.levelorderzz();
//		tree.multisolver(70);
		System.out.println(tree.path(100));
	}

}
