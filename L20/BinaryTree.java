package L20;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

import L24.HAshmap_demo;

public class BinaryTree {
	Scanner scn = new Scanner(System.in);

	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;

	public BinaryTree() {
		this.root = construct(null, false);
	}

	private Node construct(Node root, boolean itl) {
		if (root == null) {
			System.out.println("ENTER DATA FOR ROOT NODE");
		} else {
			System.out.println("ENTER DATA FOR NODE OF" + root.data);
		}
		Node nn = new Node();
		nn.data = scn.nextInt();
		System.out.println("IS THERE A LEFT NODE?");
		boolean left = scn.nextBoolean();
		if (left) {
			nn.left = construct(nn, true);
		}
		System.out.println("IS THERE A Right NODE?");
		boolean right = scn.nextBoolean();
		if (right) {
			nn.right = construct(nn, false);
		}
		return nn;
	}

	public BinaryTree(int[] pre, int[] in) {
		this.root = constructpretoin(pre, 0, pre.length - 1, in, 0, in.length - 1);
//		this.root = constructposttoin(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	private Node constructposttoin(int[] post, int polo, int pohi, int[] in, int inlo, int inhi) {
		if (polo > pohi || inlo > inhi) {
			return null;
		}
		Node nn = new Node();
		nn.data = post[pohi];
		int x = -1;
		for (int i = inlo; i <= inhi; i++) {
			if (in[i] == nn.data) {
				x = i;
				break;
			}
		}
		int nel = x - inlo;
		nn.left = constructpretoin(post, polo, polo + nel - 1, in, inlo, x - 1);
		nn.right = constructpretoin(post, polo + nel, pohi - 1, in, x + 1, inhi);
		return nn;

	}

	private Node constructpretoin(int[] pre, int prelo, int prehi, int[] in, int inlo, int inhi) {
		if (prelo > prehi || inlo > inhi) {
			return null;
		}
		Node nn = new Node();
		nn.data = pre[prelo];
		int x = -1;
		for (int i = inlo; i <= inhi; i++) {
			if (in[i] == nn.data) {
				x = i;
			}
		}
		int nel = x - inlo;
		nn.left = constructpretoin(pre, prelo + 1, prelo + nel, in, inlo, x - 1);
		nn.right = constructpretoin(pre, prelo + nel + 1, prehi, in, x + 1, inhi);
		return nn;

	}

	public void display() {
		System.out.println("***************************");
		display(root);
		System.out.println("***************************");
	}

	private void display(Node root) {
		if (root == null) {
			return;
		}
		String str = "";
		if (root.left == null) {
			str = str + ".";
		} else {
			str = str + root.left.data;
		}
		str = str + " => " + root.data + " <= ";
		if (root.right == null) {
			str = str + ".";
		} else {
			str = str + root.right.data;
		}
		System.out.println(str);
		display(root.left);
		display(root.right);
	}

	public int size() {
		return size(root);
	}

	private int size(Node root) {
		if (root == null) {
			return 0;
		}
		int left = size(root.left);
		int right = size(root.right);
		return right + left + 1;

	}

	public int max() {
		return max(root, Integer.MIN_VALUE);
	}

	private int max(Node root, int max) {
		if (root == null) {
			return max;
		}
		if (root.data > max) {
			return root.data;
		}
		int left = max(root.left, max);
		int right = max(root.right, max);
		max = Math.max(left, right);
		return max;
	}

	public boolean find(int item) {
		return find(root, item);
	}

	private boolean find(Node root, int item) {
		if (root == null) {
			return false;
		}
		if (root.data == item) {
			return true;

		}
		boolean left = find(root.left, item);
		boolean right = find(root.right, item);

		if (left || right) {
			return true;
		}
		return false;
	}

	public int ht() {
		return ht(root);
	}

	private int ht(Node root) {
		if (root == null) {
			return -1;
		}
		int left = ht(root.left);
		int right = ht(root.right);

		return Math.max(left, right) + 1;
	}

	public int diameter() {
		return diameter(this.root);
	}

	private int diameter(Node node) {
		if (node == null) {
			return 0;
		}
		int ld = diameter(node.left);
		int rd = diameter(node.right);
		int sd = ht(node.left) + ht(node.right) + 2;
		return Math.max(sd, Math.max(rd, ld));

	}

	private class Diapair {
		int diameter = 0;
		int ht = -1;
	}

	public int diameter2() {
		return diameter2(this.root).diameter;
	}

	private Diapair diameter2(Node node) {
		if (node == null) {
			Diapair bdp = new Diapair();
			return bdp;
		}
		Diapair ldp = diameter2(node.left);
		Diapair rdp = diameter2(node.right);
		Diapair sdp = new Diapair();
		sdp.ht = Math.max(ldp.ht, rdp.ht) + 1;
		sdp.diameter = Math.max(ldp.ht + rdp.ht + 2, Math.max(ldp.diameter, rdp.diameter));

		return sdp;
	}

	public boolean isbalanced() {
		return isbalanced(this.root);
	}

