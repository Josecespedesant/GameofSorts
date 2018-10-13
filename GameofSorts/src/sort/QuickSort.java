package sort;
import entities.Dragon;

public class QuickSort {	
//	Esta funci�n toma el �ltimo elemento como pivote,
//  coloca el elemento de pivote en su posici�n correcta
//  en el array ordenado, y coloca todos los
//  m�s peque�os (m�s peque�o que el pivote) a la izquierda del
//  pivote y todos los elementos mayores a la derecha
//  del pivote
	
 int partition(Dragon oleada[], int low, int high) 
 { 
     int pivot = oleada[high].getAge();  
     int i = (low-1); // indice del menor elemento 
     for (int j=low; j<high; j++) 
     { 
         // Si el elemento actual es menor que o
         // igual al pivote
         if (oleada[j].getAge() <= pivot) 
         { 
             i++; 

             // intercambia oleada[i] y oleada[j] 
             Dragon temp = oleada[i]; 
             oleada[i] = oleada[j]; 
             oleada[j] = temp; 
         } 
     } 

     // intercambia oleada[i + 1] y oleada[high] (o pivot) 
     Dragon temp = oleada[i+1]; 
     oleada[i+1] = oleada[high]; 
     oleada[high] = temp; 

     return i+1; 
 } 

// La funci�n principal que implementa QuickSort ()
// oleada [] -> Arreglo a ordenar,
// low -> �ndice de inicio,
// high -> �ndice de finalizaci�n
 void sort(Dragon oleada[], int low, int high) 
 { 
     if (low < high)
     { 
        
//    	 pi es �ndice de particion, oleada[pi] es ahora en el lugar correcto
         int pi = partition(oleada, low, high); 

         // Recursively sort elements before 
         // partition and after partition 
         sort(oleada, low, pi-1); 
         sort(oleada, pi+1, high); 
     } 
  } 
} 
