package entities;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
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


	private String[] images = {"griph1","griph2","griph3"};

	Image img;
	HitBox hitbox = new HitBox(x, y, 200, 200);
<<<<<<< HEAD
	FireBall fire = new FireBall(x, y);
=======
	static ArrayList<FireBall> fireballs;
	
	/**
	 * Constructor of the class Player.
	 */
>>>>>>> refs/remotes/origin/master

	public Player() {
		x = 10;
		y = 350;
		nx = 0;
		nx2 = 1266;
		fireballs = new ArrayList<>();
		ImageIcon image = new ImageIcon("griph.gif");
		img = image.getImage();
	}


	public Rectangle getBounds() {
		return new Rectangle(x,y,200,200);
	}
	
	
	public static ArrayList getFireballs() {
		return fireballs;
	}
	
	public void fire() {
		FireBall fire = new FireBall(x, y);
		fireballs.add(fire);
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
			dx = -3;
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
<<<<<<< HEAD

=======
>>>>>>> refs/remotes/origin/master
		if(key == KeyEvent.VK_SPACE) {
<<<<<<< HEAD
			
			do {
				fire.move();
			} while (fire.getX()!=1000);
=======
			fire();
>>>>>>> refs/remotes/origin/master
		}
<<<<<<< HEAD
		
=======
>>>>>>> refs/remotes/origin/master
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
