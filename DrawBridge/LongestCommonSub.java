package DrawBridge;

/**
 * A B C D E & A C E F G returns.... ACE
 * 
 * 
 * @author oliviazhang
 * 
 */
public class LongestCommonSub {

	public static void main(String[] args) {
		String s1 = "ABCDE";
		String s2 = "ACEFG";
		int res_dp = lcs_dp(s1, s2);
		System.out.println(res_dp);

		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		int res = lcs(c1, c2, c1.length, c2.length);
		System.out.println(res);

	}

	public static int lcs_dp(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
			return 0;
		}

		int m = s1.length();
		int n = s2.length();
		int[][] dp = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) { // dp[i][j] records
															// the common
															// characters
															// catched for now
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}

		return dp[m][n];
	}

	public static int lcs(char[] c1, char[] c2, int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}

		if (c1[m - 1] == c2[n - 1]) {
			return 1 + lcs(c1, c2, m - 1, n - 1);
		} else {
			return Math.max(lcs(c1, c2, m, n - 1), lcs(c1, c2, m - 1, n));
		}
	}

	public static void print(char[] arr) {
		for (char c : arr) {
			System.out.print(c + " ");
		}
		System.out.println();
	}
}
