package entities;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.ImageIcon;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import linkedlist.SimpleLinkedList;
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
	private String rank;
	private Dragon father;
	private HitBox dragonHitBox;
	private int speed;
	public static int numeroPadre;
	public static int numeroDragon;
	public int x, dx, y, dy;
	public boolean alive = true;
	Image img;
	static SimpleLinkedList<FireBallDragon> fireballsD;


	/**
	 * Constructor for the dragon
	 * @param resistance
	 * @param rank
	 */

	public Dragon(int resistance, String rank) {
		setName();
		this.father = null;
		this.resistance = resistance;
		this.rank = rank;
		setAge();
		this.speed = speed;
		ImageIcon dg = new ImageIcon("dragon.gif");
		img = dg.getImage();
		fireballsD = new SimpleLinkedList<FireBallDragon>();
		this.dragonHitBox = new HitBox(this.x, this.y, img.getWidth(null), img.getHeight(null));
	}


	/**
	 * Constructor for the dragon
	 * @param name
	 * @param resistance
	 * @param rank
	 */
	public Dragon(String name, int resistance, String rank) {
		this.name = name;
		this.resistance = resistance;
		this.rank = rank;
		setAge();
		this.speed = speed;
		this.father = null;
		ImageIcon dg = new ImageIcon("dragon.gif");
		img = dg.getImage();
		fireballsD = new SimpleLinkedList<FireBallDragon>();
		this.dragonHitBox = new HitBox(this.x, this.y, img.getWidth(null), img.getHeight(null));
	}


	public Rectangle getBounds() {
		return new Rectangle(x,y,100,100);
	}

	public void fire(int x1, int y1) {
		FireBallDragon fireD = new FireBallDragon(x1, y1);
		fireballsD.addLast(fireD);
	}

	public static SimpleLinkedList<FireBallDragon> getFireballsDragon() {
		return fireballsD;
	}

	/**
	 * Sets the name of the dragon randomly
	 */
	public void setName() {

		String[] names = new String[] {"Rhaegal", "Viserion", "Drogon", "Errol", "Faranth", "Firnen", "Glaedr",
				"Saphira", "Slathborg", "Thorn", "Eldrax", "Balerion", "Chrysophylax", "Ancalagon", "Aithusa",
				"Shen Long", "Spyro", "Mushu", "Alduin", "Alexstrasza", "Kalameet", "Aquamentus", "Shyvanna",
				"Yomigami", "Charizard", "Yoshi", "Aurelion Sol", "Jabberwocky", "Leviathan", "Ryujin", "Toothless",
				"Hyorinmaru", "Paarthurnax", "Deathwing", "Quetzalcoatl","Hearkon", "Aatrox", "Rek Sai", "Vel Koz",
				"Kai Sa", "Teemo", "Dartharjae", "Cho Gath"};

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
	 * @param reloadingTime
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
	 */
	public void setAge() {
		if(getFather() == null) {
			int num = ThreadLocalRandom.current().nextInt(500, 1000 + 1);
			this.age = num;
		}else {
			int num = ThreadLocalRandom.current().nextInt(1, 490 + 1);
			this.age = num;
		}
	}

	public void setAge(int age) {
		this.age = age;
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
	 * Returns the rank of the dragon.
	 * @return rank
	 */
	public String getRank() {
		return rank;
	}

	/**
	 * Sets the rank of the dragon
	 * @param rank
	 */
	public void setRank(String rank) {
		this.rank = rank;
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

	 //	metodo para serializar los datos del dragon y convertirlo a xml
	public Node serializarDragon(Document doc) {
		Element elementoDragon = doc.createElement("Dragon");
		elementoDragon.setAttribute("Nombre", this.name);
		elementoDragon.setAttribute("Edad", Integer.toString(this.age));
		elementoDragon.setAttribute("Resistencia", Integer.toString(this.resistance));
		elementoDragon.setAttribute("Rango", this.rank);
		elementoDragon.setAttribute("Velocidad", Integer.toString(this.speed));

		return elementoDragon;
	}

}
