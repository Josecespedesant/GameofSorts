import entities.Dragon;

public class SelectionSort {
	void sort(Dragon oleada[]) 
    { 
        int n = oleada.length; 
  
        // Límite de movimiento uno a uno de subarray sin clasificar 
        for (int i = 0; i < n-1; i++) 
        { 
            // Encuentra el elemento mínimo (edad) en el array sin clasificar
            int min_idx = i; 
            for (int j = i+1; j < n; j++) 
                if (oleada[j].getAge() < oleada[min_idx].getAge()) 
                    min_idx = j; 
  
            // Intercambia el elemento mínimo encontrado (Edad) con el primer elemento
            Dragon temp = oleada[min_idx]; 
            oleada[min_idx] = oleada[i]; 
            oleada[i] = temp; 
        } 
    } 
} 
