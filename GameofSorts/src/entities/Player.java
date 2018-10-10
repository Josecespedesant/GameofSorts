package entities;

import java.awt.FileDialog;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.applet.Applet;

import javax.swing.ImageIcon;

public class Player {
	public int x, dx, y, dy, nx, nx2;
	Image griph;
	String[] images = {"griph","griph2","griph3"};
	private int totalPictures = 0;
	
	public Player() {
		griph = null;
		x = 10;
		y = 350;
		nx = 0;
		nx2 = 1266;
		init();
	}
	
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
	
	public void move() {
		//if(dx!=1) {
		x = x + dx;
		y = y + dy;
		//nx2 = nx2 + dx;
		//nx = nx + dx;
		
	//	}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public int getNx2() {
		return nx2;
	}
	public void setNx2(int nx2) {
		this.nx2 = nx2;
	}
	
	public int getNx() {
		return nx; 
	}
	public void setNx(int nx) {
		nx = this.nx;
	}
	
	public Image getImage() {
		return griph;
	}
	
	public void KeyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_LEFT||key == KeyEvent.VK_A) { 
			dx = -2;
			//peter = l.getImage();
		}
		if(key == KeyEvent.VK_RIGHT||key == KeyEvent.VK_D) {
			dx = +1;
		}
		if(key == KeyEvent.VK_UP||key == KeyEvent.VK_W) {
			dy = -1;
		}
		if(key == KeyEvent.VK_DOWN||key == KeyEvent.VK_S) {
			dy = 1;
		}
	}
	
	public void KeyReleased(KeyEvent e) {
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
