package entities;

import static org.junit.Assert.*;

import org.junit.Test;

import tools.HitBox;

public class FireBallDragonTest {

	@Test
	public void testFireBallDragon() {
		FireBallDragon fireballDTest = new FireBallDragon(1,1);
		assertTrue(fireballDTest.getX()!=0 && fireballDTest.getY() != 0);
	}

	@Test
	public void testMove() {
		FireBallDragon fireballDTest = new FireBallDragon(1,1);
		fireballDTest.move();
		assertTrue(fireballDTest.getX()!=1);
	}

	@Test
	public void testGetFireHitBox() {
		FireBallDragon fireballDTest = new FireBallDragon(1,1);
		assertTrue(fireballDTest.getFireHitBox()!=null);
	}

	@Test
	public void testSetFireHitBox() {
		FireBallDragon fireballDTest = new FireBallDragon(1,1);
		HitBox fireHitBox = new HitBox(1,1,1,1);
		fireballDTest.setFireHitBox(null);
		fireballDTest.setFireHitBox(fireHitBox);
		assertTrue(fireballDTest.getFireHitBox()!=null);
	}

	@Test
	public void testGetX() {
		FireBallDragon fireballDTest = new FireBallDragon(1,1);
		assertEquals(11, fireballDTest.getX());
	}

	@Test
	public void testGetY() {
		FireBallDragon fireballDTest = new FireBallDragon(1,1);
		assertEquals(26, fireballDTest.getY());
	}

}
