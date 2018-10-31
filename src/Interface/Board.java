package Interface;

import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

//import org.junit.Assert;

import entities.Dragon;
import entities.FireBall;
import entities.FireBallDragon;
import entities.Player;
import linkedlist.SimpleLinkedList;
import xml.WaveXML;


public class Board extends JPanel implements ActionListener, MouseListener {
	Player p;
	//	Dragon d, d2, d3, d4, d5, d6, d7, d8, d9, d10;
	Image img, vidas;
	Timer time;
	int nx, nx2;
	//	int relodingTime, resistance, speed;
	static String mensaje;
	static SimpleLinkedList<Dragon> dragonsArray;
	static SimpleLinkedList<FireBall> fireballs;
	static SimpleLinkedList<FireBallDragon> fireballsD;
	static int number;
	static int cd;

	static LinkedList linkedList;

	private int cont;

	public Board() throws ParserConfigurationException, TransformerException{ 
		p = new Player(); //jugador
		number = 35;
		createWave(number);
		cont = 1;		
		fireballs = p.getFireballs();

		addKeyListener(new AL());
		setFocusable(true);
		addMouseListener(this);

		// imagen fondo
		ImageIcon g = new ImageIcon("fondo.png"); 
		img = g.getImage();



		time = new Timer(5, this);
		time.start();
		nx = 0;
		nx2 = 1266;

		//linkedList = new LinkedList();
	}


	/**
	 * Creates the wave
	 * @throws ParserConfigurationException 
	 * @throws TransformerException 
	 */
	public void createWave(int number) throws ParserConfigurationException, TransformerException{
		//		numero de dragones en la oleada, el parametro se ingresa con base en el nivel del juego
		//		como la primera oleada es de 10 (ya NO de 100 dragones)y se aumenta en un 20%
		//		al redondear los valores que se deben ingresar son  10 - 12 - 14 - 17 - 20
		this.number = number;
		WaveXML oleada=new WaveXML(number);
		linkedList = oleada.getLista();
		setDragonsArray(oleada.getdragonsArray());
	}


	public static LinkedList<Dragon> getDragonsList() {
		return linkedList;
	}



