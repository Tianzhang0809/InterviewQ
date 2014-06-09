package Google;

/**
 * compress string aabbbcc to a*2b*3c*2
 * 
 * @author oliviazhang
 * 
 */
public class Compress {

	public static void main(String[] args) {
		String res = compress("aabbbcc");
		System.out.println(res);
		System.out.println(decompress("a*2b*3c*2"));

	}

	public static String compress(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}

		char prev = s.charAt(0);
		StringBuilder sb = new StringBuilder();
		int count = 1;
		for (int i = 1; i < s.length(); i++) {
			char c = s.charAt(i);
			if (prev == c) {
				count++;
			} else {
				sb.append(prev).append("*").append(count);
				count = 1;
				prev = c;
			}
		}
		sb.append(prev).append("*").append(count);
		return sb.toString();
	}

	public static String decompress(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}

		StringBuilder sb = new StringBuilder();
		StringBuilder numb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '*') {
				continue;
			}

			numb = new StringBuilder(); // renew the number stringbuilder
			if (Character.isAlphabetic(c)) {
				i += 2; // skip "*"
				// remember to set i < s.length() to control boundary
				while (i < s.length() && Character.isDigit(s.charAt(i))) {
					numb.append(s.charAt(i));
					i++;
				}
				i--; // reverse by one

				int times = Integer.parseInt(numb.toString());
				while (times > 0) {
					sb.append(c);
					times--;
				}
			}
		}
		return sb.toString();
	}
}
