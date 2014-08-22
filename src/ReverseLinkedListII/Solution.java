package ReverseLinkedListII;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Solution {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null) {
			return null;
		}
		if (m == n) {
			return head;
		}
		ListNode virtual = new ListNode(-1);
		virtual.next = head;
		ListNode pre = virtual;
		int i = 1;
		while (head != null && i < m) {
			head = head.next;
			pre = pre.next;
			i++;
		}
		pre.next = null;
		ListNode curEnd = head;
		while (i <= n) {
			ListNode temp = pre.next;
			pre.next = head;
			head = head.next;
			pre.next.next = temp;
			i++;
		}
		curEnd.next = head;
		return virtual.next;
	}
}