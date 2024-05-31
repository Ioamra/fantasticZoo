package models.creatures.races;

import config.Constants;
import models.creatures.reproductionType.Oviparous;

public class Kraken extends Oviparous {

	/**
	 * Constructor to create a new kraken with specified parameters.
	 *
	 * @param name
	 * @param gender
	 * @param weight
	 * @param size
	 */
	public Kraken(
		String name, 
		Gender gender, 
		double weight, 
		double size
	) {
		super(
			name, 
			gender, 
			weight, 
			size
		);
	}

	public void makeSound() {
		
	}

	public void checkAge() {
		if (this.age > Constants.Creature.Kraken.MAX_AGE) {
			this.die();
		}
	}
	
	public void heal() {
		this.setHp(Constants.Creature.Kraken.MAX_HP);
	}
}
