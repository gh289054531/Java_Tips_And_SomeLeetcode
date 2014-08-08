package Algorithm;

public class ParentToSilbing {
	public static <T> Node<T> Convert(Node<T> root) {
		if (root == null) {
			return null;
		}
		if (root.left == null && root.right == null) {
			return new Node<T>(root.val);
		}
		Node<T> virtual = new Node<T>(root.val);
		virtual.left = Convert(root.left);
		if (virtual.left != null) {
			virtual.left.right = Convert(root.right);
		} else {
			virtual.left = Convert(root.right);
		}
		return virtual;
	}

	public static void main(String[] args) {
		Node<Integer> result = null;
		Node<Integer> n1 = new Node<Integer>(1);
		result = Convert(n1);
		System.out.println();
		n1.left = new Node<Integer>(2);
		n1.left.left = new Node<Integer>(3);
		result = Convert(n1);
		System.out.println();
		n1.right = new Node<Integer>(4);
		result = Convert(n1);
		System.out.println();
		n1.left = null;
		n1.right.right = new Node<Integer>(5);
		result = Convert(n1);
		System.out.println();
		n1.right.right = null;
		n1.right.left = new Node<Integer>(5);
		result = Convert(n1);
		System.out.println();
	}

	static class Node<T> {
		T val = null;
		Node<T> left = null;
		Node<T> right = null;

		public Node(T t) {
			val = t;
		}

		public Node() {
		}

		@Override
		public String toString() {
			return val.toString();
		}
	}
}
