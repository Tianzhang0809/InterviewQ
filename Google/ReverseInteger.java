package Google;
/**
 * Google first question
 * 
 * 1524 -> 4251
 * 
 * @author oliviazhang
 * 
 */

public class ReverseInteger {
	public static void main(String[] args) {
		Integer n = reverseNum(-1524);
		System.out.println(n);
	}

	public static Integer reverseNum(int input) {
		int sign = (input > 0) ? 1 : -1;
		input = Math.abs(input); // input is absolute number
		int output = 0;

		while (input != 0) {
			if (output < Integer.MAX_VALUE / 10) { // or return -1
				output = output * 10 + input % 10;
			}
			input /= 10;
		}
		return output * sign;
	}

}
