package sort;

import static org.junit.Assert.*;

import org.junit.Test;

import entities.Dragon;

public class SortTest {
	
	Dragon Padre;
	Dragon dragon;
	Dragon[] oleada;
	QuickSort sort;
	
	@Test
	public void QuickSortTest() {
		oleada=new Dragon[2];
		dragon=new Dragon(1,"Padre");
		Padre=new Dragon(1,null);
		sort=new QuickSort();
		Padre=oleada[1];
		dragon=oleada[0];
		
		sort.sort(oleada, 1, 0);
		assertEquals(Padre,oleada[0]);
		
	}

}
