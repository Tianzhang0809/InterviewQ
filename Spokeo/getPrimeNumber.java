package Spokeo;
public class getPrimeNumber {
	public static void main(String args[]) throws Exception {
		int N = 1000000;
		int out = getNumberOfPrimes(N);
		System.out.println(out);
	}

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
		int maxFactor = (int) Math.sqrt(n);
		for (int factor = 2; factor <= maxFactor; factor++) {
			if (n % factor == 0) {
				return false;
			}
		}
		return true;
	}
}
