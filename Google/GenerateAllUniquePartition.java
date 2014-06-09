package Google;

/**
 * Given a positive integer n, generate all possible unique ways to 
 * represent n as sum of positive integers.
 * 
 */
import java.util.ArrayList;

public class GenerateAllUniquePartition {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> res = partitionInteger(4);
		System.out.println(res);

	}

	public static ArrayList<ArrayList<Integer>> partitionInteger(int n) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		helper(res, list, arr, n, 0);
		return res;
	}

	public static void helper(ArrayList<ArrayList<Integer>> res,
			ArrayList<Integer> list, int[] arr, int n, int pos) {
		if (n <= 0) {
			if (n == 0) {
				res.add(0, new ArrayList<Integer>(list));
			}
			return;
		}

		for (int i = pos; i < arr.length; i++) {
			list.add(arr[i]);
			helper(res, list, arr, n - arr[i], i);
			list.remove(list.size() - 1);
		}
	}
}
