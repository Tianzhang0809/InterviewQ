package Library;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class FamilyTree {
	public static void main(String[] args) {
		Node node1 = new Node("a", 1);
		Node node2 = new Node("b", 1);
		Node node3 = new Node("c", 1);
		Node node4 = new Node("d", 1);
		Node node5 = new Node("e", 1);
		Node node6 = new Node("f", 1);

		node1.parent.add(node2);
		node2.child.add(node1);
		node1.parent.add(node3);
		node3.child.add(node1);

		node3.child.add(node5);
		node3.child.add(node4);
		System.out.println(CommonAncestor(node2, node6));
	}

	public static boolean CommonAncestor(Node node1, Node node2) {
		if (node1 == null || node2 == null) {
			return false;
		}
		Queue<Node> q = new LinkedList<Node>();
		Set<Node> visited = new HashSet<Node>();
		q.offer(node1);

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node curr = q.poll();
				if (visited.contains(curr)) {
					continue;
				} else {
					visited.add(curr);
					if (curr == node2) {
						return true;
					} else {
						if (curr.child != null) {
							addAllNodes(q, curr.child);
						}
						if (curr.parent != null) {
							addAllNodes(q, curr.parent);
						}
					}
				}
			}
		}
		return false;
	}

	public static void addAllNodes(Queue<Node> q, ArrayList<Node> list) {
		for (Node n : list) {
			q.add(n);
		}
	}
}
