package entities;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import tools.HitBox;

public class FireBallDragon {
	int x, y;
	static Image img;
	public boolean visible = true;
	private HitBox fireHitBox;
	public String fuego, fuegoD;
	
	
	public FireBallDragon (int startX, int startY) {
		x = startX;
		y = startY;
		ImageIcon fireball = new ImageIcon("fuegodragon.gif");
		img = fireball.getImage();
		visible = true;		
		this.fireHitBox = new HitBox(this.x, this.y, img.getWidth(null), img.getHeight(null));
	}

	public Rectangle getBounds() {
		
		return new Rectangle(x,y,75,75);
	}
	
	public void move() {
		x = x - 3;
		if (x < -100) {
			visible = false;
		}
	}

	public HitBox getFireHitBox() {
		return fireHitBox;
	}

	public void setFireHitBox(HitBox fireHitBox) {
		this.fireHitBox = fireHitBox;
	}

	public int getX() {
		return x+10;
	}

	public int getY() {
		return y+25;
	}
	
	public Image getImage() {
		return img;
	}
	
	public boolean getVisible() {
		return visible;
	}
}
