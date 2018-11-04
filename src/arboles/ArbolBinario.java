package arboles;

import entities.Dragon;

public class ArbolBinario {
	NodoArbol root;
	
	public ArbolBinario() {
		root=null;
	}
	
	/**
	 * Este metodo inserta un nuevo dragon al arbol considerando que el padre debe estar en la raiz
	 * @param dragon
	 * @param padre
	 */
	public void insertarNodo(Dragon dragon,Dragon padre) {
		NodoArbol nuevo=new NodoArbol(dragon,padre);
		
//		si el padre es nulo o la raiz es nula
		if(padre==null || root==null) {
			root=nuevo;
			nuevo.dragon=dragon;
			nuevo.padre=padre;
		}
//		si el dragon que se inserta no tiene padre pero la raiz no esta vacia
		if(padre==null && root!=null) {
//			se almacena el valor-dragon en una variable temporal que indica cual es la raiz anterior
			NodoArbol anteRoot = root;
//			reemplaza la raiz por el nuevo nodo
			root=getNodoReemplazo(nuevo);
			root.dragon=dragon;
			root.padre=padre;
//			inserta en el arbol la raiz anterior
			insertarNodo(anteRoot.dragon,anteRoot.padre);
			
	
		}
		else {
			NodoArbol temporal=root;
			NodoArbol father;
			
			while(true) {
				father=temporal;
				if(dragon.numeroPadre < temporal.dragon.numeroPadre) { // revisar
					temporal=temporal.hijoIzquierdo;
				}
					if(temporal==null) {
						father.hijoIzquierdo=nuevo;
						nuevo.dragon=dragon;
						nuevo.padre=padre;
						return;
				}else {
					temporal=temporal.hijoDerecho;
					if(temporal==null) {
						father.hijoDerecho=nuevo;
						nuevo.dragon=dragon;
						nuevo.padre=padre;
						return;
				     }
			     }
			 }
		}
	 }
	
	public boolean estaVacio() {
		boolean condicion=root==null;
		return condicion;
	}
	
//	public void inOrden(NodoArbol raiz) {
//		if(raiz!=null) {
//			inOrden(raiz.hijoIzquierdo);
//			System.out.print(raiz.dato+"  ,  ");
//			inOrden(raiz.hijoDerecho);
//		}
//	}
	
//	public void preOrden(NodoArbol raiz) {
//		if(raiz!=null) {
//			System.out.println(raiz.dato+"  ,  ");
//			preOrden(raiz.hijoIzquierdo);
//			preOrden(raiz.hijoDerecho);
//		}
//	}
	
//	public void postOrden(NodoArbol raiz) {
//		if(raiz!=null) {
//			postOrden(raiz.hijoIzquierdo);
//			postOrden(raiz.hijoDerecho);
//			System.out.println(raiz.dato+"  ,  ");
//		}
//	}
	
	public NodoArbol buscarNodo(int numeroDragon) {
		NodoArbol aux=root;
		while(aux.dragon.numeroDragon!=numeroDragon) {
			if(numeroDragon<aux.dragon.numeroDragon) {
				aux=aux.hijoIzquierdo;
			}else {
				aux=aux.hijoDerecho;
			}
			if(aux==null) {
				return null;
			}
		}
		return aux;
	}
	
