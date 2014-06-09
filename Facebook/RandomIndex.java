package Facebook;

import java.util.Arrays;
import java.util.Random;

/**
 * given an array, randomly generate the index of largest number
 * 
 * e.g. [1,2,3,4,5,6,6,6] -> randomly generate index 5,6,7
 * 
 * @author oliviazhang
 * 
 */
public class RandomIndex {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 6, 6 };
		System.out.println(randomIndex(arr));

	}

	public static int randomIndex(int[] arr) {
		if (arr == null || arr.length == 0) {
			return -1;
		}

		Arrays.sort(arr);
		int end = arr.length - 1;
		int start = end;
		while (start >= 0 && arr[start] == arr[end]) {
			start--;
		}

		int len = end - start; // length of dup biggest number
		Random r = new Random();
		return (int) (arr.length - r.nextDouble() * len); // !!!
	}
}
