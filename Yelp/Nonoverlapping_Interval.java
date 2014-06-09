package Yelp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * given an array of intervals, return max number of non-overlapping intervals
 * 
 * e.g. [[2,4], [1,3], [5,6]] --> [[5,6]]
 * 
 * @author oliviazhang
 * 
 */
public class Nonoverlapping_Interval {

	public static void main(String[] args) {
		ArrayList<int[]> list = new ArrayList<int[]>();
		list.add(new int[] { 2, 4 });
		list.add(new int[] { 1, 3 });
		list.add(new int[] { 5, 6 });
		list.add(new int[] { 8, 9 });

		ArrayList<int[]> res = getNonOverlappingIntervals_sorted(list);
		for (int[] arr : res) {
			System.out.println(arr[0] + " " + arr[1]);
		}
	}

	public static ArrayList<int[]> getNonOverlappingIntervals_sorted(
			ArrayList<int[]> list) {
		ArrayList<int[]> res = new ArrayList<int[]>();
		if (list == null || list.size() == 0) {
			return res;
		}
		Collections.sort(list, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[0] - b[0];
			}
		});

		int[] first = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			int[] curr = list.get(i);
			if (first[1] >= curr[0]) { // there is overlap
				first[1] = Math.max(first[1], curr[1]);
			} else {
				res.add(curr);
				first = curr;
			}
		}
		return res;
	}

}
