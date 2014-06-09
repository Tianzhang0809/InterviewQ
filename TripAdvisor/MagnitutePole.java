package TripAdvisor;
public class MagnitutePole {

	public static void main(String[] args) {
		int[] arr = { 4, 2, 2, 3, 1, 4, 7, 8, 6, 9 };
		int i = magnitude(arr);
		System.out.println(i);
	}

	public static int magnitude(int[] arr) {
		if (arr == null || arr.length == 0) {
			return -1;
		}

		int[] left = new int[arr.length];
		int[] right = new int[arr.length];

		// left -> right, record max
		left[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			left[i] = Math.max(left[i - 1], arr[i]);
		}

		// right -> left, record min
		right[arr.length - 1] = arr[arr.length - 1];
		for (int i = arr.length - 2; i >= 0; i--) {
			right[i] = Math.min(right[i + 1], arr[i]);
		}

		for (int i = 0; i < arr.length; i++) {
			if (left[i] == right[i]) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * logistic
	 * 
	 * 
	 * @param arr
	 */
	public static void print(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
