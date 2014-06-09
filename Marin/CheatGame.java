package Marin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CheatGame {

	public static void main(String[] args) {
		Set<String> dict = new HashSet<String>();
		dict.add("ACT");
		dict.add("AT");
		dict.add("CAT");
		dict.add("ATC");
		char[] arr = { 'A', 'C', 'T' };

		ArrayList<String> res = cheatGame(arr, dict);
		System.out.println(res);

	}

	public static ArrayList<String> cheatGame(char[] arr, Set<String> dict) {
		ArrayList<String> res = new ArrayList<String>();
		if (arr == null || arr.length == 0) {
			return res;
		}

		StringBuilder sb = new StringBuilder();

		ArrayList<ArrayList<Character>> arrlist = getPermutation(arr);
		for (ArrayList<Character> list : arrlist) {
			helper(res, sb, list, 0, dict);
		}
		return res;
	}

	public static ArrayList<ArrayList<Character>> getPermutation(char[] arr) {
		ArrayList<ArrayList<Character>> res = new ArrayList<ArrayList<Character>>();
		ArrayList<Character> list = new ArrayList<Character>();
		permute(res, list, arr);
		return res;
	}

	public static void permute(ArrayList<ArrayList<Character>> res,
			ArrayList<Character> list, char[] arr) {
		if (list.size() == arr.length) {
			res.add(new ArrayList<Character>(list));
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
			permute(res, list, arr);
			list.remove(list.size() - 1);
		}
	}

	public static void helper(ArrayList<String> res, StringBuilder sb,
			ArrayList<Character> arr, int pos, Set<String> dict) {
		if (sb.length() > 0 && dict.contains(sb.toString())) {
			if (!res.contains(sb.toString())) {
				res.add(sb.toString());
			}
		}

		for (int i = pos; i < arr.size(); i++) {
			sb.append(arr.get(i));
			helper(res, sb, arr, i + 1, dict);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}
