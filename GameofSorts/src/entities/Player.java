package entities;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Player {
	public int x, dx, y, dy, nx, nx2;
	Image peter;
	ImageIcon i = new ImageIcon("Peter_Griffin.png");
	ImageIcon l = new ImageIcon("Peter_Griffin_Left.png");
	
	public Player() {

		peter = i.getImage();
		x = 10;
		y = 350;
		nx = 0;
		nx2 = 1266;
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
		return peter;
	}
	
	public void KeyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_LEFT) { 
			dx = -2;
			//peter = l.getImage();
		}
		if(key == KeyEvent.VK_RIGHT) {
			dx = +1;
			peter = i.getImage();
		}
		if(key == KeyEvent.VK_UP)
			dy = -1;
		if(key == KeyEvent.VK_DOWN)
			dy = 1;
	}
	
	public void KeyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_LEFT) 
			dx = -1;
		if(key == KeyEvent.VK_RIGHT)
			dx = -1;
		if(key == KeyEvent.VK_DOWN)
			dy = 0;
			dx = -1;
		if(key == KeyEvent.VK_UP)
			dy = 0;
			dx = -1;
	}

	
}