	public static void setDragonsArray(SimpleLinkedList<Dragon> dragonsArray) {
		Board.dragonsArray = dragonsArray;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		//llama a los metodos que permiten que el jugador y dragones se puedan mover. Y repinta cada Graphic
		try {
			colison();
			colisionDragones();
		} catch (ParserConfigurationException | TransformerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (int i=0; i < fireballs.getLength(); i++) {
			FireBall fb = fireballs.get(i).getData();
			if(fb.getVisible()) {
				fb.move();
			} else {
				fireballs.deleteByElement(fb);
			}
		}

		for(int i=0; i<linkedList.size();i++) {
			Dragon dtemp = (Dragon) linkedList.getFirst();
			fireballsD = dtemp.getFireballsDragon();
		}

		for (int i=0; i < fireballsD.getLength(); i++) {
			FireBallDragon fb = fireballsD.get(i).getData();
			fb.setVisible();
			if(fb.getVisible()) {
				fb.move();
			} else {
				fireballsD.deleteByElement(fb);
			}
		}

		p.move();

		for (int i=0; i < dragonsArray.getLength(); i++) {
			Dragon dtemp = dragonsArray.get(i).getData();
			dtemp.move();
			if (dtemp.getX()==900 && dtemp.alive){
				dtemp.fire(dtemp.getX(), dtemp.getY());
			}
		}

		repaint();
	}
	

	public void colison() throws ParserConfigurationException, TransformerException {

		for(int i = 0; i < linkedList.size(); i++) {
			Dragon dtemp = (Dragon) linkedList.get(i);
			Rectangle d1 = dtemp.getBounds();

			if(d1.intersects(p.getBounds())) {
				if(p.getlifes()==0) {
					p.alife = false;
				}else {
				//	p.lifes = p.lifes-1;
				}
			}

			for(int j=0; j < fireballs.getLength(); j++) {
				FireBall ftemp = fireballs.get(j).getData();
				Rectangle f1 = ftemp.getBounds();

				if(d1.intersects(f1) && dtemp.isAlive()) {
					
					
					if(dtemp.getResistance() == cont) {
						//Aqui se tiene que llamar al metodo donde se acomodan los dragones
						dtemp.alive = false;
						linkedList.remove(dtemp);
						System.out.println(linkedList.size()+ "                      CACA");
					/*	for(int f = 0; f < linkedList.size(); f++) {
							Dragon dtemp1 = (Dragon) linkedList.get(f);
							//Inserte Lista Ordenada
							LinkedList DnuevaLista = new LinkedList();
									for(int k = 0; k < listaOrdenada; k++) {
										Dragon DnuevaLista = (Dragon) listaOrdenada.get(k);
										DNuevaLista.setX(dtemo1.getX());
										DNuevaListas.setY(dtemp1.getY());
										
										}
						}*/
						
							Dragon dcambio = (Dragon) linkedList.getFirst();
							dcambio.setX(dtemp.getX());
							dcambio.setY(dtemp.getY());
								
						BoardInfo.layoutActual();
						ftemp.visible = false;
						cont = 1;
					}else if(cont>3) {
						cont = 1;
					}else {
						ftemp.visible = false;
						cont++;
					}
					if(linkedList.size()==0) {
						number +=number * 20 / 100;
//						contador para saber cual es la ultima oleada 
						cd++;
						createWave(number);
					}
				}
			}	
		}
	}

	public void colisionDragones() throws Exception {
		Rectangle p1 = p.getBounds();
		for(int i=0; i<linkedList.size();i++) {
			Dragon dtemp = (Dragon) linkedList.getFirst();
			fireballsD = dtemp.getFireballsDragon();
		}
		for(int i = 0; i < fireballsD.getLength(); i++) {
			FireBallDragon ftemp = fireballsD.get(i).getData();
			Rectangle f1 = ftemp.getBounds();

			if(f1.intersects(p1)) {
				ftemp.visible = false;
				if(p.getlifes()==0) {
					p.alife = false;
				}else {
				//	p.lifes = p.lifes-1;
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

		if(p.lifes==3) {
			ImageIcon lifes = new ImageIcon("vidas3.png"); 
			vidas = lifes.getImage();
			g2d.drawImage(vidas, 0, 0, null);
		}else if(p.lifes==2) {
			ImageIcon lifes = new ImageIcon("vidas2.png"); 
			vidas = lifes.getImage();
			g2d.drawImage(vidas, 0, 0, null);
		}else if(p.lifes==1) {
			ImageIcon lifes = new ImageIcon("vidas1.png"); 
			vidas = lifes.getImage();
			g2d.drawImage(vidas, 0, 0, null);
		}

		//Validaciones que hace que el jugador no se salga de la pantalla
		if(p.getX() < 0) {
			p.x = 0;
		}

		if(p.getX() > 1050) {
			p.x = 1050;
		}

		if(p.getY() < 0) {
			p.y = 0;
		}

		if(p.getY() > 638) {
			p.y = 638;
		}

		//pinta al grifo
		if(p.isAliVe()) {
			g2d.drawImage(p.getImage(), p.getX(), p.getY(), null);
		}
		
		
//		si elimina a todos los dragones aparece una imagen de que es el ganador
		if(cd==8) {
			ImageIcon lifes = new ImageIcon("Winner.png"); 
			vidas = lifes.getImage();
			g2d.drawImage(vidas, 600, 150, null);
		}
		
		
//		pinta dragones si es que estan vivos			
		for(int i = 0; i < dragonsArray.getLength(); i++) {
			Dragon dtemp = dragonsArray.get(i).getData();
			
			if(dtemp.alive) {
				if(dtemp.getRank()=="Comandant") {
					g2d.drawImage(dtemp.getImage(), dtemp.getX(), dtemp.getY(), null);
				}else if(dtemp.getRank()=="Captain") {
				ImageIcon lifes = new ImageIcon("dragonCapitan.gif"); 
				Image capitan = lifes.getImage();
				g2d.drawImage(capitan, dtemp.getX(), dtemp.getY(), null);
			}else {
				ImageIcon lifes = new ImageIcon("dragonInfantry.gif"); 
				Image infantry = lifes.getImage();
				g2d.drawImage(infantry, dtemp.getX(), dtemp.getY(), null);
			}
							
			}
			if(p.getlifes() == 0) {
				p.alife = false;
				try {
					Frame.end();
				} catch (ParserConfigurationException | TransformerException e) {
					e.printStackTrace();
				} return;
			}else if(dtemp.getX() == 0) {
				//p.lifes -=1;
			}
		}

		//pinta las bolas de fuego del jugador
		for (int i=0; i < fireballs.getLength(); i++) {
			FireBall fb = fireballs.get(i).getData();
			g2d.drawImage(fb.getImage(), fb.getX(), fb.getY(), null);
		}

		//pinta bolas de fuego de los dragones
		for (int i=0; i < fireballsD.getLength(); i++) {
			FireBallDragon fb = fireballsD.get(i).getData();
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
						"Range: "+dragonList.getRank()+"<br/>"+
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