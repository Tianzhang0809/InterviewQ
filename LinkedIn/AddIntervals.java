package LinkedIn;

/**
 * given a list of interval, merge them and return the sum of interval length
 * e.g. [1,5] [2,6] [8,9] => [1,6], [8,9], output 6
 * 
 */

import java.util.ArrayList;
import java.util.Collections;

public class AddIntervals {
	public static void main(String[] args) {
		int[] i1 = { 1, 5 };
		int[] i2 = { 2, 10 };
		int[] i3 = { 8, 9 };

		ArrayList<int[]> list = new ArrayList<int[]>();
		list.add(i1);
		list.add(i3);
		list.add(i2);

		int res = addIntervals(list);
		System.out.println(res);

	}

	public static int addIntervals(ArrayList<int[]> list) {
		if (list == null || list.size() == 0) {
			return -1;
		}

		Collections.sort(list, new ListCom());
		int len = list.get(0)[1] - list.get(0)[0];
		int[] prev = list.get(0);

		for (int i = 1; i < list.size(); i++) {
			int[] curr = list.get(i);
			if (curr[0] < prev[1]) { // there is overlap
				int tmp = curr[1] - prev[1];
				if (tmp > 0) {
					len += tmp;
					prev[1] = curr[1];
				}
			} else { // no overlap
				len += curr[1] - curr[0];
				prev = curr;
			}
		}
		return len;

	}
}
