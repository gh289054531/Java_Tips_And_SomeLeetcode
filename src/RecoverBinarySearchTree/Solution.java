package RecoverBinarySearchTree;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	TreeNode n1 = null, n2 = null;
	TreeNode pre = null;

	public void recoverTree(TreeNode root) {
		if (root == null) {
			return;
		}
		n1 = null;
		n2 = null;
		pre = null;
		preOrder(root);
		int temp = n1.val;
		n1.val = n2.val;
		n2.val = temp;
	}

	private void preOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		preOrder(root.left);
		if (pre != null && pre.val > root.val) {
			if (n1 == null) {
				n1 = pre;
				n2 = root;
			} else {
				n2 = root;
			}
		}
		pre = root;
		preOrder(root.right);
	}
}