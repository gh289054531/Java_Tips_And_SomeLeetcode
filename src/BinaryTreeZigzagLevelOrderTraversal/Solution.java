package BinaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}
		travel(root, result);
		return result;
	}

	private void travel(TreeNode root, List<List<Integer>> result) {
		LinkedList<TreeNode> list1 = new LinkedList<TreeNode>();
		list1.add(root);
		boolean direct = true;
		while (!list1.isEmpty()) {
			LinkedList<TreeNode> list2 = new LinkedList<TreeNode>();
			List<Integer> curResult = new ArrayList<Integer>();
			for (TreeNode node : list1) {
				curResult.add(node.val);
				if (direct) {
					if (node.left != null) {
						list2.addFirst(node.left);
					}
					if (node.right != null) {
						list2.addFirst(node.right);
					}
				} else {
					if (node.right != null) {
						list2.addFirst(node.right);
					}
					if (node.left != null) {
						list2.addFirst(node.left);
					}
				}
			}
			result.add(curResult);
			direct = !direct;
			list1 = list2;
		}
	}
}