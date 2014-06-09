package etsy;
import java.util.ArrayList;

public class Permutation_etsy {
	public static void main(String[] args) {
		int[][] can = { { 1, 1, 3 }, { 4, 5 } };
		ArrayList<ArrayList<Integer>> res = permute(can);
		System.out.println(res);

	}

	public static ArrayList<ArrayList<Integer>> permute(int[][] matrix) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return res;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		helper(res, list, matrix);
		return res;
	}

	public static void helper(ArrayList<ArrayList<Integer>> res,
			ArrayList<Integer> list, int[][] matrix) {
		if (list.size() == matrix.length) {
			res.add(new ArrayList<Integer>(list));
			return;
		}

		for (int i : matrix[list.size()]) { // use list size to track
			list.add(i);
			helper(res, list, matrix);
			list.remove(list.size() - 1);
		}
	}
}
