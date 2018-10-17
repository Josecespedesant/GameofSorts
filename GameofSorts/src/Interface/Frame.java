package Interface;

import javax.swing.*;

public class Frame {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Game of Sorts");
		frame.add(new Board());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1366, 768);
		frame.setVisible(true);
	}
}
