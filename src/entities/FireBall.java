package entities;

import tools.HitBox;
import java.awt.*;
import javax.swing.ImageIcon;
public class FireBall {
	int x, y;
	static Image img;
	public boolean visible = true;
	private HitBox fireHitBox;
	public String fuego, fuegoD;
	
	
	public FireBall(int startX, int startY) {
		x = startX;
		y = startY;
		ImageIcon fireball = new ImageIcon("fuego.gif");
		img = fireball.getImage();
		visible = true;		
		this.fireHitBox = new HitBox(this.x, this.y, img.getWidth(null)-10, img.getHeight(null)-10);
	}

	public Rectangle getBounds() {
		return new Rectangle(x,y,50,50);
	}
	
	public void move() {
		x = x + 3;
		if (x > 1280) {
			visible = false;
		}
		fireHitBox.move(x);
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
