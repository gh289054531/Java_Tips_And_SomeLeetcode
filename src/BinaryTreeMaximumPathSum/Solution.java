package BinaryTreeMaximumPathSum;

public class Solution {
	int max = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		max = Integer.MIN_VALUE;
		preOrder(root);
		return max;
	}

	private int preOrder(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = preOrder(root.left);
		int right = preOrder(root.right);
		int cur = root.val + left + right;
		if (cur > max) {
			max = cur;
		}
		int temp=Math.max(left,right)+root.val;
		if (temp <= 0) {
			return 0;
		}
		return temp;
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