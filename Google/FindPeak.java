package Google;

public class FindPeak {
	/**
	 * return the index of peak element
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 2, 7, 8, 9 };
		System.out.println(findPeak(arr));

	}

	public static int findPeak(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}

		if (arr.length == 1) {
			return arr[0];
		}

		if (arr.length == 2) {
			return Math.min(arr[0], arr[1]);
		}

		return findPeak(arr, 0, arr.length - 1);
	}

	public static int findPeak(int[] arr, int start, int end) {
		int mid = start + (end - start) / 2;
		if ((mid == 0 || arr[mid - 1] <= arr[mid])
				&& (mid == arr.length - 1 || arr[mid + 1] <= arr[mid])) {
			return mid;
		}

		if (mid > 0 && arr[mid] < arr[mid - 1]) {
			return findPeak(arr, start, mid - 1);
		}

		return findPeak(arr, mid + 1, end);

	}
}
