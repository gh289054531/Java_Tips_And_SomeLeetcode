package PartitionList;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Solution {
	public ListNode partition(ListNode head, int x) {
		if (head == null) {
			return null;
		}
		ListNode newHead1 = new ListNode(-1);
		ListNode newHead2 = new ListNode(-1);
		ListNode p = head, m = newHead1, n = newHead2;
		while (p != null) {
			ListNode temp = new ListNode(p.val);
			if (p.val < x) {
				m.next = temp;
				m = temp;
			} else {
				n.next = temp;
				n = temp;
			}
			p = p.next;
		}
		m.next = newHead2.next;
		return newHead1.next;
	}
}