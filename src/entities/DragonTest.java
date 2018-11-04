package entities;

import static org.junit.Assert.*;

import org.junit.Test;

import tools.HitBox;

public class DragonTest {

	@Test
	public void testDragonIntString() {
		Dragon dragonTest = new Dragon(1, "comandante");
		int expected = -1;
		assertEquals(expected, dragonTest.getSpeed());
	}

	@Test
	public void testDragonStringIntString() {
		Dragon dragonTest = new Dragon("Aurelion Sol",1, null);
		int expected = -1;
		assertEquals(expected, dragonTest.getSpeed());
	}
	
	@Test
	public void testSetName() {
		Dragon dragonTest = new Dragon(1, null);
		dragonTest.setName();
		assertTrue(dragonTest.getName()!=null);
	}

	@Test
	public void testSetX() {
		Dragon dragonTest = new Dragon(1, null);
		dragonTest.setX(2);
		assertTrue(dragonTest.getX()!=0);
	}

	@Test
	public void testSetY() {
		Dragon dragonTest = new Dragon(1, null);
		dragonTest.setY(2);
		assertTrue(dragonTest.getY()!=0);
	}

	@Test
	public void testSetNameString() {
		Dragon dragonTest = new Dragon(1, null);
		dragonTest.setName("Aurelion Sol");
		assertEquals("Aurelion Sol", dragonTest.getName());
	}

	@Test
	public void testSetAge() {
		Dragon dragonTest = new Dragon(1, null);
		dragonTest.setAge();
		assertTrue(dragonTest.getAge()!=0);
	}

	@Test
	public void testSetAgeInt() {
		Dragon dragonTest = new Dragon(1, null);
		dragonTest.setAge(600);
		assertTrue(dragonTest.getAge()!=0);
	}

	@Test
	public void testSetResistance() {
		Dragon dragonTest = new Dragon(1, null);
		dragonTest.setResistance(2);
		assertEquals(2, dragonTest.getResistance());
	}

	@Test
	public void testSetRank() {
		Dragon dragonTest = new Dragon(1, null);
		dragonTest.setRank("comandante");
		assertEquals("comandante", dragonTest.getRank());
	}

	@Test
	public void testSetFather() {
		Dragon dragonTest = new Dragon(1, null);
		dragonTest.setFather("Alduin");
		assertTrue(dragonTest.getFather()!=null);
	}

	@Test
	public void testSetDragonHitBox() {
		Dragon dragonTest = new Dragon(1, null);
		HitBox hitboxTest = new HitBox(10, 10, 100, 20);
		dragonTest.setDragonHitBox(hitboxTest);
		assertTrue(dragonTest.getDragonHitBox()!=null);
	}

}
