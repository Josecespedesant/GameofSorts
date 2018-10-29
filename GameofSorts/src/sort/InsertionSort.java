package sort;
import entities.Dragon;
import linkedlist.SimpleLinkedList;
public class InsertionSort {
//	 
    public void sort(SimpleLinkedList<Dragon> oleada) 
    {  
        for (int i=0; i<oleada.getLength(); ++i) 
        {         
            int j = i-1;
//            temporal
            Dragon temp;
            
//          Si la edad de un dragon es mayor a la edad del siguiente dragon en la lista, se intercambian
            while (i>=0 && oleada.get(j).getData().getSpeed() > oleada.get(i).getData().getSpeed()) 
            { 
                temp=oleada.get(i).getData();
                oleada.get(i).setData(oleada.get(j).getData());
                oleada.get(j).setData(temp);
            } 
           
        } 
    } 
    
    public static void main(String[] args) {
    	SimpleLinkedList<Dragon> l = new SimpleLinkedList<Dragon>();
    	InsertionSort s = new InsertionSort();
    	
    	Dragon d1 = new Dragon(3, "Commandant", 50);
    	Dragon d2 = new Dragon(2, "Soldier", 100);
    	Dragon d3 = new Dragon(4, "Domingo 7", 150);
    	Dragon d4 = new Dragon(1, "Hola", 200);
    	
    	l.addLast(d1);
    	l.addLast(d2);
    	l.addLast(d3);
    	l.addLast(d4);
    	System.out.println(l.get(0).getData().getSpeed());
    	System.out.println(l.get(1).getData().getSpeed());
    	System.out.println(l.get(2).getData().getSpeed());
    	System.out.println(l.get(3).getData().getSpeed());
    	
    	
    	l.printList();
    	s.sort(l);
    	
    	
    	
    }
}