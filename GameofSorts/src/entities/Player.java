package entities;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Player {
	public int x, dx, y, dy;
	Image peter;
	ImageIcon i = new ImageIcon("Peter_Griffin.png");
	ImageIcon l = new ImageIcon("Peter_Griffin_Left.png");
	
	public Player() {

		peter = i.getImage();
		x = 10;
		y = 350;
	
	}
	
	public void move() {
		x = x + dx;
		y = y + dy;
	}
	

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public Image getImage() {
		return peter;
	}
	
	public void KeyPressed(KeyEvent e) {
		//movimiento cuando una tecla es presioanda
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
		//movimiento cuando una tecla se deja de presioanar
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
