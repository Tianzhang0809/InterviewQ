package Google;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * given an array find the k biggest numbers
 * 
 * @author oliviazhang
 * 
 */
public class KMostfrequentNum {

	public static void main(String[] args) {
		int[] arr = { 10, 9, 10, 6, 7, 11, 12 };
		ArrayList<Integer> res = findkLargest2(arr, 4);
		System.out.println(res);

	}

	public static ArrayList<Integer> findkLargest2(int[] arr, int k) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (arr == null || arr.length < k) {
			return res;
		}

		quicksort(arr, 0, arr.length - 1);

		int pointer = arr.length - 1;
		while (k > 0) {
			if (!res.contains(arr[pointer])) {
				res.add(arr[pointer]);
				k--;
			}
			pointer--;
		}

		return res;
	}

	public static void quicksort(int[] arr, int low, int high) {
		int i = low, j = high;
		int pivot = arr[low + (high - low) / 2];

		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}

			while (arr[j] > pivot) {
				j--;
			}

			if (i <= j) {
				swap(arr, i, j);
				i++;
				j--;
			}
		}

		// recursion
		if (low < j) {
			quicksort(arr, low, j);
		}
		if (i < high) {
			quicksort(arr, i, high);
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	/**
	 * using priority queue
	 * 
	 * @param arr
	 * @param k
	 * @return
	 */
	public static ArrayList<Integer> findkLargest(int[] arr, int k) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (arr == null || arr.length < k) {
			return res;
		}

		PQsort pq2 = new PQsort();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, pq2);
		for (int i : arr) {
			pq.offer(i);
		}

		for (int i = 0; i < k; i++) {
			res.add(pq.poll());
		}

		return res;
	}

	private static class PQsort implements Comparator<Integer> {
		public int compare(Integer one, Integer two) {
			return two - one;
		}
	}
}
