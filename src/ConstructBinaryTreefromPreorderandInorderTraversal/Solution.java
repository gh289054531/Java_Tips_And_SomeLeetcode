package ConstructBinaryTreefromPreorderandInorderTraversal;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (inorder == null || preorder == null || inorder.length == 0
				|| preorder.length == 0 || inorder.length != preorder.length) {
			return null;
		}
		return rec(preorder, inorder, 0, preorder.length - 1, 0,
				inorder.length - 1);
	}

	private TreeNode rec(int[] preorder, int[] inorder, int s1, int e1, int s2,
			int e2) {
		if (s1 > e1 || s2 > e2) {
			return null;
		}
		TreeNode node = new TreeNode(preorder[s1]);
		int i = 0;
		for (i = s2; i <= e2; i++) {
			if (inorder[i] == preorder[s1]) {
				break;
			}
		}
		node.left = rec(preorder, inorder, s1 + 1, s1 + 1 + (i - 1 - s2), s2,
				i - 1);
		node.right = rec(preorder, inorder, s1 + 1 + (i - 1 - s2) + 1, e1,
				i + 1, e2);
		return node;
	}
}