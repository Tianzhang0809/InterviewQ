public class Calculator {

	public static void add(int numOne, int numTwo) {
		int result = numOne + numTwo;
		System.out.println(numOne + " + " + numTwo + " = " + result);
	}

	public static void subtract(int numOne, int numTwo) {
		int result = numOne - numTwo;
		System.out.println(numOne + " - " + numTwo + " = " + result);
	}

	public static void multiply(int numOne, int numTwo) {
		int result = numOne * numTwo;
		System.out.println(numOne + " * " + numTwo + " = " + result);
	}

	public static void divide(int numOne, int numTwo) {
		int result = numOne / numTwo;
		System.out.println(numOne + " / " + numTwo + " = " + result);
	}

	public static void main(String[] args) {
		int numOne = Integer.parseInt(args[0]);
		int numTwo = Integer.parseInt(args[1]);
		add(numOne, numTwo);
		subtract(numOne, numTwo);
		multiply(numOne, numTwo);
		divide(numOne, numTwo);
	}
}