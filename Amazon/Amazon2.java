package Amazon;

import Library.TreeNode;

public class Amazon2 {

	public static void main(String[] args) {
		TreeNode T = new TreeNode(5);
		T.left = new TreeNode(8);
		T.left.left = new TreeNode(12);
		T.left.right = new TreeNode(2);
		T.right = new TreeNode(9);
		T.right.left = new TreeNode(8);
		T.right.left.left = new TreeNode(2);
		T.right.right = new TreeNode(4);
		T.right.right.right = new TreeNode(5);

		System.out.println(solution(T));

	}

	private static int amplitude = 0;

	public static int solution(TreeNode T) {
		// write your code in Java SE 7
		Traverse(T, Integer.MIN_VALUE, Integer.MAX_VALUE);
		return amplitude;
	}

	public static void Traverse(TreeNode T, int max, int min) {
		if (T == null) {
			return;
		}
		System.out.println("T.val : " + T.val);
		if (T.val > max) {
			max = T.val;
		}

		if (T.val < min) {
			min = T.val;
		}
		int diff = max - min;
		System.out.println(max + "-" + min + "= " + diff);

		if (diff > amplitude) {
			amplitude = diff;
		}

		Traverse(T.left, max, min);
		Traverse(T.right, max, min);

	}
}
