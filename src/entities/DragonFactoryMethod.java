package entities;

/**
 * Applying the Factory design pattern.
 * @author Jose Antonio Cespedes Downing
 *
 */
//public interface DragonFactoryMethod {
//	public Dragon createDragon(int reloadingTime, int resistance, String range, Dragon father ,int speed, int startX, int startY);
//}

public interface DragonFactoryMethod {
	public Dragon createDragon(int resistance, String rank);
}
