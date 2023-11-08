package bst;

import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.util.ArrayList;
import java.util.Comparator;

public class BinarySearchTree<E> {
	BinaryNode<E> root; // Används också i BSTVisaulizer
	int size; // Används också i BSTVisaulizer
	private Comparator<E> comp;

	public static void main(String[] args) {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		Random rand = new Random();
		for (int i = 0; i < 100; i++) {
			tree.add(rand.nextInt(101));
		}
		BSTVisualizer visualizer = new BSTVisualizer("Draw Tree", 500, 400);
		tree.rebuild();
		visualizer.drawTree(tree);
	}

	/**
	 * Constructs an empty binary search tree.
	 */

	// känns fett olagligt att casta såhär
	// borde funka sålänge man inte använder object utan comparatorer
	public BinarySearchTree() {
		size = 0;
		this.root = null;
		comp = (o1, o2) -> ((Comparable<E>) o1).compareTo(o2);
	}

	/**
	 * Constructs an empty binary search tree, sorted according to the specified
	 * comparator.
	 */
	public BinarySearchTree(Comparator<E> comparator) {
		this.comp = comparator;
	}

	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 * 
	 * @param x element to be inserted
	 * @return true if the the element was inserted
	 */
	public boolean add(E x) {
		return add(root, x);
	}

	private boolean add(BinaryNode<E> node, E x) { // privat hjälpmethod
		if (root == null) {
			root = new BinaryNode<E>(x);
			size++;
			return true;
		} else if (x == node.element) {
			return false;
		} else if (comp.compare(x, node.element) < 0) {
			if (node.left == null) {
				node.left = new BinaryNode<E>(x);
				size++;
				return true;
			} else {
				return add(node.left, x);
			}
		} else if (comp.compare(x, node.element) > 0) {
			if (node.right == null) {
				node.right = new BinaryNode<E>(x);
				size++;
				return true;
			} else {
				return add(node.right, x);
			}
		}
		return false;
	}

	/**
	 * Computes the height of tree.
	 * 
	 * @return the height of the tree
	 */
	public int height() {
		return height(root);
	}

	/*
	 * räknar antalet hörn, om hörn finns => +1
	 */
	private int height(BinaryNode<E> node) { // privat hjälpmetod
		if (node == null) {
			return 0;
		} else {
			int left = height(node.left);
			int right = height(node.right);
			return 1 + Math.max(left, right);
		}
	}

	/**
	 * Returns the number of elements in this tree.
	 * 
	 * @return the number of elements in this tree
	 */
	public int size() {
		return size;
	}

	/**
	 * Removes all of the elements from this list.
	 */
	public void clear() {
		root = null;
		size = 0;
	}

	/**
	 * Print tree contents in inorder.
	 */
	public void printTree() {
		printTree(root);
	}

	private void printTree(BinaryNode<E> node) {
		if (node == null) {
			return;
		}
		printTree(node.left);
		System.out.print(node.element + ", ");
		printTree(node.right);
	}

	/**
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() {
		ArrayList<E> sorted = new ArrayList<>();
		toArray(root, sorted);
		root = buildTreeAlt(sorted, 0, size - 1);
	}

	/*
	 * Adds all elements from the tree rooted at n in inorder to the list sorted.
	 */
	private void toArray(BinaryNode<E> n, ArrayList<E> sorted) { // funkar
		if (n == null) {
			return;
		}
		toArray(n.left, sorted);
		sorted.add(n.element);
		toArray(n.right, sorted);
	}

	/*
	 * Builds a complete tree from the elements from position first to
	 * last in the list sorted.
	 * Elements in the list a are assumed to be in ascending order.
	 * Returns the root of tree.
	 */
	private BinaryNode<E> buildTree(ArrayList<E> sorted, int first, int last) {
		ArrayList<E> top = new ArrayList<>();
		ArrayList<E> bottom = new ArrayList<>();
		int mid = 0;
		if (!sorted.isEmpty()) {
			if(!(sorted.size() == 1)) {
				mid = ((first + last) / 2);
			}
			BinaryNode<E> node = new BinaryNode<E>(sorted.get(mid));
			for (int i = 0; i < sorted.size(); i++) {
				if (i < mid) {
					bottom.add(sorted.get(i));
				} else if (i > mid) {
					top.add(sorted.get(i));
				}
			}
			node.left = buildTree(bottom, first, mid-1);
			node.right = buildTree(top, first, mid);
			return node;
		}
		return null;
	}

	private BinaryNode<E> buildTreeAlt(ArrayList<E> sorted, int first, int last) {
		if (first > last) {
			return null;
		}
		int mid = ((first + last) / 2);
		BinaryNode<E> node = new BinaryNode<E>(sorted.get(mid));
		// behöver inte bygga nya listor, räcker med att förskjuta index
		node.left = buildTreeAlt(sorted, first, mid - 1);
		node.right = buildTreeAlt(sorted, mid + 1, last);
		return node;
	}

	static class BinaryNode<E> {
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;

		private BinaryNode(E element) {
			this.element = element;
		}

	}

}