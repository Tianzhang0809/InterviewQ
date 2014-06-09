package Google;

/**
 * given a board and two points, if only can walk on the direction of
 * intersection test how many steps it needs to get from one point to another
 * 
 * @author oliviazhang
 * 
 */
public class GetStepSum {

	public static void main(String[] args) {
		boolean[][] board = new boolean[4][5];

		int n = getStepNum(board, 1, 3, 1, 1);
		System.out.println(n);

	}

	public static int getStepNum(boolean[][] board, int sr, int sc, int er,
			int ec) {
		if (sr + sc == er + ec || sr - sc == er - ec) {
			return 1;
		}

		int i = sr;
		int j = sc;

		while (i > 0 && j > 0) {
			i--;
			j--;
		} // find the border

		while (i < board.length && j < board[0].length) {
			if (i + j == er + ec || i - j == er - ec) {
				return 2;
			}
			i++;
			j++;
		}

		return Integer.MAX_VALUE;

	}
}
