package Google;
/*
 * 
 *Google second question
 *
 *Sort a string alphabetically
 */

public class SortStringAlphabatically {
	public static void main(String[] args) {
		System.out.println(sortString2("canada"));
	}

	public static String sortString1(String s) {
		if (s == null || s.length() == 0) {
			return null;
		}

		int[] charset = new int[26];

		for (int i = 0; i < s.length(); i++) {
			char c = (char) (s.charAt(i) - 'a');
			charset[c] += 1;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 26; i++) {
			while (charset[i] > 0) {
				sb.append((char) (i + 'a'));
				charset[i]--;
			}
		}
		return sb.toString();
	}

	/**
	 * Bubble sort
	 */
	public static String sortString2(String s) {
		if (s == null || s.length() == 0) {
			return null;
		}

		char[] s_arr = s.toCharArray();
		int i;

		for (i = 1; i < s_arr.length; i++) {
			char a = s_arr[i - 1];
			char b = s_arr[i];
			int com = compare(a, b);
			if (com < 1) {
				while (i >= 1 && compare(s_arr[i - 1], s_arr[i]) == -1) {
					System.out.println(s_arr[i - 1] + " " + s_arr[i]);
					swap(s_arr, i, i - 1);
					i--;
				}
			}
		}
		return new String(s_arr);
	}

	public static void swap(char[] arr, int i, int j) {
		char tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static int compare(char a, char b) {
		if (a < b) {
			return 1;
		} else if (a == b) {
			return 0;
		}
		return -1;
	}
}
