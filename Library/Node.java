package Library;

import java.util.ArrayList;

public class Node {
	String label;
	int data;
	ArrayList<Node> parent;
	ArrayList<Node> child;

	Node(String l, int d) {
		label = l;
		data = d;
		parent = new ArrayList<Node>();
		child = new ArrayList<Node>();
	}
}
