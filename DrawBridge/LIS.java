package DrawBridge;

import java.util.Arrays;

public class LIS {

	public static void main(String[] args) {
		int[] candidates = { 5, 5, 5, 9, 2, 7 };
		int res = lis(candidates);
		System.out.println(res);
	}

	public static int lis(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}

		int[] steps = new int[arr.length];
		Arrays.fill(steps, 1);
		int max = 0;

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] <= arr[i] && steps[j] + 1 > steps[i]) {
					System.out.println(arr[j] + " " + arr[i]);
					steps[i] = steps[j] + 1;
					if (steps[i] > max) {
						max = steps[i];
					}
				}
			}
		}
		return max;
	}
}
