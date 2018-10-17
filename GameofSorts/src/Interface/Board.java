package Interface;

import java.awt.*;
import java.awt.Image;
import java.awt.event.*;
import java.util.ArrayList;

import javax.imageio.stream.ImageInputStream;
import javax.swing.*;

import entities.Dragon;
import entities.FireBall;
import entities.Player;

public class Board extends JPanel implements ActionListener{
	Player p;
	Dragon d, d2;
	Image img;
	Timer time;
	int nx, nx2;

	public Board() {
		p = new Player(); //jugador
		d = new Dragon(1, 1, 1, "ak7",1,1000,50); //dragones
		d2 = new Dragon(2, 2, 2, "ak7+1",1,1300,500);

		
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
		colison();
		ArrayList fireballs = Player.getFireballs();
		for (int i=0; i < fireballs.size(); i++) {
			FireBall fb = (FireBall) fireballs.get(i);
			if(fb.getVisible()) {
			fb.move();
			} else {
				fireballs.remove(i);
			}
		}
		p.move();
		d.move();
		d2.move();
		repaint();
	}
	
	public void colison() {
		Rectangle dr = d.getBounds(); 
		Rectangle dr1 = d2.getBounds();
		ArrayList fireballs = Player.getFireballs();
		for (int i=0; i < fireballs.size(); i++) {
			FireBall fb = (FireBall) fireballs.get(i);
			Rectangle fb1 = fb.getBounds();
			if(dr.intersects(fb1) && d.isAlive()) {
				d.alive = false;
				fb.visible = false;
				
			} else if (dr1.intersects(fb1) && d2.isAlive()) {
				d2.alive = false;
				fb.visible = false;
			}
		}
		Rectangle grif = p.getBounds();
		if(grif.intersects(dr) || grif.intersects(dr1)) {
			//colision entre jugador y dragon
		}
		
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
		
		
		//pinta dragones si es que estan vivos
		if (d.alive)
			g2d.drawImage(d.getImage(), d.getX(), d.getY(), null);
		if(d2.alive)
			g2d.drawImage(d2.getImage(), d2.getX(), d2.getY(), null);
		
		ArrayList fireballs = Player.getFireballs();
		for (int i=0; i < fireballs.size(); i++) {
			FireBall fb = (FireBall) fireballs.get(i);
			g2d.drawImage(fb.getImage(), fb.getX(), fb.getY(), null);
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
