public class ArbolBinario {
NodoArbol root;
	
	public ArbolBinario() {
		root=null;
	}
	
	public void insertarNodo(int d,String nombre) {
		NodoArbol nuevo=new NodoArbol(d,nombre);
		
		if(root==null) {
			root=nuevo;
		}else {
			NodoArbol temporal=root;
			NodoArbol padre;
			
			while(true) {
				padre=temporal;
				if(d<temporal.dato) {
					temporal=temporal.hijoIzquierdo;
					
					if(temporal==null) {
						padre.hijoIzquierdo=nuevo;
						return;
					}
				}else {
					temporal=temporal.hijoDerecho;
					if(temporal==null) {
						padre.hijoDerecho=nuevo;
						return;
					}
				}
			}
		}
	}
	
	public boolean estaVacio() {
		return root==null;
	}
	
	public void inOrden(NodoArbol raiz) {
		if(raiz!=null) {
			inOrden(raiz.hijoIzquierdo);
			System.out.print(raiz.dato+"  ,  ");
			inOrden(raiz.hijoDerecho);
		}
	}
	
	public void preOrden(NodoArbol raiz) {
		if(raiz!=null) {
			System.out.println(raiz.dato+"  ,  ");
			preOrden(raiz.hijoIzquierdo);
			preOrden(raiz.hijoDerecho);
		}
	}
	
	public void postOrden(NodoArbol raiz) {
		if(raiz!=null) {
			postOrden(raiz.hijoIzquierdo);
			postOrden(raiz.hijoDerecho);
			System.out.println(raiz.dato+"  ,  ");
		}
	}
	
	public NodoArbol buscarNodo(int d) {
		NodoArbol aux=root;
		while(aux.dato!=d) {
			if(d<aux.dato) {
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
	
	public boolean eliminar(int d) {
		NodoArbol temporal=root;
		NodoArbol padre=root;
		boolean esHijoIzq=true;
		while(temporal.dato!=d) {
			padre=temporal;
			if(d<temporal.dato) {
				esHijoIzq=true;
				temporal=temporal.hijoIzquierdo;
			}else {
				esHijoIzq=false;
				temporal=temporal.hijoDerecho;
			}
			if(temporal==null) {
				return false;
			}
		}
//		
		if(temporal.hijoIzquierdo==null && temporal.hijoDerecho==null) {
			if(temporal==root) {
				root=null;
			}else if(esHijoIzq) {
				padre.hijoIzquierdo=null;
			}else {
				padre.hijoDerecho=null;
			}
		}else if(temporal.hijoDerecho==null) {
			if(temporal==root) {
				root=temporal.hijoIzquierdo;
			}else if(esHijoIzq) {
				padre.hijoIzquierdo=temporal.hijoIzquierdo;
			}else {
				padre.hijoDerecho=temporal.hijoIzquierdo;
			}
		}else if(temporal.hijoIzquierdo==null) {
			if(temporal==root) {
				root=temporal.hijoDerecho;
			}else if(esHijoIzq) {
				padre.hijoIzquierdo=temporal.hijoDerecho;
			}else {
				padre.hijoDerecho=temporal.hijoIzquierdo;
			}
		}else {
			NodoArbol reemplazo=getNodoReemplazo(temporal);
			if(temporal==root) {
				root=reemplazo;
			}else if(esHijoIzq) {
				padre.hijoIzquierdo=reemplazo;
			}else {
				padre.hijoDerecho=reemplazo;
			}
			reemplazo.hijoIzquierdo=temporal.hijoIzquierdo;
		}
		return true;
	}
	
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
		System.out.println("El nodo reemplazado es >>> "+reemplazo);
		return reemplazo;
	}
	
	public class NodoArbol {
		int dato;
		String nombre;
		NodoArbol hijoIzquierdo, hijoDerecho;
		
		public NodoArbol(int d,String nombre) {
			this.dato=d;
			this.nombre=nombre;
			this.hijoIzquierdo=null;
			this.hijoDerecho=null;
		}
		
		public String toString() {
			return "El nombre es >>> "+nombre + "   El dato es >>>  "+dato;
		}
	}
}
