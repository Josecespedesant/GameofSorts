package Interface;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class Frame {

 static JFrame frame, frame1;
 public static void main(String[] args)  {
  frame = new JFrame("Game of Sorts");
  
  frame.getContentPane().setLayout(new BorderLayout());
  frame.getContentPane().add(new BoardInicio(), BorderLayout.CENTER);
  frame.setSize(1366, 768);
  frame.setVisible(true);
 }
 
 public static void Start() throws Exception {
  frame.dispose();
  
  frame = new JFrame("Game of Sorts");
  frame.getContentPane().add(new Board(), BorderLayout.CENTER);
  frame.getContentPane().add(new BoardInfo(), BorderLayout.EAST);
  frame.setSize(1366, 768);
  frame.setVisible(true);
  
  
 }
 
	
}

