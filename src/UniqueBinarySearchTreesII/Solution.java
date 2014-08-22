package UniqueBinarySearchTreesII;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
		left = null;
		right = null;
	}
}

public class Solution {
	public List<TreeNode> generateTrees(int n) {
		List<TreeNode> result = new ArrayList<TreeNode>();
		if (n < 1) {
			result.add(null);
			return result;
		}
		return generate(1, n);
	}

	private List<TreeNode> generate(int l, int h) {
		List<TreeNode> ret = new ArrayList<TreeNode>();
		if (l > h) {
			ret.add(null);
			return ret;
		}
		for (int i = l; i <= h; i++) {
			List<TreeNode> leftChilds = generate(l, i - 1);
			List<TreeNode> rightChilds = generate(i + 1, h);
			for (int m = 0; m < leftChilds.size(); m++) {
				for (int n = 0; n < rightChilds.size(); n++) {
					TreeNode node = new TreeNode(i);
					node.left = leftChilds.get(m);
					node.right = rightChilds.get(n);
					ret.add(node);
				}
			}
		}
		return ret;
	}
}