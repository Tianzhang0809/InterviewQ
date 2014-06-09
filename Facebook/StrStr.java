package Facebook;

/**
 * return index instead of substring
 * 
 * @author oliviazhang
 * 
 */

public class StrStr {

	public static void main(String[] args) {
		String t = "abc";
		String s = "mmsdfabc";
		int res = strStr(t, s);
		System.out.println(res);

	}

	public static int strStr(String t, String s) { // find t in s
		if (s == null || t == null) {
			return -1;
		}
		if (t.length() == 0) {
			return 0;
		}

		int lent = t.length();

		for (int i = 0; i + lent <= s.length(); i++) {
			int k = i;
			int j = 0;
			while (k < s.length() && j < lent && s.charAt(k) == t.charAt(j)) {
				k++;
				j++;
			}

			if (j == lent) {
				return i;
			}
		}
		return -1;
	}

}
