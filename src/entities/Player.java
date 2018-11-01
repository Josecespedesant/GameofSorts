package entities;

import  java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import com.studiohartman.jamepad.ControllerManager;
import com.studiohartman.jamepad.ControllerState;
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

    ControllerManager controllers = new ControllerManager();

	/**
	 * Constructor of the class Player.
	 */

	public Player() {
		this.x = 10;
		this.y = 350;
		this.nx = 0;
		this.nx2 = 1266;
		this.lifes = 3;
		this.alife = true;
		this.fireballs = new SimpleLinkedList<FireBall>();
		ImageIcon image = new ImageIcon("griphFinal.gif");
		this.img = image.getImage();
		this.hitbox = new HitBox(x, y, img.getWidth(null), img.getHeight(null));
        this.controllers.initSDLGamepad();
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

        ControllerState estadoActual = this.controllers.getState(0);

		//movimiento cuando una tecla es presioanda
		int key = e.getKeyCode();


		if(key == KeyEvent.VK_LEFT||key == KeyEvent.VK_A || estadoActual.dpadLeft) {
			if(x-100 < 10) {
				dx = 0;
				x = 10;
			}else {
				dx = -3;
			}
		}

		if(key == KeyEvent.VK_RIGHT||key == KeyEvent.VK_D || estadoActual.dpadRight) {
			if(x+20 >1060) {
				dx = 0;
				x = 1050;
			}else {
				dx = 3;
			}
			

		}
		if(key == KeyEvent.VK_UP||key == KeyEvent.VK_W || estadoActual.dpadUp) {
			if(y < 10) {
				dy = 0;
				y = 10;
			}else {
				dy = -3;
			}

		}
		if(key == KeyEvent.VK_DOWN||key == KeyEvent.VK_S || estadoActual.dpadDown) {
			if(y > 638) {
				dy = 0;
				y = 638;
			}else {
				dy = 3;
			}
		}
		
		if(key == KeyEvent.VK_SPACE || estadoActual.a) {
			fire();
		}
	}

	/**
	 * Management of the key events when they're released.
	 * @param e
	 */
	public void KeyReleased(KeyEvent e) {

        ControllerState estadoActual = this.controllers.getState(0);

		//movimiento cuando una tecla se deja de presioanar
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_LEFT||key == KeyEvent.VK_A || !estadoActual.dpadLeft)
			dx = -1;
		if(key == KeyEvent.VK_RIGHT||key == KeyEvent.VK_D || !estadoActual.dpadRight)
			dx = -1;
		if(key == KeyEvent.VK_DOWN||key == KeyEvent.VK_W || !estadoActual.dpadUp)
			dy = 0;
		dx = -1;
		if(key == KeyEvent.VK_UP||key == KeyEvent.VK_S || !estadoActual.dpadDown)
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
