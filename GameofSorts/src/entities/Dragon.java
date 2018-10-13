package entities;

import java.awt.event.KeyEvent;

import hitbox.HitBox;

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
//<<<<<<< HEAD
	private int speed;
//=======
	public int x, dx, y, dy;
//>>>>>>> 1f198f2172f4662eb0bf6a699e3531582a4d3f28
	
	/**
	 * Constructor for the first dragon.
	 * @param name
	 * @param reloadingTime
	 * @param age
	 * @param resistance
	 * @param range
	 * @param father
	 */
	public Dragon(int reloadingTime, int age, int resistance, String range, int speed) {
		setName();
		this.reloadingTime = reloadingTime;
		this.age = age;
		this.resistance = resistance;
		this.range = range;
		this.father = null;
//<<<<<<< HEAD
		this.speed = speed;
	}
	
	/**
	 * Constructor of the class Dragon.
	 * @param name
	 * @param reloadingTime
	 * @param age
	 * @param resistance
	 * @param range
	 * @param father
	 */
	public Dragon(int reloadingTime, int age, int resistance, String range, int speed, Dragon father) {
		setName();
		this.reloadingTime = reloadingTime;
		this.age = age;
		this.resistance = resistance;
		this.range = range;
		this.father = father;
		this.speed = speed;
//=======
		x = 1000;
		y = 250;
	}
	
	public void move() {
		x = x + dx;
		y = y + dy;
		this.mover1();
	}
	
	public void mover1() {
		dx = -1;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
//>>>>>>> 1f198f2172f4662eb0bf6a699e3531582a4d3f28
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
	 * Sets the age of the dragon
	 * @param age
	 */
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
	 * Sets the name of the dragon randomly
	 */
	public void setName() {
		
		String[] names = new String[] {"Rhaegal", "Viserion", "Drogon", "Errol", "Faranth", "Firnen", "Glaedr", 
				"Saphira", "Slathborg", "Thorn", "Eldrax", "Balerion", "Chrysophylax", "Ancalagon", "Aithusa", 
				"Shen Long", "Spyro", "Mushu", "Alduin", "Alexstrasza", "Kalameet", "Aquamentus", "Shyvanna", 
				"Yomigami", "Charizard", "Yoshi", "Aurelion Sol", "Jabberwocky", "Leviathan", "Ryujin", "Toothless", 
				"Hyorinmaru", "Paarthurnax", "Deathwing", "Quetzalcóatl","Hearkon", "Aatrox", "Rek'Sai", "Vel'Koz", 
				"Kai'Sa", "Teemo", "Dartharjae", "Cho'Gath", "Malp'Harido", ""};
		
		int num = (int) (Math.random() * names.length-1);
		setName(names[num]);
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
	
}
