package Yelp;

/**
 * given a list of urls, find top 10 most visited urls
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Top10MostVistedURL {
	// see main function below the implementation
	public static ArrayList<String> findTop10VistedWebsites(
			ArrayList<String> list, int n) {
		ArrayList<String> res = new ArrayList<String>();
		if (list == null || list.size() == 0) {
			return res;
		}

		if (list.size() <= n) {
			return list;
		}

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		// put urls into the hashmap
		for (String url : list) {
			if (map.containsKey(url)) {
				map.put(url, map.get(url) + 1);
			} else {
				map.put(url, 1);
			}
		}

		// sort hashmap by values
		Set<Entry<String, Integer>> set = map.entrySet();

		List<Entry<String, Integer>> l = new ArrayList<Entry<String, Integer>>(
				set);

		Collections.sort(l, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1,
					Map.Entry<String, Integer> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});

		// put the top n into arraylist
		for (Map.Entry<String, Integer> entry : l) {
			if (res.size() >= n) { // we only need top n -- we can change value
				break;
			}
			res.add(entry.getKey());
		}

		return res;
	}

	/**
	 * main function
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("www.google.com");
		list.add("www.google.com");
		list.add("www.yahoo.com");
		list.add("www.google.com");
		list.add("www.amazon.com");
		list.add("www.apple.com");
		list.add("www.google.com");
		list.add("www.amazon.com");
		list.add("www.linkedin.com");
		list.add("www.udacity.com");
		list.add("www.udacity.com");
		list.add("www.linkedin.com");
		list.add("www.yelp.com");
		list.add("www.yelp.com");
		list.add("www.apple.com");
		list.add("www.amazon.com");
		list.add("www.yelp.com");
		list.add("www.apple.com");
		list.add("www.facebook.com");
		list.add("www.marinsoftware.com");
		list.add("www.marinsoftware.com");
		list.add("www.apple.com");
		list.add("www.facebook.com");
		list.add("www.yelp.com");
		list.add("www.yelp.com");
		list.add("www.facebook.com");
		list.add("www.linkedin.com");
		list.add("www.pinterest.com");
		list.add("www.pinterest.com");
		list.add("www.rent.com");
		list.add("www.rent.com");
		list.add("www.twosigma.com");
		list.add("www.twosigma.com");
		list.add("www.twitter.com");
		list.add("www.twitter.com");

		ArrayList<String> res = findTop10VistedWebsites(list, 5);
		for (String str : res) {
			System.out.println(str);
		}

	}
}
