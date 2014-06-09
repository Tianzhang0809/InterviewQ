package Google;
public class Shuffle_G {
	public static void main(String[] args) {
		int[] arr = { 2, 1, 4, 8, 3, 5, 7 };
		shuffle(arr);
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		shuffle2(arr);
		for (int i : arr) {
			System.out.print(i + " ");
		}

	}

	/**
	 * brute force O(n)
	 * 
	 * @param A
	 */

	public static void shuffle2(int[] A) {
		if (A == null || A.length == 0) {
			return;
		}

		for (int i = 1; i < A.length; i++) {
			if (i % 2 != 0 && A[i] < A[i - 1]) {
				swap(A, i, i - 1);
			}
			if (i % 2 == 0 && A[i] > A[i - 1]) {
				swap(A, i, i - 1);
			}
		}
	}

	public static void shuffle(int[] A) {
		if (A == null || A.length == 0) {
			return;
		}
		int n = A.length;

		int increase = 1;
		for (int i = 1; i < n; i++) {
			int local = (A[i] >= A[i - 1]) ? 1 : 0;
			// increase = 1, decrease = 0
			if (increase != local) {
				swap(A, i, i - 1);
			}
			increase ^= 1; // flip everytime
		}
	}

	public static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	/**
	 * public static void shuffle(int[] A) { if (A == null || A.length == 0) {
	 * return; }
	 * 
	 * boolean flag = true; for (int i = 1; i < A.length; i++) { if (A[i] >= A[i
	 * - 1] && !flag) { swap(A, i, i - 1); } flag = !flag; } }
	 * 
	 * public static void swap(int[] arr, int i, int j) { int tmp = arr[i];
	 * arr[i] = arr[j]; arr[j] = tmp; }
	 */
}
