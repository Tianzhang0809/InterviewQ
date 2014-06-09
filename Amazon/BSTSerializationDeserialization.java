package Amazon;

import java.util.ArrayList;
import java.util.Stack;

import Library.TreeNode;

public class BSTSerializationDeserialization {

	public static void main(String[] args) {
		TreeNode t = new TreeNode(30);
		t.left = new TreeNode(10);
		t.left.left = new TreeNode(50);
		t.right = new TreeNode(20);
		t.right.left = new TreeNode(45);
		t.right.right = new TreeNode(35);
		ArrayList<String> res = new ArrayList<String>();
		serial(t, res);
		ArrayList<String> out = serial2(t);
		System.out.println(res);
		System.out.println(out);

	}

	public static void serial(TreeNode t, ArrayList<String> res) {
		if (t == null) {
			res.add("#");
		} else {
			res.add(String.valueOf(t.val));
			serial(t.left, res);
			serial(t.right, res);
		}
	}

	public static ArrayList<String> serial2(TreeNode t) {
		ArrayList<String> res = new ArrayList<String>();
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<String> s2 = new Stack<String>();

		s1.push(t);
		s2.push(String.valueOf(t.val));
		while (!s1.isEmpty()) {
			if (s2.peek().equals("#")) {
				res.add(s2.pop());
				continue;
			}

			TreeNode curr = s1.pop();
			res.add(s2.pop());

			if (curr.right != null) {
				s1.push(curr.right);
				s2.push(String.valueOf(curr.right.val));
			} else {
				s2.push("#");
			}

			if (curr.left != null) {
				s1.push(curr.left);
				s2.push(String.valueOf(curr.left.val));
			} else {
				s2.push("#");
			}
		}

		return res;
	}
}