	public boolean eliminar(int numeroDragon) {
		NodoArbol temporal=root;
		NodoArbol padre=root;
		boolean esHijoIzq=true;
//		busca al numero de dragon que desea reemplazar 
		while(temporal.dragon.numeroDragon!=numeroDragon) {
			padre=temporal;
			if(numeroDragon<temporal.dragon.numeroDragon) {
//				si el numero a borrar es menor al del Dragon-Nodo visitado se mueve-busca hacia la izquierda
				esHijoIzq=true;
				temporal=temporal.hijoIzquierdo;
			}else {
//				sino se mueve-busca hacia la derecha
				esHijoIzq=false;
				temporal=temporal.hijoDerecho;
			}
//			si se llega al final y no se encuentra el nodo, retorna false
			if(temporal==null) {
				return false;
			}
		}
		
//		si el nodo no tiene hijos
		if(temporal.hijoIzquierdo==null && temporal.hijoDerecho==null) {
//			si el nodoque se busca es la raiz
			if(temporal==root) {
				root=null;
				
//			cuando el Dragon-Nodo que se busca es una hoja e hijo izquierdo
//			se elimina, sino, se elimina el hijo derecho
			}else if(esHijoIzq) {
				padre.hijoIzquierdo=null;
			}else {
				padre.hijoDerecho=null;
			}
			
//		si el nodo encontrado NO es una hoja y el hijo derecho es nulo
		}else if(temporal.hijoDerecho==null) {
//			si el que se busca es igual a la raiz
			if(temporal==root) {
//				el hijo izquierdo de la raiz pasa a ser la nueva raiz
				root=temporal.hijoIzquierdo;
//			si no es igual a la raiz 
			}else if(esHijoIzq) {
				padre.hijoIzquierdo=temporal.hijoIzquierdo;
			}else {
				padre.hijoDerecho=temporal.hijoIzquierdo;
			}
//			si el nodo encontrado NO es una hoja y el hijo izquierdo es nulo
		}else if(temporal.hijoIzquierdo==null) {
//			si es igual a la raiz
			if(temporal==root) {
				root=temporal.hijoDerecho;
//			si no es igual a la raiz 
			}else if(esHijoIzq) {
				padre.hijoIzquierdo=temporal.hijoDerecho;
			}else {
				padre.hijoDerecho=temporal.hijoIzquierdo;
			}
//		si el nodo que se quiere eliminar tiene hijos
//		se llama al metodo para reemplazar un nodo
		}else {			
			NodoArbol reemplazo=getNodoReemplazo(temporal);
//			si el nodo es la raiz
			if(temporal==root) {
				root=reemplazo;
//			si es el hijo izquierdo se reemplaza
//			sino el hijo derecho es el que se reemplaza
			}else if(esHijoIzq) {
				padre.hijoIzquierdo=reemplazo;
			}else {
				padre.hijoDerecho=reemplazo;
			}
			reemplazo.hijoIzquierdo=temporal.hijoIzquierdo;
		}
		return true;
	}
	
/**
 * Metodo para reemplazar un nodo.
 * @param aReemplazar - es el nodo que se quiere borrar
 * @return regresa el nodo que debe ir en la posicion donde se borra el nodo que se recibe como parametro
 */
	public NodoArbol getNodoReemplazo(NodoArbol aReemplazar) {
		NodoArbol reemplazarPadre=aReemplazar;
		NodoArbol reemplazo=aReemplazar;
		NodoArbol temporal=aReemplazar.hijoDerecho;
		while(temporal!=null) {
			reemplazarPadre=reemplazo;
			reemplazo=temporal.hijoIzquierdo;
		}
		if(reemplazo != aReemplazar.hijoDerecho) {
			reemplazarPadre.hijoIzquierdo=reemplazo.hijoDerecho;
			reemplazo.hijoDerecho=aReemplazar.hijoDerecho;
		}
//		System.out.println("El nodo reemplazado es >>> "+reemplazo);
		return reemplazo;
	}
	
	public class NodoArbol {
//		los datos que se almacenan en el nodo son de tipo dragon
		Dragon dragon;
		Dragon padre;
		NodoArbol hijoIzquierdo, hijoDerecho;
		
		public NodoArbol(Dragon dragon,Dragon padre) {
			this.dragon=dragon;
			this.padre=padre;
			this.hijoIzquierdo=null;
			this.hijoDerecho=null;
		}
		
//		public String toString() {
//			return "El nombre es >>> "+nombre + "   El dato es >>>  "+dato;
//		}
	}
}
