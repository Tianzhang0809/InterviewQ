package Google;

/**
 * given a decimal -> twenty six
 * 
 * @author oliviazhang
 * 
 */

public class TenToTwentySix {

	public static void main(String[] args) {
		for (int i = 0; i < 300; i++) {
			System.out.println(i + ": " + transfer(i));
		}

	}

	/**
	 * my way for doing it
	 * 
	 * @param n
	 * @return
	 */
	public static String transfer(int n) {
		char[] arr = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
				'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
				'X', 'Y', 'Z' };

		String s = "";

		while (n > 0) {
			if (n % 26 == 0) {
				s = 'Z' + s;
				n /= 27;
			} else {
				s = arr[n % 26 - 1] + s;
				n /= 26;
			}
		}

		return s;
	}

	public static String toNumberSystem26(int n) {
		String s = "";
		while (n > 0) {
			int m = n % 26;
			if (m == 0) {
				m = 26;
			}
			s = (char) (m + 64) + s;
			n = (n - m) / 26;
		}
		return s;
	}
}
