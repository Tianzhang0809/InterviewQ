package Google;

/**
 * find the longest substring that only contains two distinct ASCII characters
 * 
 * @author oliviazhang
 * 
 */
public class LongestSubstrWith2DistinctASCII {

	public static void main(String[] args) {
		String s = "DCABBBBBBACCC";
		String res = longestSub(s);
		System.out.println(res);

	}

	public static String longestSub(String str) {
		if (str == null || str.length() == 0) {
			return str;
		}

		char prev = str.charAt(0);
		StringBuilder sb = new StringBuilder(prev);
		String res = "";
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			char c = str.charAt(i);
			if (sb.toString().contains(c + "")) {
				sb.append(c); // legal character, just add
			} else if (!sb.toString().contains(c + "") && count < 2) { // first
																		// different
																		// character
				sb.append(c);
				count++;
			} else if (!sb.toString().contains(c + "") && count == 2) { // the
																		// third
																		// unique
																		// character
				if (sb.length() > res.length()) {
					res = sb.toString(); // test if the current string is longer
											// --> if yes then replace
				}

				char tmp = sb.charAt(0); // remove the initial first character
				while (sb.length() > 0 && sb.charAt(0) == tmp) { // using while
																	// loop here
					sb.deleteCharAt(0);
				}

				sb.append(c); // append the current character (to be the second
								// unique in the string)
				count = 1;
			}
		}
		return res;
	}
}
