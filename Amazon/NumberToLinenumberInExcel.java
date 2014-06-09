package Amazon;

/**
 * given a number, transfer it to the line number in excel
 * 
 * e.g. A - Z: 1 - 26, AA 27, AB 28
 * 
 * @author oliviazhang
 * 
 */
public class NumberToLinenumberInExcel {

	public static void main(String[] args) {
		// for (int i = 0; i < 300; i++) {
		System.out.println(ToNumberSystem26(27));
		System.out.println(FromNumberSystem26("AA"));

	}

	public static String ToNumberSystem26(int n) {
		String res = "";
		int m = 0;
		while (n > 0) {
			m = n % 26;
			if (m == 0) {
				m = 26;
			}

			res = (char) (64 + m) + res;
			n = (n - m) / 26;
		}
		return res;
	}

	public static int FromNumberSystem26(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int len = s.length();
		int res = 0;

		for (int i = 0; i < len; i++) {
			int n = s.charAt(i) - 64;
			res += n * Math.pow(26, len - 1 - i);
		}
		return res;
	}

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
}
