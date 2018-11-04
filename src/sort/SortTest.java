package sort;

import static org.junit.Assert.*;
import org.junit.Test;
import entities.Dragon;
import org.junit.Before;
import org.junit.After;

public class SortTest {
	
	Dragon Padre;
	Dragon dragon;
	Dragon[] oleada;
	QuickSort sort;
	
	@Before()
	public void Before() {
		oleada=new Dragon[2];
		dragon=new Dragon(1,"Padre");
		Padre=new Dragon(1,null);
		sort=new QuickSort();
		Padre=oleada[1]; //segunda posicion
		dragon=oleada[0]; //primera posicion 
	}
	
	@Test
	public void QuickSortTest() {
		// reordena
		sort.sort(oleada, 1, 0);
		assertEquals(dragon,oleada[1]);
		assertEquals(Padre,oleada[0]);
		
	}
	
	@After
	public void After() {
		System.out.println("Terminó el test");
	}

}
