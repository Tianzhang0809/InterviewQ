package GeeksforGeeks;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Median_in_streaming_integers {

	public static void main(String[] args) {
		int[] arr = { 15, 5, 1, 3, 16, 7 };
		trackMedian(arr);
	}

	public static void trackMedian(int[] arr) {
		int root = 0;
		int median;
		Queue<Integer> minHeap = new PriorityQueue<Integer>();
		Queue<Integer> maxHeap = new PriorityQueue<Integer>(10,
				new Comparator<Integer>() {
					public int compare(Integer a, Integer b) {
						return b - a;
					}
				});

		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				root = arr[i];
				median = arr[i];
			} else {
				if (arr[i] < root) { // place the new element in the right place
					maxHeap.offer(arr[i]);
				} else {
					minHeap.offer(arr[i]);
				}

				root = balance(maxHeap, minHeap, root); // calculate the root
				System.out.println(maxHeap + " " + root + " " + minHeap);

				int size = minHeap.size() + maxHeap.size() + 1;
				if (size % 2 != 0) { // calculate median
					median = root;
				} else {
					if (maxHeap.size() > minHeap.size()) {
						median = (maxHeap.peek() + root) / 2;
					} else {
						median = (minHeap.peek() + root) / 2;
					}
				}

			}
			System.out.println(median);
		}
	}

	private static int balance(Queue<Integer> maxHeap, Queue<Integer> minHeap,
			int root) {
		while (maxHeap.size() - minHeap.size() > 1) {
			minHeap.offer(root);
			root = maxHeap.poll();
		}

		while (minHeap.size() - maxHeap.size() > 1) {
			maxHeap.offer(root);
			root = minHeap.poll();
		}

		return root;
	}

}
