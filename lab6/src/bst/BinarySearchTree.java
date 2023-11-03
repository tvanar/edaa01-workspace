package bst;

import java.util.ArrayList;
import java.util.Comparator;

public class BinarySearchTree<E> {
	BinaryNode<E> root; // Används också i BSTVisaulizer
	int size; // Används också i BSTVisaulizer
	private Comparator<E> ccomparator;

	/**
	 * Constructs an empty binary search tree.
	 */

	//känns fett olagligt att casta såhär
	public BinarySearchTree() {
		this.root = null;
		ccomparator = (o1, o2) -> ((Comparable<E>) o1).compareTo(o2);
	}

	/**
	 * Constructs an empty binary search tree, sorted according to the specified
	 * comparator.
	 */
	public BinarySearchTree(Comparator<E> comparator) {
		this.ccomparator = comparator;
	}

	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 * 
	 * @param x element to be inserted
	 * @return true if the the element was inserted
	 */
	public boolean add(E x) {
		BinaryNode<E> add = new BinaryNode<E>(x);
		if (root == null) {
			root = add;
			return true;
		} else if (root.element.compareTo(x.element) < 0) {
			
		}
		
	}

	/**
	 * Computes the height of tree.
	 * 
	 * @return the height of the tree
	 */
	public int height() {
		int right;
		int left;
		if (root == null) {
			return 0;
		} else {
			right = findHeight(root.left, 1);
			left = findHeight(root.right, 1);
		}
		return Math.max(right, left);
	}

	/**
	 * Returns the number of elements in this tree.
	 * 
	 * @return the number of elements in this tree
	 */
	public int size() {
		return 0;
	}

	/**
	 * Removes all of the elements from this list.
	 */
	public void clear() {

	}

	/**
	 * Print tree contents in inorder.
	 */
	public void printTree() {

	}

	/**
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() {

	}

	/*
	 * Adds all elements from the tree rooted at n in inorder to the list sorted.
	 */
	private void toArray(BinaryNode<E> n, ArrayList<E> sorted) {

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

	private int findHeight(BinaryNode<E> node, int height) {
		if (node.left != null) {
			findHeight(node.left, height + 1);
		} else if (node.right != null) {
			findHeight(node.right, height + 1);
		}
		return height;

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
