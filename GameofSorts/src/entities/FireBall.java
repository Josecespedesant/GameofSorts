package entities;

<<<<<<< HEAD
import tools.HitBox;

=======
import java.awt.*;
import javax.swing.ImageIcon;
>>>>>>> refs/remotes/origin/master
public class FireBall {
	int x, y;
	Image img;
	public boolean visible = true;
	
	public FireBall(int startX, int startY) {
		x = startX;
		y = startY;
		ImageIcon fireball = new ImageIcon("fireball.gif");
		img = fireball.getImage();
		visible = true;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,256,256);
	}
	
	public void move() {
		x = x + 3;
		if (x > 1280) {
			visible = false;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public Image getImage() {
		return img;
	}
	
	public boolean getVisible() {
		return visible;
	}
}