	private boolean isbalanced(Node node) {
		if (node == null) {
			return true;
		}
		boolean lb = isbalanced(node.left);
		boolean rb = isbalanced(node.right);
		if (lb && rb) {
			int n = ht(node.left) - ht(node.right);
			if (n == 0 || n == 1 || n == -1) {
				return true;
			}
		}

		return false;
	}

	private class balance {
		boolean ans = true;
		int ht = -1;
	}

	public boolean isbalanced2() {
		return isbalanced2(this.root).ans;
	}

	private balance isbalanced2(Node node) {
		if (node == null) {
			balance bb = new balance();
			return bb;
		}
		balance lb = isbalanced2(node.left);
		balance rb = isbalanced2(node.right);
		balance sb = new balance();
		sb.ht = Math.max(lb.ht, rb.ht) + 1;
		if (lb.ans && rb.ans) {
			int n = lb.ht - rb.ht;
			if (n == 0 || n == 1 || n == -1) {
				sb.ans = true;
			} else {
				sb.ans = false;
			}

		}
		return sb;
	}
//	private class largest{
//		int max=0;
//	}
//	public int largestsum() {
//		return largestsum(this.root).max;
//	}
//
//	private largest largestsum(Node root2) {
//		if(root2 == null) {
//			return max;
//		}
//		int lt = largestsum(root2.left);
//		int rt = largestsum(root2.right);
//		int st = lt+rt+root2.data;
//		return Math.max(st, Math.max(rt, lt));
//	}

	// NLR : Pre
	// LNR : in
	// LRN : post
	// NRL : post rev
	// RNL : in rev
	// RLN : pre rev
	public void preorder() {
		preorder(this.root);
	}

	private void preorder(Node node) {
		if (node == null) {
			return;
		}
		System.out.println(node.data);
		preorder(node.left);
		preorder(node.right);

	}

	public void postorder() {
		postorder(this.root);
	}

	private void postorder(Node node) {
		if (node == null) {
			return;
		}
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.data + " ");

	}

	public void inorder() {
		inorder(this.root);
	}

	private void inorder(Node node) {
		if (node == null) {
			return;
		}

		inorder(node.left);
		System.out.print(node.data + " ");
		inorder(node.right);

	}

	private class pair {
		Node node;
		boolean sw = false;
		boolean lc = false;
		boolean rc = false;
	}

	public void preorderI() {
		preorderI(this.root);
	}

	private void preorderI(Node node) {
		Stack<pair> Stack = new Stack<>();
		pair root = new pair();
		root.node = this.root;
		Stack.push(root);
		while (!Stack.isEmpty()) {
			pair tp = Stack.peek();
			if (tp.node == null) {
				Stack.pop();
				continue;
			}
			if (!tp.sw) {
				System.out.println(tp.node.data);
				tp.sw = true;
			} else if (!tp.lc) {
				pair np = new pair();
				np.node = tp.node.left;
				Stack.push(np);
				tp.lc = true;
			} else if (!tp.rc) {
				pair np = new pair();
				np.node = tp.node.right;
				Stack.push(np);
				tp.rc = true;
			} else {
				Stack.pop();
			}
		}
	}

	private class Heapmover {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		boolean isBSt = true;
	}

	public boolean isBst() {
		return isBst(new Heapmover(), this.root).isBSt;
	}

	private Heapmover isBst(Heapmover mover, Node node) {
		if (node == null) {
			return new Heapmover();
		}
		Heapmover nn = new Heapmover();
		Heapmover left = isBst(mover, node.left);
		Heapmover right = isBst(mover, node.right);
		nn.max = Math.max(node.data, Math.max(left.max, right.max));
		nn.min = Math.min(node.data, Math.min(left.min, right.min));
		if (node.data > left.max && node.data < right.min && left.isBSt && right.isBSt) {
			nn.isBSt = true;
		} else {
			nn.isBSt = false;
		}
		return nn;
	}

	private class Vopair implements Comparable<Vopair> {
		int data;
		int hl;

		@Override
		public String toString() {
			return this.data + "";
		}

		@Override
		public int compareTo(Vopair o) {
			// TODO Auto-generated method stub
			return this.hl - o.hl;
		}
	}

	public void verticleorderprint() {
		HashMap<Integer, ArrayList<Vopair>> map = new HashMap<>();

		verticleorderprint(this.root, 0, 0, map);
		ArrayList<Integer> arr = new ArrayList<>(map.keySet());
		Collections.sort(arr);
		for (int val : arr) {
			ArrayList<Vopair> vv = map.get(val);
			Collections.sort(vv);
			System.out.print(val +" =>");
			System.out.println(vv);
		}
	}

	private void verticleorderprint(Node node, int i, int hl, HashMap<Integer, ArrayList<Vopair>> map) {
		if (node == null) {
			return;
		}
		Vopair cc = new Vopair();
		cc.data = node.data;
		cc.hl = hl;
		if (map.containsKey(i)) {
			ArrayList<Vopair> arr = map.get(i);
			arr.add(cc);
			map.put(i, arr);
		} else {
			ArrayList<Vopair> arr = new ArrayList<BinaryTree.Vopair>();
			arr.add(cc);
			map.put(i, arr);

		}
		verticleorderprint(node.left, i - 1, hl + 1, map);
		verticleorderprint(node.right, i + 1, hl + 1, map);

	}
	

}
