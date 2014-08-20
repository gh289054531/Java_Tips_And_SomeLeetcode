package ConstructBinaryTreefromInorderandPostorderTraversal;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null || inorder.length == 0
				|| postorder.length == 0 || inorder.length != postorder.length) {
			return null;
		}
		TreeNode root = rec(inorder, postorder, 0, inorder.length - 1, 0,
				postorder.length - 1);
		return root;
	}

	private TreeNode rec(int[] inorder, int[] postorder, int s1, int e1,
			int s2, int e2) {
		if (s1 > e1 || s2 > e2) {
			return null;
		}
		TreeNode node = new TreeNode(postorder[e2]);
		int i = 0;
		for (i = s1; i <= e1; i++) {
			if (inorder[i] == postorder[e2]) {
				break;
			}
		}
		node.left = rec(inorder, postorder, s1, i - 1, s2, s2 + (i - 1 - s1));
		node.right = rec(inorder, postorder, i + 1, e1, s2 + (i - 1 - s1) + 1,
				e2 - 1);
		return node;
	}

}