public class LongestSubstring_withTwoUniqueChar {
	public static void main(String args[]) throws Exception {
		String s = "DCABBBBBBACCC";
		String out = longestSubstring(s);
		System.out.println(out);
	}

	public static String longestSubstring(String s) {
		if (s == null || s.length() < 2) {
			return s;
		}

		int start = 0;
		int i = 1;

		// find the first letter that is not equal to the first one
		while (i < s.length() && s.charAt(start) == s.charAt(i)) {
			i++;
			if (i == s.length()) {
				return s;
			}
		}

		int[] res = new int[2];
		res[0] = s.charAt(start);
		res[1] = s.charAt(i);
		int lastGroupStart = 0;

		String longest = "";

		while (i < s.length()) {
			if (s.charAt(i) == res[0] || s.charAt(i) == res[1]) {
				if (s.charAt(i) != s.charAt(i - 1)) {
					lastGroupStart = i;
				}
			} else {
				String sub = s.substring(start, i);
				if (sub.length() > longest.length()) {
					longest = sub;
				}
				start = lastGroupStart;
				lastGroupStart = i;
				res[0] = s.charAt(start);
				res[1] = s.charAt(lastGroupStart);
			}

			i++;
		}
		return longest;
	}
}
