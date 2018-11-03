package entities;

import static org.junit.Assert.*;

import org.junit.Test;

import tools.HitBox;

public class FireBallTest {

	@Test
	public void testFireBall() {
		FireBall fireballTest = new FireBall(1,1);
		assertTrue(fireballTest.getX()!=0 && fireballTest.getY() != 0);
	}

	@Test
	public void testSetFireHitBox() {
		HitBox hitboxTest = new HitBox(10, 10, 100, 20);
		FireBall fireballTest = new FireBall(1,1);
		fireballTest.setFireHitBox(hitboxTest);
		assertTrue(fireballTest.getFireHitBox()!=null);
	}

	@Test
	public void testMove() {
		FireBall fireballTest = new FireBall(1,1);
		fireballTest.move();
		assertTrue(fireballTest.getX()!=1);
	}

	@Test
	public void testGetFireHitBox() {
		FireBall fireballTest = new FireBall(1,1);
		assertTrue(fireballTest.getFireHitBox()!=null);
	}

	@Test
	public void testGetX() {
		FireBall fireballTest = new FireBall(1,1);
		assertEquals(11, fireballTest.getX());
	}

	@Test
	public void testGetY() {
		FireBall fireballTest = new FireBall(1,1);
		assertEquals(26, fireballTest.getY());
	}

}
