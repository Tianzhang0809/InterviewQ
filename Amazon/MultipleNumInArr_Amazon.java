package Amazon;
/**
 * given { 1,2,3} output {2 * 3, 1*3, 1*2}
 * 
 * @author oliviazhang
 * 
 */
public class MultipleNumInArr_Amazon {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		// suppose {6,3,2};

		int[] arr1 = { 0, 2, 3 };
		// suppose {0,0,6};
		int[] res = multiply(arr1);
		for (int i : res) {
			System.out.print(i + " ");
		}

	}

	public static int[] multiply(int[] arr) {
		if (arr == null || arr.length == 0) {
			return null;
		}

		int mul = 1;
		boolean flag = false;
		int count = 0;

		for (int i : arr) {
			if (i != 0) {
				mul *= i;
			} else if (i == 0) {
				flag = true;
				count++;
			}
		}

		int[] res = new int[arr.length];

		if (count >= 2) {
			return res; // should be all zero
		}

		for (int i = 0; i < res.length; i++) {
			if (flag) { // discuss when there is a single zero in the array
				if (arr[i] == 0) {
					res[i] = mul;
				}
			} else { // when there is no zero
				res[i] = mul / arr[i];
			}
		}
		return res;
	}

}
