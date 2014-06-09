package online_test;

import java.util.ArrayList;

public class Node {
	public String val;
	public int degree;
	ArrayList<Node> adj = new ArrayList<Node>();

	public Node(String d) {
		val = d;
		degree = 0;
	}

	public void addAdj(Node child) {
		adj.add(child);
		child.degree++;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int d) {
		degree = d;
	}
}
