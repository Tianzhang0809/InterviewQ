package Marin;

import java.util.Stack;

// given a string "1 + 2 + 6 * 10 + 5 - 7" calculate the math result

public class SimpleMath {

	public static void main(String[] args) {
		String s = "1+2+6*10-8/2+9";
		calculate(s);

	}

	public static void calculate(String s) {
		if (s == null || s.length() == 0) {
			return;
		}

		Stack<Integer> nums = new Stack<Integer>();
		Stack<String> oper = new Stack<String>();
		String operators = "+-*/";

		String[] strs = s.split("\\+|-|\\*|/");
		for (String num : strs) {
			nums.push(Integer.valueOf(num));
		}

		for (int i = 0; i < s.length(); i++) {
			if (operators.contains(s.charAt(i) + "")) {
				oper.push(s.charAt(i) + "");
			}
		}

	}
}
