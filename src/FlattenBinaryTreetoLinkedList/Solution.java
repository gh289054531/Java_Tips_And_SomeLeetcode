package FlattenBinaryTreetoLinkedList;


public class Solution {
	TreeNode tail = null;

	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}
		TreeNode left = root.left;
		TreeNode right = root.right;
		if (tail == null) {
			tail = root;
		} else {
			tail.right = root;
			tail.left = null;
			tail = root;
		}
		flatten(left);
		flatten(right);
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