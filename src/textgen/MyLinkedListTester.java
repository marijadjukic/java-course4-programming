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
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// TODO: Add more tests here
		int three = longerList.remove(3);
		int nine = longerList.remove(8);
		assertEquals("Remove: check three is correct ", 3, three);
		assertEquals("Remove: check three is correct ", 9, nine);
		assertEquals("Remove: check element 3 is correct ", (Integer)4, longerList.get(3));
		assertEquals("Remove: check element 7 is correct ", (Integer)8, longerList.get(7));
		assertEquals("Remove: check size is correct ", 8, longerList.size());

		try {
			shortList.remove(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {

		}

		try {
			shortList.remove(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {

		}

		try {
			emptyList.remove(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {

		}

	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		shortList.add("C");
		String c = shortList.get(2);
		assertEquals("AddEnd: check c is correct ", "C", c);
		assertEquals("AddEnd: check element 1 is correct ", (String) "B", shortList.get(1));
		assertEquals("AddEnd: check element 0 is correct ", (String) "A", shortList.get(0));
		assertEquals("AddEnd: check size is correct ", 3, shortList.size());

		for(int i = 0; i < 12; i=i+2) {
			emptyList.add(i);
		}
		int first = emptyList.get(0);
		int last = emptyList.get(5);
		assertEquals("AddEnd: check first is correct ", 0,first);
		assertEquals("AddEnd: check last is correct ", 10,last);
		assertEquals("AddEnd: check element 4 is correct ", (Integer)8,emptyList.get(4));
		assertEquals("AddEnd: check size is correct ", 6,emptyList.size());

		try{
			list1.add(null);
			fail("Null pointer");
		} catch (NullPointerException e){

		}
		
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		assertEquals("Size: check size is correct ", 0,emptyList.size());

		for (int i = 10; i < 50; i++) {
			longerList.add(i);
		}
		assertEquals("Size: check size is correct ", 50,longerList.size());

		shortList.remove(0);
		shortList.remove(0);
		assertEquals("Size: check size is correct ", 0,shortList.size());

	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		list1.add(1,55);
		list1.add(3,100);
		int num1 = list1.get(1);
		int num2 = list1.get(3);
		assertEquals("Add at index: check num1 is correct ", 55,num1);
		assertEquals("Add at index: check num2 is correct ", 100,num2);
		assertEquals("Add at index: check element 2 is correct ", (Integer)21,list1.get(2));
		assertEquals("Add at index: check element 4 is correct ", (Integer)42,list1.get(4));
		assertEquals("Add at index: check size is correct ", 5,list1.size());

		shortList.add(0,"O");
		String o = shortList.get(0);
		assertEquals("Add at index: check o is correct ", "O",o);
		assertEquals("Add at index: check element 1 is correct ", (String)"A",shortList.get(1));
		assertEquals("Add at index: check size is correct ", 3,shortList.size());

		emptyList.add(0,0);
		int num = emptyList.get(0);
		assertEquals("Add at index: check num is correct ", 0,num);
		assertEquals("Add at index: check element 0 is correct ", (Integer)0,emptyList.get(0));
		assertEquals("Add at index: check size is correct ", 1,emptyList.size());

		try {
			emptyList.add(-1,0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}

		try {
			shortList.add(0,null);
			fail("Null pointer");
		}
		catch (NullPointerException e) {

		}

		try {
			longerList.add(15,15);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e){

		}
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
	    String A = shortList.set(0,"a");
	    String B = shortList.set(1,"b");

		assertEquals("Set: check A is correct ", "A",A);
		assertEquals("Set: check element 0 is correct ", (String)"a",shortList.get(0));
		assertEquals("Set: check a is correct ", "B",B);
		assertEquals("Set: check element 0 is correct ", (String)"b",shortList.get(1));

		try {
			longerList.set(10, 10);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {

		}

		try {
			longerList.set(0, null);
			fail("Null pointer");
		}
		catch (NullPointerException e) {

		}

		try {
			emptyList.set(0, 0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {

		}
	}
	
	
	// TODO: Optionally add more test methods.
	
}
