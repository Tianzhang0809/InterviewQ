package Yelp;

import java.util.ArrayList;
import java.util.HashMap;

public class Combination_upperLowercase {
	public static void main(String[] args) {

		String input = "ab";
		ArrayList<String> list = generate(input);
		System.out.println(list);
	}

	private static ArrayList<String> generate(String input) {
		ArrayList<String> res = new ArrayList<String>();

		HashMap<Character, char[]> map = new HashMap<Character, char[]>();
		for (int i = 0; i < input.length(); i++) {
			char[] arr = new char[2];
			arr[0] = input.toLowerCase().charAt(i);
			arr[1] = input.toUpperCase().charAt(i);
			map.put(arr[0], arr);
		}

		StringBuilder sb = new StringBuilder();
		helper(input, sb, map, res);
		return res;
	}

	public static void helper(String input, StringBuilder sb,
			HashMap<Character, char[]> map, ArrayList<String> res) {
		if (sb.length() == input.length()) {
			res.add(sb.toString());
			return;
		}

		for (char c : map.get(input.charAt(sb.length()))) {
			sb.append(c);
			helper(input, sb, map, res);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	/**
	 * optimized O(2**N)--Time O(1) space
	 * 
	 */

	private static ArrayList<String> generate2(String input) {
		ArrayList<String> res = new ArrayList<String>();
		helper(input, "", res);
		return res;
	}

	private static void helper(String s, String temp, ArrayList<String> res) {
		if (temp.length() >= s.length()) {
			if (temp.length() == s.length()) {
				res.add(temp);
			}
			return;
		}
		Character c = s.charAt(temp.length());
		if (Character.isLetter(c)) {
			helper(s, temp + Character.toUpperCase(c), res);
			helper(s, temp + Character.toLowerCase(c), res);
		} else {
			helper(s, temp + c, res);
		}
	}
}
