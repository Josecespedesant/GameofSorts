package Interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Collections;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import arboles.BTree;
import arboles.Node;
import entities.Dragon;

public class BoardInfo extends JPanel{
	JButton b1;
	JLabel labelLayOut;
	static JLabel labelActual;
	JLabel labelDragon, labelB, labelArbol;
	static JLabel labelStats;
	static LinkedList<Dragon> dragonsArray;
	static int cont = 1;
	static LinkedList<String> nombres;
	

	public BoardInfo() {
		dragonsArray = Board.getDragonsList();
		nombres = new LinkedList<String>();
		
		for(int i=0; i<dragonsArray.size(); i++) {
			nombres.add(dragonsArray.get(i).getName());
		}
		
		this.setPreferredSize(new Dimension(200, 768));
		this.setLabels();
		this.add(labelLayOut);
		this.add(labelActual);
		this.add(labelDragon);
		this.add(labelStats);
		this.add(labelB);
		this.add(labelArbol);
	}
	
	public void setLabels() {
		//Label del Layout
		
		labelLayOut = new JLabel("Layout Actual");
		labelActual = new JLabel();
		layoutActual();
		labelLayOut.setOpaque(true);
		labelActual.setOpaque(true);
		labelLayOut.setFont(new Font("Serif", Font.BOLD, 25));
		labelActual.setFont(new Font("Serif", Font.PLAIN, 22));
		
		//Label del stats del dragon
		labelDragon = new JLabel("Dragon Stats");
		labelStats = new JLabel("<html>Age:<br/>Name:<br/>Resistance:<br/>Speed:<br/>Range:<br/>Reloding Time:</html>");
		labelDragon.setOpaque(true);
		labelStats.setOpaque(true);
		labelDragon.setFont(new Font("Serif", Font.BOLD, 25));
		labelStats.setFont(new Font("Serif", Font.PLAIN, 25));
		
		//label donde se muestra el arbol B
		labelB = new JLabel("Arbol B de dragones");
		labelArbol = new JLabel();
		labelB.setOpaque(true);
		labelArbol.setOpaque(true);
		labelB.setFont(new Font("Serif", Font.BOLD, 20));
		labelArbol.setFont(new Font("Serif", Font.PLAIN, 12));
	}
	
	public void paintComponent(Graphics g) {
		nombres = new LinkedList<String>();
		
		for(int i=0; i<dragonsArray.size(); i++) {
			nombres.add(dragonsArray.get(i).getName());
		} 
		
		int x=50;
		int y=370;
		super.paintComponent(g);
		BTree<Integer, String> arbolB = new BTree<Integer, String>();
		
		Collections.sort(nombres);
		
		for(int i = 0; i < nombres.size(); i++) {
			arbolB.put(i, nombres.get(i));
			
			
			int xcent = 50;
			int ycent = 370;
			
			if(i<=nombres.size()/2) {
				g.drawString(nombres.get(i), x, y);
				y+=20;
				x-=17;
				if(i == nombres.size()/2) {
					x = xcent+35;
					y = ycent+20;
				}
			}else {
				g.drawString(nombres.get(i), x, y);
				x+=15;
				y+=20;
			}
			
			
			
			
			
			
			
		}
		
		repaint();
		
	}
	
	/**
     * Dibuja la flecha
     * @param g
     * @param srcX
     * @param srcY
     * @param destX
     * @param destY
     * @param width
     * @param height
     */
    private void drawArrowLine(Graphics g, int srcX, int srcY, int destX, int destY, int width, int height) {
        int distX = destX - srcX, distY = destY - srcY;
        double D = Math.sqrt(distX*distX + distY*distY);
        double xm = D - width, xn = xm, ym = height, yn = -height, x;
        double sin = distY / D, cos = distX / D;

        x = xm*cos - ym*sin + srcX;
        ym = xm*sin + ym*cos + srcY;
        xm = x;

        x = xn*cos - yn*sin + srcX;
        yn = xn*sin + yn*cos + srcY;
        xn = x;

        int[] xpoints = {destX, (int) xm, (int) xn};
        int[] ypoints = {destY, (int) ym, (int) yn};

        g.drawLine(srcX, srcY, destX, destY);
    }
	
	public static void cambiarL() {
		labelStats.setText(Board.getMensaje());
	}
	
	public static void layoutActual() {		
		switch (cont) {
		case 1: labelActual.setText("Desorden");
		cont++;
		break;
		case 2:  labelActual.setText("Selection sort");
		cont++;
		break;
		case 3:  labelActual.setText("Insertion sort");
		cont++;
		break;
		case 4:  labelActual.setText("Quick Sort");
		cont++;
		break;
		case 5:  labelActual.setText("Arbol binario");
		cont++;
		break;
		case 6:  labelActual.setText("Árbol AVL");
		cont=1;
		break;
		}
	}

}
