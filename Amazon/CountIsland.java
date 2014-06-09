package Amazon;

import java.util.LinkedList;
import java.util.Queue;

public class CountIsland {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 0, 1, 1, 0, 1, 1 }, { 0, 1, 0, 0, 1, 0, 1, 1 },
				{ 1, 1, 1, 1, 1, 0, 1, 0 }, { 1, 1, 1, 0, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1 } };
		System.out.println(countIsland(matrix));
	}

	public static int countIsland(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}

		int count = 0;
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (!visited[i][j] && matrix[i][j] == 0) { // found island
					count++;
					flip(matrix, i, j, visited);
				}

			}
		}
		return count;
	}

	public static void flip(int[][] matrix, int row, int col,
			boolean[][] visited) {

		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { row, col });
		int[][] moves = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			for (int i = 0; i < moves.length; i++) {
				int[] move = moves[i];
				int newrow = curr[0] + move[0];
				int newcol = curr[1] + move[1];
				if (isValid(matrix, newrow, newcol, visited)) {
					visited[newrow][newcol] = true;
					q.offer(new int[] { newrow, newcol });
				}
			}
		}
	}

	public static boolean isValid(int[][] matrix, int row, int col,
			boolean[][] visited) {
		return row >= 0 && row < matrix.length && col >= 0
				&& col < matrix[0].length && !visited[row][col]
				&& matrix[row][col] == 0;
	}

}
