package Google;

import Library.TreeNode;

public class BSTserialization {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(30);
		root.left = new TreeNode(10);
		root.right = new TreeNode(20);
		root.left.left = new TreeNode(50);
		root.right.left = new TreeNode(45);
		root.right.right = new TreeNode(35);
		bstserialization(root);

	}

	public static void bstserialization(TreeNode root) {
		if (root == null) {
			System.out.print("# ");
		} else {
			System.out.print(root.val + " ");
			bstserialization(root.left);
			bstserialization(root.right);
		}
	}
}
