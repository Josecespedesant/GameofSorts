package Interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.*;
import javax.swing.Timer;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

public class BoardInicio extends JPanel implements ActionListener{
	Image img;
	Image button;
	Timer time;
	JLabel gameStart;
	JButton startB;

	
	public BoardInicio() {
		ImageIcon g = new ImageIcon("start.jpg"); 
		img = g.getImage();
		
		//ImageIcon buttonStart = new ImageIcon("startButton.png"); 
		//button = buttonStart.getImage();
		
		startB = new JButton("Start Game");
		startB.addActionListener(this);
		
		time = new Timer(5, this);
		time.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==startB) {
			try {
				Frame.Start();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
		//repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawImage(img, 0, 0, null);
		this.add(startB);
		
		//g2d.drawImage(img, 0, 0, null); pinta imagen pero hay que cambiarla
	}

}
