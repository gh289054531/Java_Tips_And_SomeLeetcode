package ValidateBinarySearchTree;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	TreeNode pre = null;

	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		pre = null;
		return inOrder(root);
	}

	private boolean inOrder(TreeNode root) {
		if (root == null) {
			return true;
		}
		boolean r1 = inOrder(root.left);
		if (r1 == false) {
			return false;
		}
		if (pre != null && pre.val >= root.val) {
			return false;
		}
		pre = root;
		boolean r2 = inOrder(root.right);
		if (r2 == false) {
			return false;
		}
		return true;
	}
}