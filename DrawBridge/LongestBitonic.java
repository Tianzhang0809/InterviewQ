package DrawBridge;

public class LongestBitonic {

	public static void main(String[] args) {
		int[] arr = { 1, 9, 2, 100, 3, 11, 4, 8, 6, 4 };
		System.out.println(longestBitonic(arr));

	}

	public static int longestBitonic(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}

		int[] temp1 = new int[arr.length]; // for increasing
		int[] temp2 = new int[arr.length]; // for decreasing
		// String[] arr1 = new String[arr.length];
		// String[] arr2 = new String[arr.length];

		// initialize
		for (int i = 0; i < arr.length; i++) {
			temp1[i] = 1;
			temp2[i] = 1;
			// arr1[i] = arr[i] + " ";
			// arr2[i] = arr[i] + " ";
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && temp1[i] < temp1[j] + 1) {
					temp1[i] = temp1[j] + 1;
					// arr1[i] = arr1[j] + arr[i] + " ";
				}
			}
		}

		for (int i = arr.length - 2; i >= 0; i--) {
			for (int j = arr.length - 1; j > i; j--) {
				if (arr[i] > arr[j] && temp2[i] < temp2[j] + 1) {
					temp2[i] = temp2[j] + 1;
					// arr2[i] = arr2[j] + arr[i] + " ";
				}
			}
		}

		int max = 0;
		// print(arr1);
		// print(arr2);
		for (int i = 0; i < arr.length; i++) {
			int tmp = temp1[i] + temp2[i];
			if (tmp > max) {
				max = tmp;
			}
		}
		return max - 1; // add the bitonic point twice, we want to deduct by one
	}

	public static void print(String[] arr) {
		for (String ss : arr) {
			System.out.print(ss + ", ");
		}
		System.out.println();
	}
}
