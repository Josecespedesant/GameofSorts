package arboles;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Interface.BoardInfo;

public class GrapichBTree extends ArbolB{
	static Node[] tab = new Node[100];
	static int i = 0;
	JFrame frame = null;
	JPanel panel = null; 
	
	public GrapichBTree() {
		frame = new JFrame();
		frame.setTitle("grafico");
		frame.setSize(1500,600);
		frame.setResizable(false);
	}
	
	public void getReady(Node node) {
		tab[i] = node;
		i++;
		if(node.left !=null) {
			getReady(node.left);
		} 
		if(node.right != null) {
			getReady(node.right);
		}
	}
	
	public void drawTree() {
		//frame.setContentPane(new BoardInfo(tab,cuantos));
		frame.setVisible(true);
	}
}
