package Twitter;

/**
 * given an integer array, you can go i + arr[i] steps for one time if out of
 * bound, you stop. return the number of coordinates that you cannot reach
 * 
 * @author oliviazhang
 * 
 */
public class ArrayDistance {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5 };
		System.out.println(cannotReach(arr));

	}

	public static int cannotReach(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}

		boolean[] can = new boolean[arr.length];
		can[0] = true;

		for (int i = 0; i < arr.length; i++) {
			if (!can[i]) { // if cannot start from current pos - > continue
				continue;
			}

			int next = i + arr[i];
			if (next >= arr.length) {
				break;
			} else if (can[next]) { // the goal has been reached
				continue;
			} else {
				can[next] = true; // assign true
			}
		}

		int count = 0;
		for (int i = 0; i < can.length; i++) {
			if (can[i]) {
				count++;
			}
		}
		return count;
	}

}
