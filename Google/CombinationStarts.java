package Google;

import java.util.ArrayList;

public class CombinationStarts {

	public static void main(String[] args) {
		String s = "00*1*0";
		ArrayList<String> res = combinationStarts(s);
		System.out.println(res);

	}

	public static ArrayList<String> combinationStarts(String s) {
		ArrayList<String> res = new ArrayList<String>();
		dfs(new StringBuilder(s), 0, res);
		return res;
	}

	public static void dfs(StringBuilder s, int p, ArrayList<String> res) {
		if (p == s.length()) {
			res.add(s.toString());
			return;
		}
		if (s.charAt(p) == '*') {
			s.setCharAt(p, '0');
			dfs(s, p + 1, res);
			s.setCharAt(p, '1');
			dfs(s, p + 1, res);
			s.setCharAt(p, '*');
		} else {
			dfs(s, p + 1, res);
		}
	}

}
