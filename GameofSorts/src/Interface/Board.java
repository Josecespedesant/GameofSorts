package Interface;

import java.awt.*;
import java.awt.Image;
import java.awt.event.*;

import javax.swing.*;

import entities.Player;

public class Board extends JPanel implements ActionListener{
	Player p;
	Image img;
	Timer time;
	int nx, nx2;

	public Board() {
		p = new Player();
		addKeyListener(new AL());
		setFocusable(true);
		ImageIcon i = new ImageIcon("GoSBG.jpeg");	
		img = i.getImage();
		time = new Timer(5, this);
		time.start();
		nx = 0;
		nx2 = 1266;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		p.move();
		repaint();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		
		nx--;
		nx2--;
		g2d.drawImage(img, nx, 0, null);
		if (nx <= 0) {
			g2d.drawImage(img, nx2+100, 0, null);
			System.out.println(nx);
		}
		if (nx == -1370) {
			nx =0;
			nx2 = 1266;
			
		}
		
		g2d.drawImage(p.getImage(), p.getX(), p.getY(), null);
	}
	
	private class AL extends KeyAdapter{
		
		public void keyReleased(KeyEvent e) {
			p.KeyReleased(e);
		}
		
		public void keyPressed(KeyEvent e) {
			p.KeyPressed(e);
		}
		
	}
}
