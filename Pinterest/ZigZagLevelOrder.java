package Pinterest;
import java.util.ArrayList;
import java.util.Stack;

import Library.TreeNode;

public class ZigZagLevelOrder {
	/**
	 * This is the main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(2);
		t.right = new TreeNode(3);
		t.left.left = new TreeNode(4);
		t.left.right = new TreeNode(6);
		t.right.right = new TreeNode(5);
		t.right.left = new TreeNode(7);

		ArrayList<ArrayList<Integer>> res = zigzagLevelOrder(t);
		System.out.println(res);
	}

	/**
	 * This is level order traversal
	 * 
	 * @param root
	 * @return
	 */
	public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return res;
		}
		Stack<TreeNode> currentLevel = new Stack<TreeNode>();
		Stack<TreeNode> nextLevel = new Stack<TreeNode>();
		Stack<TreeNode> tmp;
		currentLevel.push(root);
		boolean flag = true;

		while (!currentLevel.isEmpty()) {
			ArrayList<Integer> level = new ArrayList<Integer>();

			while (!currentLevel.isEmpty()) {
				TreeNode current = currentLevel.pop(); // continuously poping
														// out current level
														// result
				level.add(current.val);

				if (flag) {
					if (current.left != null) {
						nextLevel.push(current.left);
					}
					if (current.right != null) {
						nextLevel.push(current.right);
					}
				} else {
					if (current.right != null) {
						nextLevel.push(current.right);
					}
					if (current.left != null) {
						nextLevel.push(current.left);
					}
				}
			}
			res.add(level);
			// swap current and next level stack
			tmp = currentLevel;
			currentLevel = nextLevel;
			nextLevel = tmp;
			flag = !flag;
		}
		return res;
	}
}
