package entities;

public class DragonFactory implements DragonFactoryMethod{

	@Override
	public Dragon createDragon(int reloadingTime, int age, int resistance, String range, Dragon father) {
		return new Dragon(reloadingTime,  age,  resistance,  range, father);
	}
	
	
	

}
