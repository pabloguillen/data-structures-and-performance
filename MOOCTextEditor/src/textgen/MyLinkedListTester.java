/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	//@Test
	public void testRemove()
	{
		int test = list1.get(2);
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		assertEquals ("Remove: check element 1 is correct ", (Integer) test, list1.get(1));
		try
		{
			list1.remove(-1);
			fail ("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		try
		{
			list1.remove(list1.size);
			fail ("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		try
		{
			list1.remove(null);
			fail ("Check null pointer");
		}
		catch (NullPointerException n) {
		}
		
		// TODO: Add more tests here
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
		shortList.add("C");
		try
		{
			shortList.add(null);
			fail ("Check element to add");
		}
		catch (NullPointerException n) {
		}
		int a = shortList.size -1;
		assertEquals("Add: Check last element is added ", "C", shortList.get(a));
        // TODO: implement this test
		int oldsize = shortList.size;
		shortList.add("D");
		int newsize = shortList.size;
		assertEquals("Add: Check if size was updated ", oldsize +1, newsize);
		assertEquals ("Add: Check if attached at the ende ", "D", shortList.tail.prev.data);
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		assertEquals("Size: Check if size is correct", 2, shortList.size);
		// TODO: implement this test
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
		try
		{
			shortList.add(1, null);
			fail ("Check element to add");
		}
		catch (NullPointerException n) {
		}
		try
		{
		shortList.add(-1, "Z");
		fail ("Check element to add");
		}
		catch (IndexOutOfBoundsException e) {
		}
		try
		{
		shortList.add(3, "Z");
		fail ("Check element to add");
		}
		catch (IndexOutOfBoundsException e) {
		}
		shortList.add(1,"Z");
		assertEquals("Add at Index: Check element ", "Z", shortList.get(1));
		assertEquals ("Add at Index: Check size ", 3, shortList.size);
		assertEquals("Add at Index: Check movement of element", "B", shortList.get(2));
        // TODO: implement this test
		
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{

		try
		{
			shortList.set(1, null);
			fail ("Check element to set");
		}
		catch (NullPointerException n) {
		}
		try
		{
		shortList.set(-1, "Z");
		fail ("Check element to set");
		}
		catch (IndexOutOfBoundsException e) {
		}
		try
		{
		shortList.set(3, "Z");
		fail ("Check element to set");
		}
		catch (IndexOutOfBoundsException e) {
		}
		shortList.set(0,"X");
		assertEquals("Set: Check result ", "X",shortList.get(0));
	    // TODO: implement this test
	    
	}
	
	
	// TODO: Optionally add more test methods.
	
}
