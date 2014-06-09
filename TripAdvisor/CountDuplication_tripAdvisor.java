package TripAdvisor;
import java.util.HashSet;

import Library.TreeNode;

public class CountDuplication_tripAdvisor {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(2);
		root.right = new TreeNode(1);
		root.right.right = new TreeNode(3);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		System.out.println(countDup_bit(root));
		// a tree like this --return 2
		// 0
		// 2 1
		// 1 3 3
	}

	/**
	 * useing bit manipulation
	 * 
	 * @param root
	 * @return
	 */
	private static int res = 0;
	private static int checker = 0;

	public static int countDup_bit(TreeNode root) {
		search(root);
		return res;
	}

	public static void search(TreeNode root) {
		if (root == null) {
			return;
		}
		int val = root.val;
		if ((checker & (1 << val)) > 0) {
			res -= val;
			int mask = ~(1 << val); // clear bit
			checker &= mask;
		} else {
			res += val;
			checker |= (1 << val); // set bit
		}
		search(root.left);
		search(root.right);
	}

	/**
	 * using hashset
	 * 
	 * @param root
	 * @return
	 */

	public static int countDup_additionalDS(TreeNode root) {
		HashSet<Integer> set = new HashSet<Integer>();
		search(set, root);
		int res = 0;
		for (int i : set) {
			res += i;
		}
		return res;
	}

	public static void search(HashSet<Integer> set, TreeNode root) {
		if (root == null) {
			return;
		}
		if (set.contains(root.val)) {
			set.remove(root.val);
		} else {
			set.add(root.val);
		}

		search(set, root.left);
		search(set, root.right);
	}
}
