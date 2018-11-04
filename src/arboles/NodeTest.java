package arboles;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class NodeTest {
	Node nodo;
	Node nodoR;
	Node nodoL;
	
	@Before
	public void Before() {
		nodo=new Node(67);	
		nodoR=new Node(56);
		nodoL=new Node(45);
		nodo.setRight(nodoR);
		nodo.setLeft(nodoL);
		nodo.setX(22);
		nodo.setY(11);
	}
	
	@Test
	public void getDataTest() {
		assertTrue(nodo.getData()==67);
	}
	@Test
	public void setDataTest() {
		Integer data=16;
		nodo.setData(data);
		assertFalse(nodo.getData()!=data);
	}
	@Test
	public void getRightTest() {
		assertTrue(nodo.getRight()==nodoR);
	}
	@Test
	public void setRightTest() {
		nodo.setRight(nodoL);
		assertFalse(nodo.getRight()==nodoR);
	}
	@Test
	public void getLeftTest() {
		assertTrue(nodo.getLeft()==nodoL);
	}
	@Test
	public void setLeftTest() {
		nodo.setLeft(nodoR);
		assertFalse(nodo.getLeft()==nodoL);
	}
	@Test
	public void getXTest() {
		assertTrue(nodo.getX()==22);
	}
	@Test
	public void setXTest() {
		int x=16;
		nodo.setX(x);
		assertFalse(nodo.getX()!=x);
	}
	@Test
	public void getYTest() {
		assertTrue(nodo.getY()==11);
	}
	@Test
	public void setYTest() {
		int y=61;
		nodo.setY(y);
		assertFalse(nodo.getX()==y);
	}

}
