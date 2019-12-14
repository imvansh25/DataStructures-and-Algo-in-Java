package L22;

import java.util.Scanner;

public class bst {
	Scanner scn = new Scanner(System.in);

	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;

	public bst(int[] in) {
		this.root = constructor(in, 0, in.length - 1);
	}

	private Node constructor(int[] in, int lo, int hi) {
		if (lo > hi) {
			return null;
		}
		int mid = (lo + hi) / 2;
		Node nn = new Node();
		nn.data = in[mid];
		nn.left = constructor(in, lo, mid - 1);
		nn.right = constructor(in, mid + 1, hi);
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
		return max(root);
	}

	private int max(Node root) {
		if (root.right == null) {
			return root.data;
		}
		return max(root.right);
	}

	public boolean find(int item) {
		return find(root, item);
	}

	private boolean find(Node root, int item) {
		if (root == null) {
			return false;
		}
		if (item > root.data) {
			return find(root.right, item);
		} else if (item < root.data) {
			return find(root.left, item);
		} else {
			return true;
		}
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

	public void inrange(int lo, int hi) {
		inrange(this.root, lo, hi);
	}

	private void inrange(Node root, int lo, int hi) {
		if (root == null) {
			return;
		}
		if (root.data < lo) {
			inrange(root.right, lo, hi);
		} else if (root.data > hi) {
			inrange(root.left, lo, hi);
		} else {
			inrange(root.left, lo, hi);
			System.out.println(root.data);
			inrange(root.right, lo, hi);

		}

	}

	public void printdec() {
		printdec(this.root);
	}

	private void printdec(Node root) {
		if (root == null) {
			return;
		}
		printdec(root.right);
		System.out.println(root.data);
		printdec(root.left);
	}

	private class Heapmover {
		int sum;
	}

	public void replacewithsumlarger() {
//		replacewithsumlarger(this.root, new Heapmover());
		replacewithsumlarger(this.root, 0);

	}

	private void replacewithsumlarger(Node root2, Heapmover mover) {
		if (root2 == null) {
			return;
		}
		replacewithsumlarger(root2.right, mover);
		int temp = root2.data;
		root.data = mover.sum;
		mover.sum += temp;
		replacewithsumlarger(root2.left, mover);

	}

	public int replacewithsumlarger(Node root2, int sum) {
		if (root2 == null) {
			return sum;
		}
		int right = replacewithsumlarger(root2.right, sum);
		int temp = root2.data;
		root2.data = sum;
		int left = replacewithsumlarger(root2.left, sum + temp);
		return left;
	}

	public void add(int item) {
		add(this.root, item);
		this.root = add1(root, item);
	}

	private void add(Node root, int item) {
		if (root.data > item) {
			if (root.left == null) {
				Node nn = new Node();
				nn.data = item;
				root.left = nn;

			} else {
				add(root.left, item);
			}
		} else if (root.data < item) {
			if (root.right == null) {
				Node nn = new Node();
				nn.data = item;
				root.right = nn;

			} else {
				add(root.right, item);
			}
		}

	}

	private Node add1(Node root, int item) {
		if (root == null) {
			Node nn = new Node();
			nn.data = item;
			return nn;

		}
		if (root.data > item) {
			root.left = add1(root.left, item);
		} else if (root.data < item) {
			root.right = add1(root.right, item);
		}
		return root;
	}

	public void remove(int data) {
		remove(this.root, null, data);
	}

	private void remove(Node node, Node parent, int data) {
		if (node == null) {
			return;
		}
		if (node.data > data) {
			remove(node.left, node, data);
		} else if (node.data < data) {
			remove(node.right, node, data);
		} else {
			if (node.right == null && node.left == null) {
				if (parent.data >= node.data) {
					parent.left = null;
				} else {
					parent.right = null;
				}
			} else if (node.right == null && node.left != null) {
				if (parent.data >= node.data) {
					parent.left = node.left;
				} else {
					parent.right = node.left;
				}

			} else if (node.left == null && node.right != null) {
				if (parent.data >= node.data) {
					parent.left = node.right;
				} else {
					parent.right = node.right;
				}

			} else {
				int max = max(node.left);
				remove(node.left, node, max);
				node.data = max;

			}
		}

	}

}
