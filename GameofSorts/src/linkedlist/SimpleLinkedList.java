package linkedlist;

/**
 * SimpleLinkedList class declaration.
 * @author José Antonio Céspedes Downing
 */
public class SimpleLinkedList<T>{
	
	/**
	 * SimpleLinkedList class attributes.
	 */
	private Node<T> first;
	private int len;
	
	/**
	 * SimpleLinkedList constructor declaration.
	 */
	public SimpleLinkedList() {
		first = null;
		len = 0;
	}
	
	/**
	 * Method that let you know if the list is empty or not.
	 * @return True or False.
	 */
	public boolean isEmpty() {
		return first == null;
	}
	
	/**
	 * Method that gives you the length of the list.
	 * @return Length of the list.
	 */
	public int getLength() {
		return len;
	}
	
	/**
	 * Method that inserts a new Data at the front of the list.
	 * @param Data
	 */
	public void addFront(T Data) {
		Node<T> newNode = new Node<T>();
		newNode.setData(Data);
		
		if(isEmpty()) {
			first = newNode;
			first.setPosition(0);
		}
		else {
			newNode.setPosition(0);
			newNode.setNext(first);
			first = newNode;
			
		}
		Node<T> aux = first.getNext();
		while(aux!=null) {
			aux.setPosition(aux.getPosition()+1);
			aux = aux.getNext();
		}
		len++;
	}
	
	/**
	 * Method that deletes the item at the front.
	 */
	public void deleteFront() {
		if(isEmpty()) {
			first = null;
		}else {
			first = first.getNext();
			Node<T> aux = first;
			while(aux!=null) {
				aux.setPosition(aux.getPosition()-1);
				aux = aux.getNext();
			}
		}
		len--;
	}
	
	/**
	 * Method that inserts a new Data at the end of the list.
	 * @param Data
	 */
	public void addLast(T Data) {
		Node<T> newNode = new Node<T>();
		newNode.setData(Data);
		if(isEmpty()) {
			first = newNode;
			first.setPosition(0);
		}
		else {
			Node<T> aux = new Node<T>();
			aux = first;
			while(aux.getNext()!=null) {
				aux = aux.getNext();
			}
			aux.setNext(newNode);
			aux.getNext().setPosition(len);
		}
		len++;
	}
	
	/**
	 * Method that delete the last Data at the end of the list.
	 */
	public void deleteLast() {
		Node<T> aux = new Node<T>();
		aux = first;
		if(isEmpty() || len == 1 ) {
			first = null;
		}
		else {
			while(aux.getNext().getNext()!=null){
				aux = aux.getNext();
			}
		aux.setNext(null);
		}
		len--;
	}
	
	/**
	 * Get the item specified by index.
	 * @param i
	 * @return n
	 */
	public Node<T> get(int i){
	    if (i >= len) {
	    	try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
	    Node<T> aux = first;
	    while(aux != null) {
	    	if(aux.getPosition() == i) {
	    		return aux;
	    	}
	    	aux = aux.getNext();
	    }
	    return null;
	}

	
	/**
	 * Method that deletes an object from the list by specifying it.
	 * @param t
	 */
	public void deleteByElement(T t) {
		Node<T> aux = new Node<T>();
		
		aux = first;
		if(isEmpty()) {
			first = null;
		}
		else if(first.getData()==t){
			deleteFront();
		}
		else {
			if(aux.getNext() == null) {
				aux = aux.getNext();
			}
			while(aux.getNext()!=null) {
				if(aux.getNext().getData()==t){
					
					Node<T> aux2 = new Node<T>();
					aux2 = aux.getNext().getNext();
					while(aux2!=null) {
						aux2.setPosition(aux2.getPosition()-1);
						aux2 = aux2.getNext();
					}
					aux.setNext(aux.getNext().getNext());
				}
				else {
					aux = aux.getNext();
				}
			}
		}len--;
	}
	
	/**
	 * Method that displays the elements of the list on console.
	 */
	public void printList() {
		Node<T> aux = first;
		while(aux!= null) {
			System.out.println(aux.getData().toString());
			aux = aux.getNext();
		}
	}
	
	/**
	 * Returns the first element of the list.
	 * @return first
	 */
	public Node<T> getFirst() {
		return first;
	}
	
	/**
	 * Allows you to get the last item of the list.
	 * @return
	 */
	protected Node<T> getLast(){
		Node<T> aux = first;
		while(aux.getNext()!=null) {
		aux = aux.getNext();
		}
		return aux;
	}
	
	
	
	/**
	 * Let you know if the item is on the list.
	 * @param t
	 * @return
	 */
	public boolean contains(T t) {
		Node<T> aux = first;
		boolean ans = false;
		while(aux!=null) {
			if(aux.getData().equals(t)) {
				ans = true;
			}aux = aux.getNext();
		}return ans;
	}
	
	
	

	
}