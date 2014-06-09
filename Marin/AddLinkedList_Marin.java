package Marin;
import Library.ListNode;

public class AddLinkedList_Marin {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(6);
		l1.next = new ListNode(1);
		l1.next.next = new ListNode(7);

		ListNode l2 = new ListNode(2);
		l2.next = new ListNode(9);
		l2.next.next = new ListNode(5);

		ListNode res = addTwoList(l1, l2);
		while (res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}

	}

	public static ListNode addTwoList(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) {
			return null;
		}

		// padding zero
		int len1 = getLength(l1);
		int len2 = getLength(l2);

		if (len1 > len2) {
			l2 = padding(l2, len1 - len2);
		} else {
			l1 = padding(l1, len2 - len1);
		}

		ResultType sum = helper(l1, l2);

		if (sum.carry != 0) {
			ListNode res = insertBefore(sum.sum, sum.carry);
			return res;
		} else {
			return sum.sum;
		}

	}

	public static ResultType helper(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) {
			return new ResultType();
		}

		ResultType curr = helper(l1.next, l2.next); // go to the bottom
		int val = l1.val + curr.carry + l2.val;
		ListNode res = insertBefore(curr.sum, val % 10);

		// set the curr attributes
		curr.sum = res;
		curr.carry = val / 10;

		return curr;
	}

	public static ListNode insertBefore(ListNode head, int val) {
		ListNode n = new ListNode(val);
		n.next = head;
		head = n;
		return head;
	}

	public static ListNode padding(ListNode l, int num) {
		for (int i = 0; i < num; i++) {
			ListNode n = new ListNode(0);
			n.next = l;
			l = n;
		}
		return l;
	}

	// get the length of linkedlist
	public static int getLength(ListNode head) {
		int count = 0;
		while (head != null) {
			count++;
			head = head.next;
		}
		return count;
	}

}

class ResultType {
	ListNode sum = null;
	int carry = 0;
}
