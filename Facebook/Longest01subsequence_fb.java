package Facebook;
public class Longest01subsequence_fb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 1, 0, 0, 1, 1, 1, 0, 0, 0 };
		System.out.println(":::: " + longest(arr));
	}

	public static int longest(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				arr[i] = -1;
			}
		}

		int max = Integer.MIN_VALUE;
		for (int start = 0; start < arr.length; start++) {
			int sum = arr[start];
			for (int len = 1; start + len < arr.length; len++) {
				sum += arr[start + len];
				if (sum == 0 && len > max) { // reassign
					max = len;
				}
			}
		}
		return max + 1; // + 1
	}
}
