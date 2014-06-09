package RentPath;
public class ReverseSpokeo {

	public static void main(String[] args) {
		String s = "I live in california";
		char[] chars = s.toCharArray();

		reverse(chars);

		for (char c : chars) {
			System.out.print(c);
		}
	}

	public static void reverse(char[] chars) {
		if (chars == null || chars.length == 0) {
			return;
		}

		// reverse the inital chars
		int start = 0;
		int end = chars.length - 1;
		reversehelper(chars, start, end); // pacakge the swap function in the
											// helper

		// loop through the reversed array to do second time reversion
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] != ' ') {
				continue;
			}

			end = i - 1;
			reversehelper(chars, start, end); // reverse back
			start = i + 1; // set the new start
		}
	}

	// reverse the entire char array from start to end
	public static void reversehelper(char[] chars, int start, int end) {
		if (start > end || start >= chars.length || end >= chars.length) {
			return; // error check
		}
		while (start <= end) {
			char tmp = chars[start];
			chars[start] = chars[end];
			chars[end] = tmp;
			start++;
			end--;
		}
	}
}
