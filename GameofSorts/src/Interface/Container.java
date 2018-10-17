package Interface;

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class Container extends JComponent{
	private static final long serialVersionUID = 1L;
	static JPanel panel;
	
	public Container(JPanel panel) {
		this.panel = panel;
		setBounds(0,0,panel.getWidth(),panel.getHeight());
	}
	
	public void paint(Graphics g) {
		ImageIcon image = new ImageIcon(new ImageIcon(getClass().getResource("griph")))
	}
	
	
	
	
	
	
	
	
	
	
	

}
