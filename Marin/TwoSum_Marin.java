package Marin;
import java.util.HashMap;

public class TwoSum_Marin {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 4, 5 };
		int[] res = findSum(arr, 6);
		for (int i : res) {
			System.out.print(i + " ");
		}
	}

	// [1, 2, 4, 5] target = 6
	// [0, 3]

	public static int[] findSum(int[] arr, int target) {
		if (arr == null || arr.length < 2) {
			return null;
		}

		int[] res = new int[2];
		HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
		// initialize the hashmap
		for (int i = 0; i < arr.length; i++) {
			if (hs.containsKey(arr[i])) { //
				continue;
			}
			hs.put(arr[i], i);
		}

		for (int i = 0; i < arr.length; i++) {
			if (hs.containsKey(target - arr[i])) {
				int index1 = i;
				int index2 = hs.get(target - arr[i]);
				if (index1 == index2) { // same number
					continue;
				}
				res[0] = index1;
				res[1] = index2;
				return res;
			}
		}

		return res;
	}

}
