package Interface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BoardWin extends JPanel{
	Image img;
	
	public BoardWin() {
		
		this.setBackground(Color.BLACK);
		ImageIcon g = new ImageIcon("Winner.png");
		img = g.getImage();
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(img, 0, -35, null);

	}
	
}
