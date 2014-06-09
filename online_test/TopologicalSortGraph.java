package online_test;

import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortGraph {

	public static void topologicalSort(Graph graph) {
		Queue<Node> q = new LinkedList<Node>();
		int vertexProcess = 0;

		for (Node m : graph.nodes) {
			if (m.degree == 0) {
				vertexProcess++;
				q.offer(m);
				System.out.println("No edge linked to--> " + m.val); // first
																		// print
																		// out
																		// ancestors
			}
		}

		while (!q.isEmpty()) {
			Node m = q.poll();
			for (Node child : m.adj) {
				--child.degree;
				if (child.degree == 0) {
					q.offer(child);
					vertexProcess++;
					System.out.println(child.val);
				}
			}

			if (vertexProcess > graph.v) {
				System.out.println("---");
			}
		}
	}

	public static void main(String[] args) {
		Graph g = new Graph();
		g.v = 8;

		Node TEN = new Node("10");
		Node ELEVEN = new Node("11");
		Node TWO = new Node("2");
		Node THREE = new Node("3");
		Node FIVE = new Node("5");
		Node SEVEN = new Node("7");
		Node EIGHT = new Node("8");
		Node NINE = new Node("9");

		SEVEN.adj.add(ELEVEN);
		ELEVEN.degree++;
		SEVEN.adj.add(EIGHT);
		EIGHT.degree++;
		FIVE.adj.add(ELEVEN);
		ELEVEN.degree++;
		THREE.adj.add(EIGHT);
		EIGHT.degree++;
		THREE.adj.add(TEN);
		TEN.degree++;
		ELEVEN.adj.add(TEN);
		TEN.degree++;
		ELEVEN.adj.add(TWO);
		TWO.degree++;
		ELEVEN.adj.add(NINE);
		NINE.degree++;
		EIGHT.adj.add(NINE);
		NINE.degree++;

		g.nodes.add(TWO);
		g.nodes.add(THREE);
		g.nodes.add(FIVE);
		g.nodes.add(SEVEN);
		g.nodes.add(EIGHT);
		g.nodes.add(NINE);
		g.nodes.add(TEN);
		g.nodes.add(ELEVEN);

		// for (Node n : g.nodes) {
		// System.out.println(n.val + " " + n.degree);
		// }
		topologicalSort(g);

	}

}
