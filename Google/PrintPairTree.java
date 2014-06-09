package Google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import Library.Relation;

public class PrintPairTree {
	public static void main(String[] args) {
		ArrayList<Relation> list = new ArrayList<Relation>();
		Relation p1 = new Relation("lifework", "animal");
		Relation p2 = new Relation("animal", "mamal");
		Relation p3 = new Relation("animal", "reptical");
		Relation p4 = new Relation("reptical", "lizard");
		Relation p5 = new Relation("mamal", "cat");
		Relation p6 = new Relation("mamal", "dog");

		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(p5);
		list.add(p6);

		printRelation(list);
	}

	public static void printRelation(ArrayList<Relation> list) {
		if (list == null || list.size() == 0) {
			return;
		}

		HashSet<String> set = new HashSet<String>();
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

		for (Relation r : list) {
			set.add(r.child);
		}

		String god = "";
		for (Relation r : list) {
			if (map.containsKey(r.parent)) {
				map.get(r.parent).add(r.child);
			} else {
				ArrayList<String> l = new ArrayList<String>();
				l.add(r.child);
				map.put(r.parent, l);
			}
			if (!set.contains(r.parent)) {
				god = r.parent;
			}
		}

		print(god, 0);
		dfs(map, god, 0);
	}

	public static void dfs(HashMap<String, ArrayList<String>> map, String p,
			int level) {
		if (!map.containsKey(p)) {
			return;
		}

		for (String child : map.get(p)) {
			print(child, level + 1);
			dfs(map, child, level + 1);
		}
	}

	public static void print(String s, int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(" ");
		}
		System.out.println(s);
	}
}
