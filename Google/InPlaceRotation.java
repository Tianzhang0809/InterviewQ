package Google;


public class InPlaceRotation {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		inPlaceRotationByK(arr, 7);
		for (int i : arr) {
			System.out.print(i + " ");
		}

	}

	public static void inPlaceRotationByK(int[] arr, int k) {
		k = k % arr.length;
		int[] bu = new int[arr.length];
		// copy
		for (int i = 0; i < arr.length; i++) {
			bu[i] = arr[i];
		}

		for (int i = k; i < arr.length + k; i++) {
			arr[i % arr.length] = bu[i - k];
		}
	}

}
