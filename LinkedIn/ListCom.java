package LinkedIn;

import java.util.Comparator;

public class ListCom implements Comparator<int[]> {
	public int compare(int[] a, int[] b) {
		return a[0] - b[0];
	}
}
