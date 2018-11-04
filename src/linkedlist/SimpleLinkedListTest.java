package linkedlist;

import static org.junit.Assert.*;

import org.junit.Test;

public class SimpleLinkedListTest {

	@Test
	public void testSimpleLinkedList() {
		SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
		assertTrue(list.getFirst()==null && list.getLength()==0);
	}

	@Test
	public void testIsEmpty() {
		SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
		assertTrue(list.isEmpty());
	}

	@Test
	public void testGetLength() {
		SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
		assertTrue(list.getLength()==0);
	}

	@Test
	public void testAddFront() {
		SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
		list.addFront(10);
		assertTrue(list.getFirst().getData()==10);
	}

	@Test
	public void testDeleteFront() {
		SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
		list.addFront(10);
		list.deleteFront();
		assertTrue(list.isEmpty());
	}

	@Test
	public void testAddLast() {
		SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
		list.addLast(10);
		assertTrue(list.getFirst().getData()==10);
	}

	@Test
	public void testDeleteLast() {
		SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
		list.addFront(10);
		list.deleteLast();
		assertTrue(list.isEmpty());
	}

	@Test
	public void testGet() {
		SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
		list.addLast(10);
		list.addLast(20);
		assertTrue(list.get(1).getData()==20);
		
	}

	@Test
	public void testDeleteByElement() {
		SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
		list.addLast(10);
		list.deleteByElement(10);
		assertTrue(list.isEmpty());
	}

	@Test
	public void testGetFirst() {
		SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
		list.addLast(10);
		assertTrue(list.getFirst().getData()==10);
	}

	@Test
	public void testGetLast() {
		SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		assertTrue(list.getLast().getData()==40);
	}

	@Test
	public void testContains() {
		SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
		list.addFront(10);
		assertTrue(list.contains(10));
	}

}
