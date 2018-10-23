package Interface;

import java.awt.Dimension;
import java.awt.Font;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entities.Dragon;
import linkedlist.SimpleLinkedList;

public class BoardInfo extends JPanel{
	JButton b1;
	JLabel labelLayOut;
	static JLabel labelActual;
	JLabel labelDragon, labelB, labelArbol;
	static JLabel labelStats;
	static SimpleLinkedList<Dragon> dragonsArray;
	static int cont = 1;

	public BoardInfo() {
		this.setPreferredSize(new Dimension(200, 768));
		this.setLabels();
		this.add(labelLayOut);
		this.add(labelActual);
		this.add(labelDragon);
		this.add(labelStats);
		this.add(labelB);
		this.add(labelArbol);
		dragonsArray = Board.getdragonsArray();
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
