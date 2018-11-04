package entities;

import static org.junit.Assert.*;

import org.junit.Test;

public class DragonFactoryTest {

	@Test
	public void testCreateDragon() {
		DragonFactoryMethod dftest = new DragonFactory();
		Dragon dragonTest = dftest.createDragon(2, "Alduin");
		assertTrue(dragonTest.getName()!=null);
	}

}
