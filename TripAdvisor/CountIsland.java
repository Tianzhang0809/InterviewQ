package TripAdvisor;
public class CountIsland {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 },
				{ 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 }, { 1, 0, 1, 0, 1 } };
		int num = getNumOfIslands(matrix);
		System.out.println(num);

	}

	public static int getNumOfIslands(int[][] A) {
		if (A == null || A.length == 0 || A[0].length == 0) {
			return 0;
		}

		boolean[][] map = new boolean[A.length][A[0].length];
		int count = 0;

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				if (A[i][j] == 1 && !map[i][j]) {
					dfs(A, i, j, map);
					count++;
				}
			}
		}
		return count;
	}

	public static void dfs(int[][] A, int row, int col, boolean[][] map) {
		map[row][col] = true; // assign visited
		int newX;
		int newY;

		int[] xMove = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] yMove = { -1, 0, 1, -1, 1, -1, 0, 1 };

		for (int i = 0; i < xMove.length; i++) {
			newX = row + xMove[i];
			newY = col + yMove[i];
			if (isValid(A, newX, newY, map)) {
				dfs(A, newX, newY, map);
			}
		}
	}

	public static boolean isValid(int[][] A, int x, int y, boolean[][] map) {
		return (x >= 0 && x < A.length && y >= 0 && y < A[0].length
				&& A[x][y] == 1 && !map[x][y]);
	}
}
