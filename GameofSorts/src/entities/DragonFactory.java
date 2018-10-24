package entities;

/**
 * Applying the Factory design pattern.
 * @author Jose Antonio Cespedes Downing
 *
 */

public class DragonFactory implements DragonFactoryMethod{
	
//	@Override
//	public  Dragon createDragon(int reloadingTime, int resistance, String range, Dragon father ,int speed, int startX, int startY) {
//		return new Dragon(reloadingTime,  resistance,  range, father, speed, startX, startY);
//	}
	
	@Override
	public  Dragon createDragon(int resistance, String range,int speed) {
		return new Dragon(resistance,  range, speed);
	}

}
