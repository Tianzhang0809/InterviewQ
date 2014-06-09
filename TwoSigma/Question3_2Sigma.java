package TwoSigma;
// find the number of prime number smaller than or equal to n
public class Question3_2Sigma {

	static int getNumberOfPrimes(int N) {
		if (N <= 1) {
			return 0;
		}
		int count = 0;
		for (int i = 2; i <= N; i++) {
			if (isPrime(i) == true) {
				count++;
			}
		}
		return count;
	}

	public static boolean isPrime(int n) {
		if (n < 2) {
			return false;
		}
		if (n == 2) {
			return true;
		}
		if (n % 2 == 0) {
			return false;
		}

		for (int factor = 2; factor <= Math.sqrt(n); factor++) {
			if (n % factor == 0) {
				return false;
			}
		}
		return true;
	}
}
