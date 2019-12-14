package L19;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.LinkedList;

public class GenericTrees {
	Scanner scn = new Scanner(System.in);

	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	private Node root;

	public GenericTrees() {
		this.root = construct(null, -1);
	}

	private Node construct(Node parent, int ith) {
		if (parent == null) {
			System.out.println("ENTER THE DATA FOR PARENT CLASS.");
		} else {
			System.out.println("ENTER THE DATA  FOR " + ith + " NODE OF " + parent.data + "?");
		}
		int data = scn.nextInt();
		Node nn = new Node();
		nn.data = data;
		System.out.println("Enter no of child of " + data);
		int i = scn.nextInt();
		for (int j = 0; j < i; j++) {
			Node child = construct(nn, j);
			nn.children.add(child);
		}
		return nn;
	}

	public void display() {
		System.out.println("---------------------");
		display(this.root);
		System.out.println("---------------------");
	}

	private void display(Node root) {
		String str = root.data + " => ";
		for (Node val : root.children) {
			str = str + " " + val.data;
		}
		str = str + ".";
		System.out.println(str);
		for (Node val : root.children) {
			display(val);
		}

	}

	public int size() {
		return size(root);
	}

	private int size(Node root) {
		int ts = 0;
		for (Node val : root.children) {
			ts += size(val);
		}
		return ts + 1;
	}

	public int max() {
		return max(root);
	}

	private int max(Node root) {
		int max = root.data;
		for (Node child : root.children) {
			if (max < max(child)) {
				max = child.data;
			}
		}
		return max;
	}

	public boolean find(int i) {
		return find(root, i);
	}

	private boolean find(Node root, int i) {
		boolean ans = false;
		if (root.data == i) {
			return true;
		}
		for (Node child : root.children) {
			ans = find(child, i);
			if (ans) {
				return true;
			}
		}

		return ans;
	}

	public int ht() {
		return ht(root);
	}

	private int ht(Node root) {
		int th = -1;
		for (Node child : root.children) {
			int nt = ht(child);
			if (nt > th) {
				th = nt;
			}
		}

		return th + 1;
	}

	public void mirror() {
		mirror(root);
	}

	private void mirror(Node root) {
		ArrayList<Node> narr = new ArrayList<>();
		for (int i = root.children.size() - 1; i <= 0; i--) {
			narr.add(root.children.get(i));
		}
		root.children = narr;
		for (Node child : root.children) {
			mirror(child);
		}

	}

	public void PrintatLevel(int level) {
		PrintatLevel(root, level, 0);
	}

	private void PrintatLevel(Node root, int level, int count) {
		if (count == level) {
			System.out.print(root.data + " ");
			return;
		}
		for (Node child : root.children) {
			PrintatLevel(child, level, count + 1);
		}

	}

	public void Linearize() {
		Linearize(root);
	}

	private void Linearize(Node root) {
		// TODO Auto-generated method stub

	}

	public void preorder() {
		preorder(root);
	}

	private void preorder(Node node) {
		System.out.println(node.data);
		for (Node child : node.children) {
			preorder(child);
		}
	}

	public void postorder() {
		postorder(root);
	}

	private void postorder(Node node) {
		for (Node child : node.children) {
			postorder(child);
		}
		System.out.println(node.data);
	}

	public void levelorder() {
		LinkedList<Node> ll = new LinkedList<>();
		ll.add(root);
		while (ll.size() != 0) {
			Node rn = ll.removeFirst();
			System.out.print(rn.data + " ");
			for (Node val : rn.children) {
				ll.addLast(val);
			}
		}
	}

	public void levelorderlinear() {
		LinkedList<Node> primary = new LinkedList<>();
		LinkedList<Node> secondry = new LinkedList<>();
		primary.add(root);
		while (primary.size() != 0) {
			Node rn = primary.removeFirst();
			System.out.print(rn.data + " ");
			for (Node val : rn.children) {
				secondry.addLast(val);
			}
			if (primary.size() == 0) {
				System.out.println();
				primary = secondry;
				secondry = new LinkedList<>();
			}
		}

	}

	public void levelorderzz() {
		LinkedList<Node> Queue = new LinkedList<>();
		LinkedList<Node> stack = new LinkedList<>();
		Queue.add(root);
		int count = 0;
		while (Queue.size() != 0) {
			Node rn = Queue.removeFirst();
			System.out.print(rn.data + " ");
			if (count % 2 == 0) {
				for (Node val : rn.children) {
					stack.addFirst(val);
				}
			} else {
				for (int i = rn.children.size() - 1; i >= 0; i--) {
					stack.addFirst(rn.children.get(i));
				}
			}
			if (Queue.size() == 0) {
				System.out.println();
				Queue = stack;
				stack = new LinkedList<>();
				count++;
			}

		}

	}

	private class HeapMover {
		int size = 0;
		int max = Integer.MIN_VALUE;
		int ht = 0;
		boolean find = false;
		Node pred = null;
		Node succ = null;
	}

	public void multisolver(int item) {
		HeapMover mover = new HeapMover();
		multisolver(root, mover, 0, item);
		System.out.println(mover.max);
		System.out.println(mover.find);
		System.out.println(mover.ht);
		System.out.println(mover.size);
		System.out.println(mover.pred == null ? null : mover.pred.data);
		System.out.println(mover.succ == null ? null : mover.succ.data);
	}

	private void multisolver(Node root, HeapMover mover, int cl, int item) {
		mover.size++;
		if (root.data > mover.max) {
			mover.max = root.data;
		}
		if (cl > mover.ht) {
			mover.ht = cl;
		}
		if (mover.find == true && mover.succ == null) {
			mover.succ = root;
		}
		if (item == root.data) {
			mover.find = true;
		}
		if (mover.find == false) {
			mover.pred = root;
		}
		for (Node child : root.children) {
			multisolver(child, mover, cl + 1, item);
		}
	}
	public ArrayList<Integer> path(int item){
		return path(item,this.root);
	}
	private ArrayList<Integer> path(int item, Node node){
		if(node==null) {
			return new ArrayList<Integer>();
		}
		
		if(node.data == item) {
			ArrayList<Integer> barr = new ArrayList<Integer>();
			barr.add(node.data);
			return barr;
		}
		for(Node val : node.children) {
			ArrayList<Integer> narr = path(item, val);
			if(!narr.isEmpty()) {
				ArrayList<Integer> barr = new ArrayList<Integer>();
				barr.add(node.data);
				for(int val1 : narr) {
					barr.add(val1);
				}
				return barr;
			}
		}
		return new ArrayList<Integer>();
		
	}

}
