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
	Timer time;
	JLabel gameStart;
	JButton startB;

	
	public BoardInicio() {
		this.setBackground(Color.BLACK);
		ImageIcon g = new ImageIcon("start.gif"); 
		img = g.getImage();
		
		startB = new JButton("Start");
		gameStart = new JLabel("Start Game");
		startB.addActionListener(this);
		this.add(gameStart);
		this.add(startB);
		
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

		
		//g2d.drawImage(img, 0, 0, null); pinta imagen pero hay que cambiarla
	}

}
