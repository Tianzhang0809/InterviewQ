package DrawBridge;

import java.util.ArrayList;

public class LongestDecreasingSubsequence {

	public static void main(String[] args) {
		int[] arr = { 10, 7, 9, 2, 2, 5, 4, 2, 9, 0 };

		ArrayList<Integer> list = longestDecreSub(arr);
		System.out.println(list);
	}

	public static ArrayList<Integer> longestDecreSub(int[] arr) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (arr == null || arr.length == 0) {
			return res;
		}

		int i, j, max = 0;

		int[] steps = new int[arr.length];
		String[] str_arr = new String[arr.length];

		// initialize
		for (i = 0; i < arr.length; i++) {
			steps[i] = 1;
			str_arr[i] = arr[i] + " ";
		}

		for (i = 1; i < arr.length; i++) {
			for (j = 0; j < i; j++) {
				if (arr[i] < arr[j] && steps[i] < steps[j] + 1) {
					steps[i] = steps[j] + 1;
					str_arr[i] = str_arr[j] + arr[i] + " ";
					if (steps[i] > max) {
						max = steps[i];
					}
				}
			}
		}

		System.out.println(max);
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (i = 0; i < arr.length; i++) {
			if (steps[i] == max) {
				String[] s = str_arr[i].split(" ");
				for (String ss : s) {
					list.add(Integer.valueOf(ss));
				}
			}
		}
		return list;
	}
}
