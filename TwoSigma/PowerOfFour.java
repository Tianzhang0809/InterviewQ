package TwoSigma;

public class PowerOfFour {

	public static void main(String[] args) {
		System.out.println(powerOfTwo(8));

	}

	public static boolean powerOfTwo(int n) {
		return ((n - 1) & n) == 0;
	}
}
