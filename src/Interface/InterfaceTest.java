package Interface;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;

import org.junit.Test;

import junit.framework.Assert;

public class InterfaceTest {

	
	@Test //Prueba que la primera oleda es desordenada
	public void TestlayoutActual() throws Exception {
		Frame.main(null);
		Frame.Start();
		String test = Board.getMensaje();
		String esperado = "Desorden";
		assertEquals(test, esperado);
	
	}
	
	@Test //comprueba el tamano del frame
	public void testFrame() throws Exception {
		Frame.main(null);
		
		int height = Frame.frame.getHeight();
		int width = Frame.frame.getWidth();
		
		assertEquals(width, 1366);
		assertEquals(height, 500);
	}
	
	@Test //prueba que la cancion del BoardInicio sea la correcta
	public void testSongName() throws Exception {
		Frame.main(null);
		assertEquals(Frame.p.filePath, "intro.wav");
	}
	
	@Test //prueba que la imagen en BoardFinal sea la correcta
	public void testImage() throws Exception {
		Frame.main(null);
		BoardFinal bI = new BoardFinal();
		ImageIcon g = new ImageIcon("end.gif"); 
		Image img = g.getImage();
		assertEquals(bI.img, img);
	}
	
	@Test //prueba el movimiento de la pantalla de Board
	public void testMovimientoBoard() throws Exception {
		Frame.main(null);
		Frame.Start();
		
		Board b = new Board();
		assertTrue(b.nx!=0);
	}

}
