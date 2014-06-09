package Google;
/**
 * calculate the sum of intersect
 * 
 * @author oliviazhang
 * 
 */
public class Diagno_sum {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[] res = diagnoSum(matrix);
		for (int i : res) {
			System.out.print(i + " ");
		}
	}

	public static int[] diagnoSum(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return null;
		}

		int[] res = new int[matrix.length + matrix[0].length - 1];
		int count = 0;

		int start = 0;
		int end = res.length - 1;
		int mid = start + (end - start) / 2;

		for (int i = 0; i < matrix.length; i++) {
			int sum = 0;
			for (int j = 0; i + j < matrix.length; j++) {
				sum += matrix[i + j][j];
			}
			res[mid - count] = sum; // starting from middle and gradually move
									// on

			sum = 0;
			for (int j = 0; i + j < matrix.length; j++) {
				sum += matrix[j][i + j];
			}
			res[mid + count] = sum;
			count++;
		}
		return res;
	}
}
