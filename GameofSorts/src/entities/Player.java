package entities;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import hitbox.HitBox;

/**
 * Declatation of the class Player
 * @author Sing
 *
 */
public class Player {
	/**
	 * Attributes of the class Player.
	 */
	public int x, dx, y, dy, nx, nx2;
	Image griph;
	String[] images = {"griph","griph2","griph3"};
	HitBox hitbox = new HitBox(x, y, 200, 200);
	FireBall fire = new FireBall(x, y);

	public Player() {
		griph = null;
		x = 10;
		y = 350;
		nx = 0;
		nx2 = 1266;
		init();
	}
	
	/**
	 * TODO
	 * Selects the image of the player.
	 */
	public void init() {
		for(int i = 0; i < 3; i++) {
			String imageText = null;
			imageText = images[i]+".png";
			ImageIcon image = new ImageIcon(imageText);
			if(imageText != null) {
				griph = image.getImage();
			}
		}
	}
	
	/**
	 * Allows the movement of the player.
	 */
	public void move() {
		x = x + dx;
		y = y + dy;
		hitbox.move(x, y);
	}

	/**
	 * Returns the X position of the player.
	 * @return x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Returns the Y position of the player.
	 * @return y
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Returns the image of the player
	 * @return griph
	 */
	public Image getImage() {
		return griph;
	}
	
	/**
	 * Management of the key events when they're pressed.
	 * @param e
	 */
	public void KeyPressed(KeyEvent e) {
		//movimiento cuando una tecla es presioanda
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_LEFT||key == KeyEvent.VK_A) { 
			dx = -3;
			
			
			//peter = l.getImage();
		}
		if(key == KeyEvent.VK_RIGHT||key == KeyEvent.VK_D) {
			dx = +3;
			
		}
		if(key == KeyEvent.VK_UP||key == KeyEvent.VK_W) {
			dy = -3;
			
		}
		if(key == KeyEvent.VK_DOWN||key == KeyEvent.VK_S) {
			dy = 3;
			
		}

		if(key == KeyEvent.VK_SPACE) {
			
			do {
				fire.move();
			} while (fire.getX()!=1000);
		}
		
	}
	
	/**
	 * Management of the key events when they're released.
	 * @param e
	 */
	public void KeyReleased(KeyEvent e) {
		//movimiento cuando una tecla se deja de presioanar
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_LEFT||key == KeyEvent.VK_A) 
			dx = -1;
		if(key == KeyEvent.VK_RIGHT||key == KeyEvent.VK_D)
			dx = -1;
		if(key == KeyEvent.VK_DOWN||key == KeyEvent.VK_W)
			dy = 0;
			dx = -1;
		if(key == KeyEvent.VK_UP||key == KeyEvent.VK_S)
			dy = 0;
			dx = -1;
	}

	
}
