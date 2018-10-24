package entities;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.ImageIcon;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import tools.HitBox;

/**
 * Declaration of the class Dragon.
 * @author Jose Antonio Cespedes
 */
public class Dragon {
	
	/**
	 * Attributes of the class Dragon.
	 */
	private String name;
	private int reloadingTime;
	private int age;
	private int resistance;
	private String range;
	private Dragon father;
	private HitBox dragonHitBox;
	private int speed;
//	public static int numeroPadre;
//	public static int numeroDragon;
	public int x, dx, y, dy;
	public boolean alive = true;
	Image img;

	/**
	 * Constructor for the dragon.
	 * @param name
	 * @param reloadingTime
	 * @param age
	 * @param resistance
	 * @param range
	 */
//	public Dragon(int reloadingTime, int resistance, String range, Dragon father ,int speed, int startX, int startY) {
//		setName();
//		this.reloadingTime = reloadingTime;
//		this.resistance = resistance;
//		this.range = range;
//		this.father = father;
//		setAge();
//		this.speed = speed;
//		x = startX;
//		y = startY;
//		ImageIcon dg = new ImageIcon("dragon.gif");
//		img = dg.getImage();
//		this.dragonHitBox = new HitBox(this.x, this.y, img.getWidth(null), img.getHeight(null));
//	}
	
	public Dragon(int resistance, String range, int speed) {
		setName();
		this.resistance = resistance;
		this.range = range;
		setAge();
		this.speed = speed;
		ImageIcon dg = new ImageIcon("dragon.gif");
		img = dg.getImage();
		this.dragonHitBox = new HitBox(this.x, this.y, img.getWidth(null), img.getHeight(null));
	}
	
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,100,100);
	}
	
	
	/**
	 * Sets the name of the dragon randomly
	 */
	public void setName() {
		
		String[] names = new String[] {"Rhaegal", "Viserion", "Drogon", "Errol", "Faranth", "Firnen", "Glaedr", 
				"Saphira", "Slathborg", "Thorn", "Eldrax", "Balerion", "Chrysophylax", "Ancalagon", "Aithusa", 
				"Shen Long", "Spyro", "Mushu", "Alduin", "Alexstrasza", "Kalameet", "Aquamentus", "Shyvanna", 
				"Yomigami", "Charizard", "Yoshi", "Aurelion Sol", "Jabberwocky", "Leviathan", "Ryujin", "Toothless", 
				"Hyorinmaru", "Paarthurnax", "Deathwing", "Quetzalcóatl","Hearkon", "Aatrox", "Rek'Sai", "Vel'Koz", 
				"Kai'Sa", "Teemo", "Dartharjae", "Cho'Gath"};
		
		int num = (int) (Math.random() * names.length-1);
		setName(names[num]);
	}
	
	/**
	 * Starts the movement of the Dragon.
	 */
	public void move() {
		x = x + dx;
		y = y + dy;
		dragonHitBox.move(x);
		this.moveLeft();
	}
	
	/**
	 * Moves the dragon to the left.
	 */
	public void moveLeft() {
		dx = -1;
	}
	
	/**
	 * Returns de X position of the Dragon.
	 * @return x
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Returns the Y position of the Dragon.
	 * @return y
	 */
	public int getY() {
		return y;
	}
	
	public Image getImage() {
		return img;
	}
	/**
	 * Sets de X position of the Dragon.
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Sets the Y position of the Dragon.
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	public boolean isAlive() {
		return alive;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	/**
	 * Sets the speed of the dragon
	 * @param speed
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	/**
	 * Returns the speed of the dragon.
	 * @return speed
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the dragon
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns the reloading time of the dragon.
	 * @return reloadinTime
	 */
	public int getReloadingTime() {
		return reloadingTime;
	}
	
	/**
	 * Sets the reloading time of the dragon
	 * @param reloadinTime
	 */
	public void setReloadingTime(int reloadingTime) {
		this.reloadingTime = reloadingTime;
	}
	
	/**
	 * Returns the age of the dragon.
	 * @return age
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * Sets the age of the dragon in a way two dragons doesn't have the same age.
	 * @param age
	 */
	public void setAge() {
		if(getFather() == null) {
			int num = ThreadLocalRandom.current().nextInt(900, 1000 + 1);
			this.age = num;
		}else {
			int num = ThreadLocalRandom.current().nextInt(1, 890 + 1);
			this.age = num;
		}
	}
	
	/**
	 * Returns the resistance of the dragon.
	 * @return resistance
	 */
	public int getResistance() {
		return resistance;
	}
	
	/**
	 * Sets the resistance of the dragon
	 * @param resistance
	 */
	public void setResistance(int resistance) {
		this.resistance = resistance;
	}
	
	/**
	 * Returns the range of the dragon.
	 * @return range
	 */
	public String getRange() {
		return range;
	}
	
	/**
	 * Sets the range of the dragon
	 * @param range
	 */
	public void setRange(String range) {
		this.range = range;
	}
	
	/**
	 * Returns the father of the dragon.
	 * @return father
	 */
	public Dragon getFather() {
		return father;
	}
	
	/**
	 * Sets the father of the dragon
	 * @param father
	 */
	public void setFather(Dragon father) {
		this.father = father;
	}
	
	/**
	 * Returns the hit box of the dragon.
	 * @return dragonHitBox
	 */
	public HitBox getDragonHitBox() {
		return dragonHitBox;
	}
	
	/**
	 * Sets the hit box of the dragon
	 * @param dragonHitBox
	 */
	public void setDragonHitBox(HitBox dragonHitBox) {
		this.dragonHitBox = dragonHitBox;
	}
	
//	+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//	metodo para serializar los datos del dragon y convertirlo a xml
	public Node serializarDragon(Document doc) {
		Element elementoDragon = doc.createElement("Dragon");
		elementoDragon.setAttribute("Nombre", this.name);
		elementoDragon.setAttribute("Edad", Integer.toString(this.age));
		elementoDragon.setAttribute("Resistencia", Integer.toString(this.resistance));
		elementoDragon.setAttribute("Rango", this.range);
		elementoDragon.setAttribute("Velocidad", Integer.toString(this.speed));
		
		
		return elementoDragon;
	}

//	Instancia los dragones apartir de un xml
	public static Dragon instanciarXML(Node elementoDragon) {
		
		Dragon nuevoDragon = new Dragon(Integer.parseInt(((Element) elementoDragon).getAttribute("Resistencia")),((Element) elementoDragon).getAttribute("Rango"),Integer.parseInt(((Element) elementoDragon).getAttribute("Velocidad")));
		return nuevoDragon;
	}
	
//	-------------------------------------------------------------
	
////	Instancia los dragones apartir de un xml
//	public static Dragon instanciarXML(Node elementoDragon) {
//		Dragon nuevoDragon = new Dragon(Integer.parseInt(((Element) elementoDragon).getAttribute("Resistencia")),((Element) elementoDragon).getAttribute("Rango"),Integer.parseInt(((Element) elementoDragon).getAttribute("Velocidad")));
//		return nuevoDragon;
//	}
////	-------------------------------------------------------------

}
