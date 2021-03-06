package programmingAssignment2;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.NullPointerException;
import java.lang.UnsupportedOperationException;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * A randomized queue is similar to a stack or queue, except that the item 
 * removed is chosen uniformly at random from items in the data structure. 
 * 
 * @author Henry Doan
 * @version September 27, 2018
 */

public class RandomizedQueue<Item> implements Iterable<Item> {
	// what all Randomized queue should have
	private Item[] itemQueue;
	private int size;

	/*
	 * Construct an empty randomized queue
	 */
	@SuppressWarnings("unchecked")
	public RandomizedQueue() {
		itemQueue = (Item[]) new Object[2];
		size = 0;
	}
	
	/*
	 * Is the queue empty?
	 * @return true -- boolean on the size is empty.
	 * 		   false --- boolean on the queue isn't empty
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/*
	 * Return the number of items on the queue
	 * @return size -- the number capcity of the queue.
	 */
	public int size() {
		return size;
	}
	
	/*
	 * Resize the underlying array holding the elements 
	 * Method from https://www.youtube.com/watch?v=GNr872PjQMI
	 * he said we can use.
	 * 
	 * @author Robert Sedgewick & Kevin Wayne
	 * @param capacity -- int that is the capacity of the queue.
	 */
	private void resize(int capacity) {
		assert capacity >= size;
		
		// create new array
		@SuppressWarnings("unchecked")
		Item[] temp = (Item[]) new Object[capacity];
		
		// copy items over
		for (int i = 0; i < size; i++) {
			temp[i] = itemQueue[i];
		}
		
		// reassign the queue
		itemQueue = temp;
	}
	
	/*
	 * Add the item.
	 * 
	 * @param item -- Item that is added to the queue.
	 * @throw NullPointerException -- when the item is null.
	 */
	public void enqueue(Item item) {
		// handle if item is null
		if (item == null) {
			throw new NullPointerException("item cannot be null");
		}
		
		// resize the array
		if (size == itemQueue.length) {
			resize(2 * itemQueue.length);
		}
		
		// add item
		itemQueue[size++] = item;
	}
	
	/*
	 * Delete and return a random item.
	 * 
	 * @return item -- the deleted item.
	 * @throw NoSuchElementException -- when the queue is empty.
	 */
	public Item dequeue() {
		// handle if queue is empty
		if (isEmpty()) {
			throw new NoSuchElementException("There are no items");
		}
		
		// delete the item
		Item item = itemQueue[size - 1];
		itemQueue[size - 1] = null;
		size--;
		
		// shrink array
		if(size > 0 && size == itemQueue.length / 4) {
			resize(itemQueue.length / 2);
		}
		
		// return the deleted item
		return item;
	}
	
	/*
	 * Return (but do not delete) a random item.
	 * 
	 * @return random item.
	 * @throw NoSuchElementException -- when the queue is empty.
	 */
	public Item sample() {
		// handle if queue is empty
		if (isEmpty()) {
			throw new NoSuchElementException("There are no items");
		}
		
		// generate a random index from the StdRandom jar file
		int randomIndexFromQueue = StdRandom.uniform(size);
		
		// return random item with the random index
		return itemQueue[randomIndexFromQueue];
	}
	
	/*
	 * Return an independent iterator over items in random order.
	 */
	@Override
	public Iterator<Item> iterator() {
		return new RandomQueueIterator();
	}
	
	private class RandomQueueIterator implements Iterator<Item> {
		private int iteratorSize = size;
		private Item[] copyOfQueue;
		
		/*
		 * Construct a copy of the queue and size.
		 */
		@SuppressWarnings("unchecked")
		private RandomQueueIterator() {
			copyOfQueue = (Item[]) new Object[iteratorSize];
			for (int index = 0; index < iteratorSize; index++) {
				copyOfQueue[index] = itemQueue[index];
			}
		}
		
		/*
		 * Override method to see if the item has next.
		 * 
		 * @return false -- boolean if there is no next item.
		 *         true -- boolean if there is a next item.
		 */
		@Override
		public boolean hasNext() {
			return iteratorSize > 0;
		}
		
		/*
		 * Override method to go to the next item.
		 * 
		 * @return nextItem -- Item  that is next
		 * @throw NoSuchElementException -- there is no next element
		 */
		@Override
		public Item next() {
			if(hasNext() == false) {
				throw new NoSuchElementException("no more items to go next to");
			}
			
			int randomIndexFromQueue = StdRandom.uniform(iteratorSize);
			Item nextItem = copyOfQueue[randomIndexFromQueue];
			
			if (randomIndexFromQueue != size - 1) {
				copyOfQueue[randomIndexFromQueue] = copyOfQueue[iteratorSize - 1];
			}
			
			copyOfQueue[--iteratorSize] =  null;
			return nextItem;
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
		RandomizedQueue<String> testQueue = new RandomizedQueue<String>();
		//enqueue
		testQueue.enqueue("a");
		testQueue.enqueue("b");
		testQueue.enqueue("c");
		testQueue.enqueue("d");
		
		// testing iterator
		Iterator<String> testI = testQueue.iterator();
		// test the iterator to have next item
		StdOut.println("items iterator: " + testI.next());
		StdOut.println("items iterator: " + testI.next());
				
		// end of the queue
		StdOut.println("items iterator has next: " + testI.hasNext());

		// checks the size
		StdOut.println("items in queue after enqueue: " + testQueue.size());
		
		// test the sample method
		StdOut.println("sample: " + testQueue.sample());
		
		// dequeue
		testQueue.dequeue();
		testQueue.dequeue();
		testQueue.dequeue();
		testQueue.dequeue();
		
		// check the size and empty
		StdOut.println("items in queue after dequeue: " + testQueue.size());
		StdOut.println("is the queue empty: " + testQueue.isEmpty());
		
	}	

}
