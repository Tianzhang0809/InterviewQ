package Facebook;

/**
 * Given an integer array, put all non zero to the left
 * 
 * -fewer the number of change of manipulation
 * 
 * -whatever on the right side
 * 
 * return the number of nonzero element
 * 
 * @author oliviazhang
 * 
 */
public class ManipulateIntArray {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 6, 0, 3, 6, 0, 2, 4 };
		int res = sortColorImproved(arr);
		System.out.println(res);
		for (int i : arr) {
			System.out.print(i + " ");
		}
		// System.out.println();
		// System.out.println(count);
	}

	public static int sortColorImproved(int[] arr) {
		// check null
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int right = arr.length - 1;
		int i = 0;
		while (i <= right) {
			if (arr[i] == 0) {
				int tmp = arr[i];
				arr[i] = arr[right];
				arr[right] = tmp;
				right--;
			} else {
				i++;
			}
		}
		return i;
	}

	public static int sortColorSimilar(int[] arr) {
		// check null
		if (arr == null || arr.length == 0) {
			return 0;
		}
		// loop through the array and swap place
		int left = 0, i = 0;
		int right = arr.length - 1;

		while (i <= right) {
			if (arr[i] != 0) {
				if (left != i) {
					swap(arr, left, i);
				}
				left++;
				i++;
			} else if (arr[i] == 0) {
				if (right != i) {
					swap(arr, right, i);
				}
				right--;
			} else {
				i++;
			}
		}
		return i;
	}

	private static int count = 0;

	public static void swap(int[] arr, int i, int j) {
		count++;
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}
