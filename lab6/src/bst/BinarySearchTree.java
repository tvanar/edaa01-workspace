package bst;

import java.util.ArrayList;
import java.util.Comparator;


public class BinarySearchTree<E> {
	BinaryNode<E> root; // Används också i BSTVisaulizer
	int size; // Används också i BSTVisaulizer
	private Comparator<E> comp;

	public static void main(String[] args) {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.add(3);
		tree.add(5);
		tree.add(1);
		tree.add(7);
		tree.add(11);
		tree.add(9);
		tree.add(13);
		

		BSTVisualizer visualizer = new BSTVisualizer("Draw Tree", 400, 400);
		// visualizer.drawTree(tree);
		// tree.rebuild();
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
		root = buildTree(sorted, 0, size);
	}


	/*
	 * Adds all elements from the tree rooted at n in inorder to the list sorted.
	 */
	private void toArray(BinaryNode<E> n, ArrayList<E> sorted) { //funkar
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
		return null;
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