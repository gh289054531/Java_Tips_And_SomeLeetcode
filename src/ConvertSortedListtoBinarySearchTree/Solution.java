package ConvertSortedListtoBinarySearchTree;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		TreeNode root = rec(head, null);
		return root;
	}

	private TreeNode rec(ListNode head, ListNode end) {
		if (head == null || head == end) {
			return null;
		}
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != end && fast.next.next != end) {
			fast = fast.next.next;
			slow = slow.next;
		}
		TreeNode node = new TreeNode(slow.val);
		node.left = rec(head, slow);
		node.right = rec(slow.next, end);
		return node;
	}
}