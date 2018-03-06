package Trees;

import java.util.Stack;

public class Tree {

	Node root;

	public Tree() {
		root = null;
	}

	public void add(int element) {

		Node node = new Node(element);
		if (root == null) {
			root = node;
			return;
		}

		Node parent = root;
		Node ptr = root;
		boolean isLeft = true;

		if (ptr == null) {
			ptr = node;
			return;
		}

		while (ptr != null) {
			parent = ptr;
			if (element <= ptr.val) {
				ptr = ptr.left;
				isLeft = true;
			} else {
				ptr = ptr.right;
				isLeft = false;
			}
		}

		if (isLeft) {
			parent.left = node;
			node.parent = parent;
		}

		else {
			parent.right = node;
			node.parent = parent;
		}

	}

	public boolean search(int element) {

		Node ptr = root;

		if (root == null)
			return false;

		if (root.val == element)
			return true;

		while (ptr != null) {
			if (element == ptr.val)
				return true;

			if (element < ptr.val)
				ptr = ptr.left;
			else
				ptr = ptr.right;
		}

		return false;
	}

	public boolean remove(int element) {
		if (root == null)
			return false;

		// if you are deleting a root node
		if (root.val == element) {

			if (root.left == null && root.right == null) {
				root = null;
				return true;
			}

			if (root.left != null && root.right == null) {
				root = root.left;
				root.parent = null;
				return true;
			}

			if (root.left == null && root.right != null) {
				root = root.right;
				root.parent = null;
				return true;
			}

			if (root.left != null && root.right != null) {
				Node minNode = getMinElement(root.right, root);
				Node minNodeParent = getMinElement(root.right, root);
				root.val = minNode.val;
				minNodeParent.left = null;
				return true;
			}

		}

		// If it is not the root node then iterate through the entire tree and
		// search for the element
		Node parent = null;
		Node ptr = root;
		while (ptr != null) {
			parent = ptr;
			if (root.val == element)
				break;
			if (element < root.val)
				ptr = ptr.left;

			ptr = ptr.right;
		}

		// If you could not find that element in the tree the return false
		if (ptr == null)
			return false;

		// If it is a leaf node
		if (ptr.left == null && ptr.right == null) {
			if (parent.left == ptr) {
				parent.left = null;
				return true;
			}

			if (parent.right == ptr) {
				parent.right = null;
				return true;
			}

		}

		// Deleting an intermediate node with one child
		if (ptr.left != null && ptr.right == null) {
			if (parent.left == ptr) {
				parent.left = ptr.left;
				ptr.left.parent = parent;
				return true;
			}

			if (parent.right == ptr) {
				parent.right = ptr.left;
				ptr.left.parent = parent;
				return true;
			}
		}

		if (ptr.left == null && ptr.right != null) {
			if (parent.left == ptr) {
				parent.left = ptr.right;
				ptr.right.parent = parent;
				return true;
			}

			if (parent.right == ptr) {
				parent.right = ptr.right;
				ptr.right.parent = parent;
				return true;
			}
		}

		// Deleting an intermediate node with two child
		if (ptr.left != null && ptr.right != null) {
			Node minNode = getMinElement(ptr.right, ptr);
			Node minNodeParent = getMinElement(ptr.right, ptr);
			ptr.val = minNode.val;
			minNodeParent.left = null;
			return true;
		}

		return false;
	}

	public Node getMinElement(Node root, Node Parent) {

		Node ptr = root;
		Node parent = Parent;

		while (ptr.left != null) {
			parent = ptr;
			ptr = ptr.left;
		}
		return ptr;
	}

	public Node getMinElementParent(Node root, Node Parent) {

		Node ptr = root;
		Node parent = Parent;

		while (ptr.left != null) {
			parent = ptr;
			ptr = ptr.left;
		}
		return parent;
	}

	public void inOrderTraversal(Node root) {
		if (root == null)
			return;

		inOrderTraversal(root.left);
		System.out.println(root.val);
		inOrderTraversal(root.right);
	}

	public void preOrderTraversal(Node root) {
		if (root == null)
			return;

		System.out.println(root.val);
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}

	public void postOrderTraversal(Node root) {
		if (root == null)
			return;

		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.println(root.val);
	}

	public void inOrderTraversalReversed(Node root) {
		if (root == null)
			return;

		inOrderTraversal(root.right);
		System.out.println(root.val);
		inOrderTraversal(root.left);

	}

	public void levelOrderTraversal(Node root) {

	}

	public void inOrderTraversalIterative(Node root) {

	}

	public void preOrderTraversalIterative(Node root) {
		
	}

	public void postOrderTraversalIterative(Node root) {

	}

	public void levelOrderTraversalIterative(Node root) {

	}
	
	public void myOwnPostOrderTraversal(Node root) {}

	public void printStrategy(int strategy) {
		if (strategy == 1)
			inOrderTraversal(root);
		else if (strategy == 2)
			preOrderTraversal(root);
		else if (strategy == 3)
			postOrderTraversal(root);
		else if (strategy == 4)
			inOrderTraversalReversed(root);
		else if (strategy == 5)
			myOwnPostOrderTraversal(root);
		else if (strategy == 6)
			levelOrderTraversal(root);
	}

	public static void main(String[] args) {
		Tree bt = new Tree();

		bt.add(4);
		bt.add(2);
		bt.add(1);
		bt.add(300);
		bt.add(5);
		bt.add(-10);
		bt.add(45);
		bt.add(40);
		bt.add(-5);
		bt.add(-55);

		 System.out.println("***================================***");
		 bt.printStrategy(1);
		 System.out.println("***================================***");
		 System.out.println("Is element present ? :" + bt.search(35));
		 bt.remove(45);
		System.out.println("***================================***");
		bt.printStrategy(3);
		System.out.println("\n***================================***");

		//System.out.println("***================================***");
		bt.printStrategy(5);
		System.out.println("\n***================================***");
		bt.printStrategy(6);
	}

}
