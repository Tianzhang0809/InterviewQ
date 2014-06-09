package Amazon;

/**
 * 
 * Count the number of negative numbers in a matrix looks like this
 * 
 * up is bigger than down, left is bigger than right
 * 
 * [ [-2, -1, 0, 1], [-1, 0, 1, 1], [1, 2, 3, 4] ]
 * 
 * @author oliviazhang
 * 
 */
public class CountNegInMatrix {

	public static void main(String[] args) {
		int[][] m = { { -2, -1, 0, 1 }, { -1, 0, 1, 1 }, { 1, 2, 3, 4 } };
		System.out.println(countNegNumber(m));
	}

	/**
	 * worst case nlog(n)
	 * 
	 * @param matrix
	 * @return
	 */
	public static int countNegNum_Binary(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}

		int res = 0;

		for (int[] arr : matrix) {
			res += binarySearch(arr);
		}
		return res;
	}

	public static int binarySearch(int[] arr) {
		int start = 0;
		int end = arr.length - 1;

		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] == 0) {
				end = mid;
			} else if (arr[mid] > 0) {
				end = mid - 1;
			} else {
				start = mid;
			}

		}

		if (arr[end] < 0) {
			return end + 1;
		}

		if (arr[start] < 0) {
			return start + 1;
		}

		return 0;
	}

	/**
	 * worst case is n**2
	 * 
	 * @param matrix
	 * @return
	 */
	public static int countNegNumber(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}

		int m = matrix.length;
		int n = matrix[0].length;
		int count = 0;
		for (int i = 0; i < n; i++) { // for every column
			for (int j = 0; j < m; j++) {
				if (matrix[j][i] >= 0) {
					break;
				}
				count++;
			}
		}
		return count;
	}
}
