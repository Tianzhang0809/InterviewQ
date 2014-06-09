package Google;

/**
 * instead of returning true or false, return the times the word is matched
 * 
 * @author oliviazhang
 * 
 */
public class WordSearchSimilar {

	public static void main(String[] args) {
		char[][] board = { { 'A', 'X', 'Y' }, { 'C', 'T', 'C' },
				{ 'A', 'X', 'Y' } };
		String w = "AXYC";
		System.out.println(matchWord(board, w));

	}

	public static int matchWord(char[][] board, String word) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return 0;
		}

		int m = board.length;
		int n = board[0].length;
		int count = 0;

		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (isValid(board, i, j, word, 0, visited)) {
					count++;
				}
			}
		}

		return count;
	}

	public static boolean isValid(char[][] board, int row, int col,
			String word, int pos, boolean[][] visited) {
		if (pos == word.length()) {
			return true;
		}

		if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
			return false;
		}

		if (word.charAt(pos) != board[row][col]) {
			return false;
		}

		if (visited[row][col]) {
			return false;
		}

		visited[row][col] = true;
		boolean res = isValid(board, row + 1, col, word, pos + 1, visited)
				|| isValid(board, row - 1, col, word, pos + 1, visited)
				|| isValid(board, row, col + 1, word, pos + 1, visited)
				|| isValid(board, row, col - 1, word, pos + 1, visited);
		visited[row][col] = false;
		return res;
	}
}
