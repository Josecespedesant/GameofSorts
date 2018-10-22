package Interface;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class Frame {
	public static void main(String[] args) throws ParserConfigurationException, TransformerException, SAXException, IOException {
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
