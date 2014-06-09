package Amazon;

/**
 * given an array return the smallest number within 3 steps
 * 
 * e.g. [1,2,3,4,0,1,2] ==> [1,2,0,0,0,1,2];
 * 
 * @author oliviazhang
 * 
 */

public class SmallestNumberInThree {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 0, 1, 2 };
		int[] res = smallest(arr);
		for (int i : res) {
			System.out.print(i + " ");
		}

	}

	public static int[] smallest(int[] arr) {
		if (arr == null || arr.length == 0) {
			return arr;
		}

		for (int i = 0; i < arr.length - 3; i++) {
			arr[i] = Math.min(Math.min(arr[i], arr[i + 1]), arr[i + 2]);
		}

		return arr;
	}

}
