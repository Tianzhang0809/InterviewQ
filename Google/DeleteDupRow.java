package Google;

import java.util.ArrayList;

/**
 * Eliminate duplicated bit arrays Given a binary matrix of N X N of integers ,
 * you need to return only unique rows of binary arrays
 * 
 * @author oliviazhang
 * 
 */
public class DeleteDupRow {

	public static void main(String[] args) {
		int[][] m = { { 0, 1, 0, 0, 1 }, { 1, 0, 1, 1, 0 }, { 0, 1, 0, 0, 1 },
				{ 0, 1, 0, 0, 1 } }; // return two lines
		ArrayList<int[]> res = deleteDuprows(m);

		for (int[] arr : res) {
			for (int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	public static ArrayList<int[]> deleteDuprows(int[][] matrix) {
		ArrayList<int[]> res = new ArrayList<int[]>();
		// check null
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return res;
		}

		int checker = 0;
		for (int[] arr : matrix) {
			int hashvalue = getHash(arr);
			if ((checker & (1 << hashvalue)) > 0) { // duplicated row
				continue;
			} else {
				checker |= (1 << hashvalue);
				res.add(arr);
			}
		}
		return res;
	}

	public static int getHash(int[] arr) {
		int res = 0;
		int count = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			res += arr[i] * Math.pow(2, count++); // calculate the number value
		}
		return res;
	}
}
