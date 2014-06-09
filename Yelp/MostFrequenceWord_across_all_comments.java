package Yelp;

import java.util.ArrayList;
import java.util.HashMap;

public class MostFrequenceWord_across_all_comments {
	public static void main(String[] args) {
		String s1 = "A A A B C";
		String s2 = "B D";
		String s3 = "C D";
		String s4 = "D";
		ArrayList<String> co = new ArrayList<String>();
		co.add(s2);
		co.add(s3);
		co.add(s1);
		co.add(s4);
		ArrayList<String> res = mostFrequentAppear(co, 1);
		System.out.println(res);
	}

	public static ArrayList<String> mostFrequentAppear(
			ArrayList<String> comments, int k) {
		// key: word, value: the comment that stores this comment
		// e.g. "I like it", "I want it",
		// I = {0, 1}, like = {0}
		HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
		// put words into hashmap
		for (int i = 0; i < comments.size(); i++) {
			String comment = comments.get(i);
			String[] words = comment.split(" ");
			for (String str : words) {
				if (map.containsKey(str)) {
					ArrayList<Integer> list = map.get(str);
					if (list.get(list.size() - 1) == i) {
						continue;
					} else {
						map.get(str).add(i);
					}
				} else {
					ArrayList<Integer> level = new ArrayList<Integer>();
					level.add(i);
					map.put(str, level);
				}
			}
		}

		int count = 0;
		ArrayList<String> res = new ArrayList<String>();

		for (int i = comments.size(); i >= 1; i--) {
			if (res.size() > 0) {
				count++;
			}

			if (count == k) {
				return res;
			} else {
				res = new ArrayList<String>();
			}

			for (String str : map.keySet()) {
				if (map.get(str).size() == i) {
					res.add(str);
				}
			}
		}

		return res;
	}
}
