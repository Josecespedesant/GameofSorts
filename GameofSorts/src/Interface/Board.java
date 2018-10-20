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
import linkedlist.SimpleLinkedList;

public class Board extends JPanel implements ActionListener, MouseListener{
	Player p;
	Dragon d, d2, d3, d4, d5, d6, d7, d8, d9, d10;
	Image img;
	Timer time;
	int nx, nx2;
	int relodingTime, resistance, speed;
	static SimpleLinkedList<Dragon> dragons;
	static SimpleLinkedList<FireBall> fireballs;
	
	
	public Board() {
		p = new Player(); //jugador
		createWave();
		
		fireballs = p.getFireballs();

		addKeyListener(new AL());
		setFocusable(true);
		addMouseListener(this);

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
		d = factory.createDragon(1, 3, "Comandant", null, 3,1400,250);
		//Crea los capitanes
		d2 = factory.createDragon(2, 2, "Captain", d,3,1600, 250-100);
		d3 = factory.createDragon(2, 2, "Captain", d,3,1600, 250+100);
		d4 = factory.createDragon(2, 2, "Captain", d,3,1850, 250-200);
		d5 = factory.createDragon(2, 2, "Captain", d,3,1850, 250+0);
		//Crea los de infanteria
		d6 = factory.createDragon(3, 1, "Infantry", d,3,1850, 250+200);
		d7 = factory.createDragon(3, 1, "Infantry", d,3,2050, 250-300);
		d8 = factory.createDragon(3, 1, "Infantry", d,3,2050, 250-100);
		d9 = factory.createDragon(3, 1, "Infantry", d,3,2050, 250+100);
		d10 = factory.createDragon(3, 1, "Infantry", d,3,2050, 250+300);
		dragons = new SimpleLinkedList<>();
		dragons.addLast(d);
		dragons.addLast(d2);
		dragons.addLast(d3);
		dragons.addLast(d4);
		dragons.addLast(d5);
		dragons.addLast(d6);
		dragons.addLast(d7);
		dragons.addLast(d8);
		dragons.addLast(d9);
		dragons.addLast(d10);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//llama a los metodos que permiten que el jugador y dragones se puedan mover. Y repinta cada Graphic
		colison();
		
		for (int i=0; i < fireballs.getLength(); i++) {
			FireBall fb = fireballs.get(i).getData();
			if(fb.getVisible()) {
				fb.move();
			} else {
				fireballs.deleteByElement(fb);
			}
		}
		p.move();
		for (int i=0; i < dragons.getLength(); i++) {
			Dragon dragonList = dragons.get(i).getData();
			dragonList.move();
		}
		repaint();
	}

	public void colison() {
		for(int i = 0; i < dragons.getLength(); i++) {
			Dragon dtemp = dragons.get(i).getData();
			for(int j=0; j < fireballs.getLength(); j++) {
				FireBall ftemp = fireballs.get(j).getData();
				if(dtemp.getDragonHitBox().collidesWith(ftemp.getFireHitBox())) {
					dtemp.alive = false;
					dragons.deleteByElement(dtemp);
					ftemp.visible = false;
				}
			}
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
		
		if (p.getX() < 0) {
			p.dx = 0;
		}
		
		//pinta al grifo
		g2d.drawImage(p.getImage(), p.getX(), p.getY(), null);

		//pinta dragones si es que estan vivos
		for (int i=0; i < dragons.getLength(); i++) {
			Dragon dragonList =  dragons.get(i).getData();
			if (dragonList.alive){
				g2d.drawImage(dragonList.getImage(), dragonList.getX(), dragonList.getY(), null);
			}
		}
		
		//pinta las bolas de fuego del jugador
		for (int i=0; i < fireballs.getLength(); i++) {
			FireBall fb = fireballs.get(i).getData();
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

	@Override
	public void mouseClicked(MouseEvent e) {
		for (int i=0; i < dragons.getLength(); i++) {
			Dragon dragonList = dragons.get(i).getData();
			if(e.getX() >= dragonList.getX() && e.getX() <= dragonList.getX()+dragonList.getImage().getWidth(null) && e.getY() >=dragonList.getY() && e.getY() <= dragonList.getY()+dragonList.getImage().getWidth(null)) {
				System.out.println("Age:"+dragonList.getAge()+" Name:"+dragonList.getName()+" RT:"+dragonList.getReloadingTime());
				} 
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}