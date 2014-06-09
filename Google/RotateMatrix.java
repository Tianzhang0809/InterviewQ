package Google;
public class RotateMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		for (int[] arr : matrix) {
			for (int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		System.out.println();
		rotate(matrix);
		for (int[] arr : matrix) {
			for (int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	// in place change
	public static void rotate(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return;
		}

		for (int layer = 0; layer < matrix.length / 2; layer++) { // only half
																	// of layers
																	// should be
																	// checked
			int first = layer;
			int last = matrix.length - first - 1;

			for (int i = first; i < last; i++) { // search should be between
													// first and last
				// we dont want to include last here bcoz last is the first for
				// next direction

				int offset = i - first;

				// save top
				int top = matrix[first][i];
				// left to top
				matrix[first][i] = matrix[last - offset][first];
				// bottom to left
				matrix[last - offset][first] = matrix[last][last - offset];
				// right to bottm
				matrix[last][last - offset] = matrix[i][last];
				matrix[i][last] = top;

			}
		}

	}
}
