package Google;

import java.util.ArrayList;
import java.util.Stack;

import Library.TreeNode;

/**
 * You have a binary search tree and integer n, find out the most efficient way
 * to locate two nodes of the three whose summation is equals to "n" ?
 * 
 * 
 * Read more:
 * http://javarevisited.blogspot.com/2012/01/google-interview-questions
 * -answers-top.html#ixzz30Q3Rk34L
 * 
 * @author oliviazhang
 * 
 */
public class SearchBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(8);

		ArrayList<Integer> res = findSum(root, 15);
		System.out.println(res);

	}

	// using preorder traversal to turn the tree into an arraylist then using
	// 3 sum
	public static ArrayList<Integer> findSum(TreeNode root, int t) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (root == null) {
			return res;
		}

		ArrayList<Integer> treelist = new ArrayList<Integer>();
		helper(root, treelist);

		for (int i = 0; i < treelist.size() - 2; i++) {
			for (int j = i + 1; j < treelist.size(); j++) {
				int left = j;
				int right = treelist.size() - 1;

				int sum = treelist.get(i) + treelist.get(left)
						+ treelist.get(right);
				if (sum == t) {
					res.add(treelist.get(i));
					res.add(treelist.get(left));
					res.add(treelist.get(right));
					return res;
				} else if (sum < t) {
					left++;
				} else {
					right--;
				}
			}
		}
		return res;
	}

	public static void helper(TreeNode root, ArrayList<Integer> list) {
		if (root == null) {
			return;
		}

		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root);

		while (!s.isEmpty()) {
			TreeNode curr = s.pop();
			list.add(curr.val);
			if (curr.right != null) {
				s.push(curr.right);
			}
			if (curr.left != null) {
				s.push(curr.left);
			}
		}
	}
}
