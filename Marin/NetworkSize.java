package Marin;

//size of the network

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// 
public class NetworkSize {

	public static void main(String[] args) {
		Set<String> dict = new HashSet<String>();
		dict.add("ANT");
		dict.add("ANTO");
		dict.add("ANTOT");
		dict.add("ACT");
		dict.add("PACT");
		dict.add("ACTG");
		String start = "ACT";
		int res = networkSize(start, dict);
		System.out.println(res);
		// StringBuilder sb = new StringBuilder(start);
		// ArrayList<String> gen = generator(sb);
		// System.out.println(gen.size());

	}

	public static int networkSize(String start, Set<String> dict) {
		if (dict == null || dict.size() == 0) {
			return 0;
		}

		int count = 0;
		Queue<String> q = new LinkedList<String>();
		q.offer(start);

		while (!q.isEmpty()) {
			String curr = q.poll();
			StringBuilder sb = new StringBuilder(curr);
			ArrayList<String> gen = generator(sb, dict);
			for (String str : gen) {
				if (dict.contains(str)) {
					count++; // add new network size
					q.offer(str);
					dict.remove(str);
				}
			}

		}
		return count;

	}

	public static ArrayList<String> generator(StringBuilder sb, Set<String> dict) {
		ArrayList<String> res = new ArrayList<String>();
		res.add(sb.toString()); // add itself
		int len = sb.length();
		// only add those contained in dictionary
		for (int i = 0; i <= len; i++) {
			for (char c = 'A'; c <= 'Z'; c++) {
				// insert --> ## can do when i == len
				sb.insert(i, c);
				if (dict.contains(sb.toString())) {
					res.add(sb.toString());
				}
				sb.deleteCharAt(i);
				// replace & remove
				if (i != len) {
					replace(res, sb, i, c, dict);
					remove(res, sb, i, dict);
				}

			}
		}
		return res;
	}

	private static void remove(ArrayList<String> res, StringBuilder sb, int i,
			Set<String> dict) {
		char tmp = sb.charAt(i);
		sb.deleteCharAt(i);
		if (dict.contains(sb.toString())) {
			res.add(sb.toString());
		}
		sb.insert(i, tmp); // back
	}

	private static void replace(ArrayList<String> res, StringBuilder sb, int i,
			char c, Set<String> dict) { // doesn't change the initial string
		char[] arr = sb.toString().toCharArray(); // replace
		if (arr[i] != c) {
			arr[i] = c;
			String temp = new String(arr);
			if (dict.contains(temp)) {
				res.add(temp);
			}
		}
	}
}
