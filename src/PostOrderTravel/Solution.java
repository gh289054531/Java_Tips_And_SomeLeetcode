package PostOrderTravel;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		stack1.push(root);
		while (root.left != null) {
			stack1.push(root.left);
			root = root.left;
		}
		while (stack1.isEmpty() == false) {
			TreeNode node = stack1.peek();
			if (stack2.isEmpty() == false && stack2.peek() == node) {
				result.add(node.val);
				stack1.pop();
				stack2.pop();
			} else {
				stack2.push(node);
				if (node.right != null) {
					stack1.push(node.right);
					node = node.right;
					while (node.left != null) {
						stack1.push(node.left);
						node = node.left;
					}
				}
			}
		}
		return result;
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