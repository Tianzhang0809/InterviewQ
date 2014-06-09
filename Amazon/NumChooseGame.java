package Amazon;

//http://blog.csdn.net/fightforyourdream/article/details/17653163

/**
 * given an integer array
 * 
 * 
 * @author oliviazhang
 * 
 */
public class NumChooseGame {

	public static void main(String[] args) {
		int[] arr = { 8, 15, 3, 7 };
		int res = playGame(0, arr.length - 1, arr);
		int res2 = optimalStrategyOfGame(arr);
		System.out.println(res);
		System.out.println(res2);

	}

	// dp
	public static int optimalStrategyOfGame(int[] A) {
		int n = A.length;
		int[][] dp = new int[n][n];

		// Fill table using above recursive formula. Note that the table
		// is filled in diagonal fashion (similar to http://goo.gl/PQqoS),
		// from diagonal elements to table[0][n-1] which is the result.
		for (int gap = 0; gap < n; gap++) {
			int begin = 0, end = gap;
			while (end < n) {
				int x = begin + 2 <= end ? dp[begin + 2][end] : 0; // both choose start
				int y = begin + 1 <= end - 1 ? dp[begin + 1][end - 1] : 0; // one start one end
				int z = begin <= end - 2 ? dp[begin][end - 2] : 0; // both end

				dp[begin][end] = Math.max(A[begin] + Math.min(x, y), A[end]
						+ Math.min(y, z));
				begin++;
				end++;
				//print(dp);
			}
		}
		
		return dp[0][n - 1];
	}

	/**
	 * playGame(i, j, arr) represents the maximum value the user can collect
	 * from i'th coin to j'th coin.
	 * 
	 * @param start
	 * @param end
	 * @param arr
	 * @return
	 */
	public static int playGame(int start, int end, int[] arr) {
		// System.out.println(start + " " + end);
		if (start == end) {
			return arr[start];
		}
		if (start + 1 == end) {
			return Math.max(arr[start], arr[end]);

		}

		int pos1 = arr[start]
				+ Math.min(playGame(start + 2, end, arr),
						playGame(start + 1, end - 1, arr));// if choosing start,
															// player can choose
															// start + 1 or end
		int pos2 = arr[end]
				+ Math.min(playGame(start + 1, end - 1, arr),
						playGame(start, end - 2, arr));// if choosing end,
														// player can choose
		return Math.max(pos1, pos2);
	}

	// logistics
	public static void print(int[][] dp) {
		for (int[] arr : dp) {
			for (int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		System.out.println("-------");
	}
}
