package Algorithm;

import java.util.LinkedList;

public class NonRecusivelyPreOrderTraverse {
	public static <T> void Traverse(Node<T> root) {
		if (root == null) {
			return;
		}
		LinkedList<Node<T>> stack = new LinkedList<Node<T>>();
		stack.push(root);
		while (stack.isEmpty() == false) {
			Node<T> node = stack.pop();
			while (node != null) {
				System.out.print(node.val + " ");
				if (node.right != null) {
					stack.push(node.right);
				}
				node = node.left;
			}
		}
	}

	public static void main(String[] args) {
		Node<Integer> n1 = new Node<Integer>(1);
		Traverse(n1);
		System.out.println();
		n1.left = new Node<Integer>(2);
		n1.left.left = new Node<Integer>(3);
		Traverse(n1);
		System.out.println();
		n1.right = new Node<Integer>(4);
		Traverse(n1);
		System.out.println();
		n1.left = null;
		n1.right.right = new Node<Integer>(5);
		Traverse(n1);
		System.out.println();
		n1.right.right = null;
		n1.right.left = new Node<Integer>(5);
		Traverse(n1);
		System.out.println();
	}

	static class Node<T> {
		T val = null;
		Node<T> left = null;
		Node<T> right = null;

		public Node(T t) {
			val = t;
		}
	}
}
