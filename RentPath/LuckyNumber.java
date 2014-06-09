package RentPath;
import java.util.ArrayList;

public class LuckyNumber {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
				17, 18, 19 };
		ArrayList<Integer> out = getLuckySet(arr);
		System.out.println(out);

	}

	public static ArrayList<Integer> getLuckySet(int[] arr) {
		if (arr == null || arr.length == 0) {
			return null;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (i % 2 != 0) {
				continue;
			} else {
				list.add(arr[i]);
			}
		}

		for (int i = 0; i < list.size(); i++) {
			if (i != 0 && i % 2 == 0) {
				list.remove(i);
			}
		}

		return list;
	}

}
