package entities;

import static org.junit.Assert.*;

import org.junit.Test;

import tools.HitBox;

public class PlayerTest {

	@Test
	public void testPlayer() {
		Player ptest = new Player();
		assertEquals(10, ptest.getX());
	}

	@Test
	public void testFire() {
		Player ptest = new Player();
		ptest.fire();
		assertTrue(ptest.getFireballs().get(0)!=null);
	}

	@Test
	public void testMove() {
		Player ptest = new Player();
		ptest.dx = 1;
		ptest.move();
		assertTrue(ptest.getHitbox().getX()!=10);
	}

	@Test
	public void testGetX() {
		Player ptest = new Player();
		assertEquals(10,ptest.getX());
	}

	@Test
	public void testGetY() {
		Player ptest = new Player();
		assertEquals(350,ptest.getY());
	}

	@Test
	public void testGetlifes() {
		Player ptest = new Player();
		assertEquals(3,ptest.getlifes());
	}

	@Test
	public void testIsAliVe() {
		Player ptest = new Player();
		assertTrue(ptest.isAliVe());
	}

	@Test
	public void testGetHitbox() {
		Player ptest = new Player();
		assertTrue(ptest.getHitbox()!=null);
	}

	@Test
	public void testSetHitbox() {
		HitBox hitboxTest = new HitBox(10, 10, 100, 20);
		Player fireballTest = new Player();
		fireballTest.setHitbox(hitboxTest);
		assertTrue(fireballTest.getHitbox()!=null);
	}

}
