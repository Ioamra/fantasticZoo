package models.creatures.races;

import models.creatures.reproductionType.Oviparous;

public class Kraken extends Oviparous {

	/**
	 * Constructor to create a new kraken with specified parameters.
	 *
	 * @param name
	 * @param gender
	 * @param weight
	 * @param size
	 * @param MAX_AGE
	 * @param MAX_HUNGER
	 * @param MAX_STAMINA
	 * @param MAX_HP
	 * @param ADD_PRICE
	 * @param SELL_PRICE
	 * @param MAINTENANCE_PRICE
	 * @param MONEY_GAIN
	 */
	public Kraken(
		String name, 
		Gender gender, 
		double weight, 
		double size, 
		int MAX_AGE, 
		int MAX_HUNGER, 
		int MAX_STAMINA, 
		int MAX_HP, 
		int ADD_PRICE, 
		int SELL_PRICE, 
		int MAINTENANCE_PRICE, 
		int MONEY_GAIN
	) {
		super(
			name, 
			gender, 
			weight, 
			size, 
			MAX_AGE, 
			MAX_HUNGER, 
			MAX_STAMINA, 
			MAX_HP, 
			ADD_PRICE, 
			SELL_PRICE, 
			MAINTENANCE_PRICE, 
			MONEY_GAIN
		);
	}

	public void makeSound() {
		
	}

}
