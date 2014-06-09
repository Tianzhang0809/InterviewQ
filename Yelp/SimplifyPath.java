package Yelp;

import java.util.ArrayList;

/**
 * implement the 'cd' command i.e. given a function cd('a/b','c/../d/e/../f'),
 * where 1st param is current directory and 2nd param is the sequence of
 * operations, find the final directory that the user will be in when the cd
 * command is executed
 * 
 * @author oliviazhang
 * 
 */
public class SimplifyPath {

	public static void main(String[] args) {
		String s = "c/../d/e/../f";
		String current = "a/b";
		System.out.println(simplifyPath(current, s));
	}

	public static String simplifyPath(String current, String path) {
		if (path == null || path.length() == 0) {
			return path;
		}
		path = current + path; // make it one path
		String[] strs = path.split("/");
		ArrayList<String> list = new ArrayList<String>();

		for (String str : strs) {
			if (!str.equals(".") && !str.equals("..") && str.length() > 0) {
				list.add(str);
			} else if (str.equals("..")) {
				if (list.size() > 0) {
					list.remove(list.size() - 1);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (String str : list) {
			sb.append("/").append(str);
		}

		return sb.length() == 0 ? "/" : sb.toString();
	}

}
