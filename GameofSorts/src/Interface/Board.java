package Interface;

import java.awt.*;
import java.awt.Image;
import java.awt.event.*;

import javax.swing.*;

import entities.Dragon;
import entities.Player;

public class Board extends JPanel implements ActionListener{
	Player p;
	Dragon d;
	Image img;
	Timer time;
	int nx, nx2;

	public Board() {
		p = new Player();
		d = new Dragon(1, 1, 1, "ak7");
		addKeyListener(new AL());
		setFocusable(true);
		
		// imagen fondo
		ImageIcon g = new ImageIcon("GoSBG.jpeg");	
		img = g.getImage();
			
		time = new Timer(5, this);
		time.start();
		nx = 0;
		nx2 = 1266;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//llama a los metodos que permiten que el jugador y dragones se puedan mover. Y repinta cada Graphic
		p.move();
		d.move();
		repaint();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		
		//movimiento de la imagen del fondo
		nx--;
		nx2--;
		g2d.drawImage(img, nx, 0, null);
		if (nx <= 0) {
			g2d.drawImage(img, nx2+100, 0, null);
			
		}
		if (nx == -1370) {
			nx =0;
			nx2 = 1266;
			
		}
		 //pinta al grifo (peter)
		g2d.drawImage(p.getImage(), p.getX(), p.getY(), null);
		
		//pinta los dragones (todavia no sirve)
		for (int i=0; i<=550; i+=50) {
		g.fillRect(d.getX(), d.getY()+i, 25, 25);
			if (d.getY()+i == 250) {
				for (int l=0; l==2; ++l) {
				g.fillRect(d.getX()+100, d.getY()+i-250, 25, 25);
				}
			} if (d.getY()+i == 400) {
				
				g.fillRect(d.getX()+150, d.getY()+i, 25, 25);
			}
		}
	}
	
	private class AL extends KeyAdapter{
		//llama a los metodos para que las teclas se puedan usar
		public void keyReleased(KeyEvent e) {
			p.KeyReleased(e);
		}
		
		public void keyPressed(KeyEvent e) {
			p.KeyPressed(e);
		}
	}
}
