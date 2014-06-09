package Google;

//given a 2d matrix

/*
 * match the intersection to true give just one cell
 * 
 * 
 */

public class PatternMatchMatrix {

	public static void main(String[] args) {

		boolean res = canWalkTo(3, 4, 3, 6);
		System.out.println(res);

	}

	public static boolean canWalkTo(int arow, int acol, int brow, int bcol) {
		boolean[][] ma = new boolean[8][8];
		flip(ma, arow, acol);
		for (int i = 0; i < ma.length; i++) {
			for (int j = 0; j < ma[0].length; j++) {
				if (i == brow && j == bcol && ma[i][j]) {
					return true;
				}
			}
		}
		return false;
	}

	public static void flip(boolean[][] matrix, int row, int col) {
		boolean flag = (row + col) % 2 == 0 ? true : false;

		for (int i = 0; i < matrix.length; i++) { // inspired by Jason!
			boolean value = flag;
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = value;
				value = !value;
			}
			flag = !flag;
		}
	}

}
