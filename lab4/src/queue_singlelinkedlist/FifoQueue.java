package queue_singlelinkedlist;

import java.util.*;

public class FifoQueue<E> extends AbstractQueue<E> implements Queue<E> {
	private QueueNode<E> last;
	private int size;

	public FifoQueue() {
		super();
		last = null;
		size = 0;
	}

	/**
	 * Inserts the specified element into this queue, if possible
	 * post: The specified element is added to the rear of this queue
	 * 
	 * @param e the element to insert
	 * @return true if it was possible to add the element
	 *         to this queue, else false
	 */
	public boolean offer(E e) {
		QueueNode<E> add = new QueueNode<>(e);
		if (last == null) {
			size++;
			last = add;
			last.next = last;
		} else {
			size++;
			add.next = last.next;
			last.next = add;
			last = add;
		}
		return true;
	}

	/**
	 * Returns the number of elements in this queue
	 * 
	 * @return the number of elements in this queue
	 */
	public int size() {
		return size;
	}

	/**
	 * Retrieves, but does not remove, the head of this queue,
	 * returning null if this queue is empty
	 * 
	 * @return the head element of this queue, or null
	 *         if this queue is empty
	 */
	public E peek() {
		if (last == null) {
			return null;
		} else {
			return last.next.element;
		}
	}

	/**
	 * Retrieves and removes the head of this queue,
	 * or null if this queue is empty.
	 * post: the head of the queue is removed if it was not empty
	 * 
	 * @return the head of this queue, or null if the queue is empty
	 */
	public E poll() {
		if (last == null) {
			return null;
		}
		E temp = last.next.element;
		if (size == 1) {
			last = null;
		} else {
			last.next = last.next.next;
		}
		size--;
		return temp;
	}

	/**
	 * Returns an iterator over the elements in this queue
	 * 
	 * @return an iterator over the elements in this queue
	 */
	public Iterator<E> iterator() {
		return new QueueIterator();
	}

	/**
	 * Appends the specified queue to this queue
	 * post: all elements from the specified queue are appended
	 * to this queue. The specified queue (q) is empty after the call.
	 * 
	 * @param q the queue to append
	 * @throws IllegalArgumentException if this queue and q are identical
	 */
	public void append(FifoQueue<E> q) {
		if (q.equals(this)) {
			throw new IllegalArgumentException();
		} else if (q.size == 0) {
			return;
		} else if (last == null) {
			last = q.last;
			size = q.size;
		} else {
			QueueNode<E> temp = q.last.next;
			q.last.next = last.next;
			last.next = temp;
			last = q.last;
			size += q.size;
		}
	}

	private static class QueueNode<E> {
		E element;
		QueueNode<E> next;

		private QueueNode(E x) {
			element = x;
			next = null;
		}
	}

	private class QueueIterator implements Iterator<E> {

		private QueueNode<E> pos;

		private QueueIterator() {
			try {
				pos = last.next;
			} catch (NullPointerException e) {
				pos = null;
			}
		}
		

		public boolean hasNext() {
			return pos != null;
		}

		public E next() {
			if (pos == null) {
				throw new NoSuchElementException();
			} 
			if (pos == last) {
				pos = null;
				return last.element;
			}
			E temp = pos.element;
			pos = pos.next;
			return temp;
		}
	}
}