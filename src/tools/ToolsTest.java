package tools;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Before;

public class ToolsTest {
	static HitBox hitbox;
	
	@Before
	public void Before() {
		hitbox=new HitBox(5,7,9,11);
	}
		
	@Test
	public void collidesWithTest() {
		hitbox.collidesWith(hitbox);
		boolean posicionColision = 5 < hitbox.getX() + hitbox.getWidth() && 7 < hitbox.getY() + hitbox.getHeight() && 5 + hitbox.getWidth() > hitbox.getX() && 7 + hitbox.getHeight() > hitbox.getY();        
		assertFalse(!posicionColision);
	}
	@Test
	public void getXTest() {
		assertTrue(hitbox.getX()==5);
	}

	@Test
	public void setXTest() {
		float x=90;
		hitbox.setX(x);
		assertFalse(hitbox.getX()!=x);
	}

	@Test
	public void getYTest() {
		assertTrue(hitbox.getY()==7);
	}
	@Test
	public void setYTest() {
		float y=6;
		hitbox.setY(y);
		assertFalse(hitbox.getY()!=y);
	}

	@Test
	public void getWidthTest() {
		assertTrue(hitbox.getWidth()==9);
	}

	@Test
	public void setWidthTest() {
		int width=6;
		hitbox.setWidth(width);
		assertFalse(hitbox.getWidth()!=width);
	}

	@Test
	public void getHeightTest() {
		assertTrue(hitbox.getHeight()==11);
	}

	@Test
	public void setHeightTest() {
		int height=6;
		hitbox.setHeight(height);
		assertFalse(hitbox.getHeight()!=height);
	}
	
	@Test
	public void moveTest() {
		hitbox.move(2,3);
		assertEquals((int)hitbox.getX(),2);
		assertEquals((int)hitbox.getY(),3);
	}


}
