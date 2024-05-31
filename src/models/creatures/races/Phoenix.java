package models.creatures.races;

import config.Constants;
import models.creatures.reproductionType.Oviparous;

public class Phoenix extends Oviparous {

	/**
	 * Constructor to create a new phoenix with specified parameters.
	 *
	 * @param name
	 * @param gender
	 * @param weight
	 */
	public Phoenix(
		String name, 
		Gender gender, 
		int weight,
		int age
	) {
		super(
			name, 
			gender, 
			weight, 
			Constants.Creature.Phoenix.SIZE,
			age
		);
	}

	public void makeSound() {
		
	}
	
	public void checkAge() {
		if (this.age > Constants.Creature.Phoenix.MAX_AGE) {
			this.die();
		}
	}
	
	public void heal() {
		this.setHp(Constants.Creature.Phoenix.MAX_HP);
	}
}
