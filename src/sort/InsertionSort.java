package sort;
import java.util.LinkedList;
import entities.Dragon;

public class InsertionSort {
//	 
	public void sort(LinkedList<Dragon> lista) 
    { 
        int n = lista.size(); 
        for (int i=1; i<n; ++i) 
        { 
            Dragon key = lista.get(i); 
            int j = i-1; 
  
            while (j>=0 && lista.get(j).getAge() > key.getAge()) 
            { 
            	lista.set(j+1, lista.get(j));
                j = j-1; 
            }
            
            lista.set(j+1, key);
            
        } 
    } 
    
}