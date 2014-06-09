package Google;
public class BinarySearch_G {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 2, 2, 3, 4, 5, 5, 6, 10, -1, -1, -1, -1, -1 };
		int target = 10;
		boolean out = isIn(arr, target);
		System.out.println(out);
	}

	/**
	 * pure binary search, inspired from Qiu's mock interview
	 * 
	 * @param arr
	 * @param t
	 * @return
	 */
	public static boolean isIn(int[] arr, int t) {
		if (arr == null || arr.length == 0) {
			return false;
		}

		int start = 0;
		int end = arr.length;

		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] == t) {
				return true;
			} else if (arr[mid] > t || arr[mid] == -1) {
				end = mid;
			} else {
				start = mid;
			}
		}

		if (arr[start] == t || arr[end] == t) {
			return true;
		}
		return false;
	}

	public static boolean isInArrayThatLengthNotSure(int[] arr, int target) {
		// array is sorted
		if (arr == null || arr.length == 0) {
			return false;
		}

		// find the right boundary
		int start = 0;
		int end = 1;
		while (end < arr.length && target >= arr[end]) { // must be inclusive
			end *= 2;
		}

		while (end >= arr.length) { // reduce the right boundary
			end--;
		}
		while (arr[end] == -1) { // move backwards to find the true boundary
			end--;
		}

		// go normal binary search
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] == target) {
				return true;
			} else if (arr[mid] < target) {
				start = mid;
			} else {
				end = mid;
			}
		}

		if (arr[start] == target || arr[end] == target) {
			return true;
		}

		return false;
	}

}
