package sort;
import entities.Dragon;

public class InsertionSort {
//	 
    public void sort(Dragon oleada[]) 
    {  
        for (int i=0; i<oleada.length; ++i) 
        {         
            int j = i-1;
//            temporal
            Dragon temp;
            
//          Si la edad de un dragon es mayor a la edad del siguiente dragon en la lista, se intercambian
            while (i>=0 && oleada[j].getSpeed() > oleada[i].getSpeed()) 
            { 
                temp=oleada[i];  
                oleada[i]=oleada[j];  
                oleada[j] = temp; 
            } 
           
        } 
    } 
}