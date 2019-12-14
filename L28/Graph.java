package L28;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Graph {
	private class Vertex {
		HashMap<String, Integer> nbrs = new HashMap<>();
	}

	HashMap<String, Vertex> vtces = new HashMap<>();

	public int numVertex() {
		return vtces.size();
	}

	public boolean containsVertex(String vname) {
		return vtces.containsKey(vname);
	}

	public void addVertex(String vname) {
		if (vtces.containsKey(vname)) {
			return;
		}
		Vertex vtx = new Vertex();
		vtces.put(vname, vtx);
	}

	public void removeVertex(String vname) {
		if (!vtces.containsKey(vname)) {
			return;
		}
		Vertex vtx1 = vtces.get(vname);
		for (String keys : vtx1.nbrs.keySet()) {
			Vertex nbvtx = vtces.get(keys);
			nbvtx.nbrs.remove(vname);
//			removeEdges(vname , keys); // dono se ht rehah hy
		}

		vtces.remove(vname);

	}

	public int numEdges() {
		int sum = 0;
		for (String key : vtces.keySet()) {
			Vertex vtx = vtces.get(key);
			sum += vtx.nbrs.size();
		}
		return sum / 2;
	}

	public boolean containsEdges(String vname1, String vname2) {
		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);
		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
			return false;
		}
		return true;
	}

	public void addEdges(String vname1, String vname2, int count) {
		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);
		if (vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(vname2)) {
			return;
		}
		vtx1.nbrs.put(vname2, count);
		vtx2.nbrs.put(vname1, count);
	}

	public void removeEdges(String vname1, String vname2) {

		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);

