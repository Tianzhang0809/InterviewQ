package Amazon;

import java.util.HashMap;

public class LongestRepSub {
	public static void main(String[] args) {
		String s = "abcabcaacb";
		String res = getlongestRepSub(s);
		System.out.println(res);
	}

	public static String getlongestRepSub(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int len = s.length(); len >= 1; len--) {
			for (int start = 0; start + len <= s.length(); start++) {
				String sub = s.substring(start, start + len);

				if (!map.containsKey(sub)) {
					map.put(sub, 1);
				} else {
					return sub;
				}
			}
		}
		return null;
	}
}
