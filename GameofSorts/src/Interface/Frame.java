package Interface;

import java.awt.BorderLayout;

import javax.swing.*;

public class Frame {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Game of Sorts");
		//frame.add(new Board());
		//frame.add(new BoardInfo());
		
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(new Board(), BorderLayout.CENTER);
		frame.getContentPane().add(new BoardInfo(), BorderLayout.EAST);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1366, 768);
		frame.setVisible(true);
	}
}
