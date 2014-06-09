package TripAdvisor;
import java.util.ArrayList;

import Library.ListNode;

public class FindIntersect_in_LL_TripAdvisor {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(5);

		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(5);
		l2.next.next = new ListNode(7);
		ArrayList<Integer> res = findIntersection(l1, l2);
		System.out.println(res);

	}

	public static ArrayList<Integer> findIntersection(ListNode l1, ListNode l2) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (l1 == null || l2 == null) {
			return res;
		}
		if (l1.val > l2.val) {
			return findIntersection(l2, l1);
		}

		while (l1 != null && l1.val < l2.val) {
			l1 = l1.next;
		}

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				l1 = l1.next;
			} else if (l1.val > l2.val) {
				l2 = l2.next;
			} else {
				res.add(l1.val);
				l1 = l1.next;
				l2 = l2.next;
			}
		}

		return res;
	}
}
