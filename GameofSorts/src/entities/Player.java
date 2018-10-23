package entities;

import java.awt.Image;
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
		fireballs = new SimpleLinkedList<FireBall>();
		ImageIcon image = new ImageIcon("griphFinal.gif");
		img = image.getImage();
		hitbox = new HitBox(x, y, img.getWidth(null), img.getHeight(null));
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
	
	/**
	 * Management of the key events when they're pressed.
	 * @param e
	 */
	public void KeyPressed(KeyEvent e) {
		//movimiento cuando una tecla es presioanda
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_LEFT||key == KeyEvent.VK_A) { 
			if(x<0) {
				dx = 0;
				x = 0;
			} else if(x>0) {
				dx = -3;
			}
			
		}
		if(key == KeyEvent.VK_RIGHT||key == KeyEvent.VK_D) {
			if(x<900) {
				dx = +3;
			}else if(x>900 && x<1000) {
				dx = +2;
			}
			else if(x>1030) {
				dx = 0;
				x = 1030;
			}
				
			
		}
		if(key == KeyEvent.VK_UP||key == KeyEvent.VK_W) {
			if(y>100) {
			dy = -3;
			}else if(y<100 && y>0) {
				dy = -2;
			}else if(y<=0) {
				dy = 0;
				y = 0;
			}
		}
		if(key == KeyEvent.VK_DOWN||key == KeyEvent.VK_S) {
			if(y<538) {
				dy = +3;
				}else if(y<638 && y>538) {
					dy = +2;
				}else if(y>=638) {
					dy = 0;
					y = 638;
				}
		}
		if(key == KeyEvent.VK_SPACE) {
			System.out.println("FIRE");
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
