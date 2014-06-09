import java.util.ArrayList;
import java.util.HashMap;

public class LongestChainOfConsecutiveInteger {
	public static void main(String args[]) throws Exception {
		int[][] matrix = { { 12, 3, 4 }, { 10, 8, 6 }, { 13, 11, 1 } };
		ArrayList<Integer> res = longestChainofconsecutiveInteger(matrix);
		System.out.println(res);
	}

	public static ArrayList<Integer> longestChainofconsecutiveInteger(
			int[][] matrix) {
		ArrayList<Integer> res = null;
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return res;
		}

		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		// initialize the map
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				map.put(matrix[i][j], false);
			}
		}

		for (int i : map.keySet()) {
			if (map.get(i) == true) { // has been visited
				continue;
			}

			int tmp = i;
			ArrayList<Integer> level = new ArrayList<Integer>();
			level.add(tmp);

			while (map.containsKey(tmp + 1)) {
				tmp += 1;
				level.add(tmp);
				map.put(tmp, true);
			}

			tmp = i;
			while (map.containsKey(tmp - 1)) {
				tmp -= 1;
				level.add(0, tmp);
				map.put(tmp, true);
			}

			if (res == null || res.size() < level.size()) {
				res = level;
			}
		}
		return res;

	}
}
