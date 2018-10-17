package Interface;

import java.awt.*;
import java.awt.Image;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

import entities.Dragon;
import entities.DragonFactory;
import entities.DragonFactoryMethod;
import entities.FireBall;
import entities.Player;

public class Board extends JPanel implements ActionListener{
	Player p;
	Dragon d, d2, d3, d4, d5, d6, d7, d8, d9, d10;
	Image img;
	Timer time;
	int nx, nx2;
	int relodingTime, resistance, speed;
	int randomAge;
	public Board() {
		randomAge = new Random().nextInt(1000);
		p = new Player(); //jugador
		d = new Dragon(relodingTime, randomAge, resistance, "ak7+1", speed,1400,250); //dragones
		d2 = new Dragon(relodingTime, randomAge, resistance, "ak7+1",speed ,1600, 250-100);
		d3 = new Dragon(relodingTime, randomAge, resistance, "ak7+1",speed ,1600, 250+100);
		d4 = new Dragon(relodingTime, randomAge, resistance, "ak7+1",speed ,1850, 250-200);
		d5 = new Dragon(relodingTime, randomAge, resistance, "ak7+1",speed ,1850, 250+0);
		d6 = new Dragon(relodingTime, randomAge, resistance, "ak7+1",speed ,1850, 250+200);
		d7 = new Dragon(relodingTime, randomAge, resistance, "ak7+1",speed ,2050, 250-300);
		d8 = new Dragon(relodingTime, randomAge, resistance, "ak7+1",speed ,2050, 250-100);
		d9 = new Dragon(relodingTime, randomAge, resistance, "ak7+1",speed ,2050, 250+100);
		d10 = new Dragon(relodingTime, randomAge, resistance, "ak7+1",speed ,2050, 250+300);

		/* hay que hacer un metodo para no crear cada instancia a pie
  ArrayList dragons = new ArrayList<>();
  for (int i=0; i ==10; i++) {
   d = new Dragon(1, 1, 1, "ak7",1,1400,284);
   dragons.add(d);
  }
		 */
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

	/**
	 * Creates the wave
	 */
	public void createWave() {
		DragonFactoryMethod factory = new DragonFactory();
		//Crea al dragon padre
		d = factory.createDragon(1, 4000, 3, "Comandant", null);
		//Crea los capitanes
		d2 = factory.createDragon(2, 2000, 2, "Captain", d);
		d3 = factory.createDragon(2, 2000, 2, "Captain", d);
		d4 = factory.createDragon(2, 2000, 2, "Captain", d);
		d5 = factory.createDragon(2, 2000, 2, "Captain", d);
		//Crea los de infanteria
		d6 = factory.createDragon(3, 1000, 1, "Infantry", d);
		d7 = factory.createDragon(3, 1000, 1, "Infantry", d);
		d8 = factory.createDragon(3, 1000, 1, "Infantry", d);
		d9 = factory.createDragon(3, 1000, 1, "Infantry", d);
		d10 = factory.createDragon(3, 1000, 1, "Infantry", d);
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
		d3.move();
		d4.move();
		d5.move();
		d6.move();
		d7.move();
		d8.move();
		d9.move();
		d10.move();
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

		//pinta al grifo
		g2d.drawImage(p.getImage(), p.getX(), p.getY(), null);

		//pinta dragones si es que estan vivos
		if (d.alive)
			g2d.drawImage(d.getImage(), d.getX(), d.getY(), null);
		if(d2.alive)
			g2d.drawImage(d2.getImage(), d2.getX(), d2.getY(), null);
		g2d.drawImage(d3.getImage(), d3.getX(), d3.getY(), null);
		g2d.drawImage(d4.getImage(), d4.getX(), d4.getY(), null);
		g2d.drawImage(d5.getImage(), d5.getX(), d5.getY(), null);
		g2d.drawImage(d6.getImage(), d6.getX(), d6.getY(), null);
		g2d.drawImage(d7.getImage(), d7.getX(), d7.getY(), null);
		g2d.drawImage(d8.getImage(), d8.getX(), d8.getY(), null);
		g2d.drawImage(d9.getImage(), d9.getX(), d9.getY(), null);
		g2d.drawImage(d10.getImage(), d10.getX(), d10.getY(), null);

		ArrayList fireballs = Player.getFireballs();
		for (
				int i=0; i < fireballs.size(); i++) {
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