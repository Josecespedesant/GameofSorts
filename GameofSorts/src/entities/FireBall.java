package entities;

import java.awt.Image;

import javax.swing.ImageIcon;

import hitbox.HitBox;

public class FireBall {
	
	public static final int SPEED = 500;
	public static final int WIDTH = 5;
	public static final int HEIGHT = 6;
	float x, y;
	private HitBox fireHitBox;
	public boolean remove = false;
	Image fire;
	
	public FireBall(float x, float y) {
		this.x = x;
		this.y = y;
		this.fireHitBox = new HitBox(x, y, WIDTH, HEIGHT);
		ImageIcon image = new ImageIcon("Peter_Griffin.png");
		fire = image.getImage();
	}
	
	
	public void move() {
		while(x!=100) {
			x+=1;
		}
	}
	
	public Image getImage() {
		return fire;
	}
	
	
	public float getX() {
		return x;
	}


	public void setX(float x) {
		this.x = x;
	}


	public float getY() {
		return y;
	}


	public void setY(float y) {
		this.y = y;
	}


	public HitBox getFireHitBox() {
		return fireHitBox;
	}


	public void setFireHitBox(HitBox fireHitBox) {
		this.fireHitBox = fireHitBox;
	}


	public boolean isRemove() {
		return remove;
	}


	public void setRemove(boolean remove) {
		this.remove = remove;
	}

	

}
