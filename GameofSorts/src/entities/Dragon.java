package entities;

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
	
	/**
	 * Constructor for the first dragon.
	 * @param name
	 * @param reloadingTime
	 * @param age
	 * @param resistance
	 * @param range
	 * @param father
	 */
	public Dragon(int reloadingTime, int age, int resistance, String range) {
		setName();
		this.reloadingTime = reloadingTime;
		this.age = age;
		this.resistance = resistance;
		this.range = range;
		this.father = null;
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
	public Dragon(int reloadingTime, int age, int resistance, String range, Dragon father) {
		setName();
		this.reloadingTime = reloadingTime;
		this.age = age;
		this.resistance = resistance;
		this.range = range;
		this.father = father;
	}

	/**
	 * Returns the name of the dragon.
	 * @return name
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
				"Yomigami", "Charizard", "Yoshi", "", "", "", "", "", "", "", "", "", };
		int num = (int) (Math.random() * 34) +1;
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
