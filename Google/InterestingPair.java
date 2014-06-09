package Google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Given a dictionary, if a pair of words do share at least one character, like
 * boy and dog sharing o, it is interesting pair. Find the interesting pair that
 * have the biggest length multiple, and output the multiple result
 * 
 * @author oliviazhang
 * 
 */

public class InterestingPair {

	public static void main(String[] args) {
		Set<String> dict = new HashSet<String>();
		dict.add("dog");
		dict.add("boy");
		dict.add("cat");
		dict.add("mast");
		dict.add("amast");
		System.out.println(interestingPair(dict));

	}

	public static int interestingPair(Set<String> dict) {
		if (dict == null || dict.size() == 0) {
			return 0;
		}

		HashMap<Character, PriorityQueue<String>> map = new HashMap<Character, PriorityQueue<String>>();
		// init
		for (char c = 'a'; c <= 'z'; c++) {
			map.put(c, new PriorityQueue<String>());
		}

		for (String str : dict) {
			for (char c = 'a'; c <= 'z'; c++) {
				if (str.contains(c + "")) {
					map.get(c).offer(str);
				}
			}
		}

		int max = 0;
		for (PriorityQueue<String> q : map.values()) {
			if (q.size() >= 2) {
				int tmp = q.poll().length() * q.poll().length();
				if (tmp > max) {
					max = tmp;
				}
			}
		}
		return max;
	}

}
