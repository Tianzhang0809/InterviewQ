public class FillZigZag {
	public static void main(String args[]) throws Exception {
		int n = 3;
		int[][] res = fillZigZag(n);
		print(res);
	}

	public static int[][] fillZigZag(int n) {// n >= 2
		int[][] res = new int[n][n];
		if (n <= 0) {
			return res;
		}

		int x = 0;
		int y = 0;
		int fill = 1;

		while (x < n) { // every time fill in two lines
			y = 0;
			for (int i = 0; i < n; i++) {
				res[x][y++] = fill++;
			}

			x++;

			if (fill == n * n + 1) {
				break;
			}

			y = n - 1;
			for (int i = 0; i < n; i++) {
				res[x][y--] = fill++;

			}
			// print(res);
			x++;
		}
		return res;
	}

	public static void print(int[][] matrix) {
		for (int[] arr : matrix) {
			for (int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

}
