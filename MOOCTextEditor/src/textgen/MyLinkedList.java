package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		this.head = new LLNode<E> (null);
		this.tail = new LLNode<E> (null);
		this.size = 0;
	}
	
	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		if (element == null) {
			throw new NullPointerException();
		} else {
		LLNode<E> currnode = new LLNode<E> (element);
		if (this.size ==0) {	
			currnode.prev = this.head;
			currnode.next = this.tail;
			this.head.next = currnode;
			this.tail.prev = currnode;
		}
		else {
			currnode.prev = this.tail.prev;
			this.tail.prev.next = currnode;
			currnode.next = this.tail;
			this.tail.prev = currnode;
		}
		this.size ++;
		// TODO: Implement this method
		return true;
	}
	}
	
	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		if (index < 0 || index >= this.size || this.size ==0) {
			throw new IndexOutOfBoundsException();
		}
		else 
		{
			LLNode<E> toget = null;
			LLNode<E> currnode = this.head.next;
			if (index >0) {
			for (int k=0; k < index +1;k++) {
				toget = currnode;
				currnode = currnode.next;
			}
			}
			else {
				toget = this.head.next;
				}
		return toget.data;
		}
		}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		if (element == null) {
			throw new NullPointerException();
		} 
		LLNode<E> n = new LLNode<E> (element);	
			if (index < 0 || index > this.size) {
				throw new IndexOutOfBoundsException();
			}
			else 
			{
				LLNode<E> toget = null;
				LLNode<E> currnode = this.head.next;
				if (index >0 && index < this.size) {
				for (int k=0; k < index;k++) {
					toget = currnode;
					currnode = currnode.next;
				}
				 n.next = toget.next;
				 toget.next.prev = n;
				 n.prev = toget;
				 toget.next = n;
				 this.size++;
				}
				else if (index ==0 && this.size !=0) {
					this.head.next.prev = n;
					n.next = this.head.next;
					this.head.next = n;
					n.prev = this.head;
					this.size++;
					}
				else if (index ==0 && this.size ==0) {
					this.head.next = n;
					n.next = this.tail;
					this.tail.prev = n;
					n.prev = this.head;
					this.size++;
					}
				
				
				else if (index == this.size()-1) {
					this.tail.prev = n.prev;
					this.tail.prev.next = n;
					n.next = this.tail;
					this.tail.prev = n;
					this.size++;
				}
			}
	}
	
		// TODO: Implement this method


	/** Return the size of the list */
	public int size() 
	{
		return this.size;
		// TODO: Implement this method
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
			if (index < 0 || index >= this.size || this.size ==0) {
				throw new IndexOutOfBoundsException();
			}
				LLNode<E> currnode = this.head.next;
				LLNode<E> todelete = currnode;
				
				if (index >0 && index < this.size) {
				for (int k=0; k < index +1;k++) {
					currnode = currnode.next;
					todelete = currnode;
				}
				 todelete.prev.next = todelete.next;
				 todelete.next.prev = todelete.prev;
				 todelete.prev = null;
				 todelete.next = null;
				 this.size = this.size-1;
				}
				
				else if (index ==0 && this.size > 1) {
					this.head.next = todelete.next;
					todelete.next.prev = this.head;
					todelete.prev = null;
					todelete.next = null;
					this.size = this.size-1;
					}
				
				else if (index ==0 && this.size ==1) {
					this.head.next = this.tail;
					this.tail.prev = this.head;
					todelete.prev = null;
					todelete.next = null;
					this.size = this.size-1;
					}
				
				else if (index == this.size()-1) {
					this.tail.prev = todelete.prev;
					todelete.prev.next = this.tail;
					todelete.prev = null;
					todelete.next = null;
				}
		// TODO: Implement this method
		return todelete.data;
			}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		if (element == null) {
			throw new NullPointerException();
		}
		else if (index < 0 || index >= this.size || this.size ==0) {
			throw new IndexOutOfBoundsException();
		}
		else 
		{
			LLNode<E> tochange = null;
			LLNode<E> currnode = this.head.next;
			if (index >0) {
			for (int k=0; k < index +1;k++) {
				tochange = currnode;
				currnode = currnode.next;
			}
			}
			else {
				tochange = this.head.next;
				}
			tochange.data = element;
			return tochange.data;
		}
	}  
}


 class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	
	public LLNode(LLNode<E> prevnode, LLNode<E> nextnode, E element) {
		
		this.data = element;
		this.prev = prevnode;
		this.next = nextnode;
	}
}


