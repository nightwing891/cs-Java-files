package programmingAssignment2;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.NullPointerException;
import java.lang.UnsupportedOperationException;

import edu.princeton.cs.algs4.StdOut;

/**
 * A double ended queue or deque is a generalization of a stack and a queue 
 * that supports inserting and removing items from either the front or the 
 * back of the data structure.
 * 
 * @author Henry Doan
 * @version September 27, 2018
 */

public class Deque<Item> implements Iterable<Item> {
	// what all Deque has
	private int size;
	private Node<Item> first, last;
	
	/*
	 * Construct a node for linked list
	 */
	private static class Node<Item> {
		private Item item;
		private Node<Item> next, previous;
	}
	
	/*
	 * Construct an empty deque
	 */
	public Deque() {
		first = last = null;
		size = 0;
	}
	
	/*
	 * Is the deque empty?
	 * 
	 * @return true boolean -- if the deque is empty.
	 * 		   false boolean -- if there are items in the deque.
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/*
	 * Return the number of items on the deque.
	 * 
	 * @return size -- the number of the size of the deque.
	 */
	public int size() {
		return size;	
	}
	
	/*
	 * Insert the item at the front.
	 * 
	 * @param item -- item that is added
	 * @throw NullPointerException -- if item is null
	 */
	public void addFirst(Item item) {
		// handle when item is null
		if (item == null) {
			throw new NullPointerException("Item cannot be null");
		}
		
		// if empty list then have the first be the item.
		if (first == null) {
			first = new Node<Item>();
			first.item = item;
		}
 		
		// add the item to the first.
		Node<Item> second = first;
		first = new Node<Item>();
		first.item = item;
		first.next = second;
		size++;
	}
	
	/*
	 * Insert the item at the end.
	 * 
	 * @param item -- item that is added
	 * @throw NullPointerException -- if item is null
	 */
	public void addLast(Item item) {
		// handles when item is null
		if (item == null) {
			throw new NullPointerException("Item cannot be null");
		}
		
		// add the item to the last node
		Node<Item> secondToLast = last;
		last = new Node<Item>();
		last.item = item;
		last.previous = secondToLast;
		size++;
	}
	
	/*
	 * Delete and return the item at the front.
	 * 
	 * @throw NoSuchElementException -- when deque is empty
	 * @return item -- the item that is removed.
	 */
	public Item removeFirst() {
		// handle is the deque is empty
		if (isEmpty()) {
			throw new NoSuchElementException("Deque is empty");
		}
		
		// remove item at the first
		Item item = first.item;
		first = first.next;
		size--;
		
		// return item
		return item;
	}
	
	/*
	 * Delete and return the item at the end.
	 * 
	 * @throw NoSuchElementException -- when deque is empty
	 * @return item -- the item that is removed.
	 */
	public Item removeLast() {
		// handle is the deque is empty
		if (isEmpty()) {
			throw new NoSuchElementException("Deque is empty");
		}
		
		// remove item at the end
		Item item = last.item;
		last = last.previous;
		size--;
		
		// return item
		return item;
	}
	
	/*
	 * Return an iterator over items in order from front to end.
	 * 
	 * @return the iterator that orders from the front to end.
	 */
	public Iterator<Item> iterator() {
		return new DequeIterator();
	}
	
	private class DequeIterator implements Iterator<Item> {
		private Node<Item> current = first;
		
		/*
		 * Override method to see if the node has next.
		 * 
		 * @return false -- boolean if there is no next node.
		 *         true -- boolean if there is a next node.
		 */
		@Override
		public boolean hasNext() {
			if (current.next == null) {
				return false;
			}
			return true;
		}

		/*
		 * Override method to go to the next node.
		 * 
		 * @return item -- Item node that is next
		 * @throw NoSuchElementException -- there is no next element
		 */
		@Override
		public Item next() {
			// handle if there is no next node
			if (hasNext() == false ) {
				throw new NoSuchElementException("No more items to return");
			}
			
			// get the next node
			Item item = current.item;
			current = current.next;
			
			// return item
			return item;
		}
		
		/*
		 * Override method to not to be able to call this method
		 * @throw UnsupportedOperationException -- when you call on this method
		 */
		@Override
		public void remove() {
			throw new UnsupportedOperationException("You should not call remove");
		}
	}
	
	
	/*
	 * Unit testing
	 */
	public static void main(String[] args) {
		Deque<String> testDeque = new Deque<String>();
		// add items
		testDeque.addFirst("a");
		testDeque.addFirst("b");
		testDeque.addLast("c");
		testDeque.addLast("d");
		
		// testing iterator
		Iterator<String> testI = testDeque.iterator();
		// test the iterator to have next item
		StdOut.println("items iterator: " + testI.next());
		StdOut.println("items iterator: " + testI.next());
		
		// end of the queue
		StdOut.println("items iterator has next: " + testI.hasNext());

		
		// size method should be 4 since we added 4 items
		StdOut.println("items after we added: " + testDeque.size());
		
		// remove items
		testDeque.removeFirst();
		testDeque.removeFirst();
		testDeque.removeLast();
		testDeque.removeLast();

		// size should be 0
		StdOut.println("items after we remove: " + testDeque.size());
		
		// test out the is empty method to be true for empty deck
		StdOut.println("is the deque empty: " + testDeque.isEmpty());

	}
	

}
