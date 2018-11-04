package arboles;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import entities.Dragon;

public class ArbolesTest {
	ArbolAVL avl;
	BTree arbolB;
	Node nodo;
	Node nodoR;
	Node nodoL;
	ArbolBinario BinArb;
	Dragon Padre;
	Dragon dragon;
	
	
	@Before
	public void Before() {
		avl=new ArbolAVL();
	}
	
	@Test
	public void maxTest() {
		int a=7;
		int b=21;
		int mayor=avl.max(a, b);
		assertEquals(mayor,b);
	}
	
	@Test
	public void NodeTest() {
		nodoR=new Node();
		nodoL=new Node();
		
		nodoR.data=7;
		nodoL.data=3;
		
		nodo=new Node();
		nodo.data=5;
		nodo.right=nodoR;
		nodo.left=nodoL;
		
		assertEquals(nodo.right.data,nodoR.getData());
		assertEquals(nodo.left.data,nodoL.getData());	
		
	}
	
	@Test
	public void ArbolBinarioTest() {
		BinArb=new ArbolBinario();
		dragon=new Dragon(1,"Padre");
		Padre=new Dragon(1,null);
		BinArb.insertarNodo(dragon, Padre);
		assertFalse(BinArb.estaVacio());

	}
	
	

}
