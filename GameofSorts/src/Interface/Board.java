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
	static String mensaje;
	static SimpleLinkedList<Dragon> dragonsArray;
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
		d2 = factory.createDragon(2, 2, "Captain", d,3,1500, 250-50);
		d3 = factory.createDragon(2, 2, "Captain", d,3,1500, 250+50);
		d4 = factory.createDragon(2, 2, "Captain", d,3,1600, 250-100);
		d5 = factory.createDragon(2, 2, "Captain", d,3,1600, 250+0);
		//Crea los de infanteria
		d6 = factory.createDragon(3, 1, "Infantry", d,3,1600, 250+100);
		d7 = factory.createDragon(3, 1, "Infantry", d,3,1700, 250-150);
		d8 = factory.createDragon(3, 1, "Infantry", d,3,1700, 250-50);
		d9 = factory.createDragon(3, 1, "Infantry", d,3,1700, 250+50);
		d10 = factory.createDragon(3, 1, "Infantry", d,3,1700, 250+150);
		dragonsArray = new SimpleLinkedList<>();
		dragonsArray.addLast(d);
		dragonsArray.addLast(d2);
		dragonsArray.addLast(d3);
		dragonsArray.addLast(d4);
		dragonsArray.addLast(d5);
		dragonsArray.addLast(d6);
		dragonsArray.addLast(d7);
		dragonsArray.addLast(d8);
		dragonsArray.addLast(d9);
		dragonsArray.addLast(d10);
	}
	
	public static SimpleLinkedList<Dragon> getdragonsArray() {
		return dragonsArray;
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
		for (int i=0; i < dragonsArray.getLength(); i++) {
			Dragon dragonList = dragonsArray.get(i).getData();
			dragonList.move();
		}
		repaint();
	}

	public void colison() {
		for(int i = 0; i < dragonsArray.getLength(); i++) {
			Dragon dtemp = dragonsArray.get(i).getData();
			for(int j=0; j < fireballs.getLength(); j++) {
				FireBall ftemp = fireballs.get(j).getData();
				if(dtemp.getDragonHitBox().collidesWith(ftemp.getFireHitBox())) {
					dtemp.alive = false;
					dragonsArray.deleteByElement(dtemp);
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
		
		//pinta al grifo
		g2d.drawImage(p.getImage(), p.getX(), p.getY(), null);

		//pinta dragones si es que estan vivos
		for (int i=0; i < dragonsArray.getLength(); i++) {
			Dragon dragonList =  dragonsArray.get(i).getData();
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

	public static String getMensaje() {
		return mensaje;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		for (int i=0; i < dragonsArray.getLength(); i++) {
			Dragon dragonList = dragonsArray.get(i).getData();
			if(e.getX() >= dragonList.getX() && e.getX() <= dragonList.getX()+dragonList.getImage().getWidth(null) && e.getY() >=dragonList.getY() && e.getY() <= dragonList.getY()+dragonList.getImage().getWidth(null)) {
				mensaje=("<html>Age: "+dragonList.getAge()+"<br/>"+
						"Name: "+dragonList.getName()+"<br/>"+
						"Resistance: "+dragonList.getResistance()+"<br/>"+
						"Speed: "+dragonList.getSpeed()+"<br/>"+
						"Range: "+dragonList.getRange()+"<br/>"+
						"Reloding time:"+dragonList.getReloadingTime()+"</html>");
				BoardInfo.cambiarL();
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