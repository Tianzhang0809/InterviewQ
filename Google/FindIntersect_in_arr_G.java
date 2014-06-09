package Google;
import java.util.ArrayList;

public class FindIntersect_in_arr_G {
	public static void main(String[] args) {
		int[] arr1 = { 2, 3, 4 };
		int[] arr2 = { 1, 2, 3, 5 };
		ArrayList<Integer> res = findIntersection(arr1, arr2);
		System.out.println(res);
	}

	public static ArrayList<Integer> findIntersection(int[] arr1, int[] arr2) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (arr1 == null || arr2 == null) {
			return res;
		}
		if (arr1.length > arr2.length) {
			return findIntersection(arr2, arr1);
		}

		int m = 0;
		int n = 0;

		while (m < arr1.length && n < arr2.length) {
			if (arr1[m] < arr2[n]) {
				m++;
			} else if (arr1[m] > arr2[n]) {
				n++;
			} else {
				res.add(arr1[m]);
				m++;
				n++;
			}
		}

		return res;
	}

}
