package TripAdvisor;
import java.util.Stack;

public class StackMachine_tripAdviOnlinetest {

	public static void main(String[] args) {
		String s = "13+62*7+*";
		int res = stackMachine(s);
		System.out.println(res);

	}

	public static int stackMachine(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		String operators = "+-*/";
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (!operators.contains(s.charAt(i) + "")) { // integer
				stack.push(s.charAt(i) - '0');
			} else {
				int first = stack.pop();
				int second = stack.pop();
				if (s.charAt(i) == '+') {
					stack.push(second + first);
				}
				if (s.charAt(i) == '-') {
					stack.push(second - first);
				}
				if (s.charAt(i) == '*') {
					stack.push(second * first);
				}
				if (s.charAt(i) == '/') {
					stack.push(second / first);
				}
			}
		}
		return stack.pop();
	}
}
