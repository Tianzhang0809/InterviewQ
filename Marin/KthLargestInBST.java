package Marin;

import java.util.ArrayList;
import java.util.Stack;

import Library.TreeNode;

public class KthLargestInBST {
	// 4
	// 2 6
	// 1 3 5

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.right = new TreeNode(6);
		root.right.left = new TreeNode(5);
		root.left = new TreeNode(2);
		root.left.right = new TreeNode(3);
		root.left.left = new TreeNode(1);
		kthLarget2(root, 2);
	}

	private static int index = 0;

	public static void kthLarget2(TreeNode root, int k) {
		// find the largest
		if (root == null) {
			return;
		}
		System.out.println(root.val);
		kthLarget2(root.right, k); // switch right to left --> kth smallest
		if (++index == k) {
			System.out.println("-->" + root.val);
			return;
		}

		kthLarget2(root.left, k);
	}

	/**
	 * Time: O(n)
	 * 
	 * Space: O(n)
	 * 
	 * @param root
	 * @param k
	 * @return
	 */
	public static int kthLarget(TreeNode root, int k) {
		if (root == null) {
			return 0;
		}

		// inorder
		Stack<TreeNode> s = new Stack<TreeNode>();
		ArrayList<Integer> res = new ArrayList<Integer>();
		TreeNode current = root;
		while (true) {
			while (current != null) {
				s.push(current);
				current = current.left;
			}

			if (s.isEmpty()) {
				break;
			}

			current = s.pop();
			res.add(current.val);
			current = current.right;
		}

		if (res.size() < k) {
			return 0;
		}

		return res.get(res.size() - k);

	}
}
