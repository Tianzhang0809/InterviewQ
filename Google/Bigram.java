package Google;

import java.util.ArrayList;
import java.util.Collections;

public class Bigram {

	public static void main(String[] args) {
		String s = "abcbc";
		ArrayList<String> res = getBiGram(s);
		System.out.println(res);

	}

	public static ArrayList<String> getBiGram(String s) {
		ArrayList<String> res = new ArrayList<String>();
		if (s == null || s.length() == 0) {
			return res;
		}

		int len = 2;
		for (int start = 0; start + len <= s.length(); start++) {
			String sub = s.substring(start, start + len);
			res.add(sub);
		}
		Collections.sort(res);
		return res;
	}
}
