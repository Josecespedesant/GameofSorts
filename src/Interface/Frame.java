package Interface;

import java.awt.BorderLayout;
import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;


public class Frame {
	static JFrame frame, frame1;
	
	static PlayMusic p;
	
	public static void main(String[] args) throws Exception  {
		frame = new JFrame("Game of Sorts");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(new BoardInicio(), BorderLayout.CENTER);
		frame.setSize(1366, 500);
		frame.setVisible(true);
		frame.setResizable(false);
		p = new PlayMusic("intro.wav");
	}
	
	public static void Start() throws Exception {
		frame.dispose();
		
		
		frame = new JFrame("Game of Sorts");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new Board(), BorderLayout.CENTER);
		frame.getContentPane().add(new BoardInfo(), BorderLayout.EAST);
		frame.setSize(1366, 768);
		frame.setVisible(true);
		frame.setResizable(false);
		p.stop();
		p = new PlayMusic("game.wav");
	}
	
	public static void end() throws Exception, ParserConfigurationException, TransformerException {
		frame.dispose();
	
		frame = new JFrame("Game of Sorts");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new BoardFinal(), BorderLayout.CENTER);
		frame.setSize(1366, 768);
		frame.setVisible(true);
		frame.setResizable(false);
		
		p.stop();
		p = new PlayMusic("end.wav");
	}
	
	
	
}
