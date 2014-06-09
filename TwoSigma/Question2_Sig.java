package TwoSigma;
import Library.TreeNode;

//find the diameter of the tree

public class Question2_Sig {
	public static void main(String args[]) throws Exception {
		TreeNode root = new TreeNode(40);
		root.left = new TreeNode(30);
		root.left.left = new TreeNode(20);
		root.left.right = new TreeNode(38);
		root.right = new TreeNode(65);
		root.right.right = new TreeNode(78);
		int out = diameterOfTree(root);
		System.out.println(out);
	}

	public static int diameterOfTree(TreeNode root) {
		if (root == null)
			return 0;

		int rootDiameter = getHeight(root.left) + getHeight(root.right) + 1;
		int leftDiameter = diameterOfTree(root.left);
		int rightDiameter = diameterOfTree(root.right);

		return Math.max(rootDiameter, Math.max(leftDiameter, rightDiameter));
	}

	public static int getHeight(TreeNode root) {
		if (root == null)
			return 0;

		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
}
