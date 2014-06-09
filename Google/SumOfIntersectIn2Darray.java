package Google;

/**
 * 
 * [[1,2,3],
 * 
 * [4,5,6],
 * 
 * [7,8,9]]
 * 
 * sum = {7, 12, 15, 8, 3};
 * 
 * @author oliviazhang
 * 
 */
public class SumOfIntersectIn2Darray {

	public static void main(String[] args) {
		int[][] m = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[] res = sumOfMatrixIntersect_good(m);
		for (int i : res) {
			System.out.print(i + " ");
		}

	}

	/**
	 * left down to right up
	 * 
	 * 7 12 15 8 3
	 * 
	 * @param matrix
	 * @return
	 */
	public static int[] sumOfMatrixIntersect_good(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int dia = m + n - 1;

		int index = m - 1;
		int[] res = new int[dia];

		for (int i = m - 1; i >= 0; i--) {
			for (int j = 0; j < n; j++) {
				res[index + j - i] += matrix[i][j];
			}
		}
		return res;

	}

	/**
	 * left up to right down
	 * 
	 * 1 6 15 14 9
	 * 
	 * @param matrix
	 * @return
	 */
	public static int[] sumOfMatrixIntersect_good2(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int dia = m + n - 1;

		int index = 0;
		int[] res = new int[dia];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				res[index + j - i] += matrix[i][j];
			}
			index += 2;
		}
		return res;

	}

	// //////////////////////////////////
	/**
	 * left down to right up
	 * 
	 * @param matrix
	 * @return
	 */
	public static int[] sumOfMatrixIntersect(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int dia = m + n - 1;

		int offset = m - 1;
		int[] res = new int[dia];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int tmp = offset + (j - i);
				res[tmp] += matrix[i][j];
			}
		}
		return res;

	}

}
