package Spokeo;
import java.util.PriorityQueue;
import java.util.Queue;

// maintain a data structure so that we can always keep the 10 minimum number
public class PriorityQueue_spokeo {

	public static void main(String[] args) {
		// self defined pq
		int[] arr = { 10, 9, 8, 3, 4, 5, 6, 7, 1, 2, 11, 13, 12, 14, 15 };
		int[] min = getTenMin(arr);
		for (int i : min) {
			System.out.print(i + " ");
		}
		System.out.println();
		int[] max = getTenMax(arr);
		for (int i : max) {
			System.out.print(i + " ");
		}

	}

	// get 10 max number
	public static int[] getTenMax(int[] arr) {
		if (arr == null || arr.length <= 10) {
			return arr;
		}

		int[] res = new int[10];
		Queue<Integer> q = new PriorityQueue<Integer>(10);
		for (int i : arr) {
			if (q.size() == 10) {
				int tmp = q.poll();
				q.offer(Math.max(tmp, i)); // the only difference...
			} else {
				q.offer(i);
			}
		}

		int index = 0;
		while (index < 10) {
			res[index++] = q.poll();
		}

		return res;
	}

	// get 10 minimum number
	public static int[] getTenMin(int[] arr) {
		if (arr == null || arr.length <= 10) {
			return arr;
		}

		int[] res = new int[10];
		Queue<Integer> q = new PriorityQueue<Integer>(10);
		for (int i : arr) {
			if (q.size() == 10) {
				int tmp = q.poll();
				q.offer(Math.min(tmp, i));
			} else {
				q.offer(i);
			}
		}

		int index = 0;
		while (index < 10) {
			res[index++] = q.poll();
		}

		return res;
	}

}
