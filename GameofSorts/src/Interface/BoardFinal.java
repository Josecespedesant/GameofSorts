package Interface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class BoardFinal extends JPanel implements ActionListener{
	Image img;
	Image button;
	Timer time;
	JLabel gameStart;
	JButton startB;

	
	public BoardFinal() {
		this.setBackground(Color.BLACK);
		ImageIcon g = new ImageIcon("end.gif"); 
		img = g.getImage();
				
		time = new Timer(5, this);
		time.start();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(img, 500, 250, null);
		
 	}
}
