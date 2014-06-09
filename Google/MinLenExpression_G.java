package Google;

public class MinLenExpression_G {
	public static void main(String[] args) {
		int n = 41;
		int out = findMinLen(n);
		System.out.println(out);
	}

	public static int findMinLen(int n) {
		int i = 1;
		int[] f = new int[n + 1];
		while (i * i < n) {
			f[i] = 1;
			i += 1;
		}

		for (i = 1; i <= n; i++) {
			int tmp_min = i;
			int j = 1;
			while (j * j <= i) {
				int tmp = f[i - j * j] + 1;
				tmp_min = Math.min(tmp, tmp_min);
				j++;
			}

			f[i] = tmp_min;
		}
		return f[n];
	}

	public static void print(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
