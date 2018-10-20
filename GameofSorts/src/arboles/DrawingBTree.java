package arboles;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class DrawingBTree extends JPanel{
	

	static Node[] copiatab = new Node[100];
	int n = 0;
	
	public DrawingBTree (Node [] nodes, int n) {
		copiatab = nodes.clone();
		this.n= n;
	}
	
	public void paintComponent(Graphics g) {
		for(int i=0; i < n; i++) {
			g.drawOval(copiatab[i].x, copiatab[i].y, 40, 40);
			String a = String.valueOf(copiatab[i].data);
			g.drawString(a, copiatab[i].x+5, copiatab[i].y+25);
			if(copiatab[i].right != null) {
				g.setColor(Color.red);
				g.drawLine(copiatab[i].x+15, copiatab[i].y+40, copiatab[i].x+90, copiatab[i].y+90);
			} 
			if(copiatab[i].left != null) {
				g.setColor(Color.green);
				g.drawLine(copiatab[i].x+15, copiatab[i].y+40, copiatab[i].x-50, copiatab[i].y+90);
			}
			g.setColor(Color.black);
			//g.drawString("ha", 1, 2);
		}
	}

}
