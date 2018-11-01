package Interface;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.*;
import javax.swing.Timer;
<<<<<<< HEAD:GameofSorts/src/Interface/BoardInicio.java
//import javax.xml.parsers.ParserConfigurationException;
//import javax.xml.transform.TransformerException;
=======
>>>>>>> a6a5c55e01ddb091587cd3b428db0c4d7608fc52:src/Interface/BoardInicio.java

public class BoardInicio extends JPanel implements ActionListener{
	Image img;
	Image button;
	Timer time;
	JLabel gameStart;
	JButton startB;
	


	public BoardInicio() {
		ImageIcon g = new ImageIcon("start.jpg"); 
		img = g.getImage();

//		ImageIcon buttonStart = new ImageIcon("startButton.png"); 
//		button = buttonStart.getImage();
//
		startB = new JButton("Start Game");
		startB.addActionListener(this);
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

		g2d.drawImage(img, 0, 0, null);
		this.add(startB);
		
	}

}