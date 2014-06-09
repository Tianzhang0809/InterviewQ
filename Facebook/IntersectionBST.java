package Facebook;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import Library.TreeNode;

/**
 * find the interection of two BST.
 * 
 * @author oliviazhang
 * 
 */
public class IntersectionBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(8);
		root.right = new TreeNode(9);
		root.right.left = new TreeNode(8);
		root.right.right = new TreeNode(4);

		TreeNode root2 = new TreeNode(3);
		root2.left = root.right;

		TreeNode res = intersection(root, root2);
		System.out.println(res.val);

	}

	public static TreeNode intersection(TreeNode t1, TreeNode t2) {
		if (t1 == null || t2 == null) {
			return null;
		}
		HashMap<TreeNode, Boolean> map = new HashMap<TreeNode, Boolean>(); // we
																			// can
																			// use
																			// hashset
																			// here
																			// instead
		// add all treeNode on t1 into set
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(t1);

		while (!stack.isEmpty()) {
			TreeNode curr = stack.pop();
			map.put(curr, true);
			if (curr.right != null) {
				stack.push(curr.right);
			}
			if (curr.left != null) {
				stack.push(curr.left);
			}
		}

		// level order traverse t2
		TreeNode parent = levelOrder(t2, map);
		return parent;
	}

	public static TreeNode levelOrder(TreeNode root,
			HashMap<TreeNode, Boolean> map) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode curr = q.poll();
				if (map.containsKey(curr)) {
					return curr;
				}
				if (curr.left != null) {
					q.offer(curr.left);
				}
				if (curr.right != null) {
					q.offer(curr.right);
				}
			}
		}
		return null;
	}
}
