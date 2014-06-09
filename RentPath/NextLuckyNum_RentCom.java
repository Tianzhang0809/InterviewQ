package RentPath;
/**
 * test cases:
 * 
 * 11 -> 44 45 -> 47 1004 -> 4444 91 -> 444 51 -> 74 86 -> 444 778 -> 4444
 * 
 * @author oliviazhang
 * 
 */

public class NextLuckyNum_RentCom {
	public static void main(String[] args) {
		int num = 86;
		int out = luckynumber(num);
		System.out.println(out);
	}

	public static int luckynumber(int n) {
		return -1;
	}

	public static void print(int[] arr) {
		for (int c : arr) {
			System.out.print(c + " ");
		}
		System.out.println();
	}

	public static char[] copyRest(char[] temp, char[] arr) {
		int index = 2;
		for (int i = 1; i < arr.length; i++) {
			temp[index++] = arr[i];
		}
		return temp;
	}
}