//		System.out.println(vname1);
//		System.out.println(vname2);
		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
			return;
		}

		vtx1.nbrs.remove(vname2);
		vtx2.nbrs.remove(vname1);
	}

	public void display() {
		for (String keys : vtces.keySet()) {
			Vertex vtx = vtces.get(keys);
			System.out.println(keys + " =>" + vtx.nbrs);
		}
	}

	@Override
	public String toString() {
		String str = "";
		for (String keys : vtces.keySet()) {
			Vertex vtx = vtces.get(keys);
			str = str + keys + " =>" + vtx.nbrs + "\n";
		}
		return str;
	}

	public boolean hasPathmy(String src, String dst) {
		boolean bn = false;
		Vertex vtx1 = vtces.get(src);
		ArrayList<String> arr1 = new ArrayList<String>(vtx1.nbrs.keySet());
		if (arr1.contains(dst)) {
			bn = true;
		} else {
			for (String keys : arr1) {
				int count = vtx1.nbrs.get(keys);
				removeEdges(src, keys);
				boolean tn = hasPathmy(keys, dst);
				addEdges(src, keys, count);
				if (tn) {
					return true;
				}
			}
		}
		return bn;
	}

	public boolean hasPath(String src, String dst, HashMap<String, Boolean> map) {
		map.put(src, true);
		if (vtces.get(src).nbrs.containsKey(dst)) {
			return true;
		}
		for (String keys : vtces.get(src).nbrs.keySet()) {
			if (!map.containsKey(keys) && hasPath(keys, dst, map)) {
				return true;
			}
		}
		return false;

	}

	public void printAllPath(String src, String dst, HashMap<String, Boolean> map, String str) {
		if (src.equals(dst)) {
			System.out.println(str);
			return;
		}
		map.put(src, true);
		for (String keys : vtces.get(src).nbrs.keySet()) {
			if (!map.containsKey(keys)) {
				printAllPath(keys, dst, map, str + keys);
			}
		}
		map.remove(src);

	}

	private class pair {
		String name;
		String psf;
		String color;
	}

	public boolean Bfs(String src, String dst) {
		HashMap<String, Boolean> processes = new HashMap<String, Boolean>();
		LinkedList<pair> queue = new LinkedList<>();
		pair sp = new pair();
		sp.name = src;
		sp.psf = src;
		queue.addLast(sp);
		while (!queue.isEmpty()) {
			pair np = queue.removeFirst();
			if (processes.containsKey(np.name)) {
				continue;
			}
			processes.put(np.name, true);
			if (containsEdges(np.name, dst)) {
				System.out.println(np.psf + dst);
				return true;
			}
			for (String keys : vtces.get(np.name).nbrs.keySet()) {
				if (!processes.containsKey(keys)) {
					pair ap = new pair();
					ap.name = keys;
					ap.psf = np.psf + keys;
					queue.addLast(ap);
				}
			}

		}
		return false;
	}

	public boolean Dfs(String src, String dst) {
		HashMap<String, Boolean> processes = new HashMap<String, Boolean>();
		LinkedList<pair> Stack = new LinkedList<>();
		pair sp = new pair();
		sp.name = src;
		sp.psf = src;
		Stack.addFirst(sp);
		while (!Stack.isEmpty()) {
			pair np = Stack.removeFirst();
			if (processes.containsKey(np.name)) {
				continue;
			}
			processes.put(np.name, true);
			if (containsEdges(np.name, dst)) {
				System.out.println(np.psf + dst);
				return true;
			}
			for (String keys : vtces.get(np.name).nbrs.keySet()) {
				if (!processes.containsKey(keys)) {
					pair ap = new pair();
					ap.name = keys;
					ap.psf = np.psf + keys;
					Stack.addFirst(ap);
				}
			}

		}
		return false;
	}

	public void Bft() {
		HashMap<String, Boolean> processes = new HashMap<String, Boolean>();
		LinkedList<pair> queue = new LinkedList<>();
		for (String key : vtces.keySet()) {
			if (processes.containsKey(key)) {
				continue;
			}
			pair sp = new pair();
			sp.name = key;
			sp.psf = key;
			queue.addLast(sp);
			while (!queue.isEmpty()) {
				pair np = queue.removeFirst();
				if (processes.containsKey(np.name)) {
					continue;
				}
				processes.put(np.name, true);
				System.out.println(np.name + " via " + np.psf);

				for (String keys : vtces.get(np.name).nbrs.keySet()) {
					if (!processes.containsKey(keys)) {
						pair ap = new pair();
						ap.name = keys;
						ap.psf = np.psf + keys;
						queue.addLast(ap);
					}
				}

			}
		}

	}

	public void Dft() {
		HashMap<String, Boolean> processes = new HashMap<String, Boolean>();
		LinkedList<pair> Stack = new LinkedList<>();
		for (String key : vtces.keySet()) {
			if (processes.containsKey(key)) {
				continue;
			}
			pair sp = new pair();
			sp.name = key;
			sp.psf = key;
			Stack.addFirst(sp);
			while (!Stack.isEmpty()) {
				pair np = Stack.removeFirst();
				if (processes.containsKey(np.name)) {
					continue;
				}
				processes.put(np.name, true);
				System.out.println(np.name + " via " + np.psf);

				for (String keys : vtces.get(np.name).nbrs.keySet()) {
					if (!processes.containsKey(keys)) {
						pair ap = new pair();
						ap.name = keys;
						ap.psf = np.psf + keys;
						Stack.addFirst(ap);
					}
				}

			}
		}

	}

	public boolean isCyclic() {
		HashMap<String, Boolean> processes = new HashMap<String, Boolean>();
		LinkedList<pair> queue = new LinkedList<>();
		for (String key : vtces.keySet()) {
			if (processes.containsKey(key)) {
				continue;
			}
			pair sp = new pair();
			sp.name = key;
			sp.psf = key;
			queue.addLast(sp);
			while (!queue.isEmpty()) {
				pair np = queue.removeFirst();
				if (processes.containsKey(np.name)) {
					return true;
				}
				processes.put(np.name, true);
//				System.out.println(np.name + " via " + np.psf);

				for (String keys : vtces.get(np.name).nbrs.keySet()) {
					if (!processes.containsKey(keys)) {
						pair ap = new pair();
						ap.name = keys;
						ap.psf = np.psf + keys;
						queue.addLast(ap);
					}
				}

			}
		}
		return false;

	}

	public boolean isConnected() {
		int count = 0;
		HashMap<String, Boolean> processes = new HashMap<String, Boolean>();
		LinkedList<pair> queue = new LinkedList<>();
		for (String key : vtces.keySet()) {
			if (processes.containsKey(key)) {
				continue;
			}
			count++;
			pair sp = new pair();
			sp.name = key;
			sp.psf = key;
			queue.addLast(sp);
			while (!queue.isEmpty()) {
				pair np = queue.removeFirst();
				if (processes.containsKey(np.name)) {
					continue;
				}
				processes.put(np.name, true);
//				System.out.println(np.name + " via " + np.psf);

				for (String keys : vtces.get(np.name).nbrs.keySet()) {
					if (!processes.containsKey(keys)) {
						pair ap = new pair();
						ap.name = keys;
						ap.psf = np.psf + keys;
						queue.addLast(ap);
					}
				}

			}
		}
		return count == 1;

	}

	public boolean isTree() {
		return isConnected() && !isCyclic();
	}

	public ArrayList<ArrayList<String>> getCC() {
		ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();
		HashMap<String, Boolean> processes = new HashMap<String, Boolean>();
		LinkedList<pair> queue = new LinkedList<>();
		for (String key : vtces.keySet()) {
			if (processes.containsKey(key)) {
				continue;
			}
			ArrayList<String> nar = new ArrayList<String>();
			pair sp = new pair();
			sp.name = key;
			sp.psf = key;
			queue.addLast(sp);
			while (!queue.isEmpty()) {
				pair np = queue.removeFirst();
				if (processes.containsKey(np.name)) {
					continue;
				}
				processes.put(np.name, true);
				nar.add(np.name);

				for (String keys : vtces.get(np.name).nbrs.keySet()) {
					if (!processes.containsKey(keys)) {
						pair ap = new pair();
						ap.name = keys;
						ap.psf = np.psf + keys;
						queue.addLast(ap);
					}
				}

			}
			arr.add(nar);
		}
		return arr;

	}

	public boolean Bipertite() {
		HashMap<String, String> processes = new HashMap<>();
		LinkedList<pair> queue = new LinkedList<>();
		for (String key : vtces.keySet()) {
			if (processes.containsKey(key)) {
				
			}
			pair sp = new pair();
			sp.name = key;
			sp.psf = key;
			sp.color = "r";
			queue.addLast(sp);
			while (!queue.isEmpty()) {
				pair np = queue.removeFirst();
				if (processes.containsKey(np.name)) {
					String oc = processes.get(np.name);
					String nc = np.color;
					if(oc!=nc) {
						return false; 
					}
				}
				processes.put(np.name,np.color );

				for (String keys : vtces.get(np.name).nbrs.keySet()) {
					if (!processes.containsKey(keys)) {
						pair ap = new pair();
						ap.name = keys;
						ap.psf = np.psf + keys;
						ap.color = np.color=="r" ? "g":"r";
						queue.addLast(ap);
					}
				}

			}
		}
		return true;
	}
}
