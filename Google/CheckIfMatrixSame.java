package Google;

/**
 * Given a 2D rectangular matrix of boolean values, write a function which
 * returns whether or not the matrix is the same when rotated 180 degrees.
 * 
 * @author oliviazhang
 * 
 */
public class CheckIfMatrixSame {

	public static void main(String[] args) {
		boolean[][] m = { { true, false, false, true },
				{ false, true, true, false }, { false, true, true, false },
				{ true, false, false, true } };

		boolean res = checkSame(m);
		System.out.println(res);
	}

	public static boolean checkSame(boolean[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0
				|| matrix.length != matrix[0].length) {
			return false;
		}
		int n = matrix.length;

		for (int layer = 0; layer <= n / 2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i <= last; i++) {
				int offset = i - first;
				if (matrix[last - offset][first] != matrix[first][i]) {
					return false;
				}
				if (matrix[last][last - offset] != matrix[last - offset][first]) {
					return false;
				}
				if (matrix[i][last] != matrix[last][last - offset]) {
					return false;
				}
				if (matrix[first][i] != matrix[i][last]) {
					return false;
				}
			}
		}

		return true;
	}
}
