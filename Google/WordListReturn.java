package Google;

import java.util.ArrayList;

//given a string array if there is space in " " need to return as a word
// e.g. I    have a "faux coat" ==> [I, have, a, faux coat]

public class WordListReturn {

	public static void main(String[] args) {
		String s = "I  want to fuck \"fat bird tian tian\" lo \"last but not least\"";
		ArrayList<String> res = split(s);
		System.out.println(res);

	}

	public static ArrayList<String> split(String s) {
		ArrayList<String> res = new ArrayList<String>();
		if (s == null || s.length() == 0) {
			return res;
		}
		String[] strs = s.split("\\s+");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < strs.length; i++) {
			if (strs[i].contains("\"")) {
				sb = new StringBuilder();
				sb.append(strs[i]);
				i++;
				while (i < strs.length && !strs[i].contains("\"")) {
					sb.append(strs[i]).append(" ");
					i++;
				}
				sb.append(strs[i]);
				res.add(sb.toString());
			} else {
				res.add(strs[i]);
			}
		}

		return res;
	}
}
