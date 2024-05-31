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
	 */
	public Kraken(
		String name, 
		Gender gender,  
		int weight,
		int age
	) {
		super(
			name, 
			gender, 
			weight, 
			Constants.Creature.Kraken.SIZE,
			age
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
