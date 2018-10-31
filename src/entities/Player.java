package entities;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import linkedlist.SimpleLinkedList;
import tools.HitBox;

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
	public int allow = 1;
	Image img ;
	private HitBox hitbox;
	public  int lifes;
	public boolean alife;
	FireBall fire = new FireBall(x, y);
	static SimpleLinkedList<FireBall> fireballs;

	/**
	 * Constructor of the class Player.
	 */

	public Player() {
		x = 10;
		y = 350;
		nx = 0;
		nx2 = 1266;
		lifes = 3;
		alife = true;
		fireballs = new SimpleLinkedList<FireBall>();
		ImageIcon image = new ImageIcon("griphFinal.gif");
		img = image.getImage();
		hitbox = new HitBox(x, y, img.getWidth(null), img.getHeight(null));
	}

	public Rectangle getBounds() {
		return new Rectangle(x,y,100,100);
	}


	public static SimpleLinkedList<FireBall> getFireballs() {
		return fireballs;
	}

	public void fire() {
		FireBall fire = new FireBall(x, y);
		fireballs.addLast(fire);
	}

	/**
	 * Allows the movement of the player.
	 */
	public void move() {
		x = x + dx;
		y = y + dy;
		hitbox.move(x, y);
		allow++;
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
		return img;
	}

	public int getlifes() {
		return lifes;
	}

	public boolean isAliVe() {
		return alife;
	}

	/**
	 * Management of the key events when they're pressed.
	 * @param e
	 */
	public void KeyPressed(KeyEvent e) {
		//movimiento cuando una tecla es presioanda
		int key = e.getKeyCode();


		if(key == KeyEvent.VK_LEFT||key == KeyEvent.VK_A) {
			if(x-100 < 10) {
				dx = 0;
				x = 10;
			}else {
				dx = -3;
			}
		}

		if(key == KeyEvent.VK_RIGHT||key == KeyEvent.VK_D) {
			if(x+20 >1060) {
				dx = 0;
				x = 1050;
			}else {
				dx = 3;
			}
			
			System.out.println(x);

		}
		if(key == KeyEvent.VK_UP||key == KeyEvent.VK_W) {
			if(y < 10) {
				dy = 0;
				y = 10;
			}else {
				dy = -3;
			}

		}
		if(key == KeyEvent.VK_DOWN||key == KeyEvent.VK_S) {
			if(y > 638) {
				dy = 0;
				y = 638;
			}else {
				dy = 3;
			}
		}
		
		if(key == KeyEvent.VK_SPACE) {
			fire();
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

	public HitBox getHitbox() {
		return hitbox;
	}


	public void setHitbox(HitBox hitbox) {
		this.hitbox = hitbox;
	}
}
