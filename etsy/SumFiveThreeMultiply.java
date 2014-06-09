package etsy;
/**
 * Sum multiples of 3 and 5
 * 
 * @author oliviazhang
 *
 */

public class SumFiveThreeMultiply {

	public static void main(String[] args) {
		int out = sumZero_Recur(100);
		System.out.println(sum);

	}

	/**
	 * using recursion
	 */

	private static int sum = 0;

	public static int sumZero_Recur(int end) { // 1- 1000
		if (end < 3) {
			return 0;
		}
		if (end % 3 == 0 || end % 5 == 0) {
			sum += end;
		}
		return sumZero_Recur(end - 1);
	}

	/**
	 * not using mod if start and end are given e.g. 1 ~ 1000
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static int sumZero1(int start, int end) {
		if (start > end) {
			return 0;
		}
		if (start == end && (start % 5 == 0 || start % 3 == 0)) {
			return start;
		}

		int bigestThree = findBigest(end, 3);
		int bigestFive = findBigest(end, 5);
		int bigestThreeAFive = findBigest(end, 15);

		bigestThree /= 3;
		bigestFive /= 5;
		bigestThreeAFive /= 15;
		return 3 * (1 + bigestThree) * bigestThree / 2 + 5 * (1 + bigestFive)
				* bigestFive / 2 - 15 * (1 + bigestThreeAFive)
				* bigestThreeAFive / 2;

	}

	public static int findBigest(int end, int mul) {
		while (end > 0) {
			if (end % mul == 0) {
				return end;
			}
			end--;
		}
		return -1;
	}

	/**
	 * using mod
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static int sumZero2(int start, int end) { // for scalable purpose
		if (start > end) {
			return 0;
		}
		if (start == end && (start % 5 == 0 || start % 3 == 0)) {
			return start;
		}
		int sum = 0;
		for (int i = start; i <= end; i++) {
			if (i % 3 == 0 || i % 5 == 0) {
				sum += i;
			}
		}
		return sum;
	}
}
