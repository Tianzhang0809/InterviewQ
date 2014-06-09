package Amazon;
public class Amazon1 {

	public static void main(String[] args) {
		System.out.println(solution(5, 3, -1, 5));

	}

	public static int solution(int A, int B, int C, int D) {
		// the increasing rank for A B C D is 1, 3, 0, 2 where 1 is the largest
		int[] arr = sortFour(A, B, C, D);
		return Math.abs(arr[1] - arr[3]) + Math.abs(arr[3] - arr[0])
				+ Math.abs(arr[0] - arr[2]);
	}

	public static int[] sortFour(int a, int b, int c, int d) {
		int[] arr = { a, b, c, d };
		if (a > b) {
			swap(arr, 0, 1);
		}
		if (c > d) {
			swap(arr, 2, 3);
		}
		if (a > c) {
			swap(arr, 0, 2);
		}
		if (b > d) {
			swap(arr, 1, 3);
		}
		if (b > c) {
			swap(arr, 1, 2);
		}
		return arr;
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
