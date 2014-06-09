package Yelp;

/**
 * """
 1. Write a function to add the two binary number strings.. 
 add('100', '10') -> '110'
 . 

 2. Follow up, add two number strings with specific base
 add('100', '10', 2) -> '110'
 add('100', '9', 10) -> '109'


 3. Follow up, sum list number strings with specific base.
 add_strs(['9', '3', '2'], 10) -> '14'
 """
 */

import java.util.ArrayList;

public class AddListNumbers_diff_base {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("1");
		list.add("11");
		list.add("2");

		String res = add_strs(list, 10);
		System.out.println(res);

	}

	/**
	 * n is the length of list, m is the length of each number
	 * 
	 * Time O(n * m)
	 * 
	 * @param list
	 * @param base
	 * @return
	 */
	public static String add_strs(ArrayList<String> list, int base) {
		String a, b;
		while (list.size() > 2) {
			a = list.remove(list.size() - 1);
			b = list.remove(list.size() - 1);
			String tmpres = addTwoNumber(a, b, base);
			list.add(tmpres); // add back
		}
		a = list.remove(list.size() - 1);
		b = list.remove(list.size() - 1);

		return addTwoNumber(a, b, base);
	}

	public static String addTwoNumber(String n1, String n2, int base) {
		if (n1.length() > n2.length()) { // n1 is shorter
			return addTwoNumber(n2, n1, base);
		}

		int carry = 0;
		int len1 = n1.length() - 1; // starting from base unit
		int len2 = n2.length() - 1;
		StringBuilder sb = new StringBuilder();

		while (len1 >= 0) {
			int sum = carry + n1.charAt(len1) - '0' + n2.charAt(len2) - '0';
			sb.append(sum % base); // added in reverse order
			carry = sum >= base ? sum / base : 0;
			len1--;
			len2--;
		}

		while (len2 >= 0) {
			int sum = carry + n2.charAt(len2) - '0';
			sb.append(sum % base);
			carry = sum >= base ? sum / base : 0;
			len2--;
		}

		String res = sb.reverse().toString(); // reverse back
		if (carry > 0) {
			res = carry + res; // add at the front
		}

		return res;
	}
}
