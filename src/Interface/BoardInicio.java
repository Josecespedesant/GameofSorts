package Interface;

import com.studiohartman.jamepad.ControllerManager;
import com.studiohartman.jamepad.ControllerState;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.*;
import javax.swing.Timer;

public class BoardInicio extends JPanel implements ActionListener{
	private Image img;
	private Image button;
	private Timer time;
	private JLabel gameStart;
	private JButton startB;
    private ControllerManager controllers = new ControllerManager();



	public BoardInicio() {
		ImageIcon g = new ImageIcon("start.jpg"); 
		img = g.getImage();

		//ImageIcon buttonStart = new ImageIcon("startButton.png"); 
		//button = buttonStart.getImage();

		startB = new JButton("Start Game");
		startB.addActionListener(this);
		this.add(startB);

		time = new Timer(5, this);
		time.start();

        this.controllers.initSDLGamepad();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==startB) {
			try {
				Frame.Start();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		//repaint();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.drawImage(img, 0, 0, null);
		this.add(startB);

        this.buttonPressed();

        repaint();
		
	}

	public void buttonPressed() {
        ControllerState estadoActual = controllers.getState(0);

        if (estadoActual.a) {
            try {
                Frame.Start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}