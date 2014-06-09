/** Jason Google Apr 28.
 * 
 * 1. Design a Java caching api
 * 2. most frequently visited node on BST
 */

package JasonGoogle;

import java.util.HashMap;
import java.util.Stack;

import Library.TreeNode;

public class Solution {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(1);
		root.right = new TreeNode(2);
		int val = mostFrequentUse(root);
		System.out.println(val);
	}

	public static int mostFrequentUse(TreeNode root) {
		if (root == null) {
			return -1;
		}

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		// hashmap to store key = treenode value, value store frequency
		Stack<TreeNode> stack = new Stack<TreeNode>();

		// I will use preorder traversal here
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode curr = stack.pop();
			// add the value to the hashmap
			if (!map.containsKey(curr.val)) {
				map.put(curr.val, 1);
			} else {
				map.put(curr.val, map.get(curr.val) + 1);
			}

			if (curr.right != null) {
				stack.push(curr.right);
			}
			if (curr.left != null) {
				stack.push(curr.left);
			}
		}

		int max = Integer.MIN_VALUE;
		int mode = -1;

		for (int key : map.keySet()) {
			if (map.get(key) > max) {
				max = map.get(key);
				mode = key;
			}
		}
		return mode;

	}
}
