package linkedlist;

import static org.junit.Assert.*;

import org.junit.Test;

public class NodeTest {

	@Test
	public void testNode() {
		Node<Integer> nodeTest = new Node<Integer>();
		assertTrue(nodeTest.getData()==null && nodeTest.getNext()==null
				&& nodeTest.getPosition() == 0);
	}

	@Test
	public void testNodeTNodeOfTNodeOfTGetNext() {
		Node<Integer> nodeTest1 = new Node<Integer>();
		Node<Integer> nodeTest2 = new Node<Integer>(1, nodeTest1);
		assertTrue(nodeTest2.getNext()==nodeTest1);
	}

	@Test
	public void testSetGetData() {
		Node<Integer> nodeTest = new Node<Integer>();
		nodeTest.setData(10);
		assertTrue(nodeTest.getData()==10);
	}

	@Test
	public void testSetNext() {
		Node<Integer> nodeTest1 = new Node<Integer>();
		Node<Integer> nodeTest2 = new Node<Integer>(1, nodeTest1);
		nodeTest2.setNext(nodeTest1);
		assertTrue(nodeTest2.getNext()==nodeTest1);
	}

	@Test
	public void testSetGetPosition() {
		Node<Integer> nodeTest1 = new Node<Integer>();
		assertTrue(nodeTest1.getPosition()==0);
	}

}
