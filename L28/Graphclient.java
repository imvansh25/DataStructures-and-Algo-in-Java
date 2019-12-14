package L28;

import java.util.ArrayList;
import java.util.HashMap;

public class Graphclient {

	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");
		
		graph.addEdges("A", "B", 10);
		graph.addEdges("A", "D", 2);
		graph.addEdges("C", "B", 30);
		graph.addEdges("C", "D", 40);
		graph.addEdges("E", "D", 14);
		graph.addEdges("E", "F", 17);
		graph.addEdges("G", "E", 12);
		graph.addEdges("F", "G", 11);
//		graph.removeEdges(vname1, vname2);
//		graph.display();
//		System.out.println(graph);
//		System.out.println(graph.hasPath("A", "F",new HashMap<String, Boolean>()));
////		graph.display();
		graph.removeEdges("D","E");
//		
//		System.out.println(graph.hasPath("A", "F",new HashMap<String, Boolean>()));
//		graph.printAllPath("A", "F", new HashMap<String, Boolean>(), "A");
//		System.out.println(graph.Bfs("A", "F"));
//		System.out.println(graph.Dfs("A", "F"));
//		graph.Bft();
		System.out.println(graph.isTree());
		ArrayList<ArrayList<String>> arr = graph.getCC();
		System.out.println(arr);
	}

}
