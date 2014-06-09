package TwoSigma;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class OnlineTest_2Sigma_Q1 {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		while (input.hasNext()) {
			String s = input.nextLine();
			String output = sortLine(s);
			System.out.println(output);
		}
	}

	public static String sortLine(String s) {
		String[] list = s.split(" ");
		int length = list.length;

		boolean[] numpos = new boolean[length]; // record position of
												// string/number

		ArrayList<Integer> numlist = new ArrayList<Integer>();
		ArrayList<String> strlist = new ArrayList<String>();

		for (int i = 0; i < length; i++) {
			if (isInteger(list[i])) {
				numlist.add(Integer.parseInt(list[i]));
				numpos[i] = true; // mark in the boolean array
			} else {
				strlist.add(list[i]);
			}
		}

		// sort two list
		Collections.sort(numlist);
		Collections.sort(strlist);

		StringBuilder res = new StringBuilder();
		int str_pos = 0, num_pos = 0;

		for (int i = 0; i < length; i++) {
			if (numpos[i]) {
				res.append(numlist.get(num_pos++));
			} else {
				res.append(strlist.get(str_pos++));
			}
			if (i != length - 1) {
				res.append(" ");
			}
		}

		return res.toString();
	}

	private static boolean isInteger(String str) {
		if (str == null || str.length() == 0) {
			return false;
		}
		int length = str.length();

		int i = 0;
		if (str.charAt(0) == '-') { // if is a negative number
			if (length == 1) {
				return false;
			}

			i = 1; // continue to check from position 1
		}

		for (; i < length; i++) {
			char c = str.charAt(i);
			if (c < '0' || c > '9') {
				return false;
			}
		}

		return true;
	}
}
