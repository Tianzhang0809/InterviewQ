package Google;

import java.util.ArrayList;

/**
 * given {a,b}xy{c,d,e} return all the combinations -->axyc, axyd, axye, bxyc,
 * bxyd, bxye
 * 
 * @author oliviazhang
 * 
 */
public class Combination {

	public static void main(String[] args) {
		char[] arr1 = { 'a', 'b' };
		char[] arr2 = { 'c', 'd', 'e' };
		String addon = "xy";
		ArrayList<String> res = getCombination(arr1, arr2, addon);
		System.out.println(res);

	}

	public static ArrayList<String> getCombination(char[] arr1, char[] arr2,
			String addon) {
		ArrayList<String> res = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();

		for (char c : arr1) {
			for (char d : arr2) {
				sb = new StringBuilder(); // key!
				sb.append(c).append(addon).append(d);
				res.add(sb.toString());
			}
		}

		return res;
	}

}
