package Spokeo;

public class ReverseWord {

	public static void main(String[] args) {
		String s = "Iam living in Los Angelas";
		String res = reverseWords2(s);
		System.out.println(res);

	}

	/**
	 * using char[]
	 * 
	 * @param s
	 * @return
	 */
	public static String reverseWords2(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}

		char[] arr = s.toCharArray();
		reverse(arr, 0, arr.length - 1);
		// System.out.println(new String(arr));
		int start = 0;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == ' ') {
				reverse(arr, start, i - 1);
				start = i + 1;
			}
		}

		reverse(arr, start, arr.length - 1); // important
		return new String(arr);
	}

	public static void reverse(char[] arr, int start, int end) {
		while (start < end) {
			char tmp = arr[start];
			arr[start] = arr[end];
			arr[end] = tmp;
			start++;
			end--;
		}
	}

	/**
	 * using stringbuilder
	 * 
	 * @param s
	 * @return
	 */

	public static String reverseWords(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}

		String[] strs = s.split(" ");
		if (strs.length == 0) {
			return "";
		}

		StringBuilder sb = new StringBuilder();
		for (int i = strs.length - 1; i >= 0; i--) {
			if (strs[i].length() > 0) {
				sb.append(strs[i]).append("*");
			}
		}

		System.out.println(sb.length());
		if (sb.length() > 0) {
			sb.deleteCharAt(sb.length() - 1);
		}

		return sb.toString();
	}

	/**
	 * logistic
	 */

	public static void print(char[] arr) {
		for (char c : arr) {
			System.out.print(c);
		}
		System.out.println();
	}
}
